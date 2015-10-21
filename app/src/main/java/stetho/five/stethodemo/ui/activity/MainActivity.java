package stetho.five.stethodemo.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import stetho.five.stethodemo.R;
import stetho.five.stethodemo.business.provider.DemoItem;
import stetho.five.stethodemo.ui.adapter.DemoPagerAdapter;


public class MainActivity extends FragmentActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.tab_layout)
    TabLayout tabLayout;

    @Bind(R.id.view_pager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setupViewPager();
    }

    private void setupViewPager() {
        DemoPagerAdapter adapter = new DemoPagerAdapter(getSupportFragmentManager(), DemoItem.getDemoItems());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabsFromPagerAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        ButterKnife.unbind(this);
        super.onDestroy();
    }
}
