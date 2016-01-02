package com.huanche.parallaxeffectlistviewheader;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fanzhengchen on 1/3/16.
 */
public class MainAdapter extends BaseAdapter {

    private ArrayList<String> data;
    private Activity activity;
    private LayoutInflater inflater;

    public MainAdapter(Activity activity, ArrayList<String> data) {
        this.activity = activity;
        this.data = data;
        this.inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return data == null ? 0 : data.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view == null) {
            view = inflater.inflate(R.layout.list_row_layout, null);
        }
        TextView textView = (TextView) view.findViewById(R.id.cell_list_text);
        textView.setText(data.get(position));
        return view;
    }
}
