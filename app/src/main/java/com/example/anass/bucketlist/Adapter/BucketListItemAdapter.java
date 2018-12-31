package com.example.anass.bucketlist.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.anass.bucketlist.Entity.BucketListItem;
import com.example.anass.bucketlist.Interface.BucketListItemOnClickListener;
import com.example.anass.bucketlist.R;
import com.example.anass.bucketlist.ViewHolder.BucketListItemViewHolder;

import java.util.ArrayList;
import java.util.List;

public class BucketListItemAdapter extends RecyclerView.Adapter<BucketListItemViewHolder> {

    private Context context;
    private List<BucketListItem> bucketListItems = new ArrayList<>();
    private BucketListItemOnClickListener mBucketListItemOnClickListener;

    public BucketListItemAdapter(Context context, List<BucketListItem> bucketListItems, BucketListItemOnClickListener mBucketListItemOnClickListener) {
        this.context = context;
        this.bucketListItems = bucketListItems;
        this.mBucketListItemOnClickListener = mBucketListItemOnClickListener;
    }

    @NonNull
    @Override
    public BucketListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cell_grid_bucketlist, viewGroup, false);
        return new BucketListItemViewHolder(itemView, mBucketListItemOnClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull BucketListItemViewHolder bucketListViewHolder, int position) {
        BucketListItem item = bucketListItems.get(position);

        bucketListViewHolder.itemName.setText(item.getName());
        bucketListViewHolder.itemDescription.setText(item.getDescription());
        bucketListViewHolder.checkBoxItem.setChecked(item.getChecked());

        if(item.getChecked()){
            bucketListViewHolder.itemName.setPaintFlags(bucketListViewHolder.itemName.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
            bucketListViewHolder.itemDescription.setPaintFlags(bucketListViewHolder.itemDescription.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }
    }

    @Override
    public int getItemCount() {
        return bucketListItems.size();
    }

    public void setCheckListItems(List<BucketListItem> items) {
        this.bucketListItems = items;
        notifyDataSetChanged();
    }

}
