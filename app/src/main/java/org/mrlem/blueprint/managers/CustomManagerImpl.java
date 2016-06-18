package org.mrlem.blueprint.managers;

import org.greenrobot.eventbus.EventBus;
import org.mrlem.blueprint.events.SomethingCompletedEvent;


public class CustomManagerImpl implements CustomManager {

    @Override
    public void doSomething() {
        EventBus.getDefault().post(new SomethingCompletedEvent());
    }

}
