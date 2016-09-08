package com.chan.mm.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.chan.mm.R;
import com.chan.mm.callback.BaseQQListener;
import com.chan.mm.utils.AppConstant;
import com.tencent.connect.common.Constants;
import com.tencent.connect.share.QQShare;
import com.tencent.connect.share.QzoneShare;
import com.tencent.tauth.Tencent;

import java.util.ArrayList;

public class ItemInfoActivity extends BaseActivity implements View.OnClickListener {
    private Button mBtnTencent;
    private Button mBtnShareToqq;
    private Button mBtnShareToZone;
    private TextView mTvNikname;
    private Tencent mTencent;
    private BaseQQListener mListener;

    @Override
    protected int getContentView() {
        return R.layout.activity_item_info;
    }

    @Override
    public void configApp() {
        mTencent = Tencent.createInstance(AppConstant.ThirdParty.App_ID_QQ, mApplicationContext);
        mListener = new BaseQQListener();
    }

    @Override
    public void getIntentData() {

    }

    @Override
    public void setListener() {
        mBtnTencent.setOnClickListener(this);
        mBtnShareToqq.setOnClickListener(this);
        mBtnShareToZone.setOnClickListener(this);
    }

    @Override
    public void loadDatas() {

    }

    @Override
    public void initViews() {
        mBtnTencent = (Button) this.findViewById(R.id.btn_tencent);
        mTvNikname = (TextView) this.findViewById(R.id.tv_nikname);
        mBtnShareToqq = (Button) this.findViewById(R.id.btn_share_qq);
        mBtnShareToZone = (Button) this.findViewById(R.id.btn_share_zone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_tencent:
                qqLogin();
                break;
            case R.id.btn_share_qq:
                Toast.makeText(mApplicationContext,"share to qq",Toast.LENGTH_SHORT).show();
                shareToQQ();
                break;
            case R.id.btn_share_zone:
                shareToZone();
                break;
            default:
                break;
        }
    }

    private void shareToZone() {
        final Bundle params = new Bundle();
        params.putInt(QzoneShare.SHARE_TO_QZONE_KEY_TYPE,QzoneShare.SHARE_TO_QZONE_TYPE_IMAGE_TEXT);
        params.putString(QzoneShare.SHARE_TO_QQ_TITLE, "Test");
        params.putString(QzoneShare.SHARE_TO_QQ_SUMMARY,  "content infro");
        params.putString(QzoneShare.SHARE_TO_QQ_TARGET_URL,  "http://www.hicsg.com");
        ArrayList imageUrls = new ArrayList();
        imageUrls.add("http://media-cdn.tripadvisor.com/media/photo-s/01/3e/05/40/the-sandbar-that-links.jpg");
        params.putStringArrayList(QzoneShare.SHARE_TO_QQ_IMAGE_URL, imageUrls);
        params.putInt(QzoneShare.SHARE_TO_QQ_EXT_INT,  QQShare.SHARE_TO_QQ_FLAG_QZONE_AUTO_OPEN);

        mTencent.shareToQzone(this, params, mListener);
    }

    private void shareToQQ() {
        if (mTencent.isSessionValid() && mTencent.getOpenId() != null) {
            final Bundle params = new Bundle();
            params.putInt(QQShare.SHARE_TO_QQ_KEY_TYPE, QQShare.SHARE_TO_QQ_TYPE_DEFAULT);
            params.putString(QQShare.SHARE_TO_QQ_TITLE, "要分享的标题");
            params.putString(QQShare.SHARE_TO_QQ_SUMMARY,  "要分享的摘要");
            params.putString(QQShare.SHARE_TO_QQ_TARGET_URL,  "http://www.qq.com/news/1.html");
            params.putString(QQShare.SHARE_TO_QQ_IMAGE_URL,"https://www.baidu.com/img/bd_logo1.png");
            mTencent.shareToQQ(this, params, mListener);
        }
    }


    private void qqLogin() {
        mTencent.login(this, "all", mListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.REQUEST_API) {
            if (resultCode == Constants.REQUEST_LOGIN) {
                Tencent.onActivityResultData(requestCode, resultCode, data, mListener);
            }
        }
    }
}
