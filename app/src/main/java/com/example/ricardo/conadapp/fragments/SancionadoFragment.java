package com.example.ricardo.conadapp.fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardo.conadapp.R;
import com.squareup.picasso.Picasso;

/**
 * A simple {@link Fragment} subclass.
 */
public class SancionadoFragment extends Fragment {

    private int[] textos = {R.string.texto_sancionado_1, R.string.texto_sancionado_2, R.string.texto_sancionado_3
            , R.string.texto_sancionado_4, R.string.texto_sancionado_5, R.string.texto_sancionado_6
            , R.string.texto_sancionado_7, R.string.texto_sancionado_8, R.string.texto_sancionado_9
            , R.string.texto_sancionado_10};
//    private int[] imagenes = {R.drawable.muestra_orina, R.drawable.control_doping, R.drawable.alteracion_doping
//            , R.drawable.sustancia_prohibida, R.drawable.administracion_doping, R.drawable.falta_doping
//            , R.drawable.uso_sustancia_prohibida, R.drawable.trafico_sustancia_prohibida, R.drawable.conspiracion_dopaje
//            , R.drawable.asociacion_prohibida};
    private String[] imagenes = {"http://imageshack.com/a/img922/6029/8E9DB5.png", "http://imageshack.com/a/img924/2384/JkOA84.png",
        "http://imageshack.com/a/img924/9769/LrNvxo.png", "http://imageshack.com/a/img922/8489/YtLPUo.png",
        "http://imageshack.com/a/img924/8349/MnUszO.png", "http://imageshack.com/a/img922/7082/IjHHCW.png",
        "http://imageshack.com/a/img923/420/VHHvxb.png", "http://imageshack.com/a/img923/8919/No2Mei.png",
        "http://imageshack.com/a/img922/4766/HO0CJv.png", "http://imageshack.com/a/img924/8881/ditVlo.png"};
    private int numFragment;

    @SuppressLint("ValidFragment")
    public SancionadoFragment(int numberFragment) {
        super();
        this.numFragment = numberFragment;
        // Required empty public constructor
    }

    public SancionadoFragment() {
        // Required empty public constructor
    }

    @SuppressLint("NewApi")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_sancionado, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.texto_fragment_sancionado);
        textView.setText(getString(textos[numFragment]));
        ImageView imageView = (ImageView)rootView.findViewById(R.id.imagen_fragment_sancionado);
//        imageView.setBackground(ContextCompat.getDrawable(getContext(), imagenes[numFragment]));
        if(numFragment > 0)
            Picasso.with(getContext()).load(imagenes[numFragment]).into(imageView);
        else
            Picasso.with(getContext()).load(R.drawable.muestra_orina).into(imageView);
        return rootView;
    }

}
