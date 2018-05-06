package wuxiang.miku.scorpio.wuxiang.modules.main;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseActivity;
import wuxiang.miku.scorpio.wuxiang.modules.eating.EatingFragment;

public class MainActivity extends BaseActivity {
    private Fragment[] fragments;
    private EatingFragment eatingFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        initFragments();
    }

    @Override
    public void initToolBar() {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    /**
     * 初始化fragment
     */
    private void initFragments() {
        eatingFragment = EatingFragment.newInstance();

        fragments = new Fragment[]{
                eatingFragment
        };
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_main, eatingFragment)
                .show(eatingFragment).commit();
    }
}
