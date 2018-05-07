package wuxiang.miku.scorpio.wuxiang.adapters.eating;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FindHeadChoiceItem;

/**
 * Created by Wangtianrui on 2018/5/7.
 */

public class FindHeadChoiceAdapter extends RecyclerView.Adapter<FindHeadChoiceHolder> {
    private Context mContext;
    private List<String> mList;

    public FindHeadChoiceAdapter(Context mContext, List mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public FindHeadChoiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_head_choie_filter, parent, false);
        return new FindHeadChoiceHolder(v,mContext);
    }

    @Override
    public void onBindViewHolder(FindHeadChoiceHolder holder, int position) {
        holder.bindView(mList.get(position),position);

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
