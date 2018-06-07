package wuxiang.miku.scorpio.wuxiang;

import android.app.Application;
import android.os.Environment;


import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

import com.baidu.ar.bean.DuMixARConfig;
import com.baidu.ar.util.Res;

import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class WuXiang extends Application {
    public static WuXiang mInstance;


    @Override
    public void onCreate() {
        super.onCreate();
        this.mInstance = this;

        //初始化AR
        Res.addResource(this);
        DuMixARConfig.setAppId(ConstantUtils.BAIDUARAPPID);
        DuMixARConfig.setAPIKey(ConstantUtils.BAIDUARAPIKEY);
        DuMixARConfig.setSecretKey(ConstantUtils.BAIDUARSECRETKEY);


    }

    public static WuXiang newInstance() {
        return mInstance;
    }
}
