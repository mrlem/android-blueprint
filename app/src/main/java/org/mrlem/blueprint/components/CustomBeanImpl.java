package org.mrlem.blueprint.components;

import org.greenrobot.eventbus.EventBus;
import org.mrlem.blueprint.events.SomethingCompletedEvent;


public class CustomBeanImpl implements CustomBean {

    @Override
    public void doSomething() {
        EventBus.getDefault().post(new SomethingCompletedEvent());
    }

}
