package org.mrlem.blueprint.ui;

import android.location.LocationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.mrlem.blueprint.BlueprintApplication;
import org.mrlem.blueprint.components.CustomBean;
import org.mrlem.blueprint.R;
import org.mrlem.blueprint.events.SomethingCompletedEvent;

import javax.inject.Inject;


// TODO - add ButterKnife view injection & listener injection
// TODO - add retrofit APIs
// TODO - add tests

public class MainActivity extends AppCompatActivity {

    @Inject CustomBean mCustomBean;
    @Inject LocationManager mLocationManager;

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BlueprintApplication) getApplication()).component().inject(this);

        setContentView(R.layout.activity_main);
        mTextView = (TextView) findViewById(R.id.text);

        View button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCustomBean.doSomething();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void on(SomethingCompletedEvent event) {
        mTextView.setText(R.string.main_text_done);
    }
}
