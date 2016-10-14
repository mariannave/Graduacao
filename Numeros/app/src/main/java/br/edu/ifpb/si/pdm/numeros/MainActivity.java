package br.edu.ifpb.si.pdm.numeros;

import android.net.Uri;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private TextToSpeech t1;

    private Button btn1;
    private Button btn2;
    private Button btn3;
    private Button btn4;
    private Button btn5;
    private Button btn6;
    private Button btn7;
    private Button btn8;
    private Button btn9;
    private Button btn0;



    private GoogleApiClient client;

    public MainActivity() {
        Log.i("numero", "Construtor!");
    }

    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Main Page")
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    t1.setLanguage(Locale.getDefault());
                }
            }
        });

        this.btn1 = (Button) findViewById(R.id.btn1);
        this.btn1.setOnClickListener(new OnClickBotao());
        this.btn1.setOnLongClickListener(new OnLongClickBotao());

        this.btn2 = (Button) findViewById(R.id.btn2);
        this.btn2.setOnClickListener(new OnClickBotao());
        this.btn2.setOnLongClickListener(new OnLongClickBotao());

        this.btn3 = (Button) findViewById(R.id.btn3);
        this.btn3.setOnClickListener(new OnClickBotao());
        this.btn3.setOnLongClickListener(new OnLongClickBotao());


        this.btn4 = (Button) findViewById(R.id.btn4);
        this.btn4.setOnClickListener(new OnClickBotao());
        this.btn4.setOnLongClickListener(new OnLongClickBotao());

        this.btn5 = (Button) findViewById(R.id.btn5);
        this.btn5.setOnClickListener(new OnClickBotao());
        this.btn5.setOnLongClickListener(new OnLongClickBotao());

        this.btn6 = (Button) findViewById(R.id.btn6);
        this.btn6.setOnClickListener(new OnClickBotao());
        this.btn6.setOnLongClickListener(new OnLongClickBotao());

        this.btn7 = (Button) findViewById(R.id.btn7);
        this.btn7.setOnClickListener(new OnClickBotao());
        this.btn7.setOnLongClickListener(new OnLongClickBotao());

        this.btn8 = (Button) findViewById(R.id.btn8);
        this.btn8.setOnClickListener(new OnClickBotao());
        this.btn8.setOnLongClickListener(new OnLongClickBotao());

        this.btn9 = (Button) findViewById(R.id.btn9);
        this.btn9.setOnClickListener(new OnClickBotao());
        this.btn9.setOnLongClickListener(new OnLongClickBotao());

        this.btn0 = (Button) findViewById(R.id.btn0);
        this.btn0.setOnClickListener(new OnClickBotao());
        this.btn0.setOnLongClickListener(new OnLongClickBotao());

        Log.i("numero", "onCreate");

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public void onStart() {
        super.onStart();
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }

    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {

            if (v.equals(MainActivity.this.btn1)) {
                Log.i("numero", "Clicou no botão 1");
                String texto = (String) btn1.getText();
                 t1.speak(texto,  TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn2)) {
                Log.i("numero", "Clicou no botão 2");
                String texto = (String) btn2.getText();
                t1.speak(texto,  TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn3)) {
                Log.i("numero", "Clicou no botão 3");
                String texto = (String) btn3.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn4)) {
                Log.i("numero", "Clicou no botão 4");
                String texto = (String) btn4.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn5)) {
                Log.i("numero", "Clicou no botão 5");
                String texto = (String) btn5.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn6)) {
                Log.i("numero", "Clicou no botão 6");
                String texto = (String) btn6.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn7)) {
                Log.i("numero", "Clicou no botão 7");
                String texto = (String) btn7.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn8)) {
                Log.i("numero", "Clicou no botão 8");
                String texto = (String) btn8.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn9)) {
                Log.i("numero", "Clicou no botão 9");
                String texto = (String) btn9.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            } else if (v.equals(MainActivity.this.btn0)) {
                Log.i("numero", "Clicou no botão 0");
                String texto = (String) btn0.getText();
                t1.speak(texto, TextToSpeech.QUEUE_FLUSH, null, null);
            }

        }
    }

    private class OnLongClickBotao implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {
            Log.i("numero", "IFPB");
            return true;
        }
    }


}
