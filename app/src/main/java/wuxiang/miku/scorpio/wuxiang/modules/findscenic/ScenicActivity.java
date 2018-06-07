package wuxiang.miku.scorpio.wuxiang.modules.findscenic;

import android.os.Bundle;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import wuxiang.miku.scorpio.wuxiang.R;

public class ScenicActivity extends AppCompatActivity {

    @BindView(R.id.scenic_bg)
    ImageView scenicBg;
    @BindView(R.id.rl_restaurant_info)
    RelativeLayout rlRestaurantInfo;
    @BindView(R.id.location_text_view)
    TextView locationTextView;
    @BindView(R.id.cast_text_view)
    TextView castTextView;
    @BindView(R.id.scenic_nagigation_button)
    ImageView scenicNagigationButton;
    @BindView(R.id.scnic_photo_show_recyclerview)
    RecyclerView scnicPhotoShowRecyclerview;
    @BindView(R.id.sc_movie_detail)
    NestedScrollView scMovieDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scenic);
        ButterKnife.bind(this);
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        scenicBg.setImageResource(R.drawable.wuxiangtest);
    }
}
