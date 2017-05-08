package com.example.gusta.marvelcomics.fragment;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gusta.marvelcomics.R;
import com.example.gusta.marvelcomics.activity.DetailActivity;
import com.example.gusta.marvelcomics.adapter.CharactersAdapter;
import com.example.gusta.marvelcomics.delegate.BasicDelegate;
import com.example.gusta.marvelcomics.delegate.CharacterImageDelegate;
import com.example.gusta.marvelcomics.model.MarvelBasicResponse;
import com.example.gusta.marvelcomics.model.MarvelCharacter;
import com.example.gusta.marvelcomics.response.BasicInterfaceResponse;
import com.example.gusta.marvelcomics.task.CharacterImageTask;
import com.example.gusta.marvelcomics.task.CharactersTask;
import com.example.gusta.marvelcomics.util.Alert;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class ListFragment extends BaseFragment implements BasicDelegate, CharacterImageDelegate, AdapterView.OnItemClickListener, AbsListView.OnScrollListener, View.OnClickListener{

    private ListView lvList;
    private ProgressDialog dialog;
    private TextView tvCarregar;

    private int requisitionSize = 10;
    private int offset = 0;
    private List<Bitmap> bitmapList;
    private MarvelBasicResponse marvelBasicResponse;
    private CharactersAdapter adapter;
    private List<MarvelCharacter> characterList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        inflateComponents(view);
        this.characterList = new ArrayList<>();
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        executeTask();
    }

    @Override
    public void onResume() {
        super.onResume();
        this.bitmapList = new ArrayList<>();
        setListeners();
    }

    @Override
    protected void inflateComponents(@NonNull View view){
        this.lvList = (ListView) view.findViewById(R.id.lv_list);
        this.tvCarregar = (TextView) view.findViewById(R.id.tv_carregar);
    }

    @Override
    protected void setListeners() {
        this.lvList.setOnItemClickListener(this);
        this.lvList.setOnScrollListener(this);
        this.tvCarregar.setOnClickListener(this);
    }

    private void setAdapter(){
        if(adapter == null) {
            adapter = new CharactersAdapter(getActivity(), this.marvelBasicResponse.getData().getResults(), this.bitmapList, this.marvelBasicResponse.getData().getTotal(), offset + requisitionSize);
            lvList.setAdapter(adapter);
        }else {
            adapter.showMore(this.marvelBasicResponse.getData().getResults(), this.bitmapList, offset + requisitionSize);
        }
    }

    private void executeTask(){
        new CharactersTask(this, getActivity()).execute("1", String.valueOf(10), String.valueOf(offset));
    }

    private void executeTaskImage(List<MarvelCharacter> characterList){
        this.dialog = new ProgressDialog(getActivity());
        this.dialog.setMessage(getActivity().getResources().getString(R.string.msg_consult_image));
        this.dialog.setCancelable(false);
        this.dialog.show();
        for(MarvelCharacter marvelCharacter : characterList)
            new CharacterImageTask(this, getActivity()).execute(marvelCharacter.getThumbnail().getPath(),marvelCharacter.getThumbnail().getExtension());
    }

    @Override
    public void onTaskResult(BasicInterfaceResponse basicResponse) {
        if(basicResponse != null) {
            if (basicResponse.getStatusCode() == HttpURLConnection.HTTP_OK) {
                if(basicResponse.getObject() != null){
                    this.marvelBasicResponse = (MarvelBasicResponse) basicResponse.getObject();
                    this.characterList.addAll(this.marvelBasicResponse.getData().getResults());
                    executeTaskImage(this.marvelBasicResponse.getData().getResults());
                }
            } else {
                Alert.showSimpleDialog(basicResponse.getMessage(), getActivity(), Alert.AlertType.INFO);
            }
        } else {
            Alert.showSimpleDialog(getResources().getString(R.string.msg_consult_error), getActivity(), Alert.AlertType.ERROR);
        }
    }

    @Override
    public void onImageTaskResult(Bitmap bitmap) {
        if(bitmap != null) {
            this.bitmapList.add(bitmap);
            if(this.bitmapList.size() == requisitionSize) {
                setAdapter();
                this.dialog.dismiss();
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        Intent intent = new Intent(getActivity(), DetailActivity.class);
        intent.putExtra("url", characterList.get(position).getUrls().get(0).getUrl());
        startActivity(intent);
    }

    @Override
    public void onScrollStateChanged(AbsListView absListView, int i) {

    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if(adapter != null)
            if(visibleItemCount > 0 && firstVisibleItem + visibleItemCount == totalItemCount && !adapter.endReached()){
                tvCarregar.setVisibility(View.VISIBLE);
            }
    }

    @Override
    public void onClick(View view) {
        tvCarregar.setVisibility(View.INVISIBLE);
        this.bitmapList = new ArrayList<>();
        this.offset += 10;
        executeTask();
    }
}
