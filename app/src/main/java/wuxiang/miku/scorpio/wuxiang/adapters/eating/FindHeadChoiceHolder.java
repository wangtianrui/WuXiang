package wuxiang.miku.scorpio.wuxiang.adapters.eating;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FindHeadChoiceItem;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

/**
 * Created by Wangtianrui on 2018/5/7.
 */

public class FindHeadChoiceHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.tv_movie_type)
    TextView tvTextType;
    public boolean isClicked = false;
    private Context context;


    public FindHeadChoiceHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;
        ButterKnife.bind(this, itemView);
    }

//    @TargetApi(Build.VERSION_CODES.M)
//    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
//    public void bindView(String text, final int position) {
//        tvTextType.setText(text);
//        Log.d(ConstantUtils.TAG, "bindView: " + position);
//        if (position != 0) {
//            itemView.setOnClickListener(new View.OnClickListener() {
//                @RequiresApi(api = Build.VERSION_CODES.M)
//                @Override
//                public void onClick(View v) {
//                    if (isClicked) {
//                        isClicked = false;
//                    } else {
//                        isClicked = true;
//                    }
//                    if (isClicked) {
//                        tvTextType.setBackground(context.getDrawable(R.drawable.bg_tv_movie_type_pre));
//                        tvTextType.setTextColor(context.getColor(R.color.white));
//                    } else {
//                        tvTextType.setBackground(context.getDrawable(R.drawable.bg_tv_movie_type_nor));
//                        tvTextType.setTextColor(context.getColor(R.color.black_semi_transparent));
//                    }
//                    ToastUtils.showShortToast(tvTextType.getText() + "");
//                }
//            });
//        } else {
//            tvTextType.setBackground(context.getDrawable(R.drawable.bg_tv_movie_type_pre));
//            tvTextType.setTextColor(context.getColor(R.color.white));
//        }
//    }
}
