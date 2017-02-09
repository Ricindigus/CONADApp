package com.example.ricardo.conadapp;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.github.barteksc.pdfviewer.PDFView;

public class AutActivity extends AppCompatActivity {

    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aut);
        showToolbar("AUT",true);
        if (android.os.Build.VERSION.SDK_INT >= 21) {
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(ContextCompat.getColor(getApplicationContext(), R.color.aut_primary_dark));
        }
        pdfView = (PDFView)findViewById(R.id.pdfviewaut);
        pdfView.fromAsset("FormularioAUT2016.pdf").pages(0, 1, 2, 3, 4, 5).enableSwipe(true).load();
    }

    public void showToolbar(String title, boolean upButton){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarApp);
        toolbar.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.aut_primary));
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(title);
        getSupportActionBar().setDisplayHomeAsUpEnabled(upButton);
    }

    public void goPasosASeguir(View view){
        Intent intent = new Intent(this,PasosASeguirActivity.class);
        startActivity(intent);
    }
}
