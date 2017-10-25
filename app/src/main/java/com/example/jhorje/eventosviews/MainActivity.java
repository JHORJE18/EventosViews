package com.example.jhorje.eventosviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //Variables vista
    private RelativeLayout rl;

    //Extra variables
    private boolean fondoTint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos variables de la vista
        rl = (RelativeLayout) findViewById(R.id.relativaLay);
    }

    public void onClick(View v){

        //Filtramos de que botón viene
        switch (v.getId()){
            case R.id.btnFondo:
                //Cambiar fondo de color
                if (fondoTint){
                    rl.setBackground(getDrawable(R.color.Rojo));
                    fondoTint = false;
                } else {
                    rl.setBackground(getDrawable(R.color.Transparente));
                    fondoTint = true;
                }
                break;
        }
    }
}
