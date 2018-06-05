package com.example.jatin.handymandy;

/**
 * Created by Jatin on 10-04-2017.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Jatin on 07-04-2017.
 */
public class BackgroundLocation extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context context;
    BackgroundLocation(Context ctx)
    {
        context=ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog=new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Location Status");
    }

    @Override
    protected String doInBackground(String...params) {
       // String reg_url="http://10.0.2.2/webapp/location.php";
        String reg_url="http://192.168.43.223/webapp/location.php";
        String type= params[0];
        if(type.equals("location")){

            String elocation=params[1];
            try {
                URL url=new URL(reg_url);
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os=httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter=new BufferedWriter(new OutputStreamWriter(os,"UTF-8"));
                String data=
                        URLEncoder.encode("elocation", "UTF-8")+"="+URLEncoder.encode(elocation,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream=httpURLConnection.getInputStream();
                BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while((line=bufferedReader.readLine())!=null){
                    result +=line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return  result;



            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    protected void onPostExecute(String result) {
        if(result == null)
        {
            Toast.makeText(context, "Something is Wrong", Toast.LENGTH_LONG).show();
        }

        else if (result.contains("Your Attendance has been Submitted"))

        {
            Intent i = new Intent(context,MapsActivity.class);
            context.startActivity(i);
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if (result.contains("error")){

            Toast.makeText(context, "Error", Toast.LENGTH_LONG).show();
        }

    }
}