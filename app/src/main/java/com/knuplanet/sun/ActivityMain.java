package com.knuplanet.sun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.Bind;
import butterknife.OnClick;

public class ActivityMain extends AppCompatActivity {
    @Bind(R.id.main_btn_login)
    Button mBtnLogin;
    @Bind(R.id.main_btn_join)
    Button mBtnJoin;

    @OnClick({ R.id.main_btn_login, R.id.main_btn_join }) void onClick(Button btn) {
        switch(btn.getId()) {
            case R.id.main_btn_join:

                break;
            case R.id.main_btn_login:
                break;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
