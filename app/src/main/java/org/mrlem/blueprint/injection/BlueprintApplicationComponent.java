package org.mrlem.blueprint.injection;

import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.injection.modules.AndroidModule;
import org.mrlem.blueprint.injection.modules.ApplicationModule;
import org.mrlem.blueprint.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Component;


@Singleton
@Component(modules={ AndroidModule.class, ApplicationModule.class })
public interface BlueprintApplicationComponent {

    void inject(BlueprintApplication application);
    void inject(MainActivity activity);
    // void inject(MyFragment fragment);
    // void inject(MyService service);

}