package com.example.admin.osebosao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button botao;
    private EditText etext;
    private ListView listView;
    private List<String> lista;

    public MainActivity(){
        this.lista = new ArrayList<String>();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.botao = (Button) findViewById(R.id.buttonAdd);
        this.etext = (EditText) findViewById(R.id.etext);
        this.listView = (ListView) findViewById(R.id.lista);
        this.botao.setOnClickListener(new OnClickBotao());

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.lista);
        this.listView.setAdapter(adapter);

        this.listView.setOnItemClickListener(new OnClickLista());
        this.listView.setOnItemLongClickListener(new OnClickLongo());
    }


    private class OnClickBotao implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String texto = MainActivity.this.etext.getText().toString();
            MainActivity.this.lista.add(texto);
            ((ArrayAdapter)MainActivity.this.listView.getAdapter()).notifyDataSetChanged();

        }
    }


    private class OnClickLista implements AdapterView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String lugar = MainActivity.this.lista.get(position);
            Toast.makeText(MainActivity.this, lugar, Toast.LENGTH_SHORT).show();
        }
    }

    private class OnClickLongo implements AdapterView.OnItemLongClickListener {


        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            MainActivity.this.lista.remove(position);
            ((ArrayAdapter)MainActivity.this.listView.getAdapter()).notifyDataSetChanged();
            return false;
        }
    }

}
