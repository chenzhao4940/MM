package com.chan.mm.callback;

import android.util.Log;
import android.widget.Toast;

import com.chan.mm.BaseApp;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;

/**
 * Created by chan on 2016/9/7.
 */
public class BaseQQListener implements IUiListener {

    @Override
    public void onComplete(Object o) {
        Toast.makeText(BaseApp.getInstance().getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(UiError uiError) {
        Toast.makeText(BaseApp.getInstance().getApplicationContext(), "登录失败", Toast.LENGTH_SHORT).show();
        Log.d("chanzh",uiError.errorMessage+uiError.errorDetail+uiError.errorCode);
    }

    @Override
    public void onCancel() {
        Toast.makeText(BaseApp.getInstance().getApplicationContext(), "登录取消", Toast.LENGTH_SHORT).show();
    }
}
