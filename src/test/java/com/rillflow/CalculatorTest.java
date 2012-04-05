package com.rillflow;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorTest {

	private static final Logger logger = LoggerFactory.getLogger(CalculatorTest.class);
	
	private Calculator calculator;

	@Before
	public void init() {
		calculator = new Calculator();
	}
	
	@Test
	public void add() {
		int result = calculator.add(1, 9999);
		assertThat(result, is(10000));
	}

	@Test
	public void subtract() throws Exception {
		assertEquals(-9998, calculator.substract(1, 9999));
	}
	
	@Test
	public void multiply() throws Exception {
		assertThat(calculator.multiply(1, 9999), is(9999));
	}

	@Test
	public void divide() throws Exception {
		assertThat(calculator.divide(1, 9999), is(0));
	}
	
	@After
	public void teardown() {
		logger.debug("Calculator Object : {}", calculator);
	}
}
