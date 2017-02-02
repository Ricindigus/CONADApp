package com.example.ricardo.conadapp.fragments.RiesgoFragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.ricardo.conadapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeporteFragment extends Fragment {


    public DeporteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView =  inflater.inflate(R.layout.fragment_deporte, container, false);
        ImageView imageView = (ImageView)rootView.findViewById(R.id.imagen_deporte_1);
        Picasso.with(getContext()).load("http://blog.nutritienda.com/wp-content/uploads/2016/05/Deportista-cansado.jpg").into(imageView);
        imageView = (ImageView)rootView.findViewById(R.id.imagen_deporte_2);
        Picasso.with(getContext()).load("http://www.mundoeurolatino.com/wp-content/uploads/2016/01/1282065.jpg").into(imageView);
        imageView = (ImageView)rootView.findViewById(R.id.imagen_deporte_3);
        Picasso.with(getContext()).load("http://www.bellomagazine.com/files/bellomagazine/paises-que-tienen-mas-medallas-olimpicas.jpg").into(imageView);
        imageView = (ImageView)rootView.findViewById(R.id.imagen_deporte_4);
        Picasso.with(getContext()).load("http://greenpowerperu.com/image/grassnatural/gn16g.jpg").into(imageView);
        imageView = (ImageView)rootView.findViewById(R.id.imagen_deporte_5);
        Picasso.with(getContext()).load("http://vidasaludable.com/wp-content/uploads/2013/09/3-Ejercicio2.jpg").into(imageView);
        return rootView;
    }

}
