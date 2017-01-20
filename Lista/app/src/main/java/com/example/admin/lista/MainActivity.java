package com.example.admin.lista;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lista;
    private List<String> status;
    private CarregadorReciever reciever;
    private IntentFilter itf;

    public MainActivity(){
        this.status = new ArrayList<String>();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.lista = (ListView) this.findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.status);

        this.reciever = new CarregadorReciever();
        this.itf = new IntentFilter();
        this.itf.addAction(Intent.ACTION_POWER_CONNECTED);
        this.itf.addAction(Intent.ACTION_POWER_DISCONNECTED);

        this.lista.setAdapter(adapter);

    }

    protected void onResume() {
        super.onResume();
        registerReceiver(this.reciever, this.itf);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.reciever);
    }

    private class CarregadorReciever extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            switch (intent.getAction()) {
                case Intent.ACTION_POWER_CONNECTED :
                    MainActivity.this.status.add("Carregando ... ");
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    MainActivity.this.status.add("Desconectou o carregador");
                    break;
                default:
                    MainActivity.this.status.add("Não sei! ");
            }
            ((ArrayAdapter)MainActivity.this.lista.getAdapter()).notifyDataSetChanged();
        }
    }
}
