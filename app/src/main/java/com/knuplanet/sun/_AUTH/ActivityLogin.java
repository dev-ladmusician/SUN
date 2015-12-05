package com.knuplanet.sun._AUTH;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.knuplanet.sun.R;
import com.knuplanet.sun._COMMON.DialogManager;
import com.knuplanet.sun._DTO.ResultDTO;
import com.knuplanet.sun._HTTP.RetrofitManager;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class ActivityLogin extends AppCompatActivity {
    private final String TAG = "ACTIVITY_LOGIN";
    private Context mContext;
    DialogManager mDialogManager = null;

    @Bind(R.id.login_text_username)
    EditText mTextUsername;
    @Bind(R.id.login_text_password)
    EditText mTextPassword;

    //AlertDialog.Builder mAlertDialogBuilder = null;

    @OnClick({ R.id.login_btn_submit, R.id.btn_home }) void onClick(Button btn) {
        switch(btn.getId()) {
            case R.id.login_btn_submit:
                if (mTextUsername.length() > 9 && mTextPassword.length() > 1) {
                    Call<ResultDTO> call = RetrofitManager.getAuthService().login(
                            mTextUsername.getText().toString(),
                            mTextPassword.getText().toString());

                    call.enqueue(new Callback<ResultDTO>() {
                        @Override
                        public void onResponse(Response<ResultDTO> response, Retrofit retrofit) {
                            if (response.code() == 200) {
                                Log.e(TAG, "RESULT : " + response.code());
                                Log.e(TAG, "RESPONSE : " + response.body().getResult());
                                Log.e(TAG, "RESPONSE USERNAME: " + response.body().getUsername());
                                Log.e(TAG, "RESPONSE PASSWORD: " + response.body().getPassword());

                            } else {
                                // error handling
                                getDialogManager().alertServerErrorMsg();
                            }
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            getDialogManager().alertServerErrorMsg();
                        }
                    });
                } else {
                    getDialogManager().alertDialog(
                            mContext.getString(R.string.msg_error_login_verify_title),
                            mContext.getString(R.string.msg_error_login_verify_content)
                    );

                    mTextUsername.setText("");
                    mTextPassword.setText("");
                }
                break;

            case R.id.btn_home:
                finish();
                break;
        }
    }

    DialogManager getDialogManager() {
        if (mDialogManager == null)
            return new DialogManager(this);

        return mDialogManager;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mContext = getApplicationContext();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
