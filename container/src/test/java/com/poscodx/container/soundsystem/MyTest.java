package com.poscodx.container.soundsystem;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class MyTest {
	
	@Test
	public void test01() {
//		MyClass myClass = new MyClass();
//		myClass.setPrice(1000);
//		myClass.setDiscount(10);
//		
//		int discountPrice= myClass.getPrice();
//		assertEquals(discountPrice, 900);
		
		int i = 10;
		assertTrue(i - 10 < 10);
		
	}
	
	@Test
	public void test02() {
		int i = 10;
		assertEquals(10,i);
		
	}
}
