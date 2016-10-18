package com.app.oscar.pruebadescargafichero;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private Button buttonVer;
    private EditText mEditText;
    ArrayList<String> datas = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        buttonVer = (Button) findViewById(R.id.button2);
        mEditText = (EditText) findViewById(R.id.editText);


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
                StringBuilder str = new StringBuilder();

                for ( String valor:datas )
                {
                    str.append(valor + "\n");
                   // Log.d("MainActivity", valor);
                }

                mEditText.setText(str.toString());

            }
        });

    }


    private void downloadFile() throws IOException {

        new Thread(new Runnable() {
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


                    // DefaultHttpClient  httpclient = new DefaultHttpClient();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        }).start();

    }

}
