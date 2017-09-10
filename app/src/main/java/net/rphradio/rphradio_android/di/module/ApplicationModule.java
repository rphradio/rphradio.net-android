package net.rphradio.rphradio_android.di.module;

import android.app.Application;
import android.content.Context;

import net.rphradio.rphradio_android.di.ApplicationContext;

import dagger.Module;
import dagger.Provides;

/**
 * Created by maclawrence on 10/09/2017.
 */
@Module
public class ApplicationModule {
    private final Application mApplication;

    public ApplicationModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideContext() { return mApplication.getBaseContext(); }

    @Provides
    Application provideApplication() { return mApplication; }
}
