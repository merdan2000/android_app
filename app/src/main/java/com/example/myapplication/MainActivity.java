package com.example.myapplication;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.udojava.evalex.AbstractOperator;
import com.udojava.evalex.Expression;

import java.math.BigDecimal;
import java.util.EmptyStackException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView result_1;
    private TextView input;
    private Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12, btn13, btn14, btn15, btn16, btn17, btn18, btn19, btn20, btn21, btn22,
            btn23, btn24, btn25, btn26, btn27, btn28, btn29, btn30, btn31, btn32, btn33;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_1 = findViewById(R.id.result_1);
        input = findViewById(R.id.input);
        System.out.println(getScreenOrientation());

        initButtons();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("input", input.getText().toString());
        outState.putString("result_1", result_1.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        input.setText(savedInstanceState.getString("input"));
        result_1.setText(savedInstanceState.getString("result_1"));
    }


    private void initButtons() {
        btn0 = findViewById(R.id.b0);
        btn1 = findViewById(R.id.b1);
        btn2 = findViewById(R.id.b2);
        btn3 = findViewById(R.id.b3);
        btn4 = findViewById(R.id.b4);
        btn5 = findViewById(R.id.b5);
        btn6 = findViewById(R.id.b6);
        btn7 = findViewById(R.id.b7);
        btn8 = findViewById(R.id.b8);
        btn9 = findViewById(R.id.b9);
        btn10 = findViewById(R.id.ac);
        btn11 = findViewById(R.id.plusminus);
        btn12 = findViewById(R.id.procent);
        btn13 = findViewById(R.id.delenie);
        btn14 = findViewById(R.id.umnojenie);
        btn15 = findViewById(R.id.minus);
        btn16 = findViewById(R.id.plus);
        btn17 = findViewById(R.id.rovno);
        btn18 = findViewById(R.id.zapyataya);
        if (getScreenOrientation().equals("Альбомная ориентация")) {
        btn19 = findViewById(R.id.skobka_1);
        btn20 = findViewById(R.id.skobka_2);
        btn21 = findViewById(R.id.sin);
        btn22 = findViewById(R.id.x2);
        btn23 = findViewById(R.id.xy);
        btn24 = findViewById(R.id.sqrt);
        btn25 = findViewById(R.id.fakt);
        btn26 = findViewById(R.id.atan);
        btn27 = findViewById(R.id.rand);
        btn28 = findViewById(R.id.cos);
        btn29 = findViewById(R.id.tg);
        btn30 = findViewById(R.id.pi);
        btn31 = findViewById(R.id.log);
        btn32 = findViewById(R.id.ln);
        btn33 = findViewById(R.id.ex);
        }
        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
        btn13.setOnClickListener(this);
        btn14.setOnClickListener(this);
        btn15.setOnClickListener(this);
        btn16.setOnClickListener(this);
        btn17.setOnClickListener(this);
        btn18.setOnClickListener(this);
        if (getScreenOrientation().equals("Альбомная ориентация")) {
        btn19.setOnClickListener(this);
        btn20.setOnClickListener(this);
        btn21.setOnClickListener(this);
        btn22.setOnClickListener(this);
        btn23.setOnClickListener(this);
        btn24.setOnClickListener(this);
        btn25.setOnClickListener(this);
        btn26.setOnClickListener(this);
        btn27.setOnClickListener(this);
        btn28.setOnClickListener(this);
        btn29.setOnClickListener(this);
        btn30.setOnClickListener(this);
        btn31.setOnClickListener(this);
        btn32.setOnClickListener(this);
        btn33.setOnClickListener(this);

        }
    }
    private void addToResult(String str){
        input.setText(input.getText()+str);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.b0:
                addToResult("0");
                break;
            case R.id.b1:
                addToResult("1");
                break;
            case R.id.b2:
                addToResult("2");
                break;
            case R.id.b3:
                addToResult("3");
                break;
            case R.id.b4:
                addToResult("4");
                break;
            case R.id.b5:
                addToResult("5");
                break;
            case R.id.b6:
                addToResult("6");
                break;
            case R.id.b7:
                addToResult("7");
                break;
            case R.id.b8:
                addToResult("8");
                break;
            case R.id.b9:
                addToResult("9");
                break;
            case R.id.ac:
                input.setText("");
                break;
            case R.id.plusminus:
                addToResult("-");
                break;
            case R.id.procent:
                addToResult("%");
                break;
            case R.id.delenie:
                addToResult("/");
                break;
            case R.id.umnojenie:
                addToResult("*");
                break;
            case R.id.minus:
                addToResult("-");
                break;
            case R.id.plus:
                addToResult("+");
                break;
            case R.id.rovno:
                try {
                    BigDecimal result = null;
                    Expression expression = new Expression(input.getText().toString());
                    result = expression.eval();
                    result_1.setText(result.toString());
                    input.setText("");
                }
                catch (Expression.ExpressionException e){
                    input.setText("");
                    addToResult("Error");
                }
                catch (EmptyStackException e) {

                }
                catch (ArithmeticException e){
                    input.setText("");
                    addToResult("Error");
                }
                break;

            case R.id.zapyataya:
                addToResult(".");
                break;
            case R.id.skobka_1:
                addToResult("(");
                break;
            case R.id.skobka_2:
                addToResult(")");
                break;
            case R.id.sin:
                addToResult("SIN");
                break;
            case R.id.x2:
                addToResult("^2");
                break;
            case R.id.xy:
                addToResult("^");
                break;
            case R.id.sqrt:
                addToResult("SQRT");
                break;
            case R.id.fakt:
                addToResult("FACT");
                break;
            case R.id.atan:
                addToResult("ATAN");
                break;
            case R.id.rand:
                addToResult("RANDOM");
                break;
            case R.id.cos:
                addToResult("COS");
                break;
            case R.id.tg:
                addToResult("TAN");
                break;
            case R.id.pi:
                addToResult("PI");
                break;
            case R.id.log:
                addToResult("LOG10");
                break;
            case R.id.ln:
                addToResult("LOG");
                break;
            case R.id.ex:
                addToResult("e^");
                break;


        }
    }
    public String getScreenOrientation(){
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
            return "Портретная ориентация";
        else if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)
            return "Альбомная ориентация";
        else
            return "";
    }
}