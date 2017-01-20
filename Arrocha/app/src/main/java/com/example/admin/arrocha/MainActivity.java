package com.example.admin.arrocha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView valorInicial;
    private TextView valorFinal;
    private Button botaoApostar;
    private EditText aposta;
    private int valorArrocha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Random r = new Random();
        valorArrocha = r.nextInt(100);

        this.valorInicial = (TextView) findViewById(R.id.valorInicial);
        this.valorFinal = (TextView) findViewById(R.id.valorFinal);
        this.botaoApostar = (Button) findViewById(R.id.btnApostar);
        this.aposta = (EditText) findViewById(R.id.aposta);

        this.botaoApostar.setOnClickListener(new OnClickBotao());
    }


    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int valorArrocha = MainActivity.this.valorArrocha;

            int valorAposta = Integer.parseInt(MainActivity.this.aposta.getText().toString());
            int valorFinal = 0;
            int valorInicial = 0;


            Toast.makeText(MainActivity.this, Integer.toString(valorArrocha), Toast.LENGTH_SHORT).show();

            if(valorAposta != valorArrocha || valorAposta < valorFinal && valorAposta > valorInicial){

                if(valorAposta < valorArrocha) {
                    valorInicial = valorAposta;
                    MainActivity.this.valorInicial.setText(Integer.toString(valorInicial));
                }
                if(valorAposta > valorArrocha) {
                    valorFinal = valorAposta;
                    MainActivity.this.valorFinal.setText(Integer.toString(valorFinal));
                }
                if( valorFinal - valorInicial == 2 ) {

               }

                Log.i("Valor", "FUNFOU");
            }


        }
    }
}
