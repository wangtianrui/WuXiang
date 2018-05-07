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
        unbinder.unbind();
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
        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
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
        eatingItem.setDesc("我最棒");

        for (int i = 0; i < 10; i++) {
            eatingItem.setInformation(i + "");
            mList.add(eatingItem);
        }
    }


}
