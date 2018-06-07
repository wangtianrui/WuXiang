package wuxiang.miku.scorpio.wuxiang.modules.main;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

public class DefualtActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_defualt);
        mContext = DefualtActivity.this;
        askPermission();
    }

    /**
     * 权限请求
     */
    private void askPermission() {
        String[] permissions = new String[]{
                Manifest.permission.CALL_PHONE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA,
                Manifest.permission.ACCESS_FINE_LOCATION
        };
        List<String> mPermissionList = new ArrayList<>();
        mPermissionList.clear();
        for (int i = 0; i < permissions.length; i++) {
            if (ContextCompat.checkSelfPermission(mContext, permissions[i]) != PackageManager.PERMISSION_GRANTED) {
                mPermissionList.add(permissions[i]);
            }
        }
        if (!mPermissionList.isEmpty()) {
            String[] permissions2 = mPermissionList.toArray(new String[mPermissionList.size()]);
            ActivityCompat.requestPermissions(DefualtActivity.this, permissions2, 1);
        }else{
            Intent intent = new Intent(DefualtActivity.this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1:
                Intent intent = new Intent(DefualtActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            default:
                ToastUtils.showShortToast("请授予所有权限，才能保证您的正常使用");
                askPermission();
                break;
        }
    }
}
