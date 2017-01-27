package com.example.admin.birthday;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText texto;
    private DatePicker aniversario;
    private Button btnAdd;
    private PessoaDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.texto = (EditText) findViewById(R.id.texto);
        this.aniversario = (DatePicker) findViewById(R.id.data);
        this.btnAdd = (Button) findViewById(R.id.btnEnviar);

        this.aniversario.setCalendarViewShown(false);

        this.btnAdd.setOnClickListener(new OnClickBotao());

        this.dao = new PessoaDAO(this);

    }

    private class OnClickBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            String nome = MainActivity.this.texto.getText().toString();
            int dia = MainActivity.this.aniversario.getDayOfMonth();
            int mes = MainActivity.this.aniversario.getMonth();
            int ano = MainActivity.this.aniversario.getYear();

            Pessoa pessoa = new Pessoa(nome,dia,mes,ano);

            MainActivity.this.dao.insert(pessoa);

            Log.i("Pessoa", MainActivity.this.dao.get().toString());
        }
    }


}
