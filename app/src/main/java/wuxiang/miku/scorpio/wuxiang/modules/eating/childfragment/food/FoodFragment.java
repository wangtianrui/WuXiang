package wuxiang.miku.scorpio.wuxiang.modules.eating.childfragment.food;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.eating.FoodAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;
import wuxiang.miku.scorpio.wuxiang.entity.FoodItem;
import wuxiang.miku.scorpio.wuxiang.view.ProgressLayout;
import wuxiang.miku.scorpio.wuxiang.view.SuperSwipeRefreshLayout;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class FoodFragment extends BaseMVPFragment {
    @BindView(R.id.rv_food_recyclerview)
    RecyclerView rvFoodRecyclerview;
    @BindView(R.id.swipe)
    SuperSwipeRefreshLayout swipe;
    @BindView(R.id.progressLayout)
    ProgressLayout progressLayout;
    Unbinder unbinder;

    private ArrayList<FoodItem> mList = new ArrayList<>();
    private FoodAdapter foodAdapter;

    /**
     * maker
     *
     * @return
     */
    public static FoodFragment newInstance() {
        return new FoodFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.eating_fragment_food;
    }

    @Override
    protected void initEventAndData() {
        loadData();
        initRecyclerView();
    }

    /**
     * 初始化recyclerview
     */
    private void initRecyclerView() {
        foodAdapter = new FoodAdapter(mList);
        foodAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        rvFoodRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        rvFoodRecyclerview.setNestedScrollingEnabled(false);
        rvFoodRecyclerview.setAdapter(foodAdapter);
    }

    /**
     * 初始化数据
     */
    private void loadData() {
        for (int i = 0; i < 10; i++) {
            mList.add(new FoodItem());
        }
    }


}
