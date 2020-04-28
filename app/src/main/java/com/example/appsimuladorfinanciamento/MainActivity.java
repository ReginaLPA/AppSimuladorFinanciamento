package com.example.appsimuladorfinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
 //https://www.youtube.com/watch?v=4BEYAfOkCts
    //https://www.youtube.com/watch?v=SRJ8s6MInC0
    //https://www.youtube.com/watch?v=I1pPRhS4RUM // sistema vendas

    public static final int CONSTANTE_TELA2 = 2;
    private EditText nome;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Tela Inicial");

    }
    //chama a tela veiculo
    public void irVeiculo(View view) {
        nome = (EditText)findViewById(R.id.editTextNome);

        Intent intent = new Intent(MainActivity.this, Veiculo.class);//parametro a tela  que esta e a tela a ser chamada
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        msg = nome.getText().toString();
        intent.putExtra("parametro",msg);
        //startActivityForResult(intent,CONSTANTE_TELA1);
        startActivity(intent);

    }
    //chama a tela
    public void irResidencia(View view) {
        nome = (EditText)findViewById(R.id.editTextNome);

        Intent intent = new Intent(MainActivity.this, Residencia.class);//parametro a tela  que esta e a tela a ser chamada
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        msg = nome.getText().toString();
        intent.putExtra("parametro", msg);
        //startActivityForResult(intent,CONSTANTE_TELA1);
        startActivity(intent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //return super.onCreateOptionsMenu(menu);
        return  true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.menu_Início){
            startActivity(new Intent(this,MainTeste.class));
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Simular_Residência){
            startActivity(new Intent(this,Residencia.class));
            //Toast.makeText(this,"simular inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Simular_Veículo){
            startActivity(new Intent(this,Veiculo.class));
           // Toast.makeText(this,"Simular inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Sobre){
            startActivity(new Intent(this,Sobre.class));
            //Toast.makeText(this,"Sobre inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Sair){
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }



}
