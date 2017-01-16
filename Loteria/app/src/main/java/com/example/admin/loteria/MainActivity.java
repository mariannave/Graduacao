package com.example.admin.loteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private TextView valores;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botao = (Button)this.findViewById(R.id.btnGerar);
        this.valores = (TextView) this.findViewById(R.id.valores);


        this.botao.setOnClickListener(new OnClickBotao());
    }


    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            Set<Integer> lista = new TreeSet<Integer>();
            Random r = new Random();


            while(lista.size() < 6){
                lista.add(r.nextInt(60) + 1);
            }

            MainActivity.this.valores.setText(lista.toString());

        }
    }

}
