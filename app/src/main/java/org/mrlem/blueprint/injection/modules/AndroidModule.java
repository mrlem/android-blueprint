package org.mrlem.blueprint.injection.modules;

import android.content.Context;
import android.location.LocationManager;

import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.injection.ForApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import static android.content.Context.LOCATION_SERVICE;


/**
 * Dagger module providing Android related instances.
 */
@Module
public class AndroidModule {

    private final BlueprintApplication mApplication;

    public AndroidModule(final BlueprintApplication application) {
        mApplication = application;
    }

    /**
     * Allow the application context to be injected but require that it be annotated with
     * {@link ForApplication @Annotation} to explicitly differentiate it from an activity context.
     */
    @Provides @Singleton @ForApplication
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides @Singleton
    LocationManager provideLocationManager() {
        return (LocationManager) mApplication.getSystemService(LOCATION_SERVICE);
    }

}
