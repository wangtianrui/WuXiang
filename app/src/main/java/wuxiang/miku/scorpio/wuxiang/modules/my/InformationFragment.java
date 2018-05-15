package wuxiang.miku.scorpio.wuxiang.modules.my;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.base.BaseMVPFragment;
import wuxiang.miku.scorpio.wuxiang.utils.GlideUtils;
import wuxiang.miku.scorpio.wuxiang.view.CircleImageView;
//
/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class InformationFragment extends BaseMVPFragment {
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.information_avatar_circle_image_view)
    CircleImageView informationAvatarCircleImageView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.collapsing_layout)
    CollapsingToolbarLayout collapsingLayout;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    Unbinder unbinder;
    @BindView(R.id.information_user_name_text_view)
    TextView informationUserNameTextView;
    Unbinder unbinder1;

    /**
     * maker
     *
     * @return
     */
    public static InformationFragment newInstance() {
        return new InformationFragment();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.my_information_fragment_main;
    }

    @Override
    protected void initEventAndData() {
        initUserData();
    }

    /**
     * 初始化用户信息
     */
    private void initUserData() {
        GlideUtils.loadImage(mContext, R.drawable.user_avatar_test, informationAvatarCircleImageView);
        informationUserNameTextView.setText("ScorpioMiku");
    }


}
