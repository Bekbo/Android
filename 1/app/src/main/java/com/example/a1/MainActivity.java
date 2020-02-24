package com.example.a1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity{
    Button num1,num2,num3,num4,num5,num6,num7,num8,num9,num0, min, plus, mul, div, res, abs, dot,
    clear, remove, sin,cos,pow,sqrt, fact, ln,lg,tan,pi;
    String oper = "";
    TextView txt, preres;
    boolean ravno = false, dott = false;
    float arg1 = 0, arg2 = 0, total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        num1 = findViewById(R.id.num1); min = findViewById(R.id.min);
        num2 = findViewById(R.id.num2); plus = findViewById(R.id.plus);
        num3 = findViewById(R.id.num3); div = findViewById(R.id.div);
        num4 = findViewById(R.id.num4); mul = findViewById(R.id.mul);
        num5 = findViewById(R.id.num5); res = findViewById(R.id.result);
        num6 = findViewById(R.id.num6); abs = findViewById(R.id.abs);
        num7 = findViewById(R.id.num7); dot = findViewById(R.id.dot);
        num8 = findViewById(R.id.num8); clear = findViewById(R.id.clear);
        num9 = findViewById(R.id.num9); remove = findViewById(R.id.remove);
        num0 = findViewById(R.id.num0); txt = findViewById(R.id.text);
        preres = findViewById(R.id.preresult); ln = findViewById(R.id.ln);
        sin = findViewById(R.id.sin); lg = findViewById(R.id.lg);
        cos = findViewById(R.id.cos); tan = findViewById(R.id.tan);
        fact = findViewById(R.id.fact); pi = findViewById(R.id.pi);
        pow = findViewById(R.id.pow);
        sqrt = findViewById(R.id.sqrt);
    }

    protected void onStart(){
        super.onStart();
    }

    protected void onResume(){
        super.onResume();

    }

    protected void onPause(){
        super.onPause();
    }

    protected void onStop(){
        super.onStop();
    }

    protected void onDestroy(){
        super.onDestroy();
    }

    protected void onRestart(){
        super.onRestart();
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        txt.setText(savedInstanceState.getString("result"));
        preres.setText(savedInstanceState.getString("preres"));
        oper = savedInstanceState.getString("oper");
        arg1 = savedInstanceState.getFloat("arg1");
        dott = savedInstanceState.getBoolean("dot");
    }

    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("result", txt.getText()+"");
        outState.putString("oper", oper);
        outState.putString("preres", preres.getText()+"");
        outState.putFloat("arg1", arg1);
        outState.putBoolean("dot", dott);
    }

    public void onClick(View v) {
        if (v.getId()==dot.getId()){
            if (dott == false) {
                dott = true;
                txt.append(".");
            }
            return;
        }else{
            Button btn = (Button)v;
            if (txt.getText().charAt(txt.length() - 1) == '.') {
                txt.append(btn.getText());
                return;
            }
            if (Float.parseFloat(txt.getText()+"") == 0) {
                txt.setText(btn.getText());
            }else{
                txt.append(btn.getText());
            }
        }
    }

    public void operClick(View v){
        try {
            dott = false;
            if(arg1 != 0){
                arg2 = Float.parseFloat(txt.getText()+"");
            }else{
                arg1 = Float.parseFloat(txt.getText()+"");
            }
            if (oper != ""){
                if(oper == "+"){
                    arg1 = arg1 + arg2;
                }else if (oper == "-"){
                    arg1 = arg1 - arg2;
                }else if (oper == "*"){
                    if (arg2 != 0){
                        arg1 = arg1 * arg2;
                    }
                }else if (oper == "/"){
                    if (arg2 != 0){
                        arg1 = arg1 / arg2;
                    }
                }
                arg2 = 0;
                oper = "";
            }
            if (v.getId() == plus.getId()){
                oper = "+";
            }else if(v.getId() == min.getId()){
                oper = "-";
            }else if (v.getId() == div.getId()){
                oper = "/";
            }else if (v.getId() == mul.getId()){
                oper = "*";
            }
            arg2 = 0;
        }catch (Exception e) {
            arg1 = 0; arg2 = 0;
        }finally {
            txt.setText("0");
            preres.setText(arg1+"");
        }

    }

    public void landOperClick(View v){
        Double arg1_1 = Double.parseDouble(txt.getText()+"");
        try {
            dott = false;
            if (v.getId() == sin.getId()){
                arg1_1 = Math.sin(arg1_1*Math.PI/180);
            }else if (v.getId() == cos.getId()){
                arg1_1 = Math.cos(arg1_1*Math.PI/180);
            }else if (v.getId() == pow.getId()){
                arg1_1 = Math.pow(arg1_1,2);
            }else if (v.getId() == sqrt.getId()){
                arg1_1 = Math.sqrt(arg1_1);
            }else if (v.getId() == fact.getId()){
                arg1_1 = calcFact(Integer.parseInt(txt.getText()+""));
            }else if (v.getId() == pi.getId()){
                arg1_1 = Math.PI;
            }else if (v.getId() == ln.getId()){
                arg1_1 = Math.log(arg1_1);
            }else if (v.getId() == lg.getId()){
                arg1_1 = Math.log10(arg1_1);
            }else if (v.getId() == tan.getId()){
                arg1_1 = Math.tan(arg1_1*Math.PI/180);
            }
            dott = true;
            if (arg1 == 0)
                arg1 = arg1_1.floatValue();
            else
                arg2 = arg1_1.floatValue();
        }catch (Exception e){
            arg1 = 0; arg2 = 0;
        }finally {
            txt.setText(arg1_1+"");
        }

    }

    private Double calcFact(int num){
        double res = 1;
        for(int i = 2; i <=num; i++)
            res = res*i;
        return res;
    }

    public void absClick(View v){
        dott = false;
        float num = Float.parseFloat(txt.getText()+"");
        if (num < 0)
            num *= -1;
        txt.setText(num+"");
    }

    public void clearText(View v){
        dott = false;
        arg2= 0;
        arg1=0;
        total = 0;
        preres.setText("");
        txt.setText("0");
    }

    public void remove(View v){
        String s = txt.getText()+"";
        int n = s.length();
        if (n==1){
            txt.setText("0");
        }else{
            if (s.charAt(n-1)=='.'){
                dott = false;
            }
            String news = s.substring(0,s.length()-1);
            txt.setText(news);
        }
    }

    public void total(View v) {
        ravno = true;
        if (oper != ""){
            arg2 = Float.parseFloat(txt.getText()+"");
            if (oper == "+"){
                arg1 = arg1 + arg2;
            }else if (oper == "-"){
                arg1 = arg1 - arg2;
            }else if (oper == "/"){
                arg1 = arg1 / arg2;
            }else if (oper == "*"){
                arg1 = arg1 * arg2;
            }
            arg2 = 0;
            oper="";
        }
        preres.setText("");
        txt.setText(arg1+"");
        arg2 = 0;
        dott = true;
        oper = "";
    }
}
