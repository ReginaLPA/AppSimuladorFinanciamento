package com.example.appsimuladorfinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class Sobre extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre);

        setTitle(" Tela Sobre");
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
            startActivity(new Intent(this,MainActivity.class));
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
