package org.mrlem.blueprint.injection.modules;

import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.components.CustomBean;
import org.mrlem.blueprint.components.CustomBeanImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


/**
 * Dagger module providing custom instances.
 */
@Module
public class CustomModule {

    private BlueprintApplication mApplication;

    public CustomModule(BlueprintApplication application) {
        mApplication = application;
    }

    @Provides @Singleton
    public CustomBean providesBean() {
        return new CustomBeanImpl();
    }
}
