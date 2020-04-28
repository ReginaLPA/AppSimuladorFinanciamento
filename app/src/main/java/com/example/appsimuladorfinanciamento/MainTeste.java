package com.example.appsimuladorfinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainTeste extends AppCompatActivity {

    private static final int Activity_UM_DOIS = 1;
    Button BtnStart;
    private EditText nome;
    private String msg;
    String casa;
    String carro;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_teste);

        setTitle("Tela Início");

        // associa o radiobutton
        final RadioButton casa = (RadioButton) findViewById(R.id.radioButtonResidencia);
        final RadioButton carro = (RadioButton) findViewById(R.id.radioButtonVeiculo);
       //RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        BtnStart = (Button) findViewById(R.id.btnIniciar);



        BtnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            if(casa.isChecked()) {
                nome = (EditText)findViewById(R.id.editTextNome);

                Intent intent = new Intent(MainTeste.this, Residencia.class);//parametro a tela  que esta e a tela a ser chamada
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                msg = nome.getText().toString();
                intent.putExtra("parametro", msg);
                //startActivityForResult(intent,CONSTANTE_TELA1);
                startActivity(intent);
            }
            if(carro.isChecked()){
                carro.setChecked(true);
                nome = (EditText)findViewById(R.id.editTextNome);

                Intent intent = new Intent(MainTeste.this, Veiculo.class);//parametro a tela  que esta e a tela a ser chamada
                intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                msg = nome.getText().toString();
                intent.putExtra("parametro",msg);
                //startActivityForResult(intent,CONSTANTE_TELA1);
                startActivity(intent);
            }
                carro.setText("");
                casa.setText("");
                nome.setText("");
            }

        });
    }

    //Menu
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
