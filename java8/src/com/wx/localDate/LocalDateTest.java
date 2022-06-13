package com.wx.localDate;

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/5/29 20:03
 */
public class LocalDateTest {

	@Test
	public void build(){
		LocalDateTime localDateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
		System.out.println(dateTimeFormatter.format(localDateTime));
		System.out.println(localDateTime);
	}

}
