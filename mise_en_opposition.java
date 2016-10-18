package com.example.kamelbenlakhal.atbmobilebanking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class mise_en_opposition extends AppCompatActivity {
    TextView etDate,etNumco ;
    EditText  etNumca ;
    Spinner spinner;
    String sp,numco,numca,date ;
    ArrayAdapter<CharSequence> adapter ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mise_en_opposition);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.b);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.b);
        etNumca =(EditText)findViewById(R.id.etNumca);
        etDate =(TextView)findViewById(R.id.etDate);
        etNumco =(TextView)findViewById(R.id.etNum);
        spinner = (Spinner)findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(this, R.array.Motif, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        etNumco.setText(String.valueOf(staticVars.numCompte));
        Calendar c = Calendar.getInstance();
        System.out.println("Current time => " + c.getTime());
        SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
        String formattedDate = df.format(c.getTime());
       etDate.setText(formattedDate);

    }


    public void onEnvoyer (View view) {
        numca = etNumca.getText().toString();
        date = etDate.getText().toString();
        numco = etNumco.getText().toString();
        sp = spinner.getSelectedItem().toString();
        if (numca.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Veuillez saisir le numéro de compte", Toast.LENGTH_LONG).show();
        } else {
            String method = "envoyer";
            BackgroundTask4 backgroundTask4 = new BackgroundTask4(this);
            backgroundTask4.execute(method, numco, numca, sp, date);
            finish();

        }
    }
    public void onExit (View view){
        //startActivity(new Intent(this, Mes_cartes.class));
        finish();

    }
    private void runActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void onDec (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(mise_en_opposition.this);
        builder.setTitle("Se deconnecter");
        builder.setMessage("voulez-vous vraiment vous déconnecter ?");
        builder.setPositiveButton("oui", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                runActivity();

            }
        });
        builder.setNegativeButton("annuler", null);
        builder.show();

    }


}

