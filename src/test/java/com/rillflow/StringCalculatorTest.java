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
	public void ���ڿ�_�Է½�() throws Exception {
		assertEquals(0, stringCalculator.add(""));
	}

	@Test
	public void �����ϳ�_�Է½�() throws Exception {
		assertThat(stringCalculator.add("7"), is(7));
		assertThat(stringCalculator.add("9999"), is(9999));
	}

	@Test
	public void ���ڵΰ���_�ĸ���_�Է½�() throws Exception {
		assertThat(stringCalculator.add("9,1"), is(10));
	}

	@Test
	public void ����_�̻���_����_�Է½�() throws Exception {
		assertThat(stringCalculator.add("1,2,3"), is(6));
	}

	@Test
	public void �����ڿ�_newLine_����() throws Exception {
		assertThat(stringCalculator.add("9,1\n3"), is(13));
	}

	@Test
	public void Ŀ����_������_����() throws Exception {
		assertThat(stringCalculator.add("//!\n5!4!3"), is(12));
	}

	@Test
	public void ����ǥ���Ŀ����_����ó��() throws Exception {
		assertThat(stringCalculator.add("//.\n3.2.2.1"), is(8));
	}

	@Test(expected = RuntimeException.class)
	public void ����_���޽�_RuntimeException����() throws Exception {
		stringCalculator.add("-1\n2");
	}
}
