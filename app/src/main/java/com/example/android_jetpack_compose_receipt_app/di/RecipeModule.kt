package com.example.android_jetpack_compose_receipt_app.di

import android.content.Context
import com.example.android_jetpack_compose_receipt_app.BaseApplication
import com.example.android_jetpack_compose_receipt_app.data.network.RecipeDtoMapper
import com.example.android_jetpack_compose_receipt_app.data.network.api.RecipeApi
import com.example.android_jetpack_compose_receipt_app.domain.repository.RecipeRepository
import com.example.android_jetpack_compose_receipt_app.data.repository.RecipeRepositoryImpl
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RecipeModule {

    @Singleton
    @Provides
    fun provideApplication(@ApplicationContext app: Context): BaseApplication {
        return app as BaseApplication
    }

    @Singleton
    @Provides
    fun provideRecipeApi(): RecipeApi {
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeApi::class.java)
    }

    @Singleton
    @Provides
    fun provideRecipeMapper(): RecipeDtoMapper {
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeApi: RecipeApi,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository {
        return RecipeRepositoryImpl(
            recipeApi, recipeDtoMapper
        )
    }

    @Singleton
    @Provides
    fun provideAuthToken(): String {
     return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}