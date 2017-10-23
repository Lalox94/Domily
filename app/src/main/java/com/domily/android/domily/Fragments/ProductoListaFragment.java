package com.domily.android.domily.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.domily.android.domily.R;

public class ProductoListaFragment extends Fragment {


    public ProductoListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_producto_lista, container, false);


        // Inflate the layout for this fragment
        return view;
    }

}
