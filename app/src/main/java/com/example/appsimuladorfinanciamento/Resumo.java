package com.example.appsimuladorfinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import java.text.DecimalFormat;

public class Resumo extends AppCompatActivity {

    private String msg,teste;
    private DecimalFormat formatador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo);

        setTitle("Tela Resumo");


        int callingActivity = getIntent().getIntExtra("calling-activity", 0);
        formatador = new DecimalFormat("#,##0.00");


        switch (callingActivity) {
            case Veiculo.CONSTANTE_TELA1_NOVO:
                Intent intent1 = getIntent();
                msg = intent1.getStringExtra("parametro");
                double val = intent1.getDoubleExtra("parametro1", 0);
                double valjuros = intent1.getDoubleExtra("parametro2", 0);
                double ent = intent1.getDoubleExtra("parametro3", 0);
                int qtde = intent1.getIntExtra("parametro4", 0);
                double parcela = intent1.getDoubleExtra("parametro5", 0);
                double juros = intent1.getDoubleExtra("parametro6", 0);
                double IPVA = intent1.getDoubleExtra("parametro7", 0);
                double emplac = intent1.getDoubleExtra("parametro8", 0);


                TextView textResultado1 = findViewById(R.id.textViewResultado);
                textResultado1.setText("Parabéns " + msg + "\nFinanciamento Aprovado \nVEÍCULO NOVO  \nValor Veiculo:" + formatador.format(val) + "\n" + "Entrada: "
                        + formatador.format(ent) + "\nQuantidade de parcelas: " + qtde
                        + "\n" + "Valor da Parcela: " + formatador.format(parcela) + "\n" + "IPVA: "+ formatador.format(IPVA) + "\n"+"Emplacamento: "
                        + formatador.format(emplac)+"\nJuros: " + formatador.format(juros)+ " \nValor com juros: "
                        + formatador.format(valjuros));
                ImageView img1 = (ImageView) findViewById(R.id.imageViewCarro);
                img1.setImageResource(R.drawable.carro);
                break;


            case Veiculo.CONSTANTE_TELA1_USADO:
                Intent intent3 = getIntent();
                msg = intent3.getStringExtra("parametro");
                double val1 = intent3.getDoubleExtra("parametro1", 0);
                double val1juros = intent3.getDoubleExtra("parametro2", 0);
                double ent1 = intent3.getDoubleExtra("parametro3", 0);
                int qtde1 = intent3.getIntExtra("parametro4", 0);
                double parcela1 = intent3.getDoubleExtra("parametro5", 0);
                double juros1 = intent3.getDoubleExtra("parametro6", 0);



                TextView textResultado3 = findViewById(R.id.textViewResultado);
                textResultado3.setText("Parabéns " + msg + "\nFinanciamento Aprovado \nVEÍCULO USADO \nValor Veiculo: " +formatador.format(val1) + "\n" + "Entrada: "
                        + formatador.format(ent1) + "\nQuantidade de parcelas: " + qtde1 + "\nValor da Parcela: " + formatador.format(parcela1)
                        + "\n"+ "Juros: " + formatador.format(juros1)+ " \nValor com juros: " + formatador.format(val1juros));
                ImageView img3 = (ImageView) findViewById(R.id.imageViewCarro);
                img3.setImageResource(R.drawable.carro);
                break;
            case Residencia.CONSTANTE_TELA2_USADO:
                Intent intent = getIntent();
                msg = intent.getStringExtra("parametro");
                teste = intent.getStringExtra("parametro0");
                double  valor = intent.getDoubleExtra("parametro1",0);
                double valorJuros = intent.getDoubleExtra("parametro2", 0);
                double entrada = intent.getDoubleExtra("parametro3", 0);
                int qtdeImovel = intent.getIntExtra("parametro4", 0);
                double par = intent.getDoubleExtra("parametro5", 0);
                double taxa = intent.getDoubleExtra("parametro6", 0);
                double transfere = intent.getDoubleExtra("parametro7", 0);

                TextView textResultado = findViewById(R.id.textViewResultado);
                textResultado.setText("Parabéns " + msg + "\nFinanciamento Aprovado \n IMÓVEL USADO \nValor Imóvel: "+  formatador.format(valor) + "\n" + "Entrada: "
                       +formatador.format(entrada) +"\nTransferência: "+ formatador.format(transfere) +"\nQuantidade de parcelas: " + qtdeImovel
                        + "\n" + "Valor da Parcela: " + formatador.format(par) + "\n" + "Juros: " + formatador.format(taxa) + "\nValor com juros: "
                        + formatador.format(valorJuros));
                ImageView img = (ImageView) findViewById(R.id.imageViewCarro);
                img.setImageResource(R.drawable.casa);
                break;


            case Residencia.CONSTANTE_TELA2_NOVO:
                Intent intent2 = getIntent();
                msg = intent2.getStringExtra("parametro");
                teste = intent2.getStringExtra("parametro0");
                double  valor1 = intent2.getDoubleExtra("parametro1",0);
                double valor1Juros = intent2.getDoubleExtra("parametro2", 0);
                double entrada1 = intent2.getDoubleExtra("parametro3", 0);
                int qtdeImovel1 = intent2.getIntExtra("parametro4", 0);
                double par1 = intent2.getDoubleExtra("parametro5", 0);
                double taxa1 = intent2.getDoubleExtra("parametro6", 0);
                double Habite = intent2.getDoubleExtra("parametro7", 0);


                TextView textResultado2 = findViewById(R.id.textViewResultado);
                textResultado2.setText("Parabéns " + msg + "\nFinanciamento Aprovado \n IMÓVEL NOVO\nValor Imóvel: "+formatador.format(valor1) +"\n" + "Entrada: "
                       + formatador.format(entrada1) + "\nQuantidade de parcelas: " + qtdeImovel1 +"\nHabite: "+ formatador.format(Habite)
                        + "\nValor da Parcela: " + formatador.format(par1) +   "\n" + "Juros: " + formatador.format(taxa1)
                        +"\nValor com juros: "+ formatador.format(valor1Juros));
                ImageView imagem = (ImageView) findViewById(R.id.imageViewCarro);
                imagem.setImageResource(R.drawable.casa);
                break;

        }


    }
    public void irInicio(View view){

        startActivity(new Intent(this, MainTeste.class));
        System.exit(0);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);

        //return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_Início) {
            startActivity(new Intent(this, MainTeste.class));
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Simular_Residência) {
            startActivity(new Intent(this, Residencia.class));
            //Toast.makeText(this,"simular inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Simular_Veículo) {
            startActivity(new Intent(this, Veiculo.class));
            // Toast.makeText(this,"Simular inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Sobre) {
            startActivity(new Intent(this, Sobre.class));
            //Toast.makeText(this,"Sobre inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if (id == R.id.Sair) {
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

}




