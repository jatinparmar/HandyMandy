package com.example.jatin.handymandy;

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
 * Created by Jatin on 08-04-2017.
 */

public class BackgroundTaskEmployer extends AsyncTask<String,Void,String> {
    AlertDialog alertDialog;
    Context context;

    BackgroundTaskEmployer(Context ctx) {
        context = ctx;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Transaction Status");
    }

    @Override
    protected String doInBackground(String... params) {
        //String reg_urle = "http://10.0.2.2/webapp/registeremployer.php";
        String reg_urle = "http://192.168.43.223/webapp/registeremployer.php";
        //String log_urle = "http://10.0.2.2/webapp/loginemployer.php";
        String log_urle = "http://192.168.43.223/webapp/loginemployer.php";
        String type = params[0];
        if (type.equals("registerer")) {

            String name = params[1];
            String lastname = params[2];
            String email = params[3];
            String username = params[4];
            String password = params[5];
            try {
                URL url = new URL(reg_urle);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&" +
                        URLEncoder.encode("lastname", "UTF-8") + "=" + URLEncoder.encode(lastname, "UTF-8") + "&" +
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                        URLEncoder.encode("username", "UTF-8") + "=" + URLEncoder.encode(username, "UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        } else if (type.equals("loginer")) {
            String email = params[1];
            String password = params[2];
            try {
                URL url = new URL(log_urle);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream os = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                String data1 =
                        URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&" +
                                URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
                bufferedWriter.write(data1);
                bufferedWriter.flush();
                bufferedWriter.close();
                os.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return null;

    }
    @Override
    protected void onPostExecute (String result){
        alertDialog.setMessage(result);
        alertDialog.show();

        if(result == null)
        {
            Toast.makeText(context, "Server Not Found!", Toast.LENGTH_LONG).show();
        }


        else if (result.contains("Registered")){
            Toast.makeText(context, "Registered Successfully. Please Login", Toast.LENGTH_LONG).show();

        }

        else if (result.contains("Login Success"))

        {
            Intent i = new Intent(context,EmployerMain.class);
            context.startActivity(i);
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else if (result.contains("User undefined")){

            Toast.makeText(context, "Something is Wrong Please Login Again!", Toast.LENGTH_LONG).show();
        }
        else{

            Toast.makeText(context, "Error!", Toast.LENGTH_LONG).show();
        }

    }

    }


