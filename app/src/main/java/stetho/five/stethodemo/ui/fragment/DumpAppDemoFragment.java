package stetho.five.stethodemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import stetho.five.stethodemo.R;

public final class DumpAppDemoFragment extends Fragment {

    public static DumpAppDemoFragment newInstance() {
        DumpAppDemoFragment fragment = new DumpAppDemoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_demo_database, container, false);        // TODO - drugi layout
        ButterKnife.bind(this, fragmentView);
        return fragmentView;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
