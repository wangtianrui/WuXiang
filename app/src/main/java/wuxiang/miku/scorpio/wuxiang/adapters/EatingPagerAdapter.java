package wuxiang.miku.scorpio.wuxiang.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.Toast;

import wuxiang.miku.scorpio.wuxiang.modules.eating.childfragment.hot.HotFragment;
import wuxiang.miku.scorpio.wuxiang.utils.ToastUtils;

/**
 * Created by Wangtianrui on 2018/5/6.
 */

public class EatingPagerAdapter extends FragmentPagerAdapter {
    private Fragment[] fragments;
    private String[] titles;

    public EatingPagerAdapter(FragmentManager fm, Context applicationContext, String[] title) {
        super(fm);
        this.titles = title;
        fragments = new Fragment[titles.length];
    }

    @Override
    public Fragment getItem(int position) {
        ToastUtils.showLongToast(position + "");
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = HotFragment.newInstance();
                    break;
                case 1:
                    fragments[position] = HotFragment.newInstance();
                    break;
                case 2:
                    fragments[position] = HotFragment.newInstance();
                    break;
                default:
                    break;
            }
        }
        return fragments[position];
    }

    @Override
    public int getCount() {
        return titles.length;
    }
}
