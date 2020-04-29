package com.example.laba_1;

import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    String[][] sex = {
            {"" , "один" , "два" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять"} ,
            {"" , "одна" , "две" , "три" , "четыре" , "пять" , "шесть" , "семь" , "восемь" , "девять"} ,
    };
    String[] str100 = {"" , "сто" , "двести" , "триста" , "четыреста" , "пятьсот" , "шестьсот" , "семьсот" , "восемьсот" , "девятьсот"};
    String[] str11 = {"" , "десять" , "одиннадцать" , "двенадцать" , "тринадцать" , "четырнадцать" , "пятнадцать" , "шестнадцать" , "семнадцать" , "восемнадцать" , "девятнадцать" , "двадцать"};
    String[] str10 = {"" , "десять" , "двадцать" , "тридцать" , "сорок" , "пятьдесят" , "шестьдесят" , "семьдесят" , "восемьдесят" , "девяносто"};
    String[]forms ={"тысячa","тысячи" , "тысяч"};


    final String LOG_TAG = "myLogs";
    final String LOG_TAG_1 = "число";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      String [] Num_1 =new String[100000];
      int a,b,c, d, e;
      for(int i=1; i<100000; i++){
          e=i/10000;
          d=(i-e*10000)/1000;
          c=(i-e*10000-d*1000)/100;
          if(e>=10 && e<=19){
              Num_1[i-1]=str11[i % 100 - 9]+" ";
          }
          else {
              Num_1[i-1]=str10[e]+" ";
          }
          if (i%100>=11 && i%100<=19 && !(e>=11 && e<=19)){
              if(d>=2 &&d<=4 && !(e>=11 && e<=19)) {
                  Num_1[i - 1] += sex[1][d] + " тысячи " + str100[c] + " " + str11[i % 100 - 9];
              }
             else if(d>=5 &&d<=9 && !(e>=11 && e<=19)) {
                  Num_1[i - 1] += sex[0][d] + " тысяч " + str100[c] + " " + str11[i % 100 - 9];
              }
              else if(d==1&& !(e>=11 && e<=19)) {
                  Num_1[i - 1] += sex[1][d] + " тысяча " + str100[c] + " " + str11[i % 100 - 9];
              }
              else if (d==0){
                  Num_1[i - 1] = str100[c] + " " + str11[i % 100 - 9];
              }
          }
          else{
              a=(i-e*10000-d*1000-c*100)/10;
              b=i%10;
              if(d>=2 &&d<=4 && !(e>=11 && e<=19) ) {
                  Num_1[i - 1] += sex[1][d] + " тысячи " +str100[c]+" "+str10[a]+" "+sex[0][b];
              }
              else if(d>=5 &&d<=9 &&!(e>=11 && e<=19)) {
                  Num_1[i - 1] += sex[0][d] + " тысяч " + str100[c]+" "+str10[a]+" "+sex[0][b];
              }
              else if(d==1  &&!(e>=11 && e<=19)) {
                  Num_1[i - 1] += sex[1][d] + " тысяча " + str100[c]+" "+str10[a]+" "+sex[0][b];
              }
              else if (d==0 &&!(e==1)){
                  Num_1[i - 1] += str100[c]+" "+str10[a]+" "+sex[0][b];
              }
          }
      }

        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        ListView lvMain = (ListView) findViewById(R.id.lvMain);
        CustomArrayAdapter listAdapter = new CustomArrayAdapter(this, Num_1);
        lvMain.setAdapter(listAdapter);
    }
}
