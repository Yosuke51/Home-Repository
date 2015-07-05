package com.yosuke;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Timezone {

	public static void main(String[] args) {
		
		String x = "Asia/Tokyo";
		TimeZone tz = TimeZone.getTimeZone(x);  
		TimeZone.setDefault(tz);
		Date z = new Date();
		String[] p = x.split("/");
		SimpleDateFormat d = new SimpleDateFormat("yyyy年MM月dd日 a HH時mm分ss秒");
		
		System.out.println(p[1]+"現在的時間為："+d.format(z));
		System.out.println("AOA");

	}

}
