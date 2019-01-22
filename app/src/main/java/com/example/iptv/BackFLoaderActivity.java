package com.example.iptv;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class BackFLoaderActivity  {



    private void downloadFile(String url) {
       // final ProgressDialog progressDialog = new ProgressDialog(this);

        new AsyncTask<String, Integer, InputStream>() {
            private Exception m_error = null;



            @Override
            protected  InputStream doInBackground(String... params) {
                try {

                    URL url  = new URL("http://185.70.15.1:27999/play");

                    // vidUri.describeContents()
                    URLConnection conn =  url.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

            wr.flush();

            return  conn.getInputStream();

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                    m_error = e;
                } catch (IOException e) {
                    e.printStackTrace();
                    m_error = e;
                }

                return null;
            }


        }.execute(url);
    }
}
