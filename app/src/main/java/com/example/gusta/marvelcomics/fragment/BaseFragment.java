package com.example.gusta.marvelcomics.fragment;

import android.app.Fragment;
import android.support.annotation.NonNull;
import android.view.View;

/**
 * Created by gusta on 06/05/2017.
 */

public abstract class BaseFragment extends Fragment {
    protected abstract void inflateComponents(@NonNull View view);
    protected abstract void setListeners();
}