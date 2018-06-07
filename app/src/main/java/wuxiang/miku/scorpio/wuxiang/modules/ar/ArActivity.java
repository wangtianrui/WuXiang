package wuxiang.miku.scorpio.wuxiang.modules.ar;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.baidu.ar.ARFragment;
import com.baidu.ar.constants.ARConfigKey;

import org.json.JSONException;
import org.json.JSONObject;

import wuxiang.miku.scorpio.wuxiang.R;


/**
 * <pre>
 *     author : baoqianyue
 *     time   : 2018/06/07
 *     desc   :
 *     version: 1.0
 * </pre>
 */

public class ArActivity extends AppCompatActivity {

    private ARFragment mARFragment;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar);


        if (findViewById(R.id.bdar_id_fragment_container) != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            //准备调用AR的参数
            int arType = 7;
            Bundle data = new Bundle();
            JSONObject jsonObj = new JSONObject();
            try {
                //云端识图key为空
                jsonObj.put(ARConfigKey.AR_KEY, "");
                jsonObj.put(ARConfigKey.AR_TYPE, arType);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            data.putString(ARConfigKey.AR_VALUE, jsonObj.toString());
            mARFragment = new ARFragment();
            mARFragment.setArguments(data);

            //将ARFragment设置到布局上
            fragmentTransaction.replace(R.id.bdar_id_fragment_container, mARFragment);
            fragmentTransaction.commitAllowingStateLoss();
        }
    }

    @Override
    public void onBackPressed() {
        boolean backFlag = false;
        if (mARFragment != null) {
            backFlag = mARFragment.onFragmentBackPressed();
        }
        if (!backFlag) {
            super.onBackPressed();
        }
    }
}
