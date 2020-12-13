package com.marten.testdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ListAdapter extends BaseAdapter {

    private Context context;
    private List<String> myData = new ArrayList<>();


    public ListAdapter(Context context, List<String> list) {
        this.context = context;
        this.myData = list;
    }

    public void addAllData(List<String> newData) {
        if (myData != null && newData != null) {
            //拼接
            myData.addAll(newData);
            //刷新
            notifyDataSetChanged();
        }
    }

    @Override
    public int getCount() {
        return myData.size();
    }

    @Override
    public Object getItem(int position) {
        return myData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        ViewHolder viewHolder;
        if (convertView == null) {
            view = LayoutInflater.from(context).inflate(R.layout.first_list_item, parent,false);
            viewHolder = new ViewHolder();
            viewHolder.mTvText = view.findViewById(R.id.text_item);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        String str = myData.get(position);
        viewHolder.mTvText.setText(str);

        return view;
    }

    static class ViewHolder {
        TextView mTvText;
    }
}
