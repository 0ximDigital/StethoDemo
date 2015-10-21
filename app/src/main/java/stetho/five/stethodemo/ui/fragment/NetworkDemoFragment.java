package stetho.five.stethodemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.OnClick;
import stetho.five.stethodemo.R;
import stetho.five.stethodemo.application.Injector;

public final class NetworkDemoFragment extends Fragment {

    private static final String NORMAL_REQUEST = "https://www.android.com/";
    private static final String IMAGE_REQUEST = "https://lh3.ggpht.com/04DjMWrG_qAyMBj_sMi4AlQgR5nHZAc_H9r7DwXU5MyH35mpUjHQZVYB0ylQJ9o7Qf4=w300";

    private OkHttpClient okHttpClient;

    public static NetworkDemoFragment newInstance() {
        NetworkDemoFragment fragment = new NetworkDemoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_demo_network, container, false);
        ButterKnife.bind(this, fragmentView);
        okHttpClient = Injector.getInstance(getActivity()).getOkHttpClient();
        return fragmentView;
    }

    @OnClick(R.id.normal_request_button)
    public void makeNormalRequest() {
        new Thread(() -> {
            try {
                okHttpClient.newCall(
                        new Request.Builder().url(NORMAL_REQUEST).build()
                ).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @OnClick(R.id.image_request_button)
    public void makeImageRequest() {
        new Thread(() -> {
            try {
                okHttpClient.newCall(
                        new Request.Builder().url(IMAGE_REQUEST).build()
                ).execute();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
