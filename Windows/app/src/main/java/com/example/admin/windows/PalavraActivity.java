package com.example.admin.windows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PalavraActivity extends AppCompatActivity {

    EditText et;
    Button btnPalavraSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_palavra);

        this.btnPalavraSalvar = (Button)this.findViewById(R.id.btnPalavraSalvar);
        this.btnPalavraSalvar.setOnClickListener(new OnClickBotao());

        this.et = (EditText) this.findViewById(R.id.etPalavra);
    }


    private class OnClickBotao implements View.OnClickListener {


        @Override
        public void onClick(View v) {
            String texto = PalavraActivity.this.et.getText().toString();
            Log.i("Word", texto);
            Intent it = new Intent();
            it.putExtra("palavra", texto);
            setResult(RESULT_OK, it);
            finish();
        }
    }
}
