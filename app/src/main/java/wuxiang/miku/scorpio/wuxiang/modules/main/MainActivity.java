package wuxiang.miku.scorpio.wuxiang.modules.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import butterknife.BindView;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseActivity;
import wuxiang.miku.scorpio.wuxiang.modules.eating.EatingFragment;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

public class MainActivity extends BaseActivity {
    @BindView(R.id.floationg_action_menu)
    FloatingActionsMenu floationgActionMenu;
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
        initFloatingMenu();
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

    private void initFloatingMenu() {
        FloatingActionButton actionButtonActivate = new FloatingActionButton(getBaseContext());
        actionButtonActivate.setTitle("实物AR扫描");
//        actionButtonActivate.setSize(FloatingActionButton.SIZE_MINI);
        actionButtonActivate.setIcon(R.drawable.ic_ar);
        actionButtonActivate.setTextDirection(FloatingActionButton.TEXT_DIRECTION_FIRST_STRONG_LTR);
        actionButtonActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.showShortToast("纸悦动");
            }
        });
        floationgActionMenu.addButton(actionButtonActivate);
    }
}
