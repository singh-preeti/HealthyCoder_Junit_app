package com.healthycoderapp;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class BMICalculatorTest {

	@Test
	void should_ReturnFalse_When_DietRecommended() {
		//assertTrue(BMICalculator.isDietRecommended(89.0,1.72));
		
		//given
		 double weight = 50.0;
		 double height = 1.92;
		//when
		  boolean recommended = BMICalculator.isDietRecommended(weight,height);
		//then
		  assertFalse(recommended);
	}
	@Test
	void should_ReturnThrowsArithmeticException_When_HeightZero() {
		//assertTrue(BMICalculator.isDietRecommended(89.0,1.72));
		
		//given
		 double weight = 50.0;
		 double height = 0.00;
		//when
		  Executable executable = () -> BMICalculator.isDietRecommended(weight,height);
		//then
		  assertThrows(ArithmeticException.class,executable);
	}
	@Test
	void should_ReturnCoderWithWorstBMI_When_CoderListNotEmpty()
	{
		// given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80,60.0));
		coders.add(new Coder(1.82,90.0));
		coders.add(new Coder(1.82,80.0));
		coders.add(new Coder(1.83,95.0));
		coders.add(new Coder(1.70,60.0));
		
		// when
		Coder coderObj = BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertAll(
				() -> assertEquals(1.83,coderObj.getHeight()),
				() -> assertEquals(98.0,coderObj.getWeight())
		);
	}
	
	@Test
	void should_ReturnNullWorstBMI_When_CoderListEmpty()
	{
		//given
		List<Coder> coders = new ArrayList<>();
		
		// when
		Coder coderObj = BMICalculator.findCoderWithWorstBMI(coders);
		
		//then
		assertNull(coderObj);
	}
	//Test Array equality
	
	@Test
	void should_ReturnCorrectBMIScoreArray_When_CoderListNotEmpty()
	{
		//given
		List<Coder> coders = new ArrayList<>();
		coders.add(new Coder(1.80,60.0));
		//coders.add(new Coder(1.82,95.0));
		coders.add(new Coder(1.82,64.7));
		//coders.add(new Coder(1.83,95.0));
		//coders.add(new Coder(1.70,60.0));
		
		double[] expected = {18.52,19.53};
		//when
		double[] bmiscores = BMICalculator.getBMIScores(coders);
		
		//then
		assertArrayEquals(expected,bmiscores);
	}
	}



















