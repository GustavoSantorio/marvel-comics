package com.example.gusta.marvelcomics.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import com.example.gusta.marvelcomics.response.BasicTaskResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;

/**
 * Created by gusta on 06/05/2017.
 */

public class WebClient {

    public static BasicTaskResponse request(String urlString, String method, String user, String pass, String json) throws SocketTimeoutException, IOException, Exception {
        HttpURLConnection connection = null;
        InputStream inputStream = null;
        BasicTaskResponse basicResponse = new BasicTaskResponse();

        try {
            URL url = new URL(urlString);
            connection = (HttpURLConnection) url.openConnection();

            if(user != null && pass != null){
                connection.setRequestProperty(Constant.REQUEST_PROPERTY_AUTHORIZATION, buildBasicAuthorizationString(user, pass));
            }

//            connection.setReadTimeout(Constant.READ_TIMEOUT);
            connection.setConnectTimeout(Constant.CONNECT_TIMEOUT);
            connection.setRequestMethod(method);
            connection.setRequestProperty(Constant.WS_ACCEPT, Constant.WS_APPLICATION_JSON);
            connection.setRequestProperty(Constant.WS_CONTENT_TYPE, Constant.WS_APPLICATION_JSON);
            connection.setDoInput(true);

            if(method.equalsIgnoreCase(Constant.REQUEST_METHOD_POST)){
                connection.setRequestProperty(Constant.REQUEST_PROPERTY_CONTENT_LENGHT, String.valueOf(json.getBytes().length));

                OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
                writer.write(json);
                writer.flush();
                writer.close();
            }

            connection.connect();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_CREATED
                    || connection.getResponseCode() == HttpURLConnection.HTTP_ACCEPTED
                    || connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                inputStream = connection.getInputStream();
                basicResponse.setStatusCode(connection.getResponseCode());
                basicResponse.setBody(convertStreamToStringRequest(inputStream));
            } else if(connection.getResponseCode() == HttpURLConnection.HTTP_BAD_REQUEST){
                inputStream = connection.getErrorStream();
                basicResponse.setStatusCode(connection.getResponseCode());
                basicResponse.setBody(convertStreamToStringRequest(inputStream));
            } else{
                basicResponse.setStatusCode(connection.getResponseCode());
                basicResponse.setBody("Ocorreram erros na consulta");
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            connection.disconnect();
            inputStream.close();
        }
        return basicResponse;
    }

    public static Bitmap getBitmapFromURL(String src) throws IOException{
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
    }

    public static String buildBasicAuthorizationString(String username, String password) {
        String credentials = username + ":" + password;
        return "Basic " + new String(Base64.encode(credentials.getBytes(), Base64.DEFAULT));
    }

    public static String convertStreamToStringRequest(InputStream is) throws IOException {
        if (is != null) {
            Writer writer = new StringWriter();
            char[] buffer = new char[1024];
            try {
                Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
                int n;
                while ((n = reader.read(buffer)) != -1) {
                    writer.write(buffer, 0, n);
                }
            } finally {
                is.close();
            }
            return writer.toString();
        } else {
            return "";
        }
    }

}
