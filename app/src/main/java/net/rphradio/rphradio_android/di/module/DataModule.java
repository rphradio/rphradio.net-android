package net.rphradio.rphradio_android.di.module;

import android.app.Application;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by maclawrence on 10/09/2017.
 */
@Module
public class DataModule {
    private String webdavUsername;
    private String webdavPassword;

    public DataModule(String webdavUsername, String webdavPassword) {
        this.webdavUsername = webdavUsername;
        this.webdavPassword = webdavPassword;
    }

    @Provides
    @Singleton
    Sardine provideSardine() {
        return SardineFactory.begin(webdavUsername, webdavPassword);
    }

//    @Provides
//    @Singleton
//    Cache provideHttpCache(Application application) {
//        int cacheSize = 10 * 1024 * 1024;
//        return new Cache(application.getCacheDir(), cacheSize);
//    }
//
//    @Provides
//    @Singleton
//    Gson provideGson() {
//        return new GsonBuilder()
//                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
//                .create();
//    }
//
//    @Provides
//    @Singleton
//    OkHttpClient provideOkhttpClient(Cache cache) {
//        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
//        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
//        return new OkHttpClient.Builder()
//                .cache(cache)
//                .addInterceptor(interceptor)
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    Retrofit provideRetrofit(Gson gson, OkHttpClient okHttpClient) {
//        return new Retrofit.Builder()
//                .addConverterFactory(GsonConverterFactory.create(gson))
//                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
//                .baseUrl(webdavUrl)
//                .client(okHttpClient)
//                .build();
//    }
//
//    @Provides
//    @Singleton
//    AppLocalDataStore porvidesAppLocalDataStore(Application context) {
//        return new AppLocalDataStore(context);
//    }
//
//    @Provides
//    @Singleton
//    AppRemoteDataStore providesAppRemoteDataStore(Retrofit retrofit) {
//        return new AppRemoteDataStore(retrofit);
//    }
//
//    @Provides
//    @Singleton
//    AppRepository providesAppRepository(AppLocalDataStore localDataStore, AppRemoteDataStore remoteDataStore) {
//        return new AppRepository(localDataStore, remoteDataStore);
//    }
}
