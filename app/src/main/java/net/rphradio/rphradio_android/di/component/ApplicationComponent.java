package net.rphradio.rphradio_android.di.component;

import android.content.Context;

import net.rphradio.rphradio_android.di.ApplicationContext;
import net.rphradio.rphradio_android.di.module.ApplicationModule;
import net.rphradio.rphradio_android.di.module.DataModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by maclawrence on 10/09/2017.
 */
@Singleton
@Component(modules = {DataModule.class, ApplicationModule.class})
public interface ApplicationComponent {
    @ApplicationContext
    Context getContext();

//    Application getApplication();

//    AppRepository getAppRepository();

    Retrofit getRetrofit();

//    SQLiteHelper getSqliteHelper();
}
