package com.cj3dreams.aliftesttask.di

import android.app.Application
import androidx.room.Room
import com.cj3dreams.aliftesttask.presentation.main.home.HomeViewModel
import com.cj3dreams.data.api.DataApi
import com.cj3dreams.data.db.RoomAppDb
import com.cj3dreams.data.db.dao.DataDao
import com.cj3dreams.data.mappers.DataEntityMapper
import com.cj3dreams.data.mappers.DataResponseMapper
import com.cj3dreams.data.repositories.*
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://guidebook.com"

val networkModule = module {

    fun <Api> provideRetrofit(api: Class<Api>) =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(OkHttpClient.Builder().also { client ->
                    val logging = HttpLoggingInterceptor()
                    logging.setLevel(HttpLoggingInterceptor.Level.BODY)
                    client.addInterceptor(logging)
            }.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(api)

    factory { provideRetrofit(DataApi::class.java) }
}

val dataDb = module {

    fun provideDataBase(application: Application) =
        Room.databaseBuilder(application, RoomAppDb::class.java, "AppDb")
            .fallbackToDestructiveMigration()
            .build()

    fun provideDao(database: RoomAppDb) = database.dataDao()

    fun provideDataRepository(dataDao: DataDao, dataApi: DataApi) =
        DataRepositoryImpl(
            LocaleDataSourceImpl(dataDao = dataDao, DataEntityMapper()),
            RemoteDataSourceImpl(dataApi = dataApi, DataResponseMapper())
        )

    single { provideDataBase(androidApplication()) }
    single { provideDao(get()) }
    single { provideDataRepository(get(), get()) }
        viewModel {
            HomeViewModel(get())
        }
}


