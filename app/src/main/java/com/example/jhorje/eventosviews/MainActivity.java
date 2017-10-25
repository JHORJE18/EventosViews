package com.example.jhorje.eventosviews;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Variables vista
    private RelativeLayout rl;
    private Button btnFondo, btnLetra;
    private CheckBox cbMostrar;
    private TextView txtOculto, txtLargaPuls, txtPuntos;
    private RatingBar stars;

    //Extra variables
    private boolean fondoTint = false;
    private boolean letraTint = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Asignamos variables de la vista
        rl = (RelativeLayout) findViewById(R.id.relativaLay);
        btnFondo = (Button) findViewById(R.id.btnFondo);
        btnLetra = (Button) findViewById(R.id.btnLine);
        cbMostrar = (CheckBox) findViewById(R.id.cbMostrar);
        txtOculto = (TextView) findViewById(R.id.txtOculto);
        txtLargaPuls = (TextView) findViewById(R.id.txtLargo);
        txtPuntos = (TextView) findViewById(R.id.txtPuntos);
        stars = (RatingBar) findViewById(R.id.ratingBar);

        //Asignamos valor larga pulsación
        txtLargaPuls.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "¡Muchas Gracias!";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                return false;
            }
        });

        //Asignamos funcion al cambiar valor de las estrellas
        stars.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                txtPuntos.setText("[" + Math.round(stars.getRating()) + "/5]");
            }
        });

    }

    public void onClick(View v){

        //Filtramos de que botón viene
        switch (v.getId()){

            //Boton Fondo
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

            //Boton Linea Texto
            case R.id.btnLine:
                //Cambiar letras
                if (!letraTint){
                    btnLetra.setTextColor(getColor(R.color.Rojo));
                    btnLetra.setText("Letras negras");
                    letraTint = true;
                } else {
                    btnLetra.setTextColor(getColor(R.color.Negro));
                    btnLetra.setText("Letras rojas");
                    letraTint = false;
                }
                break;

            //Checkbox texto oculto
            case R.id.cbMostrar:
                if (cbMostrar.isChecked()){
                    txtOculto.setVisibility(View.VISIBLE);
                } else {
                    txtOculto.setVisibility(View.INVISIBLE);
                }
                break;
        }
    }
}
