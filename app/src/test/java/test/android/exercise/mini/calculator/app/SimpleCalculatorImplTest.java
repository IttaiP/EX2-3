package test.android.exercise.mini.calculator.app;

import android.exercise.mini.calculator.app.SimpleCalculatorImpl;

import org.junit.Before;
import org.junit.Test;

import java.io.Serializable;

import static org.junit.Assert.*;

public class SimpleCalculatorImplTest {

  @Test
  public void when_noInputGiven_then_outputShouldBe0(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    assertEquals("0", calculatorUnderTest.output());
  }

  @Test
  public void when_inputIsPlus_then_outputShouldBe0Plus(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertPlus();
    assertEquals("0+", calculatorUnderTest.output());
  }


  @Test
  public void when_inputIsMinus_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertMinus();
    String expected = "0-"; // TODO: decide the expected output when having a single minus
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_noEquals_then_outputShouldBeSequence(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    String expected = "3-7+";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_Equals_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertEquals();
    String expected = "-4";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_multipleEquals_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(0);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertEquals();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(4);
    calculatorUnderTest.insertEquals();
    String expected = "25";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_multipleOrders_then_outputShouldBeCorrect(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    String expected = "3-7+";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingInsertDigitWithIllegalNumber_then_exceptionShouldBeThrown(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    try {
      calculatorUnderTest.insertDigit(357);
      fail("should throw an exception and not reach this line");
    } catch (RuntimeException e) {
      // good :)
    }
  }


  @Test
  public void when_callingDeleteLast_then_lastOutputShouldBeDeleted(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.deleteLast();
    String expected = "3-7";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingDeleteLastMidNumber_then_OutputShouldBeCorrect(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(7);

    String expected = "3-77";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingDeleteLastMidNumberWithEquals_then_OutputShouldBeCorrect(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertDigit(8);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.insertDigit(1);
    calculatorUnderTest.insertEquals();

    String expected = "74";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingDeleteLastWithNoInput_then_OutputShouldBeZero(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.deleteLast();
    String expected = "0";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingDeleteLastWithRemovedInput_then_OutputShouldBeZero(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.deleteLast();
    String expected = "0";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_callingClear_then_outputShouldBeCleared(){
    // todo: implement test
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    calculatorUnderTest.insertDigit(3);
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertMinus();
    calculatorUnderTest.insertDigit(7);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.deleteLast();
    calculatorUnderTest.clear();
    String expected = "0";
    assertEquals(expected, calculatorUnderTest.output());
  }

  @Test
  public void when_savingState_should_loadThatStateCorrectly(){
    SimpleCalculatorImpl calculatorUnderTest = new SimpleCalculatorImpl();
    // give some input
    calculatorUnderTest.insertDigit(5);
    calculatorUnderTest.insertPlus();
    calculatorUnderTest.insertDigit(7);

    // save current state
    Serializable savedState = calculatorUnderTest.saveState();
    assertNotNull(savedState);

    // call `clear` and make sure calculator cleared
    calculatorUnderTest.clear();
    assertEquals("0", calculatorUnderTest.output());

    // load the saved state and make sure state was loaded correctly
    calculatorUnderTest.loadState(savedState);
    assertEquals("5+7", calculatorUnderTest.output());
  }

  @Test
  public void when_savingStateFromFirstCalculator_should_loadStateCorrectlyFromSecondCalculator(){
    SimpleCalculatorImpl firstCalculator = new SimpleCalculatorImpl();
    SimpleCalculatorImpl secondCalculator = new SimpleCalculatorImpl();
    // TODO: implement the test based on this method's name.
    //  you can get inspiration from the test method `when_savingState_should_loadThatStateCorrectly()`
    // give some input
    firstCalculator.insertDigit(5);
    firstCalculator.insertPlus();
    firstCalculator.insertDigit(7);

    secondCalculator.insertDigit(1);
    secondCalculator.insertPlus();
    secondCalculator.insertDigit(1);

    // save current state
    Serializable savedState = firstCalculator.saveState();

    // load the saved state and make sure state was loaded correctly
    secondCalculator.loadState(savedState);
    assertEquals("5+7", secondCalculator.output());
  }

  // TODO:
  //  the existing tests are not enough since they only test simple use-cases with small inputs.
  //  write at least 10 methods to test correct behavior with complicated inputs or use-cases.
  //  examples:
  //  - given input "5+7-13<DeleteLast>25", expected output is "5+17-125"
  //  - given input "9<Clear>12<Clear>8-7=", expected output is "1"
  //  - given input "8-7=+4=-1=", expected output is "4"
  //  - given input "999-888-222=-333", expected output is "-111-333"
  //  - with 2 calculators, give them different inputs, then save state on first calculator and load the state into second calculator, make sure state loaded well
  //  etc etc.
  //  feel free to be creative in your tests!
}