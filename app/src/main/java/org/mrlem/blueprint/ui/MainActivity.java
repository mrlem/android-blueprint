package org.mrlem.blueprint.ui;

import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.components.CustomBean;
import org.mrlem.blueprint.R;

import javax.inject.Inject;


public class MainActivity extends AppCompatActivity {

    @Inject CustomBean mCustomBean;
    @Inject LocationManager mLocationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((BlueprintApplication) getApplication()).component().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        mCustomBean.doSomething();
    }
}
