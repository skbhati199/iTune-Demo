package com.metro.itunesdemo.ui.home;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;

import com.android.databinding.library.baseAdapters.BR;
import com.metro.itunesdemo.R;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.databinding.ActivityHomeBinding;
import com.metro.itunesdemo.ui.adapter.ITuneRecyclerViewAdapter;
import com.metro.itunesdemo.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

public class HomeActivity extends BaseActivity<ActivityHomeBinding, HomeViewModel> implements HomeNavigator, ITuneRecyclerViewAdapter.ITuneAdapterListener {


    @Inject
    ViewModelProvider.Factory mViewModelFactory;
    @Inject
    LinearLayoutManager mLayoutManager;
    @Inject
    ITuneRecyclerViewAdapter iTuneRecyclerViewAdapter;
    ActivityHomeBinding activityHomeBinding;
    HomeViewModel mHomeViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding = getViewDataBinding();
        mHomeViewModel.setNavigator(this);
        setUp();
        subscribeToLiveData();
    }

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    @Override
    public HomeViewModel getViewModel() {
        mHomeViewModel = ViewModelProviders.of(this, mViewModelFactory).get(HomeViewModel.class);
        return mHomeViewModel;
    }

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_home;
    }

    private void setUp() {
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        activityHomeBinding.recyclerView.setLayoutManager(mLayoutManager);
        activityHomeBinding.recyclerView.setItemAnimator(new DefaultItemAnimator());
        activityHomeBinding.recyclerView.setAdapter(iTuneRecyclerViewAdapter);
        iTuneRecyclerViewAdapter.setListener(this);
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    private void subscribeToLiveData() {
        mHomeViewModel.getListLiveData().observe(this, searchModel -> mHomeViewModel.addItems(searchModel));
    }

    @Override
    public void updateItem(List<Result> blogList) {
        iTuneRecyclerViewAdapter.addItems(blogList);
    }


    @Override
    public void handleError(Throwable throwable) {

    }

    @Override
    public void onRetryClick() {

    }
}
