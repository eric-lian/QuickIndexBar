package com.example.quickindexbar;



public class NameInfo  implements Comparable<NameInfo>{

	public String name;
	
	public String pinYin;

	public NameInfo(String name){
		this.name=name;
		this.pinYin=PinYinUtil.getHanYuPinYin(name);
	};
	@Override
	public int compareTo(NameInfo another) {
			return this.pinYin.compareTo(another.pinYin);
	}
	
	
	

}
