package com.example.appsimuladorfinanciamento;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Veiculo extends AppCompatActivity {

    public static final int CONSTANTE_TELA1_NOVO = 1;
    public static final int CONSTANTE_TELA1_USADO = 2;
    private CheckBox imNovo;
    private CheckBox imUsado;
    private EditText valorVeiculo;
    private  EditText entradaVeiculo;
    private EditText qtdeParcelaVeiculo;
    private EditText rendaVeiculo;
    private double tax,juros,total,emplacamento;
    private double valorParcelaVeiculo,juro ;
    private  double precoVeiculoUsado,IPVA;
    private  double precoVeiculoNovo,montante;
    private double parcela,limit,ValorParcela;

    private String msg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_veiculo);

        setTitle(" Tela Veículo");

        Intent intent = getIntent();
        //String mensagem = intent.getStringExtra("parametro");

        // recebe intent do nome
        msg = intent.getStringExtra("parametro");

        TextView textResultado = findViewById(R.id.textViewNomeVeiculo);
        textResultado.setText("Bem Vindo! " + msg);

        //set variaveis
         imNovo = (CheckBox) findViewById(R.id.checkBoxNovo) ;
         imUsado = (CheckBox) findViewById(R.id.checkBoxUsado) ;
         valorVeiculo = (EditText) findViewById(R.id.editTextValorVeiculo);
         entradaVeiculo = (EditText) findViewById(R.id.editTextentrada);
         qtdeParcelaVeiculo = (EditText) findViewById(R.id.editTextQtdeParcelas);
         rendaVeiculo = (EditText) findViewById(R.id.editTextRendaLiquida);


        //Button SimularResidencia = (Button) findViewById(R.id.btnSimularResidencia);
        //SimularResidencia.setOnClickListener((View.OnClickListener) this);

       limit = 0.05;
        Button b = (Button) findViewById(R.id.btnSimularVeiculo);
        b.setOnClickListener(new Button.OnClickListener(){
        public void onClick(View v) {
            if (valorVeiculo.getText().toString().equals("")
                    && qtdeParcelaVeiculo.getText().toString().equals("")
                    && rendaVeiculo.getText().toString().equals("")) {
                Toast.makeText(Veiculo.this, "Insira os Valores", Toast.LENGTH_SHORT).show();
            if(entradaVeiculo.getText().toString().equals(limit) ){
                    Toast.makeText(Veiculo.this,"Insira um valor maior que "+limit,Toast.LENGTH_SHORT).show();
                }
            } else {
                if (imNovo.isChecked()) {
                    imNovo.setChecked(true);
                    double valor = Double.parseDouble(valorVeiculo.getText().toString());
                    double ent = Double.parseDouble(entradaVeiculo.getText().toString());
                    int parc = Integer.parseInt(qtdeParcelaVeiculo.getText().toString());
                    double ren = Double.parseDouble(rendaVeiculo.getText().toString());
                    IPVA = valor*0.04;
                    emplacamento = valor* 0.01;
                    montante = valor - ent;
                    if (ren <= 3.500) {
                        tax =  0.06;
                        total = (montante*(Math.pow(1+tax, parc)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juros = total - montante;
                        //precoVeiculoNovo = total + IPVA + emplacamento;

                    } else if (ren >= 3.501 && ren < 5.000) {
                        tax =  0.05;
                        total = (montante*(Math.pow(1+tax, parc)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juros = total - montante;
                        //precoVeiculoNovo = total + IPVA + emplacamento;

                    } else if (ren > 5.000) {
                        tax = 0.04;
                        total = (montante*(Math.pow(1+tax, parc)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juros = total - montante;
                        //precoVeiculoNovo = total + IPVA + emplacamento;
                    }
                    precoVeiculoNovo = total + IPVA + emplacamento;

                    //double total = val * Math.pow((1 + tax), par);
                    valorParcelaVeiculo = precoVeiculoNovo / parc;

                    if (valorParcelaVeiculo < parcela) {

                        Intent intent = new Intent(Veiculo.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        intent.putExtra("calling-activity", Veiculo.CONSTANTE_TELA1_NOVO);
                        intent.putExtra("parametro", msg);
                        intent.putExtra("parametro1", valor);
                        intent.putExtra("parametro2", precoVeiculoNovo);
                        intent.putExtra("parametro3", ent);
                        intent.putExtra("parametro4", parc);
                        intent.putExtra("parametro5", valorParcelaVeiculo);
                        intent.putExtra("parametro6", juros);
                        intent.putExtra("parametro7", IPVA);
                        intent.putExtra("parametro8", emplacamento);
                        startActivityForResult(intent, 1);

                    } else if(valorParcelaVeiculo > parcela) {
                        Toast.makeText(Veiculo.this, "Parcela Ultrapassa 30% da renda!\nTente outro Valor", Toast.LENGTH_LONG).show();
                    }
                }
                else if (imUsado.isChecked()) {
                    imUsado.setChecked(true);
                    double val = Double.parseDouble(valorVeiculo.getText().toString());
                    double ent = Double.parseDouble(entradaVeiculo.getText().toString());
                    int par = Integer.parseInt(qtdeParcelaVeiculo.getText().toString());
                    double ren = Double.parseDouble(rendaVeiculo.getText().toString());
                    montante = val - ent;
                    if (ren <= 3.500) {
                        tax = 0.06;
                        total = (montante*(Math.pow(1+tax, par)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juro = total - montante;
                        precoVeiculoUsado = total ;

                    } else if (ren >= 3.501 && ren < 5.000) {
                        tax = 0.05;
                        total = (montante*(Math.pow(1+tax, par)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juro = total - montante;
                        precoVeiculoUsado = total ;

                    } else if (ren > 5.000) {
                        tax = 0.04;
                        total = (montante*(Math.pow(1+tax, par)));
                        parcela = ren * 0.3;//trinta porcento da renda
                        juro = total - montante;
                        precoVeiculoUsado = total ;
                    }

                    ValorParcela = total / par;
                    if (ValorParcela < parcela) {

                        Intent intent = new Intent(Veiculo.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
                        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                        intent.putExtra("calling-activity", Veiculo.CONSTANTE_TELA1_USADO);
                        intent.putExtra("parametro", msg);
                        intent.putExtra("parametro1", val);
                        intent.putExtra("parametro2", precoVeiculoUsado);
                        intent.putExtra("parametro3", ent);
                        intent.putExtra("parametro4", par);
                        intent.putExtra("parametro5", ValorParcela);
                        intent.putExtra("parametro6", juro);
                        startActivityForResult(intent, 1);

                    } else if (ValorParcela > parcela) {
                        Toast.makeText(Veiculo.this, "Parcela Ultrapassa 30% da renda!\nTente outro Valor", Toast.LENGTH_LONG).show();
                    }
                }
                }
                //imNovo.setText("");
                //imUsado.setText("");
                valorVeiculo.setText("");
                entradaVeiculo.setText("");
                qtdeParcelaVeiculo.setText("");
                rendaVeiculo.setText("") ;

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
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Simular_Veículo){
            startActivity(new Intent(this,Veiculo.class));
           // Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Sobre){
            startActivity(new Intent(this,Sobre.class));
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Sair){
           System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }
/*
    public void irResumoVeiculo(View view) {
        Intent intent = new Intent(Veiculo.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        //intent.putExtra("parametro1", "Valor Parcela: "+valorPacelaVeiculo);
        startActivity(intent);
    }*/
}
