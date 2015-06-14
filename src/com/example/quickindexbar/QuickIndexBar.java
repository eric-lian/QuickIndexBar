package com.example.quickindexbar;

import android.R.interpolator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

//������ת��Ϊƴ�� PINYIN4j.jar
public class QuickIndexBar extends View {

	private String[] index = {};
	private Paint paint;
	private String[] characterArrays;
	private int x;
	private int y = -1;
	private int single_height_size;
	private int size;
	private int height;

	onCharacterChangeListener changeListener;

	private String currentCharacter;

	public void setChangeListener(onCharacterChangeListener changeListener) {
		this.changeListener = changeListener;
	}

	public QuickIndexBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	// ���ȶ���init����
	public void init() {
		// event.getX(); viewΪ����ϵ
		// event.getRawX() ����Ļ��Ϊ����ϵ
		paint = InitDataUtil.obtainPaint(Color.parseColor("#ff000000"),
				Typeface.DEFAULT_BOLD, 18);

		characterArrays = InitDataUtil.getCharacterArray();

	}

	@Override
	protected void onDraw(Canvas canvas) {
		canvas.drawRGB(255, 0, 0);
		int width = getMeasuredWidth();
		height = getMeasuredHeight();
		single_height_size = (int) (height / characterArrays.length + 0.5);
		Rect rect = new Rect();
		paint.getTextBounds(characterArrays[0], 0, 1, rect);
		int coordinateX = (width / 2 - rect.centerX());
		int coordinateY = (single_height_size / 2 + rect.centerY() + 10);

		for (int i = 0; i < 26; i++) {
			if (i == size) {
				paint.setColor(Color.WHITE);
				currentCharacter = characterArrays[i];
				changeListener.characterChangeListener(currentCharacter + "");
			} else {
				paint.setColor(Color.parseColor("#ff000000"));
			}

			canvas.drawText(characterArrays[i], coordinateX, single_height_size
					* i + coordinateY, paint);
		}

		// super.onDraw(canvas);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		x = (int) event.getX();
		y = (int) event.getY();

		switch (event.getAction()) {

		case MotionEvent.ACTION_DOWN:
		case MotionEvent.ACTION_MOVE:
			size = y / single_height_size;
			single_height_size = (int) (height / characterArrays.length + 0.5);
			invalidate();
			break;
		case MotionEvent.ACTION_UP:

			break;

		default:
			break;
		}
		// ����true�Ǵ���������ܴ�����¼����ͻᷢ�������¼�
		return true;
	}

	interface onCharacterChangeListener {
		void characterChangeListener(String s);
	};

	// s �����ƴ��
	public void changeCharacter(String s) {
		if (!TextUtils.isEmpty(s) || s.length() > 0) {
			String listchar = s.substring(0, 1);
			if (currentCharacter != null) {
				if (currentCharacter.equals(listchar)) {

				} else {
					int height = getMeasuredHeight();
					size = listchar.toCharArray()[0] - 65;
					System.out.println(size);
					single_height_size = (int) (height / characterArrays.length + 0.5);
					invalidate();
				}
			} else {
				currentCharacter = listchar;
			}
		}
	};
}
