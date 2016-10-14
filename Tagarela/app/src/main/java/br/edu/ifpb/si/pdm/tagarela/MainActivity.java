package br.edu.ifpb.si.pdm.tagarela;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnYes;
    private Button btnNo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btnYes = (Button)findViewById(R.id.btnYes);
        this.btnNo = (Button) findViewById(R.id.btnNo);

        this.btnYes.setOnClickListener(new OnClickBotao());
    }




    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }



}
