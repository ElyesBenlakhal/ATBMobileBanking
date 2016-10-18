package com.example.kamelbenlakhal.atbmobilebanking;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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

public class Type_compte extends AppCompatActivity {
    private String jsonResult;
    public String url ="http://192.168.1.72/client/type_compte.php";
    ListView listView;
    List<Map<String, String>> bd_atb = new ArrayList<Map<String,String>>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_compte);
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
        task.execute(new String[] {url+"?num_compte="+staticVars.numCompte});
    }
    public void ListDrwaer (){
        try{
            JSONObject jsonResonse = new JSONObject(jsonResult.substring(jsonResult.indexOf("{"), jsonResult.lastIndexOf("}")+1));
            JSONArray jsonMainNode = jsonResonse.optJSONArray("client");

            final ArrayList<HashMap<String,String>> MyArrList = new ArrayList<HashMap<String, String>>();

            HashMap<String,String> map;

            for(int i=0; i<jsonMainNode.length(); i++){
                JSONObject c = jsonMainNode.getJSONObject(i);

                map = new HashMap<String,String>();

                map.put("num_compte", c.getString("num_compte"));
                map.put("type_compte", c.getString("type_compte"));

                MyArrList.add(map);

                SimpleAdapter sAdap;
                sAdap = new SimpleAdapter(Type_compte.this, MyArrList, R.layout.type_compte_column, new String[]{"num_compte",
                        "type_compte"}, new int[]
                        {R.id.Colnum_compte,R.id.Coltype_compte});

                listView.setAdapter(sAdap);





            }
        }catch (JSONException e){
            Toast.makeText(getApplicationContext(),"error ..." + e.toString(), Toast.LENGTH_LONG).show();
        }

    }

}
