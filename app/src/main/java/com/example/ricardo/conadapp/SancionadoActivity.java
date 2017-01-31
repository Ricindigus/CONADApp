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

import com.example.ricardo.conadapp.fragments.SancionadoFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class SancionadoActivity extends AppCompatActivity {
    int controlador = 0;
    private float x1,x2;
    static final int MIN_DISTANCE = 150;
    int[] fragments = {R.id.tab_1, R.id.tab_2, R.id.tab_3, R.id.tab_4, R.id.tab_5,
            R.id.tab_6, R.id.tab_7, R.id.tab_8, R.id.tab_9, R.id.tab_10};
    int fragmentActual = 0;
    int fragmentAnterior = 0;
    Fragment fragment;
    BottomBar bottomBar;
    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sancionado);
        showToolbar("¿Cuándo soy sancionado?",true);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.sancionado_primary_dark));
        }
        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setDefaultTab(fragments[fragmentActual]);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                if(controlador == 1){
                    switch(tabId){
                        case R.id.tab_1:
                            fragment = new SancionadoFragment(0);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 0;
                            break;
                        case R.id.tab_2:
                            fragment = new SancionadoFragment(1);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 1;
                            break;
                        case R.id.tab_3:
                            fragment = new SancionadoFragment(2);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 2;
                            break;
                        case R.id.tab_4:
                            fragment = new SancionadoFragment(3);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 3;
                            break;
                        case R.id.tab_5:
                            fragment = new SancionadoFragment(4);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 4;
                            break;
                        case R.id.tab_6:
                            fragment = new SancionadoFragment(5);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 5;
                            break;
                        case R.id.tab_7:
                            fragment = new SancionadoFragment(6);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 6;
                            break;
                        case R.id.tab_8:
                            fragment = new SancionadoFragment(7);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 7;
                            break;
                        case R.id.tab_9:
                            fragment = new SancionadoFragment(8);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 8;
                            break;
                        case R.id.tab_10:
                            fragment = new SancionadoFragment(9);
                            fragmentAnterior = fragmentActual;
                            fragmentActual = 9;
                            break;
                        default:break;
                    }
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
                    // Left to Right swipe action
                    if (x2 > x1)
                    {
                        if(fragmentActual > 0){
                            bottomBar.selectTabAtPosition(fragmentActual-1);
                        }
                    }
                    // Right to left swipe action
                    else
                    {
                        if(fragmentActual < 9) {
                            bottomBar.selectTabAtPosition(fragmentActual+1);
                        }
                    }
                }
                else
                {
                    // consider as something else - a screen tap for example
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
