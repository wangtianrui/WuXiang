package wuxiang.miku.scorpio.wuxiang.modules.navigation;

import android.os.Binder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.model.LatLng;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import wuxiang.miku.scorpio.wuxiang.R;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;


/**
 * Created by Wangtianrui on 2018/5/10.
 */

public class NavigationFragment extends Fragment {
    @BindView(R.id.baidu_map)
    MapView mMapView;
    Unbinder unbinder;
    private boolean isFirstLocate = true;

    private BaiduMap mBaiduMap;

    public LocationClient mLocationClient;

    /**
     * maker
     *
     * @return
     */
    public static NavigationFragment newInstance() {
        return new NavigationFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.navigation_fragment_main, container, false);
        ButterKnife.bind(this, v);
        initEventAndData();
        return v;
    }


    private void initEventAndData() {
        initMap();
    }

    /**
     * 百度地图
     */
    private void initMap() {
        mBaiduMap = mMapView.getMap();
        MapStatusUpdate update = MapStatusUpdateFactory.zoomTo(12.5f);
        mBaiduMap.animateMapStatus(update);
        mLocationClient = new LocationClient(getContext());
        mLocationClient.registerLocationListener(new MyLocationListener());
        mLocationClient.start();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    /**
     * 位置初始化
     *
     * @param location
     */
    private void navigateTo(BDLocation location) {
        if (isFirstLocate) {
            LatLng ll = new LatLng(location.getLatitude(), location.getLongitude());
            MapStatusUpdate update = MapStatusUpdateFactory.newLatLng(ll);
            mBaiduMap.animateMapStatus(update);
            update = MapStatusUpdateFactory.zoomTo(16f);
            mBaiduMap.animateMapStatus(update);
            isFirstLocate = false;
        }
    }

    public class MyLocationListener implements BDLocationListener {

        @Override
        public void onReceiveLocation(BDLocation bdLocation) {
            if (bdLocation.getLocType() == BDLocation.TypeGpsLocation
                    || bdLocation.getLocType() == BDLocation.TypeNetWorkLocation) {
                navigateTo(bdLocation);
            }
        }
    }
}

