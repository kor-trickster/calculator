package com.rillflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private String delimeter = ",|\n";	// �⺻���� ���ǵ� ������
	
	/**
	 * ���ڿ��� �� ���ڸ� �Է¹޾� ���� �� ��ȯ
	 * @param string : ���ڿ��� �� ����
	 * @return ���� �հ�
	 */
	public int add(String string) {

		if (string.isEmpty()) {
			
			return 0;
			
		} else {

			int[] numbers = getNumbers(string);
			int sum = 0;
			
			for(int i = 0; i < numbers.length; i++) {
				sum += numbers[i];
			}
			
			return sum;
		}
	}
	
	/**
	 * �Էµ� ���ڿ��� �����ڷ� ������ ���� �迭 ��ȯ
	 * @param text : ���ڿ��� �� ����
	 * @return ���� �迭
	 */
	private int[] getNumbers(String text) {
		
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

		// Ŀ���� �����ڰ� �ִ� ���
		if (m.find()) {	
			text = m.group(2);
			delimeter = Pattern.quote(m.group(1));
		}
		
		String[] numbers = text.split(delimeter);
		
		return getIntArray(numbers);
	}

	/**
	 * ���ڿ� �迭�� ������ �迭�� ��ȯ
	 * @param numbers : ���ڿ� �迭
	 * @return ���� �迭
	 */
	private int[] getIntArray(String[] numbers) throws RuntimeException {
		
		int[] realNumbers = new int[numbers.length];
		int temp;
		
		for(int i = 0; i < numbers.length; i++) {
			temp = Integer.parseInt(numbers[i]);
			
			if( temp < 0) {
				throw new RuntimeException();
			}
			
			realNumbers[i] = temp;
		}
		
		return realNumbers;
	}
}
