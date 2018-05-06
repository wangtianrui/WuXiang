package wuxiang.miku.scorpio.wuxiang;

import android.app.Application;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class WuXiang extends Application {
    public static WuXiang mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        this.mInstance = this;
    }

    public static WuXiang newInstance() {
        return mInstance;
    }
}
