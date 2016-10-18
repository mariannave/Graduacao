package com.example.admin.windows;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnMainSobre, btnMainPalavra;

    private static final int PALAVRA = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnMainSobre = (Button)this.findViewById(R.id.btnMainSobre);
        this.btnMainSobre.setOnClickListener(new OnClickBotao());

        this.btnMainPalavra = (Button) this.findViewById(R.id.btnMainPalavra);
        this.btnMainPalavra.setOnClickListener(new OnClickBotao());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK) {
            if(requestCode == PALAVRA) {
                Log.i("WINDOWS", "Resposta" + data.getStringExtra("palavra"));
            }
        }
    }

    private class OnClickBotao implements View.OnClickListener {


        @Override
        public void onClick(View v) {

            if(v.equals(MainActivity.this.btnMainSobre)){
                Log.i("sobre", "Clicou no botao sobre.");
                Intent it = new Intent(MainActivity.this, SobreActivity.class);
                startActivity(it);
            } else if (v.equals(MainActivity.this.btnMainPalavra)){
                Log.i("palavra", "Clicou no botao palavra");
                Intent it = new Intent(MainActivity.this, PalavraActivity.class);
                startActivityForResult(it, PALAVRA);
            }

        }
    }
}
