package wuxiang.miku.scorpio.wuxiang.modules.find;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.findscenic.ScenicRecyclerAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;
import wuxiang.miku.scorpio.wuxiang.entity.FindScenicItem;

/**
 * Created by Wangtianrui on 2018/5/9.
 */

public class FindFragment extends BaseMVPFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.find_recycler_view)
    RecyclerView findScenicRecyclerView;
    Unbinder unbinder;

    private ScenicRecyclerAdapter scenicRecyclerAdapter;
    private ArrayList<FindScenicItem> mList = new ArrayList<>();
    private ArrayList<Integer> bannerItemList = new ArrayList<>();

    /**
     * maker
     *
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
        loadData();
        initRecycler();
    }


    /**
     * 初始化recycler
     */
    private void initRecycler() {
        scenicRecyclerAdapter = new ScenicRecyclerAdapter(mList);
        scenicRecyclerAdapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        scenicRecyclerAdapter.isFirstOnly(false);
        findScenicRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        findScenicRecyclerView.setAdapter(scenicRecyclerAdapter);
        findScenicRecyclerView.setNestedScrollingEnabled(false);
    }

    /**
     * 初始化数据
     */
    private void loadData() {
        for (int i = 0; i < 5; i++) {
            bannerItemList.add(R.drawable.wuxiangtest);
        }
        FindScenicItem findScenicItem = new FindScenicItem();
        findScenicItem.setImageUrls(bannerItemList);
        for (int i = 0; i < 10; i++) {
            mList.add(findScenicItem);
        }
    }


}
