package com.rillflow;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

	private String delimeter = ",|\n";	// 기본으로 정의된 구분자
	
	/**
	 * 문자열로 된 숫자를 입력받아 덧셈 후 반환
	 * @param string : 문자열로 된 숫자
	 * @return 숫자 합계
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
	 * 입력된 문자열을 구분자로 나누어 숫자 배열 반환
	 * @param text : 문자열로 된 숫자
	 * @return 숫자 배열
	 */
	private int[] getNumbers(String text) {
		
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);

		// 커스텀 구분자가 있는 경우
		if (m.find()) {	
			text = m.group(2);
			delimeter = Pattern.quote(m.group(1));
		}
		
		String[] numbers = text.split(delimeter);
		
		return getIntArray(numbers);
	}

	/**
	 * 문자열 배열을 숫자형 배열로 반환
	 * @param numbers : 문자열 배열
	 * @return 숫자 배열
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
