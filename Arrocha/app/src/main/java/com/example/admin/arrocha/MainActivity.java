package com.example.admin.arrocha;

import android.content.Intent;
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
    private TextView msg;

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
        this.msg = (TextView) findViewById(R.id.MSG);

        this.botaoApostar.setOnClickListener(new OnClickBotao());
    }


    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            int valorArrocha = MainActivity.this.valorArrocha;

            int valorAposta = Integer.parseInt(MainActivity.this.aposta.getText().toString());
            int valorFinal = 100;
            int valorInicial = 0;


//            Toast.makeText(MainActivity.this, Integer.toString(valorArrocha), Toast.LENGTH_SHORT).show();

             if(valorAposta != valorArrocha && valorAposta < valorFinal && valorAposta > valorInicial){
                MainActivity.this.msg.setText("Você ainda não acertou!" );


                if(valorAposta < valorArrocha) {
                    valorInicial = valorAposta;
                    MainActivity.this.valorInicial.setText(Integer.toString(valorInicial));
                }
                if(valorAposta > valorArrocha) {
                    valorFinal = valorAposta;
                    MainActivity.this.valorFinal.setText(Integer.toString(valorFinal));
                }

                Log.i("Valor Arrocha", Integer.toString(valorArrocha));
                Log.i("Valor da aposta", Integer.toString(valorAposta));
            }


           if(valorAposta < valorInicial || valorAposta > valorFinal){
                MainActivity.this.msg.setText("Você não pode apostar um valor maior ou menor que o intervalo!" );
               MainActivity.this.aposta.setVisibility(View.GONE);
           }else if(valorAposta == valorArrocha){
                MainActivity.this.msg.setText("Acertou! O número é = " + valorArrocha);
               MainActivity.this.aposta.setVisibility(View.GONE);
           }else if(valorFinal - valorInicial == 2 ) {
                MainActivity.this.msg.setText("Você arrochou o número! O número é = " + valorArrocha);
               MainActivity.this.aposta.setVisibility(View.GONE);
            }

//            if(valorAposta == valorInicial){
//                MainActivity.this.msg.setText("Você não pode apostar o mesmo valor inicial do intervalo!" );
//
//            } else if(valorAposta == valorFinal){
//                MainActivity.this.msg.setText("Você não pode apostar o mesmo valor final do intervalo!" );
//
//            }

        }


    }
}
