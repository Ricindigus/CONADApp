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
public class SaludFragment extends Fragment {

    private final int numH = 6;
    private final int numM = 5;
    private final int numA = 11;
    private int cardsHombre[] ={R.id.salud_hombre_imagen_1, R.id.salud_hombre_imagen_2, R.id.salud_hombre_imagen_3,
            R.id.salud_hombre_imagen_4, R.id.salud_hombre_imagen_5, R.id.salud_hombre_imagen_6};
    private int cardsMujer[] ={R.id.salud_mujer_imagen_1, R.id.salud_mujer_imagen_2,
            R.id.salud_mujer_imagen_3, R.id.salud_mujer_imagen_4, R.id.salud_mujer_imagen_5};
    private int cardsAmbos[] ={R.id.salud_ambos_imagen_1, R.id.salud_ambos_imagen_2, R.id.salud_ambos_imagen_3,
            R.id.salud_ambos_imagen_4, R.id.salud_ambos_imagen_5, R.id.salud_ambos_imagen_6,
            R.id.salud_ambos_imagen_7, R.id.salud_ambos_imagen_8, R.id.salud_ambos_imagen_9,
            R.id.salud_ambos_imagen_10, R.id.salud_ambos_imagen_11};

    private String imagenesHombre[] = {"http://imageshack.com/a/img923/4089/lyLsHI.png", "http://imageshack.com/a/img924/1755/O0XyeW.png",
            "http://imageshack.com/a/img922/4066/OrRMEc.png", "http://imageshack.com/a/img924/6627/kBfKqL.png","http://imageshack.com/a/img923/1268/ufm2Kq.png",
            "http://imageshack.com/a/img923/4973/S5SQzh.png}"};
    private String imagenesMujer[] = {"http://imageshack.com/a/img924/4417/kHKvVm.png", "http://imageshack.com/a/img922/9962/2JzvJv.png",
            "http://imageshack.com/a/img923/2932/RhvhsB.png", "http://imageshack.com/a/img924/2773/yqlGSC.png", "http://imageshack.com/a/img924/2389/dRj58T.png"};
    private String imagenesAmbos[] = {"http://imageshack.com/a/img922/9350/Ag6owx.png", "http://imageshack.com/a/img924/7328/dVAq4r.png",
            "http://imageshack.com/a/img924/9683/EpGojk.png","http://imageshack.com/a/img924/8829/RuJxQI.png","http://imageshack.com/a/img922/4122/c8xPD1.png",
            "http://imageshack.com/a/img923/8805/NxHK38.png", "http://imageshack.com/a/img922/2069/VmFeHz.png", "http://imageshack.com/a/img923/1589/usZeH8.png",
            "http://imageshack.com/a/img924/6576/niqYWM.png", "http://imageshack.com/a/img922/1039/86FQie.png", "http://imageshack.com/a/img924/4117/IyqlZW.png"};


    public SaludFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_salud, container, false);
        ImageView imgView;
        for (int i = 0; i <numH ; i++) {
            imgView = (ImageView)rootView.findViewById(cardsHombre[i]);
            Picasso.with(getContext()).load("http://blog.nutritienda.com/wp-content/uploads/2016/05/Deportista-cansado.jpg").into(imgView);
        }
        for (int i = 0; i <numM ; i++) {
            imgView = (ImageView)rootView.findViewById(cardsMujer[i]);
            Picasso.with(getContext()).load("http://blog.nutritienda.com/wp-content/uploads/2016/05/Deportista-cansado.jpg").into(imgView);
        }
        for (int i = 0; i <numA ; i++) {
            imgView = (ImageView)rootView.findViewById(cardsAmbos[i]);
            Picasso.with(getContext()).load("http://blog.nutritienda.com/wp-content/uploads/2016/05/Deportista-cansado.jpg").into(imgView);
        }
        return rootView;
    }

}
