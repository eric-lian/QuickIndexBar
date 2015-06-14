package com.example.quickindexbar;
import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinYinUtil {

	public static String getHanYuPinYin(String name) {
		StringBuffer buffer = new StringBuffer();
		
		HanyuPinyinOutputFormat format = new HanyuPinyinOutputFormat();
		format.setCaseType(HanyuPinyinCaseType.UPPERCASE);
		format.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
		format.setVCharType(HanyuPinyinVCharType.WITH_U_UNICODE);
		
		for (char c : name.toCharArray()) {
			String[] array;
			
			try {
				if (c > 127) {
					
					array = PinyinHelper.toHanyuPinyinStringArray(c, format);
					
					if (array != null && array[0]!=null) {
						buffer.append(array[0]);
					} else {
						buffer.append("");
					}

				} else {
					buffer.append(c + "");
				}
			} catch (BadHanyuPinyinOutputFormatCombination e) {
				e.printStackTrace();
			}

		}
		System.out.println(buffer.toString()+"-----------");
		return buffer.toString();
	};
}
