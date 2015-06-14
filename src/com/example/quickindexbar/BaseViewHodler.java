package com.example.quickindexbar;

import android.content.Context;
import android.util.Log;
import android.view.View;

public abstract class BaseViewHodler<T> {

	public View view;
	
	private T t;
	
	public BaseViewHodler(Context context){
		view=initView(context);
		Log.e("abstract", view.toString());
		//将自己作为一个标签添加到这个视图里面
		view.setTag(this);
	}
	
	public  void setData(T t){
		this.t=t;
		refreshView();
	};
	
	public T getData(){
		return t;
	}
	
	public  abstract View initView(Context context) ;
	
	public abstract void refreshView();
	
	public View getRootView(){
		return view;
	}
}
