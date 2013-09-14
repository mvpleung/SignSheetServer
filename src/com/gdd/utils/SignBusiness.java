package com.gdd.utils;

import java.util.Calendar;
import java.util.Date;

import com.gdd.db.MyDatabaseConnection;
import com.gdd.model.Signtime;

public class SignBusiness {
	// 数据相关的
	private Signtime signtime = null;

	private int curDay = 0;
	private int curHour = 0;
	private int curMinute = 0;
	// 工具相关的
	private MyDatabaseConnection busiConnection = null;

	public SignBusiness(String username) {
		// 初始化数据和工具
		signtime = new Signtime();
		busiConnection = new MyDatabaseConnection();
		// 获取时间相关的数据
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		curDay = cal.get(Calendar.DAY_OF_MONTH);
		curHour = cal.get(Calendar.HOUR_OF_DAY);
		curMinute = cal.get(Calendar.MINUTE);
		// 设置时间相关的数据
		signtime.setCome_tiem(String.valueOf(curHour) + ":"
				+ String.valueOf(curMinute));
		signtime.setLeave_time(String.valueOf(curHour) + ":"
				+ String.valueOf(curMinute));
		signtime.setCurrentday(String.valueOf(curDay));
		signtime.setUsername(username);

	}

	public void updatememberinfo() {
		busiConnection.executesql(signtime, 2);
	}
}
