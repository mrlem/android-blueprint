package org.mrlem.blueprint.components;

import android.util.Log;


public class CustomBeanImpl implements CustomBean {

    @Override
    public void doSomething() {
        Log.i("custom", "did something");
    }

}
