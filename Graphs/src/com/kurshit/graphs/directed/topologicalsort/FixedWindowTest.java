package com.kurshit.graphs.directed.topologicalsort;

import org.junit.Test;

import junit.framework.Assert;

public class FixedWindowTest {

	
	private final FixedWindow underTest = new FixedWindow();
	
	TestResult r;
	
	@Test
	public void shouldPrintWindows( ) {
		
		int[] dummy = { 1, 2, 3, 1, 4, 5, 2, 3, 6,  7, 8, 9, 10, 11 , 12, 15, 6};
		
		int K = 10;
		
		underTest.showWindows(dummy, K);
		
		Assert.assertTrue(true);
		
	}
	
	@Test(expected = Exception.class)
	public void shouldThrowException( ) {
		
		int[] dummy = { 1, 2, 3, 1, 4, 5, 2, 3, 6};
		
		int K = 15;
		
		underTest.showWindows(dummy, K);
		
		
		
	}
	

}
