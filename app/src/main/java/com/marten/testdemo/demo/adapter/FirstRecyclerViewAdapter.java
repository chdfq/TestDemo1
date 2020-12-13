package com.marten.testdemo.demo.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marten.testdemo.R;

import java.util.ArrayList;
import java.util.List;

public class FirstRecyclerViewAdapter extends RecyclerView.Adapter<FirstRecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<String> data = new ArrayList<>();

    public FirstRecyclerViewAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.first_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //((TextView)holder.itemView).setText();
        holder.mTvItem.setText(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private TextView mTvItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTvItem = itemView.findViewById(R.id.text_item);
        }
    }
}
