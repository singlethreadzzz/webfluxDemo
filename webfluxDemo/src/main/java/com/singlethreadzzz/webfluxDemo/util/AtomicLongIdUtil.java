package com.singlethreadzzz.webfluxDemo.util;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicLongIdUtil {
	
	private static final AtomicLong idGenerator = new AtomicLong(0);
	
	public static Long generateAtomicLongId() {
		Long id = idGenerator.incrementAndGet();
		System.out.println(id);
		return id;
	}

}
