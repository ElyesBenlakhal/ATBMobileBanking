package com.example.kamelbenlakhal.atbmobilebanking;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class operation_carte extends AppCompatActivity {
    private String jsonResult;
    //public String url ="http://192.168.1.39/client/carte.php";
    ListView listView;
    List<Map<String,String>> bd_atb = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operation_carte);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setLogo(R.drawable.b);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        getSupportActionBar().setIcon(R.drawable.b);
        listView = (ListView) findViewById(R.id.listView);
        accessWebService();


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
            ListDrwaer(); // we will create it later
        }
    }
    public void accessWebService(){
        HashMap postData = new HashMap();
        postData.put("num_compte","1222");
        JsonReadTask task = new JsonReadTask();
        task.execute(new String[] {staticVars.url+"carte.php"+"?num_compte="+staticVars.numCompte});
    }
    public void ListDrwaer (){
        try{
            JSONObject jsonResonse = new JSONObject(jsonResult.substring(jsonResult.indexOf("{"), jsonResult.lastIndexOf("}")+1));
            JSONArray jsonMainNode = jsonResonse.optJSONArray("liste_operation_carte");

            final ArrayList<HashMap<String,String>> MyArrList = new ArrayList<HashMap<String, String>>();

            HashMap<String,String> map;
            staticVars.numCarte.clear();
            JSONObject c;
            SimpleAdapter sAdap = null;

            for(int i=0; i<jsonMainNode.length(); i++){

                c = jsonMainNode.getJSONObject(i);
                staticVars.numCarte.add(c.getLong("num_carte"));

                map = new HashMap<String,String>();

                map.put("num_compte", c.getString("num_compte"));
                map.put("num_carte", c.getString("num_carte"));
                map.put("type_carte", c.getString("type_carte"));
                map.put("date_expiration", c.getString("date_expiration"));
                map.put("statut", c.getString("statut"));
                MyArrList.add(map);
            }
            sAdap = new SimpleAdapter(operation_carte.this, MyArrList, R.layout.operationcarte_column, new String[]{"num_compte","num_carte","type_carte",
                    "date_expiration","statut"}, new int[]{R.id.Colnum_compte, R.id.Colnum_carte, R.id.Coltype_carte, R.id.Coldate_expiration, R.id.Colstatut});

            listView.setAdapter(sAdap);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    // Object o = listView.getItemAtPosition(position);
                    onDetail(String.valueOf(staticVars.numCarte.get(position)));
                }
            });
        }catch (JSONException e){
            Toast.makeText(getApplicationContext(),"error ..." + e.toString(), Toast.LENGTH_LONG).show();
        }


    }
    public void onExit (View view){

       // startActivity(new Intent(this, Mes_cartes.class));
        finish();

    }
    public void onDetail (String nCarte){

        Intent i = new Intent(this,Detail_operation_carte.class);
        i.putExtra("num_carte",nCarte);
        startActivity(i);

    }
    private void runActivity() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }
    public void onDec (View view){
        AlertDialog.Builder builder = new AlertDialog.Builder(operation_carte.this);
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
