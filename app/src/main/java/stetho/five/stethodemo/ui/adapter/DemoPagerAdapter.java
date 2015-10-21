package stetho.five.stethodemo.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import stetho.five.stethodemo.business.provider.DemoItem;
import stetho.five.stethodemo.ui.fragment.DatabaseDemoFragment;
import stetho.five.stethodemo.ui.fragment.DumpAppDemoFragment;
import stetho.five.stethodemo.ui.fragment.NetworkDemoFragment;
import stetho.five.stethodemo.ui.fragment.PreferencesDemoFragment;
import stetho.five.stethodemo.ui.fragment.UiDemoFragment;

public final class DemoPagerAdapter extends FragmentStatePagerAdapter {

    private final List<DemoItem> tabs;

    public DemoPagerAdapter(FragmentManager fm, List<DemoItem> tabs) {
        super(fm);
        this.tabs = tabs;
    }

    @Override
    public Fragment getItem(int position) {
        DemoItem item = tabs.get(position);
        switch (item){
            case DATABSE:
                return DatabaseDemoFragment.newInstance();
            case PREFERENCES:
                return PreferencesDemoFragment.newInstance();
            case NETWORK:
                return NetworkDemoFragment.newInstance();
            case UI:
                return UiDemoFragment.newInstance();
            case DUMPAPP:
                return DumpAppDemoFragment.newInstance();
        }
        return DatabaseDemoFragment.newInstance();
    }

    @Override
    public int getCount() {
        return tabs.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs.get(position).getTitle();
    }
}
