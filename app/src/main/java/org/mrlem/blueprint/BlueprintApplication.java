package org.mrlem.blueprint;

import android.app.Application;

import org.mrlem.blueprint.injection.DaggerBlueprintApplicationComponent;
import org.mrlem.blueprint.injection.modules.AndroidModule;
import org.mrlem.blueprint.injection.BlueprintApplicationComponent;
import org.mrlem.blueprint.injection.modules.CustomModule;


public class BlueprintApplication extends Application {

    private BlueprintApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        // init dagger deps injection
        component = DaggerBlueprintApplicationComponent.builder()
                .androidModule(new AndroidModule(this))
                .customModule(new CustomModule(this))
                .build();
        component().inject(this);
    }

    public BlueprintApplicationComponent component() {
        return component;
    }

}
