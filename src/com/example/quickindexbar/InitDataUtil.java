package com.example.quickindexbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.text.TextPaint;

public class InitDataUtil {
//获得A-Z
	public static String[]  getCharacterArray() {
		String[] character=new String[26];
		for(int i=65 ;i<91 ;i++){
			character[i-65]=String.valueOf((char)(i));
		}
		
		return character ;
	}

	//获得一个画笔
	public static  Paint obtainPaint(int color,Typeface typeface,int size) {
		Paint 	paint=new TextPaint();
			paint.setColor(Color.parseColor("#ff000000"));
			paint.setTypeface(Typeface.DEFAULT_BOLD);
			paint.setTextSize(18);
			paint.setAntiAlias(true);
			return paint;
		}
		
	//得到随机的姓名
	public static List<NameInfo> getRandomListData(int size){
			Random random = new Random();
			
			ArrayList<NameInfo> list = new ArrayList<NameInfo>();
			String  surname="张安王李赵豆陈楚齐詻安周";
			String name="发动机阿斯利康富家大室联发科技大飞机空格键东方时空了解";
			if(size<=0){return null;};
			StringBuffer buffer = new StringBuffer();
			for(int i=0;i<size;i++){
				int index = random.nextInt(surname.length());
				int name1 = random.nextInt(name.length());
				int name2= random.nextInt(surname.length());
				buffer.append(surname.charAt(index));
				buffer.append(name.charAt(name1));
				buffer.append(name.charAt(name2));
				NameInfo nameInfo=new NameInfo(buffer.toString());
				list.add(nameInfo);
				buffer.delete(0, buffer.length());
			}
			return list;
	}
	
	
}
