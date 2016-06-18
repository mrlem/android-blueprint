package org.mrlem.blueprint.injection.modules;

import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.managers.CustomManager;
import org.mrlem.blueprint.managers.CustomManagerImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Dagger module providing application-specific instances.
 */
@Module
public class ApplicationModule {

    private BlueprintApplication mApplication;

    public ApplicationModule(BlueprintApplication application) {
        mApplication = application;
    }

    @Provides @Singleton
    public CustomManager providesBean() {
        return new CustomManagerImpl();
    }
}
