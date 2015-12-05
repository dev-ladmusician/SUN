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

/**
 * Created by ladmusician on 15. 12. 5..
 */
public class ActivityJoin extends AppCompatActivity {
    private final String TAG = "ACTIVITY_JOIN";
    private DialogManager mDialogManager = null;
    private Context mContext = null;

    @Bind(R.id.join_text_username)
    EditText mTextUsername;
    @Bind(R.id.join_text_password)
    EditText mTextPassword;
    @Bind(R.id.join_text_password_check)
    EditText mTextPasswordCheck;

    @OnClick({R.id.join_btn_submit, R.id.btn_home})
    void onClick(Button btn) {
        switch (btn.getId()) {
            case R.id.join_btn_submit:
                if (verifyUsername()) {
                    if (verifyPassword()) {
                        Call<ResultDTO> call = RetrofitManager.getAuthService().join(
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
            getDialogManager().alertDialog(
                    mContext.getString(R.string.msg_error_join_verify_username_title),
                    mContext.getString(R.string.msg_error_join_verify_username_content)
            );

            return false;
        }
    }
    boolean verifyPassword() {
        if (mTextPassword.equals(mTextPasswordCheck)) {
            return true;
        } else {
            getDialogManager().alertDialog(
                    mContext.getString(R.string.msg_error_join_verify_password_title),
                    mContext.getString(R.string.msg_error_join_verify_password_content)
            );

            return false;
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
        setContentView(R.layout.activity_join);
        ButterKnife.bind(this);
        mContext = getApplicationContext();
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
