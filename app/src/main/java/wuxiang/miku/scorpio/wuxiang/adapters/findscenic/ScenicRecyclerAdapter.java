package wuxiang.miku.scorpio.wuxiang.adapters.findscenic;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.zhouwei.mzbanner.MZBannerView;
import com.zhouwei.mzbanner.holder.MZHolderCreator;
import com.zhouwei.mzbanner.holder.MZViewHolder;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.entity.FindScenicItem;
import wuxiang.miku.scorpio.wuxiang.modules.findscenic.ScenicActivity;
import wuxiang.miku.scorpio.wuxiang.utils.ConstantUtils;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class ScenicRecyclerAdapter extends BaseMultiItemQuickAdapter<FindScenicItem, BaseViewHolder> {
    private Context mContext;

    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public ScenicRecyclerAdapter(List<FindScenicItem> data, Context context) {
        super(data);
        addItemType(ConstantUtils.TYPE_SCENIC, R.layout.item_find_fragment_scenic);
        mContext = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, FindScenicItem item) {
        MZBannerView itemRowView = (MZBannerView) helper.getView(R.id.item_row_view);
        itemRowView.setIndicatorAlign(MZBannerView.IndicatorAlign.CENTER);
        TextView click = helper.getView(R.id.click);
        itemRowView.setPages(item.getImageUrls(), new MZHolderCreator() {
            @Override
            public MZViewHolder createViewHolder() {
                return new BannerViewHolder();
            }
        });
//        CardView cardView = helper.getView(R.id.click);
//        cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(mContext, ScenicActivity.class);
//                mContext.startActivity(intent);
//            }
//        });
//        itemRowView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ScenicActivity.class);
                mContext.startActivity(intent);
            }
        });
        itemRowView.setBannerPageClickListener(new MZBannerView.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int i) {
                ToastUtils.showShortToast(i + "");
                Intent intent = new Intent(mContext, ScenicActivity.class);
                mContext.startActivity(intent);
            }
        });
        //itemRowView.start();

    }
}
