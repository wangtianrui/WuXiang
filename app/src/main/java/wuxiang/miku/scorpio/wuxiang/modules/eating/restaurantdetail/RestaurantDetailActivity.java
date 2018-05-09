package wuxiang.miku.scorpio.wuxiang.modules.eating.restaurantdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

import java.util.ArrayList;
import java.util.Set;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.adapters.restaurantdetail.DetailPhotoAdapter;
import wuxiang.miku.scorpio.wuxiang.adapters.restaurantdetail.DetialCommentAdapter;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPActivity;
import wuxiang.miku.scorpio.wuxiang.entity.CommentItem;
import wuxiang.miku.scorpio.wuxiang.entity.DetailPhotoItem;
import wuxiang.miku.scorpio.wuxiang.entity.TagItem;
import wuxiang.miku.scorpio.wuxiang.utils.GlideUtils;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;
import wuxiang.miku.scorpio.wuxiang.utils.UiUtils;

/**
 * Created by Wangtianrui on 2018/5/8.
 */

public class RestaurantDetailActivity extends BaseMVPActivity {
    @BindView(R.id.iv_blur_bg)
    ImageView ivBlurBg;
    @BindView(R.id.iv_restaurant_img)
    ImageView ivRestaurantImg;
    @BindView(R.id.fl_restaurant_img)
    CardView flRestaurantImg;
    @BindView(R.id.tv_restaurant_name)
    TextView tvRestaurantName;
    @BindView(R.id.tv_restaurant_score)
    TextView tvRestaurantScore;
    @BindView(R.id.tv_snum)
    TextView tvSnum;
    @BindView(R.id.tv_pro_num)
    TextView tvProNum;
    @BindView(R.id.tv_src_dur)
    TextView tvSrcDur;
    @BindView(R.id.rl_restaurant_info)
    RelativeLayout rlRestaurantInfo;
    @BindView(R.id.detail_cost_text_view)
    TextView detailCostTextView;
    @BindView(R.id.detail_call_text_view)
    TextView detailCallTextView;
    @BindView(R.id.detail_make_call_button)
    ImageView detailMakeCallButton;
    @BindView(R.id.detail_photo_show_recyclerview)
    RecyclerView detailPhotoShowRecyclerview;
    @BindView(R.id.detail_comment_recyclerview)
    RecyclerView detailCommentRecyclerview;
    @BindView(R.id.sc_movie_detail)
    NestedScrollView scMovieDetail;
    @BindView(R.id.flowLayout)
    TagFlowLayout flowLayout;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_subTitle)
    TextView tvSubTitle;
    @BindView(R.id.ll_title)
    LinearLayout llTitle;
    @BindView(R.id.status_bar_bg)
    View statusBarBg;
    @BindView(R.id.rl_back)
    RelativeLayout rlBack;
    @BindView(R.id.divider)
    View divider;
    @BindView(R.id.iv_title_right_icon)
    ImageView ivTitleRightIcon;
    @BindView(R.id.rl_right_icon)
    RelativeLayout rlRightIcon;

    private ArrayList<TagItem> mTags = new ArrayList<>();
    private ArrayList<CommentItem> mComments = new ArrayList<>();
    private ArrayList<DetailPhotoItem> mPhotos = new ArrayList<>();
    private DetialCommentAdapter detialCommentAdapter;
    private DetailPhotoAdapter detailPhotoAdapter;

    public static void startRestaurantDetailActivity(Context context) {
        Intent start = new Intent(context, RestaurantDetailActivity.class);
        context.startActivity(start);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_restaurant_detial;
    }

    @Override
    protected void initEventAndData() {
        loadData();
        initView();
        initStatusBar();
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }


    @OnClick(R.id.detail_make_call_button)
    public void onViewClicked() {

    }

    /**
     * 初始化view
     */
    private void initView() {

        /**
         * 下拉Title初始化
         */
        final int changedHeight = UiUtils.dp2px(mContext, 214);
        scMovieDetail.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {

                float scale = (float) v.getScrollY() / changedHeight;
                //变化范围0-255 表示从透明到纯色背景
                float alpha = scale * 255 >= 255 ? 255 : scale * 255;

                llTitle.setBackgroundColor(Color.argb((int) alpha, 212, 62, 55));
                tvTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));
                tvSubTitle.setTextColor(Color.argb((int) alpha, 255, 255, 255));

            }
        });

        /**
         * 流式布局初始化
         */
        flowLayout.setAdapter(new TagAdapter<TagItem>(mTags) {

            @Override
            public View getView(FlowLayout parent, int position, TagItem tagItem) {
                String s = tagItem.getTagName();
                TextView tv = (TextView) getLayoutInflater().inflate(R.layout.layout_flow_tv, flowLayout, false);
                tv.setText(s);
                return tv;
            }
        });
        flowLayout.setOnSelectListener(new TagFlowLayout.OnSelectListener() {
            @Override
            public void onSelected(Set<Integer> selectPosSet) {
                ToastUtils.showShortToast(selectPosSet.toString());
            }
        });


        /**
         * 初始化评论区
         *
         */

        detialCommentAdapter = new DetialCommentAdapter(mComments);
        //detialCommentAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
        detailCommentRecyclerview.setLayoutManager(new LinearLayoutManager(mContext));
        detailCommentRecyclerview.setAdapter(detialCommentAdapter);
        detailCommentRecyclerview.setNestedScrollingEnabled(false);

        /**
         * 初始化图片介绍
         */
        detailPhotoAdapter = new DetailPhotoAdapter(mPhotos);
        detailPhotoShowRecyclerview.setLayoutManager(new LinearLayoutManager(mContext,
                LinearLayoutManager.HORIZONTAL, false));
        detailPhotoShowRecyclerview.setAdapter(detailPhotoAdapter);
    }

    /**
     * 加载数据
     */
    private void loadData() {
        TagItem tagItem = new TagItem();

        tagItem.setTagName("好评 123124");
        for (int i = 0; i < 5; i++) {
            tagItem.setCount(i);
            mTags.add(tagItem);
        }

        CommentItem commentItem = new CommentItem();
        commentItem.setCommment("我很喜欢这这家店弄的蛋包饭");
        for (int i = 0; i < 10; i++) {
            mComments.add(commentItem);
        }
        for (int i = 0; i < 10; i++) {
            mPhotos.add(new DetailPhotoItem());
        }
        /**
         * 初始化店家相关数据
         */
        GlideUtils.loadImage(mContext, R.drawable.test_image, ivRestaurantImg);
    }


    /**
     * 动态设置statusBarView的高度
     */
    private void initStatusBar() {
        LinearLayout.LayoutParams status_bar_params = (LinearLayout.LayoutParams) statusBarBg.getLayoutParams();
        //获取状态栏的高度
        int height = getResources().getDimensionPixelSize(getResources().getIdentifier("status_bar_height", "dimen", "android"));
        status_bar_params.height = height;
        statusBarBg.setLayoutParams(status_bar_params);
        FrameLayout.LayoutParams title_params = (FrameLayout.LayoutParams) llTitle.getLayoutParams();
        //将Title布局往上移动状态栏的高度
        title_params.setMargins(0, -height, 0, 0);
        llTitle.setLayoutParams(title_params);
//        FrameLayout.LayoutParams progressLayoutParams = (FrameLayout.LayoutParams) progressLayout.getLayoutParams();
//        progressLayoutParams.setMargins(0, -height, 0, 0);
//        progressLayout.setLayoutParams(progressLayoutParams);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
