package wuxiang.miku.scorpio.wuxiang.modules.eating;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.EatingPagerAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseFragment;
import wuxiang.miku.scorpio.wuxiang.modules.main.MainActivity;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

/**
 * Created by Wangtianrui on 2018/5/5.
 */

public class EatingFragment extends BaseFragment  {
    @BindView(R.id.eating_city)
    TextView eatingCity;
    @BindView(R.id.view_indicator)
    View view;
    @BindView(R.id.eating_hot)
    TextView eatingHot;
    @BindView(R.id.eating_nearby)
    TextView eatingNearby;
    @BindView(R.id.eating_find)
    TextView eatingFind;
    @BindView(R.id.vp_eating)
    ViewPager vpEating;
    Unbinder unbinder;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    Unbinder unbinder1;
    @BindView(R.id.search_view)
    MaterialSearchView searchView;

    private FrameLayout.LayoutParams params;


    /**
     * maker
     *
     * @return
     */
    public static EatingFragment newInstance() {
        return new EatingFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.eating_fragment_main;
    }

    @Override
    public void finishCreateView(Bundle state) {
        setHasOptionsMenu(true);
        initToolbar();
        initSearchView();
        initViewPager();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick({R.id.eating_city, R.id.eating_hot, R.id.eating_nearby, R.id.eating_find})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.eating_city:
                ToastUtils.showShortToast("选择城市？");
                break;
            case R.id.eating_hot:
                vpEating.setCurrentItem(0);
                break;
            case R.id.eating_nearby:
                vpEating.setCurrentItem(1);
                break;
            case R.id.eating_find:
                vpEating.setCurrentItem(2);
                break;
        }
    }

    /**
     * 初始化toolbar
     */
    private void initToolbar() {
        toolbar.setTitle("");
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder1 = ButterKnife.bind(this, rootView);
        return rootView;
    }

    /**
     * 初始化toolbar搜索
     *
     * @param menu
     * @param inflater
     */
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        menu.clear();
        inflater.inflate(R.menu.menu_main, menu);
        MenuItem item = menu.findItem(R.id.id_action_search);
        searchView.setMenuItem(item);
    }

    /**
     * 初始化searchview
     */
    private void initSearchView() {
        searchView.setHint("搜索");
        searchView.setVoiceSearch(false);
        searchView.setCursorDrawable(R.drawable.custom_cursor);
        searchView.setEllipsize(true);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                ToastUtils.showShortToast(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
    }

    /**
     * 初始化viewpager
     */
    private void initViewPager() {
        final int selectedColor = getResources().getColor(R.color.colorAccent);
        final int unselectedColor = getResources().getColor(R.color.white);
        String[] titles = new String[]{
                "人气", "附近", "找店"
        };
        EatingPagerAdapter eatingPagerAdapter = new EatingPagerAdapter(getFragmentManager(),
                getApplicationContext(), titles);
        vpEating.setOffscreenPageLimit(3);
        vpEating.setAdapter(eatingPagerAdapter);
        vpEating.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                boolean lessThanHalf = positionOffset < 0.5;//判断是否滑动的距离小于整体布局（fragment）的一半

                float alpha = (1 - positionOffset * 2) * 255;//变化率（从0-255表示从无到有）
                int alphaWhite = Color.argb((int) alpha, 255, 255, 255);//白渐变到透明
                int alphaRed = Color.argb((int) alpha, 212, 62, 55);//红渐变到透明

                int alphaWhiteReverse = Color.argb((int) -alpha, 255, 255, 255);//白渐变到透明
                int alphaRedReverse = Color.argb((int) -alpha, 212, 62, 55);//红渐变到透明

                //获取滑块的Layout
                params = (FrameLayout.LayoutParams) view.getLayoutParams();
                //判断滑动的距离
                if (positionOffset == 0) { // 停止滚动
                    params.setMargins(view.getWidth() * position, 0, 0, 0);
                } else {
                    params.setMargins((int) (view.getWidth() * (position + positionOffset)), 0, 0, 0);
                }
                //通过LayoutParams设置滑块的位置
                view.setLayoutParams(params);
                /**
                 * 滑动的时候需要观察position的变化才能判断滑动的位置
                 * 从左到右滑会一直是左边的position，直到切换了fragment
                 * 从右往左滑会一直是右边的position，直到切换了fragment
                 * 所以这边只需要对前两个position进行alpha的颜色变化即可
                 */
                switch (position) {
                    case 0:
                        if (lessThanHalf) {
                            eatingHot.setTextColor(alphaRed);
                            eatingNearby.setTextColor(alphaWhite);
                        } else {
                            eatingHot.setTextColor(alphaWhiteReverse);
                            eatingNearby.setTextColor(alphaRedReverse);
                        }
                        break;
                    case 1:
                        if (lessThanHalf) {
                            eatingNearby.setTextColor(alphaRed);
                            eatingFind.setTextColor(alphaWhite);
                        } else {
                            eatingNearby.setTextColor(alphaWhiteReverse);
                            eatingFind.setTextColor(alphaRedReverse);
                        }
                        break;
                }

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        eatingHot.setTextColor(selectedColor);
                        eatingNearby.setTextColor(unselectedColor);
                        eatingFind.setTextColor(unselectedColor);
                        break;
                    case 1:
                        eatingNearby.setTextColor(selectedColor);
                        eatingHot.setTextColor(unselectedColor);
                        eatingFind.setTextColor(unselectedColor);
                        break;
                    case 2:
                        eatingFind.setTextColor(selectedColor);
                        eatingNearby.setTextColor(unselectedColor);
                        eatingHot.setTextColor(unselectedColor);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
