package wuxiang.miku.scorpio.wuxiang.adapters.eating;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FindHeadChoiceItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

/**
 * Created by Wangtianrui on 2018/5/7.
 */

public class FindHeadChoiceAdapter extends RecyclerView.Adapter<FindHeadChoiceHolder> {
    private Context mContext;
    private List<String> mList;
    private Boolean isChoosed = false;

    public FindHeadChoiceAdapter(Context mContext, List mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public FindHeadChoiceHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_head_choie_filter, parent, false);
        return new FindHeadChoiceHolder(v, mContext);
    }


    @TargetApi(Build.VERSION_CODES.M)
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBindViewHolder(final FindHeadChoiceHolder holder, int position) {
        holder.tvTextType.setText(mList.get(position));
        Log.d(ConstantUtils.TAG, "bindView: " + position);
        if (position != 0) {
            holder.tvTextType.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    if (holder.isClicked) {
                        holder.isClicked = false;
                    } else {
                        holder.isClicked = true;
                    }
                    if (holder.isClicked) {
                        holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_pre));
                        holder.tvTextType.setTextColor(mContext.getColor(R.color.white));
                    } else {
                        holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_nor));
                        holder.tvTextType.setTextColor(mContext.getColor(R.color.black_semi_transparent));
                    }
                    ToastUtils.showShortToast(holder.tvTextType.getText() + "");
                    if (isChoosed == false) {
                        isChoosed = true;
                        notifyItemChanged(0);
                    }

                }
            });
        } else {
            holder.tvTextType.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.M)
                @Override
                public void onClick(View v) {
                    if (holder.isClicked) {
                        holder.isClicked = false;
                    } else {
                        holder.isClicked = true;
                    }
                    if (holder.isClicked) {
                        holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_pre));
                        holder.tvTextType.setTextColor(mContext.getColor(R.color.white));
                        isChoosed = false;
                    } else {
                        holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_nor));
                        holder.tvTextType.setTextColor(mContext.getColor(R.color.black_semi_transparent));
                    }
                    ToastUtils.showShortToast(holder.tvTextType.getText() + "");
                }
            });

            if (isChoosed == true) {
                holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_nor));
                holder.tvTextType.setTextColor(mContext.getColor(R.color.black_semi_transparent));
            } else {
                holder.tvTextType.setBackground(mContext.getDrawable(R.drawable.bg_tv_movie_type_pre));
                holder.tvTextType.setTextColor(mContext.getColor(R.color.white));
                holder.isClicked = true;
            }

        }
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }
}
