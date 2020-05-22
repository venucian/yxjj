package cn.com.honzh.core;

import java.util.Calendar;

public class DateUtil {
	
	public static String getAgeByIdCardNo(String idCardNo) {
        String age = "";
        int year = Calendar.getInstance().get(Calendar.YEAR);
        char[] number = idCardNo.toCharArray();
        boolean flag = true;
        if (number.length == 15) {
            for (int x = 0; x < number.length; x++) {
                if (!flag) return "";
                flag = Character.isDigit(number[x]);
            }
        } else if (number.length == 18) {
            for (int x = 0; x < number.length - 1; x++) {
                if (!flag) return "";
                flag = Character.isDigit(number[x]);
            }
        }
        if (flag && idCardNo.length() == 15) {
            age = (year - Integer.parseInt("19" + idCardNo.substring(6, 8))) + "";
        } else if (flag && idCardNo.length() == 18) {
            age = (year - Integer.parseInt(idCardNo.substring(6, 10))) + "";
        }
        return age;
	}
}
