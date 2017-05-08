package com.example.gusta.marvelcomics.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gusta.marvelcomics.R;
import com.example.gusta.marvelcomics.model.MarvelCharacter;
import com.example.gusta.marvelcomics.util.DateUtil;

import java.text.ParseException;
import java.util.List;

/**
 * Created by gusta on 06/05/2017.
 */

public class CharactersAdapter extends BaseAdapter {

    private LayoutInflater layoutInflater;
    private List<MarvelCharacter> characterList;
    private List<Bitmap> bitmapList;
    private int maxSize;
    private int nextRequisition;

    public CharactersAdapter(Context context, List<MarvelCharacter> characterList, List<Bitmap> bitmapList, int maxSize, int nextRequisition) {
        this.layoutInflater = LayoutInflater.from(context);
        this.characterList = characterList;
        this.bitmapList = bitmapList;
        this.maxSize = maxSize;
        this.nextRequisition = nextRequisition;
    }

    public boolean showMore(List<MarvelCharacter> characterList, List<Bitmap> bitmapList, int nextRequisition){
        updateContent(characterList, bitmapList, nextRequisition);
        notifyDataSetChanged();
        return endReached();
    }

    private void updateContent(List<MarvelCharacter> characterList, List<Bitmap> bitmapList, int nextRequisition){
        this.characterList.addAll(characterList);
        this.bitmapList.addAll(bitmapList);
        this.nextRequisition = nextRequisition;
    }

    public boolean endReached(){
        return characterList.size() == maxSize;
    }

    @Override
    public int getCount() {
        return characterList.size();
    }

    @Override
    public Object getItem(int position) {
        return characterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null) {
            view = layoutInflater.inflate(R.layout.character_item, null);
            viewHolder = new ViewHolder();

            viewHolder.ivImage = (ImageView) view.findViewById(R.id.iv_image);
            viewHolder.tvName = (TextView) view.findViewById(R.id.tv_name);
            viewHolder.tvModified = (TextView) view.findViewById(R.id.tv_modified);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.ivImage.setImageBitmap(bitmapList.get(position));
        viewHolder.tvName.setText(characterList.get(position).getName());

        try {
            viewHolder.tvModified.setText(DateUtil.format(DateUtil.parse(characterList.get(position).getModified().replaceAll("T","").substring(0,23))));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return view;
    }

    static class ViewHolder {
        ImageView ivImage;
        TextView tvName;
        TextView tvModified;
    }
}
