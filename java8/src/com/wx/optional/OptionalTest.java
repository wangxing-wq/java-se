package com.wx.optional;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * @version 1.0
 * @author 王兴
 * @date 2022/5/29 11:29
 */
public class OptionalTest {

	@Test
	public void buildTest(){
		Optional<String> opt = Optional.ofNullable("null");
		opt.ifPresent(name -> System.out.println(name.length()));
		Instant now = Instant.now();
		System.out.println(now);
		LocalDateTime localDateTime = LocalDateTime.now();
		//localDateTime.
	}

}
