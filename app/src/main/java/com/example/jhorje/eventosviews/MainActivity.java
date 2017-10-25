package com.example.jhorje.eventosviews;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    //Variables vista
    private RelativeLayout rl;
    private Button btnFondo;

    //Extra variables
    private boolean fondoTint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos variables de la vista
        rl = (RelativeLayout) findViewById(R.id.relativaLay);
        btnFondo = (Button) findViewById(R.id.btnFondo);
    }

    public void onClick(View v){

        //Filtramos de que botón viene
        switch (v.getId()){
            case R.id.btnFondo:
                //Cambiar fondo de color
                if (!fondoTint){
                    rl.setBackground(getDrawable(R.color.Rojo));
                    btnFondo.setText("Fondo blanco");
                    fondoTint = true;
                } else {
                    rl.setBackground(getDrawable(R.color.Transparente));
                    btnFondo.setText("Fondo rojo");
                    fondoTint = false;
                }
                break;
        }
    }
}
