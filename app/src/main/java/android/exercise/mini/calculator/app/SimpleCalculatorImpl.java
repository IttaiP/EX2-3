package android.exercise.mini.calculator.app;

import java.io.Serializable;

public class SimpleCalculatorImpl implements SimpleCalculator {

  String current = "";

  @Override
  public String output() {
    // todo: return output based on the current state
    if (current.isEmpty()){
      return "0";
    }
    return current;
  }

  @Override
  public void insertDigit(int digit) {
    if(digit>9 || digit<0){
      throw new RuntimeException();
    }
    current += String.valueOf(digit);
  }

  @Override
  public void insertPlus() {
    if (current.length()==0){
      current = "0+";
    }
    if(!current.endsWith("+")&&!current.endsWith("-")){
      current += "+";
    }
  }

  @Override
  public void insertMinus() {
    // todo: insert a minus
    if (current.length()==0){
      current = "0-";
    }
    if(!current.endsWith("+")&&!current.endsWith("-")){
      current += "-";
    }
  }

  private int apply_symbol(char symbol, int res, int currentNum){
    if (symbol == '!'){
      return currentNum;
    }
    if (symbol == '+'){
      return res + currentNum;
    }
    return res - currentNum;
  }


  private int applyCalc(){
    char symbol = '!';
    int res = 0;
    int currentNum = 0;

    for(int i=0; i<current.length(); i++){
      if (current.charAt(i) == '+') {
        res = apply_symbol(symbol, res, currentNum);
        currentNum = 0;
        symbol = '+';
        continue;
      } else if (current.charAt(i) == '-') {
        res = apply_symbol(symbol, res, currentNum);
        currentNum = 0;
        symbol = '-';
        continue;
      }
      currentNum *=10;
      currentNum += current.charAt(i) - '0';
    }
    res =  apply_symbol(symbol, res, currentNum);
    clear();
    return res;
  }

  @Override
  public void insertEquals() {
    // todo: calculate the equation. after calling `insertEquals()`, the output should be the result
    //  e.g. given input "14+3", calling `insertEquals()`, and calling `output()`, output should be "17"
   current = String.valueOf(applyCalc());
  }

  @Override
  public void deleteLast() {
    // todo: delete the last input (digit, plus or minus)
    //  e.g.
    //  if input was "12+3" and called `deleteLast()`, then delete the "3"
    //  if input was "12+" and called `deleteLast()`, then delete the "+"
    //  if no input was given, then there is nothing to do here
    if(!current.isEmpty()){
      current = current.substring(0, current.length() - 1);
    }
  }

  @Override
  public void clear() {
    // todo: clear everything (same as no-input was never given)
    current = "";
  }

  @Override
  public Serializable saveState() {
    CalculatorState state = new CalculatorState();
    // todo: insert all data to the state, so in the future we can load from this state
    state.currentState = current;
    return state;
  }

  @Override
  public void loadState(Serializable prevState) {
    if (!(prevState instanceof CalculatorState)) {
      return; // ignore
    }
    CalculatorState casted = (CalculatorState) prevState;
    // todo: use the CalculatorState to load
    current = ((CalculatorState) prevState).currentState;
  }

  private static class CalculatorState implements Serializable {
    /*
    TODO: add fields to this class that will store the calculator state
    all fields must only be from the types:
    - primitives (e.g. int, boolean, etc)
    - String
    - ArrayList<> where the type is a primitive or a String
    - HashMap<> where the types are primitives or a String
     */
    String currentState;
  }
}
