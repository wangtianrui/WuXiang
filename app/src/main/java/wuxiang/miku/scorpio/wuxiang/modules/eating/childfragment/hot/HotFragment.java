package wuxiang.miku.scorpio.wuxiang.modules.eating.childfragment.hot;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.eating.HotEatingListAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseFragment;
import wuxiang.miku.scorpio.wuxiang.entity.EatingItem;
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
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 初始化recyclerview
     */
    private void initRecyclerView() {
        hotEatingListAdapter = new HotEatingListAdapter(mList);
        hotEatingListAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
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
        eatingItem.setDesc("我最棒");

        for (int i = 0; i < 10; i++) {
            eatingItem.setInformation(i + "");
            mList.add(eatingItem);
        }
    }

    /**
     * 初始化下拉刷新
     */
    private void initPullRefresh() {
        pullToRefreshListener = new MyPullToRefreshListener(getContext(), swipe);
        pullToRefreshListener.setOnRefreshListener(new MyPullToRefreshListener.OnRefreshListener() {
            @Override
            public void refresh() {
                ToastUtils.showShortToast("shuaxin");
                pullToRefreshListener.refreshDone();
            }
        });
        swipe.setOnPullRefreshListener(pullToRefreshListener);
    }
}

