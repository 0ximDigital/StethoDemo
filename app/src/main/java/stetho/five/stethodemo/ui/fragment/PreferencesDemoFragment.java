package stetho.five.stethodemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;
import stetho.five.stethodemo.R;
import stetho.five.stethodemo.application.Injector;
import stetho.five.stethodemo.util.PreferenceUtils;

public final class PreferencesDemoFragment extends Fragment {

    private PreferenceUtils preferenceUtils;

    public static PreferencesDemoFragment newInstance() {
        PreferencesDemoFragment fragment = new PreferencesDemoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_prefs_demo, container, false);
        ButterKnife.bind(this, fragmentView);
        preferenceUtils = Injector.getInstance(getActivity()).getPreferenceUtils();
        return fragmentView;
    }

    @OnClick(R.id.prefs_button)
    public void onPrefsButtonClick() {
        if (preferenceUtils.getShowToast()) {
            Toast.makeText(getActivity(), "One time toast", Toast.LENGTH_LONG).show();
            preferenceUtils.setShowToast(false);
        }
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
