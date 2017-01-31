package com.example.ricardo.conadapp;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

public class PrincipalActivity extends AppCompatActivity {



    final int numOpciones = 6;
    int opciones[] = {R.id.opcion_busqueda,R.id.opcion_lista,R.id.opcion_video,
            R.id.opcion_sancionado,R.id.opcion_riesgos,R.id.opcion_aut};
    int colores1[] = {R.color.busqueda_primary_dark, R.color.prohibida_primary_dark,R.color.video_primary_dark,
                    R.color.sancionado_primary_dark, R.color.riesgo_primary_dark, R.color.aut_primary_dark};
    int colores2[] = {R.color.busqueda_primary, R.color.prohibida_primary,R.color.video_primary,
            R.color.sancionado_primary, R.color.riesgo_primary, R.color.aut_primary};
    int iconos[] ={R.drawable.busqueda_icon,R.drawable.prohibida_icon,R.drawable.video_icon,
                    R.drawable.sancionado_icon,R.drawable.riesgo_icon, R.drawable.aut_icon};
    int textos[] = {R.string.texto_opcion_busqueda, R.string.texto_opcion_lista,
                        R.string.texto_opcion_video, R.string.texto_opcion_sancionado,
                        R.string.texto_opcion_riesgo, R.string.texto_opcion_aut};
    Class contextos[] = {BusquedaActivity.class, ProhibidaActivity.class, VideoActivity.class,
                        SancionadoActivity.class, RiesgosActivity.class, AutActivity.class};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        showToolbar("ANTIDOPING APP",false);
        for (int i = 0; i <numOpciones; i++) {
            final CardView cardView = (CardView)findViewById(opciones[i]);
            cardView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), colores1[i]));
            ImageView imageView = (ImageView)cardView.findViewById(R.id.card_icono);
            Picasso.with(getApplication()).load(iconos[i]).into(imageView);
            TextView textView = (TextView)cardView.findViewById(R.id.card_texto);
            textView.setText(getString(textos[i]));
            View view = (View) cardView;
            final int indice = i;
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
//                    cardView.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.aut_primary_dark));
                    int colorFrom = ContextCompat.getColor(getApplicationContext(), colores2[indice]);
                    int colorTo = ContextCompat.getColor(getApplicationContext(), colores1[indice]);
                    ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
                    colorAnimation.setDuration(800); // milliseconds
                    colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                        @Override
                        public void onAnimationUpdate(ValueAnimator animator) {
                            cardView.setBackgroundColor((int) animator.getAnimatedValue());
                        }
                    });
                    colorAnimation.start();
                    Intent intent = new Intent(getApplicationContext(),contextos[indice]);
                    startActivity(intent);
                }
            });
        }
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarApp);
        toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }
}
