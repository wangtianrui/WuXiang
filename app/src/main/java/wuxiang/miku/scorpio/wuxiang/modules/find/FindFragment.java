package wuxiang.miku.scorpio.wuxiang.modules.find;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class FindFragment extends BaseMVPFragment {
    /**
     * maker
     * @return
     */
    public static FindFragment newInstance() {
        return new FindFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.find_fragment_main;
    }

    @Override
    protected void initEventAndData() {

    }
}
