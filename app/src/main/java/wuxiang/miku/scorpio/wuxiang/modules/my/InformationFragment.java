package wuxiang.miku.scorpio.wuxiang.modules.my;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class InformationFragment extends BaseMVPFragment {
    /**
     * maker
     * @return
     */
    public static InformationFragment newInstance() {
        return new InformationFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_information_fragment_main;
    }

    @Override
    protected void initEventAndData() {

    }
}
