package wuxiang.miku.scorpio.wuxiang.adapters.findscenic;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.zhouwei.mzbanner.holder.MZViewHolder;

import wuxiang.miku.scorpio.wuxiang.R;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class BannerViewHolder implements MZViewHolder<Integer> {
    private ImageView imageView;

    @Override
    public View createView(Context context) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_banner, null);
        imageView = view.findViewById(R.id.banner_image);
        return view;
    }

    @Override
    public void onBind(Context context, int i, Integer data) {
        imageView.setImageResource(data);
    }
}
