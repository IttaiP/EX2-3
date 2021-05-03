package android.exercise.mini.calculator.app;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

  @VisibleForTesting
  public SimpleCalculator calculator;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    if (calculator == null) {
      calculator = new SimpleCalculatorImpl();
    }


    TextView buttonEquals = (TextView) findViewById(R.id.buttonEquals);
    TextView buttonPlus = (TextView) findViewById(R.id.buttonPlus);
    TextView buttonMinus = (TextView) findViewById(R.id.buttonMinus);
    TextView buttonClear = (TextView) findViewById(R.id.buttonClear);
    TextView button0 = (TextView) findViewById(R.id.button0);
    TextView button2 = (TextView) findViewById(R.id.button2);
    TextView button5 = (TextView) findViewById(R.id.button5);
    TextView button8 = (TextView) findViewById(R.id.button8);
    TextView button1 = (TextView) findViewById(R.id.button1);
    TextView button4 = (TextView) findViewById(R.id.button4);
    TextView button7 = (TextView) findViewById(R.id.button7);
    TextView button3 = (TextView) findViewById(R.id.button3);
    TextView button6 = (TextView) findViewById(R.id.button6);
    TextView button9 = (TextView) findViewById(R.id.button9);
    TextView textViewCalculatorOutput = (TextView) findViewById(R.id.textViewCalculatorOutput);
    View spaceBelowButton1 = (View) findViewById(R.id.spaceBelowButton1);
    View buttonBackSpace = (View) findViewById(R.id.buttonBackSpace);
    ImageView backSpaceImage = (ImageView) findViewById(R.id.backSpaceImage);

    textViewCalculatorOutput.setText(calculator.output());

    buttonEquals.setOnClickListener(view -> {calculator.insertEquals();
      textViewCalculatorOutput.setText(calculator.output());});
    buttonPlus.setOnClickListener(view -> {calculator.insertPlus();
      textViewCalculatorOutput.setText(calculator.output());});
    buttonMinus.setOnClickListener(view -> {calculator.insertMinus();
      textViewCalculatorOutput.setText(calculator.output());});
    buttonClear.setOnClickListener(view -> {calculator.clear();
      textViewCalculatorOutput.setText(calculator.output());});
    button0.setOnClickListener(view -> {calculator.insertDigit(0);
      textViewCalculatorOutput.setText(calculator.output());});
    button1.setOnClickListener(view -> {calculator.insertDigit(1);
      textViewCalculatorOutput.setText(calculator.output());});
    button2.setOnClickListener(view -> {calculator.insertDigit(2);
      textViewCalculatorOutput.setText(calculator.output());});
    button3.setOnClickListener(view -> {calculator.insertDigit(3);
      textViewCalculatorOutput.setText(calculator.output());});
    button4.setOnClickListener(view -> {calculator.insertDigit(4);
      textViewCalculatorOutput.setText(calculator.output());});
    button5.setOnClickListener(view -> {calculator.insertDigit(5);
      textViewCalculatorOutput.setText(calculator.output());});
    button6.setOnClickListener(view -> {calculator.insertDigit(6);
      textViewCalculatorOutput.setText(calculator.output());});
    button7.setOnClickListener(view -> {calculator.insertDigit(7);
      textViewCalculatorOutput.setText(calculator.output());});
    button8.setOnClickListener(view -> {calculator.insertDigit(8);
      textViewCalculatorOutput.setText(calculator.output());});
    button9.setOnClickListener(view -> {calculator.insertDigit(9);
      textViewCalculatorOutput.setText(calculator.output());});
    buttonBackSpace.setOnClickListener(view -> {calculator.deleteLast();
      textViewCalculatorOutput.setText(calculator.output());});




    /*
    TODO:
    - find all views
    - initial update main text-view based on calculator's output
    - set click listeners on all buttons to operate on the calculator and refresh main text-view
     */
  }

  @Override
  protected void onSaveInstanceState(@NonNull Bundle outState) {
    super.onSaveInstanceState(outState);
    // todo: save calculator state into the bundle
    outState.putSerializable("calc_state",calculator.saveState());
  }

  @Override
  protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);
    // todo: restore calculator state from the bundle, refresh main text-view from calculator's output
    calculator.loadState(savedInstanceState.getSerializable("calc_state"));
  }
}