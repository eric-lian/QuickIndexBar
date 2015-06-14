package com.example.quickindexbar;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class AdressViewHolder extends BaseViewHodler<NameInfo> {
	private TextView t;
	private TextView textView;
	public AdressViewHolder(Context context) {
		super(context);
		//this.context=context; 这里先创建父类对象，所以在父类没有创建完毕的时候，不能使用context
	}
	@Override
	public View initView(Context context) {
		View view = View.inflate(context, R.layout.tx, null);
		textView = (TextView) view.findViewById(R.id.tt);
		return view;
	}

	@Override
	public void refreshView() {
	NameInfo nameInfo=getData();
		textView.setText(nameInfo.name);
	}

	
}
