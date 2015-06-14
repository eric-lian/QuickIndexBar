package com.example.quickindexbar;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.example.quickindexbar.QuickIndexBar.onCharacterChangeListener;

import android.R.interpolator;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.AbsListView;
import android.widget.TextView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class MainActivity extends Activity implements
		onCharacterChangeListener, OnScrollListener {

	private ListView listView;
	private List<NameInfo> list;
	private QuickIndexBar quick;
	private TextView tx;
	
	private static Handler handler=new Handler();
	private MyTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(getWindow().FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initView();
		initData();
		initListenter();
		
		AddressAdapter adapter = new AddressAdapter(list,
				getApplicationContext());
		
		initListView(adapter);
	}

	public void initListenter() {
		quick.setChangeListener(this);
		listView.setOnScrollListener(this);
	}

	public void initListView(AddressAdapter adapter) {
		
		listView.setVerticalScrollBarEnabled(false);
		listView.setAdapter(adapter);
		listView.setSelection(0);
	}

	public void initData() {
		list = InitDataUtil.getRandomListData(30);
		Collections.sort(list);
		task = new MyTask();
	}

	public void initView() {
		quick = (QuickIndexBar) findViewById(R.id.quicks);
		listView = (ListView) findViewById(R.id.list);
		tx = (TextView) findViewById(R.id.tip);
	}

	@Override
	public void characterChangeListener(String s) {
		for (int i = 0; i < list.size(); i++) {
			NameInfo n = list.get(i);
			if (n.pinYin != null && (n.pinYin.charAt(0) + "").equals(s)) {
				listView.setSelection(i);
				break;
			}
		}
		
	
		handler.removeCallbacks(task);
		tx.setText(s);
		tx.setVisibility(View.VISIBLE);
		handler.postDelayed(task, 2000);
	}

	@Override
	public void onScrollStateChanged(AbsListView view, int scrollState) {

	}

	@Override
	public void onScroll(AbsListView view, int firstVisibleItem,
			int visibleItemCount, int totalItemCount) {
		quick.changeCharacter(list.get(firstVisibleItem).pinYin);
	}

	class MyTask implements Runnable{

		@Override
		public void run() {
			tx.setVisibility(View.GONE);
		}
		
	}
}
