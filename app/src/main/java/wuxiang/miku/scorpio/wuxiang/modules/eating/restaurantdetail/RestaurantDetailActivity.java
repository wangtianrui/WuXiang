package wuxiang.miku.scorpio.wuxiang.modules.eating.restaurantdetail;

import android.content.Context;
import android.content.Intent;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPActivity;

/**
 * Created by Wangtianrui on 2018/5/8.
 */

public class RestaurantDetailActivity extends BaseMVPActivity {
    public static void startRestaurantDetailActivity(Context context) {
        Intent start = new Intent(context, RestaurantDetailActivity.class);
        context.startActivity(start);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_restaurant_detial;
    }

    @Override
    protected void initEventAndData() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
