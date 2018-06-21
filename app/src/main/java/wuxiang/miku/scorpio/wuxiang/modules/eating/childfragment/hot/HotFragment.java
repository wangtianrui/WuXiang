package wuxiang.miku.scorpio.wuxiang.modules.eating.childfragment.hot;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.eating.HotEatingListAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseFragment;
import wuxiang.miku.scorpio.wuxiang.entity.EatingItem;
import wuxiang.miku.scorpio.wuxiang.modules.eating.restaurantdetail.RestaurantDetailActivity;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;
import wuxiang.miku.scorpio.wuxiang.view.MyPullToRefreshListener;
import wuxiang.miku.scorpio.wuxiang.view.ProgressLayout;
import wuxiang.miku.scorpio.wuxiang.view.SuperSwipeRefreshLayout;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class HotFragment extends BaseFragment {
    @BindView(R.id.rv_hot_recyclerview)
    RecyclerView rvHotRecyclerview;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    Unbinder unbinder;

    private List<EatingItem> mList = new ArrayList<>();
    private HotEatingListAdapter hotEatingListAdapter;
    private MyPullToRefreshListener pullToRefreshListener;

    private Context mContext;

    public static HotFragment newInstance() {
        return new HotFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.eating_fragment_hot;
    }

    @Override
    public void finishCreateView(Bundle state) {
        loadData();
        initRecyclerView();
        initPullRefresh();
        mContext = getContext();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    /**
     * 初始化recyclerview
     */
    private void initRecyclerView() {
        hotEatingListAdapter = new HotEatingListAdapter(mList);
        hotEatingListAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        hotEatingListAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                RestaurantDetailActivity.startRestaurantDetailActivity(mContext);
            }
        });
        hotEatingListAdapter.isFirstOnly(false);
        rvHotRecyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        rvHotRecyclerview.setAdapter(hotEatingListAdapter);

    }

    /**
     * 加载数据
     */
    protected void loadData() {
        EatingItem eatingItem = new EatingItem();
        eatingItem.setName("温馨农家乐");
        eatingItem.setDesc("新推出四川老火锅，欢迎品尝");
        eatingItem.setImageResource( R.drawable.test_image);
        eatingItem.setDistance(971);

        EatingItem eatingItem1 = new EatingItem("圆坊菜","独到川味","提供渔具，环境优美",R.drawable.test_eating_1,1820);
        EatingItem eatingItem2 = new EatingItem("拾味阁","特色菜","提供预定服务，川湘口味",R.drawable.test_eating_2,710);
        EatingItem eatingItem3 = new EatingItem("东方1号","山西风味","新老顾客活动大放送，订餐就有！",R.drawable.test_eating_3,324);
        EatingItem eatingItem4 = new EatingItem("风味汉老家","百年老店","特色菜品丰富，内有山西特产",R.drawable.test_eating_4,927);

        mList.add(eatingItem);
        mList.add(eatingItem1);
        mList.add(eatingItem2);
        mList.add(eatingItem3);
        mList.add(eatingItem4);



    }

    /**
     * 初始化下拉刷新
     */
    private void initPullRefresh() {
        pullToRefreshListener = new MyPullToRefreshListener(getContext(), swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                ToastUtils.showShortToast("刷新");
                pullToRefreshListener.refreshDone();
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);
    }
}

