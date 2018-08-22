package com.metro.itunesdemo.ui.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.metro.itunesdemo.data.remote.model.Result;
import com.metro.itunesdemo.data.remote.model.SearchModel;
import com.metro.itunesdemo.databinding.ItemItuneEmptyViewBinding;
import com.metro.itunesdemo.databinding.ItemItuneViewBinding;
import com.metro.itunesdemo.ui.details.DetailsActivity;
import com.metro.itunesdemo.ui.details.DetailsViewModel;
import com.metro.itunesdemo.ui.home.ITuneEmptyItemViewModel;
import com.metro.itunesdemo.ui.home.ITuneItemViewModel;
import com.metro.itunesdemo.utils.AppConstants;

import java.util.List;

public class ITuneRecyclerViewAdapter extends RecyclerView.Adapter<ITuneRecyclerViewAdapter.BaseViewHolder> {

    public static final String TAG = ITuneRecyclerViewAdapter.class.getSimpleName();
    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;


    private List<Result> searchModelList;
    private ITuneAdapterListener mListener;

    public ITuneRecyclerViewAdapter(List<Result> searchModelList) {
        this.searchModelList = searchModelList;
    }

    @NonNull
    @Override
    public BaseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemItuneViewBinding itemItuneViewBinding = ItemItuneViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new ItemViewHolder(itemItuneViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemItuneEmptyViewBinding emptyViewBinding = ItemItuneEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder holder, int position) {
        holder.onBind(position);
    }



    @Override
    public int getItemCount() {
        if (searchModelList != null && searchModelList.size() > 0) {
            return searchModelList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (searchModelList != null && !searchModelList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    public void clearItems() {
        searchModelList.clear();
        notifyDataSetChanged();
    }

    public void setListener(ITuneAdapterListener listener) {
        this.mListener = listener;
    }

    public interface ITuneAdapterListener {

        void onRetryClick();
    }


    public void addItems(List<Result> searchModelList) {
        this.searchModelList = searchModelList;
    }

    public abstract class BaseViewHolder extends RecyclerView.ViewHolder {
        public BaseViewHolder(View itemView) {
            super(itemView);
        }

        public abstract void onBind(int position);
    }


    public class EmptyViewHolder extends BaseViewHolder implements ITuneEmptyItemViewModel.ITuneEmptyItemViewModelListener {

        private ItemItuneEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemItuneEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            ITuneEmptyItemViewModel emptyItemViewModel = new ITuneEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }

    public class ItemViewHolder extends BaseViewHolder implements ITuneItemViewModel.ItuneItemViewModelListener {

        private final ItemItuneViewBinding mBinding;
        private ITuneItemViewModel mITuneItemViewModel;

        public ItemViewHolder(ItemItuneViewBinding viewBindingRoot) {
            super(viewBindingRoot.getRoot());
            this.mBinding = viewBindingRoot;
        }

        @Override
        public void onBind(int position) {
            final Result result = searchModelList.get(position);
            mITuneItemViewModel = new ITuneItemViewModel(result, this);
            mBinding.setViewModel(mITuneItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(Context context,int trackId) {
            try {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra(AppConstants.TRACK_ID,trackId);
                context.startActivity(intent);
            } catch (Exception e){
                Log.e(TAG, e.getMessage());
            }
        }
    }
}
