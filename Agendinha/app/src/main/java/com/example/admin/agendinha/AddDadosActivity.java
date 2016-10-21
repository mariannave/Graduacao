package com.example.admin.agendinha;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddDadosActivity extends AppCompatActivity {

    Button btnSalvar;
    Button btnCancelar;
    EditText etNome, etEmail, etTelefone;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dados2);

        this.btnSalvar = (Button) findViewById(R.id.btnSalvar);
        this.btnSalvar.setOnClickListener(new OnClickBotao());


        this.btnCancelar = (Button) findViewById(R.id.btnCancelar);
        this.btnCancelar.setOnClickListener(new OnClickBotao());

        this.etNome = (EditText) findViewById(R.id.addDadosNome);
        this.etEmail = (EditText) findViewById(R.id.addDadosEmail);
        this.etTelefone = (EditText) findViewById(R.id.addDadosTelefone);


    }


    private class OnClickBotao implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            if(v.equals(btnSalvar)){
                String nome = AddDadosActivity.this.etNome.getText().toString();
                String telefone = AddDadosActivity.this.etTelefone.getText().toString();
                String email = AddDadosActivity.this.etEmail.getText().toString();

                Pessoa pessoa = new Pessoa(nome, telefone, email);


                Log.i("salvar", "Clicou em salvar");
            }else if(v.equals(btnCancelar)){
                Log.i("cancelar", "Clicou em cancelar");
                finish();
            }
        }
    }


}
