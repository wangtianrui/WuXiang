package wuxiang.miku.scorpio.wuxiang.modules.navigation;

import android.support.design.widget.NavigationView;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class NavigationFragment extends BaseMVPFragment {
    /**
     * maker
     *
     * @return
     */
    public static NavigationFragment newInstance() {
        return new NavigationFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.navigation_fragment_main;
    }

    @Override
    protected void initEventAndData() {

    }
}
