package wuxiang.miku.scorpio.wuxiang.modules.findscenic;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;

import butterknife.BindView;
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
    private ArrayList<Integer> bannerItemList1 = new ArrayList<>();
    private ArrayList<Integer> bannerItemList2 = new ArrayList<>();
    private ArrayList<Integer> bannerItemList3 = new ArrayList<>();
    private ArrayList<Integer> bannerItemList4 = new ArrayList<>();



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
        scenicRecyclerAdapter = new ScenicRecyclerAdapter(mList,mContext);
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
        for (int i = 0; i < 5; i++) {
            bannerItemList1.add(R.drawable.s_test_1);
        }
        for (int i = 0; i < 5; i++) {
            bannerItemList2.add(R.drawable.s_test_2);
        }
        for (int i = 0; i < 5; i++) {
            bannerItemList3.add(R.drawable.s_test_3);
        }
        for (int i = 0; i < 5; i++) {
            bannerItemList4.add(R.drawable.s_test_4);
        }

        FindScenicItem findScenicItem1 = new FindScenicItem();
        findScenicItem1.setImageUrls(bannerItemList);
        findScenicItem1.setName("红军遗址");

        FindScenicItem findScenicItem2 = new FindScenicItem();
        findScenicItem2.setImageUrls(bannerItemList1);
        findScenicItem2.setName("博物馆");

        FindScenicItem findScenicItem3 = new FindScenicItem();
        findScenicItem3.setImageUrls(bannerItemList2);
        findScenicItem3.setName("武乡山村之境");

        FindScenicItem findScenicItem4 = new FindScenicItem();
        findScenicItem4.setImageUrls(bannerItemList3);
        findScenicItem4.setName("桃花园");

        FindScenicItem findScenicItem5 = new FindScenicItem();
        findScenicItem5.setImageUrls(bannerItemList4);
        findScenicItem5.setName("八路军司令指挥部");

        mList.add(findScenicItem1);
        mList.add(findScenicItem2);
        mList.add(findScenicItem3);
        mList.add(findScenicItem4);
        mList.add(findScenicItem5);

    }


}
