package com.example.quickindexbar;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AddressAdapter extends MyBaseAdapter<NameInfo> {
	private Context context;

	public AddressAdapter(List<NameInfo> list,Context context) {
		super(list);
		this.context=context;
	}

	@Override
	public BaseViewHodler<NameInfo> getViewHodler() {
		return new AdressViewHolder(context);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BaseViewHodler<NameInfo> viewHodler = null;
		if(convertView==null){
			 viewHodler = getViewHodler();
		}else {
			viewHodler=(AdressViewHolder)convertView.getTag();
		}
		
		viewHodler.setData(listData.get(position));

		return viewHodler.getRootView();
	}
	
	
	
}
