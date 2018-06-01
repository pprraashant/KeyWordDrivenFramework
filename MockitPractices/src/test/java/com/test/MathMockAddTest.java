package com.test;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.code.Math;

/**
 * Test the add method of Math object
 */
public class MathMockAddTest {
 Math mathObj; //The object that needs to mocked
 
 @Before
 /**
  * Create mock object before you use them
  */
 public void create(){
  mathObj= mock(Math.class); //Create Math mock Object
  when(mathObj.add(1, 2)).thenReturn(3); // Configure it to return 3 when arguments passed are 1,2
 }
 
 @Test
 public void test() {
  assertSame(3, mathObj.add(1,2)); //Assert that math object return 3
 }

}