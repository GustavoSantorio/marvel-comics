package com.example.gusta.marvelcomics.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import com.example.gusta.marvelcomics.R;
import com.example.gusta.marvelcomics.delegate.BasicDelegate;
import com.example.gusta.marvelcomics.model.MarvelBasicResponse;
import com.example.gusta.marvelcomics.model.MarvelCharacter;
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

public class CharactersTask extends AsyncTask {
    private ProgressDialog dialog;

    private BasicDelegate delegate;
    private Context context;

    public CharactersTask(BasicDelegate delegate , Context context){
        this.delegate = delegate;
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        this.dialog = new ProgressDialog(context);
        this.dialog.setMessage(context.getResources().getString(R.string.msg_consult));
        this.dialog.setCancelable(false);
        this.dialog.show();
    }

    @Override
    protected BasicInterfaceResponse doInBackground(Object... params) {
        String ts = (String) params[0];
        String limit = (String) params[1];
        String offset = (String) params[2];

        BasicInterfaceResponse basicInterfaceResponse = new BasicInterfaceResponse();
        Gson gson = new Gson();

        try {
            BasicTaskResponse basicResponse = WebClient.request(String.format(Constant.URL_CHARACTER, ts, limit, offset, Constant.PUBLIC_KEY, Encryption.md5(ts+ Constant.PRIVATE_KEY + Constant.PUBLIC_KEY)) , Constant.REQUEST_METHOD_GET, null, null,null);
            if(basicResponse != null) {
                basicInterfaceResponse.setStatusCode(basicResponse.getStatusCode());
                basicInterfaceResponse.setMessage(basicResponse.getMessage());
                if (basicResponse.getStatusCode() == HttpURLConnection.HTTP_OK) {
                    JSONObject json = (JSONObject) new JSONTokener(basicResponse.getBody()).nextValue();
                    Type characterType = (Type) new TypeToken<MarvelBasicResponse>() {
                    }.getType();

                    MarvelBasicResponse marvelCharacter = (MarvelBasicResponse) gson.fromJson(json.toString(), (java.lang.reflect.Type) characterType);
                    basicInterfaceResponse.setObject(marvelCharacter);
                }
            }else{
                basicInterfaceResponse.setStatusCode(400);
                basicInterfaceResponse.setMessage(Constant.HTTP_PROBLEM);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return basicInterfaceResponse;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
        delegate.onTaskResult((BasicInterfaceResponse) o);
        this.dialog.dismiss();
    }

}