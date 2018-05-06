package wuxiang.miku.scorpio.wuxiang.utils;

import android.widget.Toast;

import wuxiang.miku.scorpio.wuxiang.WuXiang;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class ToastUtils {


    public static void showLongToast(String message) {
        Toast.makeText(WuXiang.newInstance(), message, Toast.LENGTH_LONG).show();
    }

    public static void showShortToast(String message) {
        Toast.makeText(WuXiang.newInstance(), message, Toast.LENGTH_SHORT).show();
    }
}
