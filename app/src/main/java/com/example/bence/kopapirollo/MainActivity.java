package com.example.bence.kopapirollo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button b_ko, b_papir, b_ollo;
    TextView tv_eredmeny;
    ImageView iv_emberValasztas, iv_gepValasztas;
    int jatekosPont, gepPont;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b_ko = (Button) findViewById(R.id.b_ko);
        b_ollo = (Button) findViewById(R.id.b_ollo);
        b_papir = (Button) findViewById(R.id.b_papir);

        iv_emberValasztas = (ImageView) findViewById(R.id.iv_emberValasztas);
        iv_gepValasztas = (ImageView) findViewById(R.id.iv_gepValasztas);

        tv_eredmeny = (TextView) findViewById(R.id.tv_eredmeny);

        b_ko.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_emberValasztas.setImageResource(R.drawable.rock);
                String megjegyzes = jatek_kor("ko");
                Toast.makeText(MainActivity.this, megjegyzes, Toast.LENGTH_SHORT).show();
                tv_eredmeny.setText("Eredmény: Ember: " + Integer.toString(jatekosPont)+ " Robot: " +Integer.toString(gepPont));
            }

        });

        b_papir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_emberValasztas.setImageResource(R.drawable.paper);
                String megjegyzes = jatek_kor("papir");
                Toast.makeText(MainActivity.this, megjegyzes, Toast.LENGTH_SHORT).show();
                tv_eredmeny.setText("Eredmény: Ember: " + Integer.toString(jatekosPont)+ " Robot: " +Integer.toString(gepPont));
            }

        });

        b_ollo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_emberValasztas.setImageResource(R.drawable.scissors);
                String megjegyzes = jatek_kor("ollo");
                Toast.makeText(MainActivity.this, megjegyzes, Toast.LENGTH_SHORT).show();
                tv_eredmeny.setText("Eredmény: Ember: " + Integer.toString(jatekosPont)+ " Robot: " +Integer.toString(gepPont));
            }
        });
    }



    public String jatek_kor( String jatekosValasztott){
        String gepValasztott = "";
        Random r = new Random();

        int gepValasztottSzam = r.nextInt(3)+1;

        if (gepValasztottSzam == 1){
            gepValasztott = "ko";
        } else
        if (gepValasztottSzam == 2){
            gepValasztott = "papir";
        } else
        if (gepValasztottSzam == 3){
            gepValasztott = "ollo";
        }



        if (gepValasztott == "ko"){
            iv_gepValasztas.setImageResource(R.drawable.rock);
        }else
        if (gepValasztott == "papir"){
            iv_gepValasztas.setImageResource(R.drawable.paper);
        }else
        if (gepValasztott == "ollo"){
            iv_gepValasztas.setImageResource(R.drawable.scissors);
        }


        if (jatekosValasztott == gepValasztott){
            return "Döntetlen.";
        }
        else if (jatekosValasztott == "ko" && gepValasztott == "ollo"){
            jatekosPont++;
            return "Az ollót széjjel csapja a kő. Játékos nyert!";
        }
        else if (jatekosValasztott == "ko" && gepValasztott == "papir"){
            gepPont++;
            return "Az papír becsomagolja a követ. Gép nyert!";
        }
        else if (jatekosValasztott == "ollo" && gepValasztott == "ko"){
            gepPont++;
            return "Az ollót széjjel csapja a kő. Gép nyert!";
        }
        else if (jatekosValasztott == "ollo" && gepValasztott == "papir"){
            jatekosPont++;
            return "Az olló földarabolja a papírt. Játékos nyert!";
        }
        else if (jatekosValasztott == "papir" && gepValasztott == "ko"){
            jatekosPont++;
            return "Az papír becsomagolja a követ. Játékos nyert!";
        }
        else if (jatekosValasztott == "papir" && gepValasztott == "ollo"){
            gepPont++;
            return "Az olló földarabolja a papírt. Gép nyert!";
        }
        else return "Kecske";

    }
}
