package com.rillflow;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@Before
	public void init() {
		stringCalculator = new StringCalculator();
	}

	@Test
	public void 빈문자열_입력시() throws Exception {
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	public void 숫자하나_입력시() throws Exception {
		assertThat(stringCalculator.add("7"), is(7));
		assertThat(stringCalculator.add("9999"), is(9999));
	}

	@Test
	public void 숫자두개를_컴마로_입력시() throws Exception {
		assertThat(stringCalculator.add("9,1"), is(10));
	}

	@Test
	public void 세개_이상의_숫자_입력시() throws Exception {
		assertThat(stringCalculator.add("1,2,3"), is(6));
	}

	@Test
	public void 구분자에_newLine_사용시() throws Exception {
		assertThat(stringCalculator.add("9,1\n3"), is(13));
	}

	@Test
	public void 커스텀_구분자_사용시() throws Exception {
		assertThat(stringCalculator.add("//!\n5!4!3"), is(12));
	}

	@Test
	public void 정규표현식예약어_예외처리() throws Exception {
		assertThat(stringCalculator.add("//.\n3.2.2.1"), is(8));
	}

	@Test(expected = RuntimeException.class)
	public void 음수_전달시_RuntimeException예외() throws Exception {
		stringCalculator.add("-1\n2");
	}
}
