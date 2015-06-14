package com.example.quickindexbar;

import java.util.List;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public abstract class MyBaseAdapter<T> extends BaseAdapter {

	public List<T> listData;


	public MyBaseAdapter(List<T> list) {
		this.listData = list;
	}

	@Override
	public int getCount() {
		return listData.size();
	}

	@Override
	public Object getItem(int position) {
		return listData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BaseViewHodler<T> hodler = null;
		
		if (convertView == null) {
				hodler = getViewHodler();
		} else {
			hodler = (BaseViewHodler<T>) convertView.getTag();
		}
		// 设置了数据以后要刷新数据
		hodler.setData((T) listData.get(position));
		
		return hodler.getRootView();
	}

	public abstract BaseViewHodler<T> getViewHodler();

}
