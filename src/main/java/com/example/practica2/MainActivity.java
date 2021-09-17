package com.example.practica2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button limpiar;
    Button calcular;
    EditText numero1;
    EditText numero2;
    TextView resultado;

    String snumero1;
    String snumero2;
    String sresultado = "";

    AlertDialog.Builder dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        limpiar = (Button) findViewById(R.id.btnLimpiar);
        calcular = (Button) findViewById(R.id.btnCalcular);
        numero1 = (EditText) findViewById(R.id.edtxtNumero1);
        numero2 = (EditText) findViewById(R.id.edtxtNumero2);
        resultado = (TextView) findViewById(R.id.txtResultado);

        limpiar.setEnabled(false);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                snumero1 = numero1.getText().toString();
                snumero2 = numero2.getText().toString();
                sresultado = "";
                if(snumero1.length() == 0 ){
                    dialog = new AlertDialog.Builder(MainActivity.this);
                    dialog.setTitle("Error");
                    dialog.setMessage("Ingresar el primer número");
                    dialog.setCancelable(false);
                    dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialogo, int id) {
                            dialogo.cancel();
                            numero1.requestFocus();
                        }
                    });
                    dialog.show();
                }else{
                    if(snumero2.length() == 0){
                        dialog = new AlertDialog.Builder(MainActivity.this);
                        dialog.setTitle("Error");
                        dialog.setMessage("Ingresar el segundo número");
                        dialog.setCancelable(false);
                        dialog.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo, int id) {
                                dialogo.cancel();
                                numero1.requestFocus();
                            }
                        });
                        dialog.show();
                    }else {
                        double suma = Double.parseDouble(snumero1) + Double.parseDouble(snumero2);
                        if (suma % 1 == 0) { //Si es entero pero termina en .0
                            sresultado += snumero1 + " + " + snumero2 + " = " + (int) suma + "\n";
                        } else{
                            sresultado += snumero1 + " + " + snumero2 + " = " + suma + "\n";
                        }
                        double resta = Double.parseDouble(snumero1) - Double.parseDouble(snumero2);
                        if (resta % 1 == 0) { //Si es entero pero termina en .0
                            sresultado += snumero1 + " - " + snumero2 + " = " + (int) resta + "\n";
                        } else{
                            sresultado += snumero1 + " - " + snumero2 + " = " + resta + "\n";
                        }
                        double multiplicacion = Double.parseDouble(snumero1) * Double.parseDouble(snumero2);
                        if (multiplicacion % 1 == 0) { //Si es entero pero termina en .0
                            sresultado += snumero1 + " * " + snumero2 + " = " + (int) multiplicacion + "\n";
                        } else{
                            sresultado += snumero1 + " * " + snumero2 + " = " + multiplicacion + "\n";
                        }
                        if(Integer.parseInt(snumero2) == 0){
                            sresultado += snumero1 + " / " + snumero2 + " = (División entre cero) \n";
                        }else{
                            double division = Double.parseDouble(snumero1) / Double.parseDouble(snumero2);
                            if (division % 1 == 0) { //Si es entero pero termina en .0
                                sresultado += snumero1 + " / " + snumero2 + " = " + (int) division + "\n";
                            } else{
                                sresultado += snumero1 + " / " + snumero2 + " = " + division + "\n";
                            }
                        }
                        resultado.setText(sresultado);
                        limpiar.setEnabled(true);
                        calcular.setEnabled(false);
                    }
                }
            }
        });

        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limpiar_controles();
            }
        });
    }

    public void limpiar_controles(){
        numero1.setText("");
        numero2.setText("");
        resultado.setText("");
        limpiar.setEnabled(false);
        calcular.setEnabled(true);
        numero1.requestFocus();
    }
}




