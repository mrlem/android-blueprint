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
import org.mrlem.blueprint.managers.CustomManager;
import org.mrlem.blueprint.R;
import org.mrlem.blueprint.events.SomethingCompletedEvent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


// TODO - add retrofit APIs

public class MainActivity extends AppCompatActivity {

    @Inject CustomManager mCustomBean;
    @Inject LocationManager mLocationManager;

    @BindView(R.id.text) TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((BlueprintApplication) getApplication()).component().inject(this);

        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
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

    @OnClick(R.id.button)
    void onButtonClick() {
        mCustomBean.doSomething();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void on(SomethingCompletedEvent event) {
        mTextView.setText(R.string.main_text_done);
    }

}
