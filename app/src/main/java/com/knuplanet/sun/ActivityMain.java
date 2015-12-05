package com.knuplanet.sun;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.knuplanet.sun._AUTH.ActivityJoin;
import com.knuplanet.sun._AUTH.ActivityLogin;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ActivityMain extends AppCompatActivity {
    @Bind(R.id.main_btn_login)
    Button mBtnLogin;
    @Bind(R.id.main_btn_join)
    Button mBtnJoin;

    @OnClick({ R.id.main_btn_login, R.id.main_btn_join }) void onClick(Button btn) {
        switch(btn.getId()) {
            case R.id.main_btn_join:
                startActivity(new Intent(this, ActivityJoin.class));
                break;
            case R.id.main_btn_login:
                startActivity(new Intent(this, ActivityLogin.class));
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
