package com.jingnan.coordinatortest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lijingnan on 25/12/2017.
 */

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.Holder> {

    protected Context mContext;

    private List<String> mData;

    HomeRecyclerAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Holder holder = new Holder(
                LayoutInflater.from(mContext).inflate(R.layout.item, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.mTextView.setBackgroundColor(position % 2 == 0 ? Color.LTGRAY : Color.WHITE);
        holder.mTextView.setText(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private TextView mTextView;

        public Holder(View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.mText);
        }
    }
}
