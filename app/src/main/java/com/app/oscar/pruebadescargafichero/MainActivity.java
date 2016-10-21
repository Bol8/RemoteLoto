package com.app.oscar.pruebadescargafichero;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.j256.ormlite.android.apptools.OrmLiteBaseActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import Adaptadores.AdapterCombinationList;
import Adaptadores.AdapterList;
import Helpers.DatabaseHelper;
import POJO.Combination;

public class MainActivity extends OrmLiteBaseActivity<DatabaseHelper> {

    private Button button;
    private Button buttonVer;
    private EditText mEditText;
    private ListView mListView;
    private AsyncTask mAsyncTask;
    Message msg = new Message();
    Handler handler;
    private AdapterCombinationList mAdapterCombinationList;
    ArrayList<String> datas = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonDescargar);
        buttonVer = (Button) findViewById(R.id.buttonVer);
        mListView = (ListView) findViewById(R.id.combination_List);
        // mEditText = (EditText) findViewById(R.id.editText);

        DatabaseHelper databaseHelper = getHelper();


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("MainActivity", "Press button");

                try {
                    downloadFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });


        buttonVer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AdapterList adpter = new AdapterList(MainActivity.this,getCombinationList());

                mListView.setAdapter(adpter);

               /* //Cursor cursor = (Cursor) datas;
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                        android.R.layout.simple_list_item_1,
                        datas);


                mListView.setAdapter(adapter);
               // mListView.*/


                //a la id de views en le layout
              /*  int[] to = new int[]{
                        R.id.row_text
                };

                mAdapterCombinationList = new AdapterCombinationList(
                        MainActivity.this,
                        R.layout.combination_row,
                        cursor,
                        null,
                        to,
                        0
                );

                mListView.setAdapter(mAdapterCombinationList);*/


                //StringBuilder str = new StringBuilder();

               /* for ( String valor:datas )
                {
                    str.append(valor + "\n");
                   // Log.d("MainActivity", valor);
                }

                mEditText.setText(str.toString());*/

            }
        });

        handler = new Handler(Looper.getMainLooper()) {

            @Override
            public void handleMessage(Message message) {
                // This is where you do your work in the UI thread.
                // Your worker tells you in the message what to do.
            }
        };

    }



    private void downloadFile() throws IOException {

        mAsyncTask = new AsyncTask() {
            @Override
            protected Object doInBackground(Object[] params) {
                // TODO Auto-generated method stub
                Looper.prepare();

                //  ArrayList<String> urls = new ArrayList<String>();
                URL url = null;

                try {
                    url = new URL("https://docs.google.com/spreadsheet/pub?key=0AhqMeY8ZOrNKdEFUQ3VaTHVpU29UZ3l4emFQaVZub3c&output=csv");
                    //  url = new URL("http://www.football-data.co.uk/mmz4281/1617/SP1.csv");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    // conn.setConnectTimeout(60000);

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String str;
                    while ((str = in.readLine()) != null) {
                        datas.add(str);
                        // mEditText.setText(str);
                        //Log.d("MainActivity", str);
                    }

                    in.close();

                    //  msg.arg1 = 1;
                    //  handler.sendMessage(msg);



                    // DefaultHttpClient  httpclient = new DefaultHttpClient();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }



                Toast.makeText(MainActivity.this, "Descarga completa", Toast.LENGTH_LONG).show();
                Looper.loop();


               // cancel(true);

                return null;
            }
        }.execute();

      // mAsyncTask.cancel(true);

        /*new AsyncTask(){

            @Override
            protected Object doInBackground(Object[] params) {


                // TODO Auto-generated method stub
                Looper.prepare();

                //  ArrayList<String> urls = new ArrayList<String>();
                URL url = null;

                try {
                    url = new URL("https://docs.google.com/spreadsheet/pub?key=0AhqMeY8ZOrNKdEFUQ3VaTHVpU29UZ3l4emFQaVZub3c&output=csv");
                    //  url = new URL("http://www.football-data.co.uk/mmz4281/1617/SP1.csv");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    // conn.setConnectTimeout(60000);

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String str;
                    while ((str = in.readLine()) != null) {
                        datas.add(str);
                        // mEditText.setText(str);
                        //Log.d("MainActivity", str);
                    }

                    in.close();

                  //  msg.arg1 = 1;
                  //  handler.sendMessage(msg);



                    // DefaultHttpClient  httpclient = new DefaultHttpClient();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }



                Toast.makeText(MainActivity.this, "Descarga completa", Toast.LENGTH_LONG).show();
                Looper.loop();
                return null;
            }
        }.execute();*/

       /* new Thread(new Runnable() {
            @Override
            public void run() {
                //  ArrayList<String> urls = new ArrayList<String>();
                URL url = null;

                try {
                    url = new URL("https://docs.google.com/spreadsheet/pub?key=0AhqMeY8ZOrNKdEFUQ3VaTHVpU29UZ3l4emFQaVZub3c&output=csv");
                    //  url = new URL("http://www.football-data.co.uk/mmz4281/1617/SP1.csv");

                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    // conn.setConnectTimeout(60000);

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

                    String str;
                    while ((str = in.readLine()) != null) {
                        datas.add(str);
                        // mEditText.setText(str);
                        //Log.d("MainActivity", str);
                    }

                    in.close();

                    msg.arg1 = 1;
                    handler.sendMessage(msg);



                    // DefaultHttpClient  httpclient = new DefaultHttpClient();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();*/

    }


    private ArrayList<Combination> getCombinationList(){

        ArrayList<Combination> listCombinations = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 1; i < datas.size() ; i++) {

            String[] values = datas.get(i).split(",");
            Combination comb = null;

            try {

                Date date = df.parse(values[0]);
                comb = new Combination(df.parse(values[0]),Integer.parseInt(values[1]),Integer.parseInt(values[2]),
                                                   Integer.parseInt(values[3]),Integer.parseInt(values[4]),Integer.parseInt(values[5]),
                                                   Integer.parseInt(values[7]),Integer.parseInt(values[8]));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            listCombinations.add(comb);
        }

       /* for (String valor : datas) {



            Combination comb = new Combination(new Date(),1,2,3,4,5,1,2);

           listCombinations.add(comb);

        }*/

        return listCombinations;
    }

}
