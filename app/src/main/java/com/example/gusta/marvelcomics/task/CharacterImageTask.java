package com.example.gusta.marvelcomics.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import com.example.gusta.marvelcomics.R;
import com.example.gusta.marvelcomics.delegate.BasicDelegate;
import com.example.gusta.marvelcomics.delegate.CharacterImageDelegate;
import com.example.gusta.marvelcomics.model.MarvelBasicResponse;
import com.example.gusta.marvelcomics.model.URL;
import com.example.gusta.marvelcomics.response.BasicInterfaceResponse;
import com.example.gusta.marvelcomics.response.BasicTaskResponse;
import com.example.gusta.marvelcomics.util.Constant;
import com.example.gusta.marvelcomics.util.Encryption;
import com.example.gusta.marvelcomics.util.WebClient;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;
import org.json.JSONTokener;

import java.lang.reflect.Type;
import java.net.HttpURLConnection;

/**
 * Created by gusta on 06/05/2017.
 */

public class CharacterImageTask extends AsyncTask {

    private CharacterImageDelegate delegate;

    public CharacterImageTask(CharacterImageDelegate delegate , Context context){
        this.delegate = delegate;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object... params) {
        Bitmap bitmap = null;
        try {
             bitmap = WebClient.getBitmapFromURL((String) params[0] + "/portrait_xlarge." + (String) params[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        delegate.onImageTaskResult((Bitmap) o);
    }

}