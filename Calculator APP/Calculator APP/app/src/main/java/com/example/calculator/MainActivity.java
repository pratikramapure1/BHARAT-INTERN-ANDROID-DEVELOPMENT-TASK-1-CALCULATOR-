package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    MaterialButton open_bracket,close_bracket,clr;
    MaterialButton divide,mul,plus,minus,equals ;
    MaterialButton one,two,three,four,five,six,seven,eight,nine,zero;
    MaterialButton dot,cut;

    TextView solution_tv,result_tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result_tv=findViewById(R.id.result);
        solution_tv=findViewById(R.id.expressoin);
        open_bracket=findViewById(R.id.open_bracket);
        open_bracket.setOnClickListener(this::onClick);
        close_bracket=findViewById(R.id.closing_bracket);
        close_bracket.setOnClickListener(this::onClick);
        clr=findViewById(R.id.Clear);
        clr.setOnClickListener(this::onClick);
        divide=findViewById(R.id.divide);
        divide.setOnClickListener(this::onClick);
        mul=findViewById(R.id.multiply);
        mul.setOnClickListener(this::onClick);
        plus=findViewById(R.id.plus);
        plus.setOnClickListener(this::onClick);
        minus  =findViewById(R.id.minus);
        minus.setOnClickListener(this::onClick);
        equals=findViewById(R.id.equal);
        equals.setOnClickListener(this::onClick);
        one=findViewById(R.id.one);
        one.setOnClickListener(this::onClick);
        two=findViewById(R.id.two);
        two.setOnClickListener(this::onClick);
        three=findViewById(R.id.three);
        three.setOnClickListener(this::onClick);
        four=findViewById(R.id.four);
        four.setOnClickListener(this::onClick);
        five=findViewById(R.id.five);
        five.setOnClickListener(this::onClick);
        six=findViewById(R.id.six);
        six.setOnClickListener(this::onClick);
        seven=findViewById(R.id.seven);
        seven.setOnClickListener(this::onClick);
        eight=findViewById(R.id.eight);
        eight.setOnClickListener(this::onClick);
        nine=findViewById(R.id.nine);
        nine.setOnClickListener(this::onClick);
        zero=findViewById(R.id.zero);
        zero.setOnClickListener(this::onClick);
        dot=findViewById(R.id.dot);
        dot.setOnClickListener(this::onClick);
        cut=findViewById(R.id.cut);
        cut.setOnClickListener(this::onClick);

       /*
        assignId(clr,R.id.Clear);
        assignId(divide,R.id.divide);
        assignId(mul,R.id.multiply);
        assignId(plus,R.id.plus);
        assignId(minus,R.id.minus);
        assignId(equals,R.id.equal);
        assignId(one,R.id.one);
        assignId(two,R.id.two);
        assignId(three,R.id.three);
        assignId(four,R.id.four);
        assignId(five,R.id.five);
        assignId(six,R.id.six);
        assignId(seven,R.id.seven);
        assignId(eight,R.id.eight);
        assignId(nine,R.id.nine);
        assignId(modulo,R.id.modulo);
        assignId(dot,R.id.dot);*/


    }
   /* void assignId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener( this);

    }*/
    public void onClick(View v){
        MaterialButton btn=(MaterialButton) v;
        String buttontext=btn.getText().toString();
        String data=solution_tv.getText().toString();

        if(buttontext.equals("=")){
            solution_tv.setText(result_tv.getText());
            result_tv.setText("0");

            return ;
        }
        if(buttontext.equals("X" )){

               // System.out.println("x");
                data = data.substring(0, data.length() - 1);

        }
        else
            data=data+buttontext;
        if(buttontext.equals("C")){

            solution_tv.setText("");
            result_tv.setText("0");
            return;
        }


        if(!getresult(data).equals("err")) {
            //System.out.println(getresult(data));
            result_tv.setText(getresult(data));
        }
        //System.out.println(data);
        solution_tv.setText(data);




    }
    String getresult(String exp){
        try {
            Context context = Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable = context.initSafeStandardObjects();
            System.out.println(exp);
            String res = context.evaluateString(scriptable, exp, "JavaScript", 1, null).toString();
            System.out.println(res);
            if(res.endsWith(".0"))
                    res=res.replace(".0","");
            /*char a=res.charAt(res.length()-1);
            char b='0';
            if(res.length()>2)
                    b=res.charAt(res.length()-2);
            if(a=='0' && b=='.')
                    res=res.substring(0,res.length()-2);*/
            double resultValue = Double.parseDouble(res);
            return String.valueOf(resultValue);
           // return res;
        }
        catch (Exception e){
            return "err";
        }

    }





}