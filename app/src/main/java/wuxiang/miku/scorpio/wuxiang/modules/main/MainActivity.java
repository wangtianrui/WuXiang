package wuxiang.miku.scorpio.wuxiang.modules.main;



import android.content.Intent;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;


import com.baidu.mapapi.SDKInitializer;
import com.getbase.floatingactionbutton.FloatingActionButton;
import com.getbase.floatingactionbutton.FloatingActionsMenu;

import butterknife.BindView;
import wuxiang.miku.scorpio.wuxiang.R;

import wuxiang.miku.scorpio.wuxiang.base.BaseActivity;
import wuxiang.miku.scorpio.wuxiang.modules.ar.ArActivity;
import wuxiang.miku.scorpio.wuxiang.modules.eating.EatingFragment;
import wuxiang.miku.scorpio.wuxiang.modules.findscenic.FindFragment;
import wuxiang.miku.scorpio.wuxiang.modules.my.InformationFragment;
import wuxiang.miku.scorpio.wuxiang.modules.navigation.NavigationFragment;

public class MainActivity extends BaseActivity {
    @BindView(R.id.floationg_action_menu)
    FloatingActionsMenu floationgActionMenu;
    @BindView(R.id.container_main)
    FrameLayout containerMain;
    @BindView(R.id.rb_movie)
    RadioButton rbMovie;
    @BindView(R.id.rb_cinema)
    RadioButton rbCinema;
    @BindView(R.id.rb_discover)
    RadioButton rbDiscover;
    @BindView(R.id.rb_mine)
    RadioButton rbMine;
    @BindView(R.id.rg_main)
    RadioGroup rgMain;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private Fragment[] fragments;
    private EatingFragment eatingFragment;
    private FindFragment findFragment;
    private InformationFragment informationFragment;
    private NavigationFragment navigationFragment;


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
        initMap();
        initFragments();
        initFloatingMenu();
        setupRg();
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
        findFragment = FindFragment.newInstance();
        informationFragment = InformationFragment.newInstance();
        navigationFragment = NavigationFragment.newInstance();
        fragments = new Fragment[]{
                eatingFragment,
                navigationFragment,
                findFragment,
                informationFragment
        };
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container_main, findFragment)
                .add(R.id.container_main, eatingFragment)
                .add(R.id.container_main, navigationFragment)
                .add(R.id.container_main, informationFragment)
                .commit();
        switchFragment(0);
    }

    /**
     * 初始化悬浮钮
     */
    private void initFloatingMenu() {
        FloatingActionButton actionButtonActivate = new FloatingActionButton(getBaseContext());
        actionButtonActivate.setTitle("实物AR扫描");
//        actionButtonActivate.setSize(FloatingActionButton.SIZE_MINI);
        actionButtonActivate.setIcon(R.drawable.ic_ar);
        actionButtonActivate.setTextDirection(FloatingActionButton.TEXT_DIRECTION_FIRST_STRONG_LTR);
        actionButtonActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ArActivity.class);
                startActivity(intent);
            }
        });
        floationgActionMenu.addButton(actionButtonActivate);
    }

    /**
     * fragment切换
     */
    private void switchFragment(int index) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (index) {
            case 0:
                floationgActionMenu.setVisibility(View.VISIBLE);
                transaction
                        .show(eatingFragment)
                        .hide(findFragment)
                        .hide(navigationFragment)
                        .hide(informationFragment);
//                        .hide(mineFragment)
                eatingFragment.setUserVisibleHint(true);
                findFragment.setUserVisibleHint(false);
                navigationFragment.setUserVisibleHint(false);
                informationFragment.setUserVisibleHint(false);
//                discoverFragment.setUserVisibleHint(false);
//                mineFragment.setUserVisibleHint(false);
                break;
            case 1:
                floationgActionMenu.setVisibility(View.INVISIBLE);
                transaction
                        .show(navigationFragment)
                        .hide(eatingFragment)
                        .hide(findFragment)
                        .hide(informationFragment);
//                        .hide(discoverFragment)
//                        .hide(mineFragment)
                navigationFragment.setUserVisibleHint(true);
                findFragment.setUserVisibleHint(false);
                informationFragment.setUserVisibleHint(false);
                eatingFragment.setUserVisibleHint(false);
//                discoverFragment.setUserVisibleHint(false);
//                mineFragment.setUserVisibleHint(false);
                break;
            case 2:
                floationgActionMenu.setVisibility(View.VISIBLE);
                transaction
                        .show(findFragment)
                        .hide(navigationFragment)
                        .hide(eatingFragment)
                        .hide(informationFragment);
//                        .hide(discoverFragment)
//                        .hide(mineFragment)
                navigationFragment.setUserVisibleHint(false);
                findFragment.setUserVisibleHint(true);
                eatingFragment.setUserVisibleHint(false);
                informationFragment.setUserVisibleHint(false);
//                discoverFragment.setUserVisibleHint(false);
//                mineFragment.setUserVisibleHint(false);
                break;
            case 3:
                floationgActionMenu.setVisibility(View.INVISIBLE);
                transaction
                        .show(informationFragment)
                        .hide(eatingFragment)
                        .hide(navigationFragment)
                        .hide(findFragment);
//                        .hide(mineFragment)
                navigationFragment.setUserVisibleHint(false);
                informationFragment.setUserVisibleHint(true);
                eatingFragment.setUserVisibleHint(false);
                findFragment.setUserVisibleHint(false);
//                discoverFragment.setUserVisibleHint(false);
//                mineFragment.setUserVisibleHint(false);
                break;
            default:
                break;

        }
        transaction.commit();
    }

    /**
     * RadioGroup点击监听
     */
    private void setupRg() {
        rgMain.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb_movie:
                        switchFragment(0);
                        break;
                    case R.id.rb_cinema:
                        switchFragment(1);
                        break;
                    case R.id.rb_discover:
                        switchFragment(2);
                        break;
                    case R.id.rb_mine:
                        switchFragment(3);
                        break;
                }
            }
        });
    }

    /**
     * 初始化百度地图
     */
    private void initMap() {
        //在使用SDK各组件之前初始化context信息，传入ApplicationContext
        //注意该方法要再setContentView方法之前实现
        SDKInitializer.initialize(getApplicationContext());
//        mSDCardPath = Environment.getDataDirectory().getPath();
//        APP_FOLDER_NAME = this.getCacheDir().getPath();
//        BaiduNaviManagerFactory.getBaiduNaviManager().init(MainActivity.this,
//                mSDCardPath, APP_FOLDER_NAME, new IBaiduNaviManager.INaviInitListener() {
//
//                    @Override
//                    public void onAuthResult(int status, String msg) {
//                        if (0 == status) {
//                            authinfo = "key校验成功!";
//                        } else {
//                            authinfo = "key校验失败, " + msg;
//                        }
//                        ToastUtils.showShortToast(authinfo);
//                    }
//
//                    @Override
//                    public void initStart() {
//                        ToastUtils.showShortToast(authinfo);
//                    }
//
//                    @Override
//                    public void initSuccess() {
//                        ToastUtils.showShortToast("初始化成功");
//                    }
//
//                    @Override
//                    public void initFailed() {
//                        ToastUtils.showShortToast("初始化失败");
//                    }
//                });
    }


}
