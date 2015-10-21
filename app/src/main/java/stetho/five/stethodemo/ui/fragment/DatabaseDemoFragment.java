package stetho.five.stethodemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnItemLongClick;
import stetho.five.stethodemo.R;
import stetho.five.stethodemo.application.Injector;
import stetho.five.stethodemo.business.dao.DemoDao;
import stetho.five.stethodemo.business.dao.model.Variable;
import stetho.five.stethodemo.ui.adapter.VariableItemAdapter;

public final class DatabaseDemoFragment extends Fragment {

    private DemoDao demoDao;
    private List<Variable> variables;
    private VariableItemAdapter adapter;

    @Bind(R.id.swipe_to_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Bind(R.id.list_view)
    ListView dataListView;

    public static DatabaseDemoFragment newInstance() {
        DatabaseDemoFragment fragment = new DatabaseDemoFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_demo_database, container, false);
        ButterKnife.bind(this, fragmentView);
        demoDao = Injector.getInstance(getActivity()).getDemoDao();
        setupPullToRefresh();
        setupListView();
        return fragmentView;
    }

    private void setupPullToRefresh() {
        swipeRefreshLayout.setColorSchemeResources(R.color.primary);
        swipeRefreshLayout.setOnRefreshListener(() -> onPullToRefresh());
    }

    private void onPullToRefresh() {
        setupListView();
        if (swipeRefreshLayout.isRefreshing()) {
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    private void setupListView(){
        variables = demoDao.getAllVariables();
        adapter = new VariableItemAdapter(getActivity());
        adapter.addAll(variables);
        dataListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @OnItemLongClick(R.id.list_view)
    public boolean onVariableLongClick(int position) {
        demoDao.deleteVariableWithId(variables.get(position).getId());
        variables.remove(position);
        adapter.clear();
        adapter.addAll(variables);
        return true;
    }

    @Override
    public void onDestroyView() {
        ButterKnife.unbind(this);
        super.onDestroyView();
    }
}
