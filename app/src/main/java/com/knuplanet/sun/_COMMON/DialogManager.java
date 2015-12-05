package com.knuplanet.sun._COMMON;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import com.knuplanet.sun.R;

/**
 * Created by ladmusician on 15. 12. 5..
 */
public class DialogManager {
    private Context mContext = null;
    AlertDialog.Builder mAlertDialogBuilder = null;

    public DialogManager(Context ctx) {
        mContext = ctx;
        if (mAlertDialogBuilder == null) {
            mAlertDialogBuilder = new AlertDialog.Builder(mContext, R.style.AppCompatAlertDialogStyle);
        }
    }

    public void alertServerErrorMsg () {
        mAlertDialogBuilder.setTitle(mContext.getString(R.string.msg_error_server_title));
        mAlertDialogBuilder.setMessage(mContext.getString(R.string.msg_error_server_content));
        mAlertDialogBuilder.setPositiveButton("확인", null);
        mAlertDialogBuilder.show();
    }

    public void alertDialog(String title, String content) {
        mAlertDialogBuilder.setTitle(title);
        mAlertDialogBuilder.setMessage(content);
        mAlertDialogBuilder.setPositiveButton("확인", null);
        mAlertDialogBuilder.show();
    }
}
