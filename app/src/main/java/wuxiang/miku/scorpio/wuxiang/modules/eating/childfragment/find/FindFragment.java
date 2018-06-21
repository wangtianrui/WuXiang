package wuxiang.miku.scorpio.wuxiang.modules.eating.childfragment.find;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.eating.FindHeadChoiceAdapter;
import wuxiang.miku.scorpio.wuxiang.adapters.eating.FindEatingListAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;
import wuxiang.miku.scorpio.wuxiang.entity.EatingItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;

/**
 * Created by Wangtianrui on 2018/5/7.
 */

public class FindFragment extends BaseMVPFragment {

    private FindHeadChoiceAdapter headChoiceAdapter1;
    private FindHeadChoiceAdapter headChoiceAdapter2;
    private FindHeadChoiceAdapter headChoiceAdapter3;

    private FindEatingListAdapter adapter;

    private List<EatingItem> mList = new ArrayList<>();

    @BindView(R.id.eating_find_recycler)
    RecyclerView eatingFindRecycler;
    Unbinder unbinder;

    public static FindFragment newInstance() {
        return new FindFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.eating_fragment_find;
    }

    @Override
    protected void initEventAndData() {
        loadData();
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        unbinder.unbind();
    }

    /**
     * 初始化底层recycler
     */
    private void initView() {
        final View header = getActivity().getLayoutInflater().inflate(R.layout.layout_kind_find_head
                , (ViewGroup) eatingFindRecycler.getParent(), false);

        RecyclerView restaurantTypeRecycler = (RecyclerView) header.findViewById(R.id.rv_search_restaurant_type);
        RecyclerView foodTypeRecycler = (RecyclerView) header.findViewById(R.id.rv_search_food_type);
        RecyclerView distanceTypeRecycler = (RecyclerView) header.findViewById(R.id.rv_search_distance);
        restaurantTypeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        foodTypeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));
        distanceTypeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(),
                LinearLayoutManager.HORIZONTAL, false));

        headChoiceAdapter1 = new FindHeadChoiceAdapter(getActivity(),
                Arrays.asList(ConstantUtils.FIND_HEAD_REASTAURANT_LIST1));
        headChoiceAdapter2 = new FindHeadChoiceAdapter(getActivity(),
                Arrays.asList(ConstantUtils.FIND_HEAD_FOOD_LIST1));
        headChoiceAdapter3 = new FindHeadChoiceAdapter(getActivity(),
                Arrays.asList(ConstantUtils.FIND_HEAD_DISTANCE_LIST1));

        restaurantTypeRecycler.setAdapter(headChoiceAdapter1);
        foodTypeRecycler.setAdapter(headChoiceAdapter2);
        distanceTypeRecycler.setAdapter(headChoiceAdapter3);

        adapter = new FindEatingListAdapter(mList);
        adapter.isFirstOnly(false);
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);
        eatingFindRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter.addHeaderView(header);
        eatingFindRecycler.setAdapter(adapter);
    }

    /**
     * 加载数据
     */
    private void loadData() {
        EatingItem eatingItem = new EatingItem();
        eatingItem.setName("温馨农家乐");
        eatingItem.setDesc("新推出四川老火锅，欢迎品尝");
        eatingItem.setImageResource( R.drawable.test_image);
        eatingItem.setDistance(971);

        EatingItem eatingItem1 = new EatingItem("圆坊菜","独到川味","提供渔具，环境优美",R.drawable.test_eating_1,1820);
        EatingItem eatingItem2 = new EatingItem("拾味阁","特色菜","提供预定服务，川湘口味",R.drawable.test_eating_2,710);
        EatingItem eatingItem3 = new EatingItem("东方1号","山西风味","新老顾客活动大放送，订餐就有！",R.drawable.test_eating_3,324);
        EatingItem eatingItem4 = new EatingItem("风味汉老家","百年老店","特色菜品丰富，内有山西特产",R.drawable.test_eating_4,927);

        mList.add(eatingItem4);
        mList.add(eatingItem2);
        mList.add(eatingItem3);
        mList.add(eatingItem);
        mList.add(eatingItem1);
    }


}
