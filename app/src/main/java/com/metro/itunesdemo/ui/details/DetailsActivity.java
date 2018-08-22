package com.metro.itunesdemo.ui.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.databinding.library.baseAdapters.BR;
import com.metro.itunesdemo.R;
import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.databinding.ActivityDetialsBinding;
import com.metro.itunesdemo.ui.base.BaseActivity;
import com.metro.itunesdemo.ui.base.BaseViewModel;
import com.metro.itunesdemo.ui.home.HomeViewModel;
import com.metro.itunesdemo.utils.AppConstants;

import javax.inject.Inject;

public class DetailsActivity extends BaseActivity<ActivityDetialsBinding, DetailsViewModel> implements DetailsNavigator {

    @Inject
    DetailsViewModel mDetailsViewModel;
    ActivityDetialsBinding mActivityDetialsBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityDetialsBinding = getViewDataBinding();
        mDetailsViewModel.setNavigator(this);
        int trackId = 159293848;
        if (getIntent().getExtras() != null){
            trackId = getIntent().getIntExtra(AppConstants.TRACK_ID, trackId);
        }
        mDetailsViewModel.getFilterData(trackId);
        Toolbar toolbar = mActivityDetialsBinding.toolbar;
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        FloatingActionButton fab = mActivityDetialsBinding.fab;
        fab.setOnClickListener(view -> Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    @Override
    public DetailsViewModel getViewModel() {
        return mDetailsViewModel;
    }
    @Override
    public int getBindingVariable() {
        return BR.viewModel;
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_detials;
    }

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }

    @Override
    public void handle(Throwable throwable) {

    }

    @Override
    public void updateResult(Result result) {
        Toast.makeText(this, "Result " + result.getArtistName(), Toast.LENGTH_SHORT).show();
    }
}
