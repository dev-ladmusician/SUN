package com.knuplanet.sun._AUTH;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.knuplanet.sun.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public class ActivityJoin extends AppCompatActivity {
    @Bind(R.id.join_text_username)
    EditText mTextUsername;
    @Bind(R.id.join_text_password)
    EditText mTextPassword;
    @Bind(R.id.join_text_password_check)
    EditText mTextPasswordCheck;

    @OnClick({ R.id.join_btn_submit, R.id.btn_home }) void onClick(Button btn) {
        switch(btn.getId()) {
            case R.id.join_btn_submit:
                if (verifyUsername()) {
                    if (verifyPassword()) {

                    }
                }
                break;

            case R.id.btn_home:
                finish();
                break;
        }
    }

    boolean verifyUsername() {
        if (mTextUsername.length() > 9) {

            return true;
        } else {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("학번 입력 오류");
            builder.setMessage("올바른 학번을 입력해주세요.");
            builder.setPositiveButton("확인", null);
            builder.show();

            return false;
        }
    }

    boolean verifyPassword() {
        if (mTextPassword.equals(mTextPasswordCheck)) {
            return true;
        } else {
            AlertDialog.Builder builder =
                    new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
            builder.setTitle("비밀번호 확인 오류");
            builder.setMessage("비밀번호를 정확히 입력해주세요.");
            builder.setPositiveButton("확인", null);
            builder.show();

            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
