package com.example.kamelbenlakhal.atbmobilebanking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kosalgeek.asynctask.AsyncResponse;
import com.kosalgeek.asynctask.PostResponseAsyncTask;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AsyncResponse,View.OnClickListener {
    //public String url ="http://192.168.1.39/client/login.php";
    private String jsonResult;
    EditText etUsername, etPassword;
    Button btnLogin;
    Intent ac;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.b);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.b);

        etUsername = (EditText) findViewById(R.id.etUsername);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(this);
        //accessWebService();
        ac = new Intent(this, Accueil.class);

    }
    private class JsonReadTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost(params[0]);
            try{
                HttpResponse response = httpclient.execute(httppost);
                jsonResult = inputStreamToString(
                        response.getEntity().getContent()).toString();



               // startActivity(ac);
/*
            staticVars.numCompte = num_compte;

            Intent i = new Intent(this, Accueil.class);
            startActivity(i);

            */
            }catch(ClientProtocolException e){
                e.printStackTrace();

            } catch (IOException e){
                e.printStackTrace();
            }


            return null;
        }
        private StringBuilder inputStreamToString(InputStream is){
            String rLine ="";
            StringBuilder answer = new StringBuilder();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            try{
                while((rLine = rd.readLine()) != null){
                    answer.append(rLine);
                }
            }catch(IOException e){
                Toast.makeText(getApplicationContext(), "error ..." + e.toString(), Toast.LENGTH_LONG).show();
            }
            return  answer;
        }
        @Override
        protected void onPostExecute(String result){

            try{
                JSONObject jsonResonse = new JSONObject(jsonResult);

                JSONObject c;
            JSONArray jsonMainNode = jsonResonse.optJSONArray("client");
            for(int i=0; i<jsonMainNode.length(); i++) {
                 c = jsonMainNode.getJSONObject(i);
                staticVars.numCompte =  c.getLong("num_compte");
                staticVars.numCarte.add(c.getLong("num_carte"));
            }
            runActivity(); // we will create it later
            } catch (JSONException e){
                Toast.makeText(getApplicationContext(), "echec de connexion", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void runActivity() {
        Intent i = new Intent(this, Accueil.class);
        startActivity(i);

    }

    public void accessWebService(){
        HashMap postData = new HashMap();
        postData.put("num_compte","1222");
        JsonReadTask task = new JsonReadTask();
        task.execute(new String[]{staticVars.url+"login.php"+ "?num_compte=" + staticVars.numCompte});
    }
    @Override
    public void processFinish(String result) {
/*

        int num_compte = Integer.parseInt(result);

        if (Integer.parseInt(result)>0) {

            Toast.makeText(this, result, Toast.LENGTH_LONG).show();

            staticVars.numCompte = num_compte;

            Intent i = new Intent(this, Accueil.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Login Failed", Toast.LENGTH_LONG).show();
        }
        */

    }

    @Override
    public void onClick(View v) {
        HashMap postData = new HashMap();
        postData.put("mobile", "android");
        postData.put("txtUsername", etUsername.getText().toString());
        postData.put("txtPassword", etPassword.getText().toString());

        String userName = etUsername.getText().toString();
        String password = etPassword.getText().toString();
        if (userName.isEmpty() || password.isEmpty()) {

            Toast.makeText(getApplicationContext(), "Veuillez remplir tous les champs S.V.P", Toast.LENGTH_LONG).show();
        } else {
            // PostResponseAsyncTask task = new PostResponseAsyncTask(this, postData);
            JsonReadTask task = new JsonReadTask();
            task.execute(new String[]{staticVars.url+"login.php"+ "?txtUsername=" + etUsername.getText().toString() + "&txtPassword=" + etPassword.getText().toString()});

            // task.execute("http://10.0.3.2/client/login.php");

        }
    }

    public void OnAg(View view) {
        startActivity(new Intent(this, Agence.class));

    }
    public void OnSim (View view) {
        startActivity(new Intent(this,  Simulation.class));

    }

    public void OnLoc(View view) {
        startActivity(new Intent(this, Geolocalisation.class));
    }
    public void onExit (View view){

        //startActivity(new Intent(this, First.class));
        finish();

    }

}