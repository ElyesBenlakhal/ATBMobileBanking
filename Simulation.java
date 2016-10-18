package com.example.kamelbenlakhal.atbmobilebanking;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

import static java.lang.StrictMath.exp;

public class Simulation extends AppCompatActivity {
    private static SeekBar duree;
    private static TextView text_View ;
    private static SeekBar montant;
    private static TextView text_View2 ;
    private static SeekBar taux;
    private static TextView text_View3 ;


    TextView etResultat ;
    double re=0.00;
    ArrayAdapter<CharSequence> adapter ;
double r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simulation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.b);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.b);

        etResultat =(TextView)findViewById(R.id.etResultat);
        duree = (SeekBar)findViewById(R.id.seekBar);
        montant = (SeekBar)findViewById(R.id.seekBar);
        taux = (SeekBar)findViewById(R.id.seekBar);




        seekduree () ;
        seekmontant() ;
        seektaux ();
    }
    public void seekduree (){
        duree = (SeekBar) findViewById(R.id.seekBar);
        text_View = (TextView) findViewById(R.id.textView);
        text_View.setText("durée : " + duree.getProgress() + "/" + duree.getMax());

     duree.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
            int progress_value;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress_value = progress;
                text_View.setText("durée : " + progress + "/" + duree.getMax());

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                text_View.setText("durée : " + progress_value + "/" + duree.getMax());


            }
        });
    }
    public void seekmontant () {
        montant = (SeekBar) findViewById(R.id.seekBar2);
        text_View2 = (TextView) findViewById(R.id.textView2);
        text_View2.setText("montant : " + montant.getProgress() + "/" + montant.getMax());
     montant.setOnSeekBarChangeListener(
        new SeekBar.OnSeekBarChangeListener() {
            int progress_valu ;
            @Override
            public void onProgressChanged(SeekBar seekBar2, int progres, boolean fromUser) {
                progress_valu = progres;
                text_View2.setText("montant : " + progres + "/" + montant.getMax());
                           }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar2) {
                text_View2.setText("montant : " + progress_valu + "/" + montant.getMax());

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar2) {
                text_View2.setText("montant : " + progress_valu + "/" + montant.getMax());


            }
        }
);
    }

    public void seektaux () {
        taux = (SeekBar) findViewById(R.id.seekBar3);
        text_View3 = (TextView) findViewById(R.id.textView3);
        text_View3.setText("taux : " + taux.getProgress() + "/" + taux.getMax());
       taux.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    int progress_val ;
                    @Override
                    public void onProgressChanged(SeekBar seekBar3, int progre, boolean fromUser) {
                        progress_val = progre;
                        text_View3.setText("taux : " + progre + "/" + taux.getMax());
                                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar3) {
                        text_View3.setText("taux : " + progress_val + "/" + taux.getMax());

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar3) {
                        text_View3.setText("taux : " + progress_val + "/" + taux.getMax());


                    }
                }
        );
    }



    public void onValide (View view){
        DecimalFormat df = new DecimalFormat("00.00");

        String s =df.format(taux.getProgress() / 100.00);
        double tmp=0.00;
        tmp = (double)(taux.getProgress()/100.00);

        re= (double)(montant.getProgress() *(double)(taux.getProgress()/100))/(double)(1-((double)(1+(double)(taux.getProgress()/100)) *exp(-duree.getProgress()) ));

        etResultat.setText(String.valueOf((double)(montant.getProgress() *(double)(taux.getProgress()/100.00))/(double)(1-((double)(1+(double)(taux.getProgress()/100.00)) *exp(-duree.getProgress()) ))));

    }

    public void onExit (View view){
        finish();

    }



}
