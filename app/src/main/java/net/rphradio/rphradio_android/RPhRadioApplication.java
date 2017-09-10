package net.rphradio.rphradio_android;

import android.app.Application;
import android.content.Context;

import com.github.sardine.Sardine;
import com.github.sardine.SardineFactory;
import com.squareup.leakcanary.LeakCanary;

import net.rphradio.rphradio_android.di.component.ApplicationComponent;
import net.rphradio.rphradio_android.di.component.DaggerApplicationComponent;
import net.rphradio.rphradio_android.di.module.ApplicationModule;
import net.rphradio.rphradio_android.di.module.DataModule;

import timber.log.Timber;

/**
 * Created by maclawrence on 10/09/2017.
 */

public class RPhRadioApplication extends Application {

    protected ApplicationComponent applicationComponent;

    public static RPhRadioApplication getInstance(Context context) {
        return (RPhRadioApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .dataModule(new DataModule("", ""))
                .build();

        LeakCanary.install(this);
        if(BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        } else {
            // TODO: Implement a CrashReport Tool
            Timber.plant(new Timber.DebugTree());
        }
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
