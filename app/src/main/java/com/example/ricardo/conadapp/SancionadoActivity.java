package com.example.ricardo.conadapp;

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.ricardo.conadapp.fragments.SancionadoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SancionadoActivity extends AppCompatActivity {
    int controlador = 0;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    int fragmentActual = 0;
    int fragmentAnterior = 0;
    Fragment fragment;
    BottomBar bottomBar;
    Toolbar toolbar;
    ArrayList<Integer> tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sancionado);
        tabs = new ArrayList<Integer>();
        tabs.add(R.id.tab_1);tabs.add(R.id.tab_2);tabs.add(R.id.tab_3);tabs.add(R.id.tab_4);
        tabs.add(R.id.tab_5);tabs.add(R.id.tab_6);tabs.add(R.id.tab_7);tabs.add(R.id.tab_8);
        tabs.add(R.id.tab_9);tabs.add(R.id.tab_10);

        showToolbar("¿Cuándo soy sancionado?",true);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.sancionado_primary_dark));
        }
        ImageView imgP = (ImageView)findViewById(R.id.imagen_fragment_sancionado);
        Picasso.with(getApplicationContext()).load("http://imageshack.com/a/img922/6029/8E9DB5.png").into(imgP);
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(controlador == 1){
                    int indice = tabs.indexOf(tabId);
                    fragment = new SancionadoFragment(indice);
                    fragmentAnterior = fragmentActual;
                    fragmentActual = indice;
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    if(fragmentActual > fragmentAnterior)
                        fragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                    else
                        fragmentTransaction.setCustomAnimations(R.anim.enter_from_left, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_left);
                    fragmentTransaction.replace(R.id.contentContainer, fragment);
                    fragmentTransaction.addToBackStack(null).commit();
                }
                else{controlador = 1;}
            }
        });
        bottomBar.setDefaultTab(R.id.tab_1);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                x1 = event.getX();
                break;
            case MotionEvent.ACTION_UP:
                x2 = event.getX();
                float deltaX = x2 - x1;
                if (Math.abs(deltaX) > MIN_DISTANCE)
                {
                    if (x2 > x1)// Left to Right swipe action
                    {
                        if(fragmentActual > 0)  bottomBar.selectTabAtPosition(fragmentActual-1);
                    }
                    else  // Right to left swipe action
                    {
                        if(fragmentActual < 9) bottomBar.selectTabAtPosition(fragmentActual+1);
                    }
                }
                break;
        }
        return super.onTouchEvent(event);
    }
    public void showToolbar(String title, boolean upButton){
        toolbar = (Toolbar) findViewById(R.id.toolbarApp);
        toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.sancionado_primary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    @SuppressLint("NewApi")
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        if (keyCode == event.KEYCODE_BACK) {
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
