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
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Residencia extends AppCompatActivity {

    //public static final int CONSTANTE_TELA2= 2;
    public static final int CONSTANTE_TELA2_NOVO = 4;
    public static final int CONSTANTE_TELA2_USADO = 3;

    private CheckBox resNovo;
    private CheckBox resUsado;
    private TextView valorImovel;
    private  TextView entradaImovel;
    private TextView qtdeParcelaImovel;
    private TextView rendaImovel;
    //private TextView valorPacelaImovel;
    //private double taxaImovel;
    private double tax,juros,juro,total;
    private double valorPacela, valorParcelaNovo;
    private  double precoImovelUsado ;
    private  double precoImovelNovo;
    private  double montante,Habite,transfere;
    private double parcela,limite;

    //private TextView textResultado;
    private String msg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_residencia);

        setTitle("Tela Residência");

        Intent intent = getIntent();
        //String mensagem = intent.getStringExtra("parametro");


        msg = intent.getStringExtra("parametro");

        TextView textResultado = findViewById(R.id.textViewNomeResidencia);
        textResultado.setText("Bem Vindo! " + msg);


        resNovo = (CheckBox) findViewById(R.id.checkBoxNovoResidencia);
        resUsado = (CheckBox) findViewById(R.id.checkBoxUsadoResidencia);


        valorImovel = (EditText) findViewById(R.id.editTextValorImovel);
        entradaImovel = (EditText) findViewById(R.id.editTextEntrada);
        //EditText taxaImovel = (EditText) findViewById(R.id.editText3);
        qtdeParcelaImovel = (EditText) findViewById(R.id.editTextQtdeparcelas);
         rendaImovel = (EditText) findViewById(R.id.editTextRendaLiquida);


        Button SimularResidencia = (Button) findViewById(R.id.btnSimularResidencia);
        //SimularResidencia.setOnClickListener((View.OnClickListener) this);

       // https://www.youtube.com/watch?v=AD5qt7xoUU8
        //Button b = (Button) findViewById(R.id.btnSimularResidencia);


        limite = 0.2;
        SimularResidencia.setOnClickListener(new Button.OnClickListener(){

            public void onClick(View view) {
                if (valorImovel.getText().toString().equals("")
                        && entradaImovel.getText().toString().equals("")
                        && qtdeParcelaImovel.getText().toString().equals("")
                        && rendaImovel.getText().toString().equals("") ) {
                Toast.makeText(Residencia.this,"Insira os Valores",Toast.LENGTH_SHORT).show();
                }
                else if(entradaImovel.getText().toString().equals(limite) ){
                    Toast.makeText(Residencia.this,"Insira um valor maior que "+limite,Toast.LENGTH_SHORT).show();
                }
                else {
                      if (resNovo.isChecked()) {
                          //resNovo.setChecked(true);
                        double val = Double.parseDouble(valorImovel.getText().toString());
                        double ent = Double.parseDouble(entradaImovel.getText().toString());
                        //double taxa = Double.parseDouble(taxaImovel.getText().toString());
                        int par = Integer.parseInt(qtdeParcelaImovel.getText().toString());
                        double renda = Double.parseDouble(rendaImovel.getText().toString());
                        Habite = val * 0.05;
                        montante = val - ent;
                        if (renda <= 3.500) {
                            tax = 0.03;
                            total = (montante*(Math.pow(1+tax, par)));
                            parcela = renda * 0.3;//trinta porcento da renda
                            juro = total - montante;
                            precoImovelNovo = total + Habite;
                        }else  if (renda >= 3.501 && renda < 5.000) {
                            tax =  0.025;
                            total = (montante*(Math.pow(1+tax, par)));
                            parcela = renda* 0.3;//trinta porcento da renda
                            juro = total - montante;
                            precoImovelNovo = total + Habite;
                        }else  if (renda > 5.000) {
                            tax = 0.020;
                            total = (montante*(Math.pow(1+tax, par)));
                            parcela = renda * 0.3;//trinta porcento da renda
                            juro = total - montante;
                            precoImovelNovo = total + Habite;
                        }

                          //double totalImovelNovo = valor * 0.05;
                        //double total = val * Math.pow((1 + tax), par);
                        valorParcelaNovo = precoImovelNovo / par;
                        //valor = precoImovelNovo;
                        if (valorParcelaNovo < parcela) {

                            Intent intent = new Intent(Residencia.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
                            //intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            intent.putExtra("calling-activity", Residencia.CONSTANTE_TELA2_NOVO);
                            //intent.putExtra("calling-activity", Residencia.CONSTANTE_TELA2);
                            intent.putExtra("parametro", msg);
                            intent.putExtra("parametro1",val);
                            intent.putExtra("parametro2", precoImovelNovo);
                            intent.putExtra("parametro3", ent);
                            intent.putExtra("parametro4", par);
                            intent.putExtra("parametro5", valorParcelaNovo);
                            intent.putExtra("parametro6", juro);
                            intent.putExtra("parametro7", Habite);
                            startActivityForResult(intent, 1);

                        } else if(valorParcelaNovo > parcela) {
                            Toast.makeText(Residencia.this, "Parcela Ultrapassa 30% da renda!\nTente outro Valor", Toast.LENGTH_LONG).show();
                        }
                    }

                    else if (resUsado.isChecked()) {
                          //resUsado.setChecked(true);
                          double valor = Double.parseDouble(valorImovel.getText().toString());
                          double entrada = Double.parseDouble(entradaImovel.getText().toString());
                          //double taxa = Double.parseDouble(taxaImovel.getText().toString());
                          int parc = Integer.parseInt(qtdeParcelaImovel.getText().toString());
                          double renda = Double.parseDouble(rendaImovel.getText().toString());
                          transfere = valor * 0.02;
                          montante = valor - entrada;
                        if (renda <= 3.500) {
                            tax = 0.03;
                            total = (montante*(Math.pow(1+tax, parc)));
                            parcela = renda * 0.3;//trinta porcento da renda
                            juros = total - montante;
                            precoImovelUsado = total + transfere;

                        }else if (renda >= 3.501 && renda < 5.000) {
                            tax = 0.025;
                            total = (montante*(Math.pow(1+tax, parc)));
                            parcela = renda * 0.3;//trinta porcento da renda
                            juros = total - montante;
                            precoImovelUsado = total + transfere;

                        } else if (renda > 5.000) {
                            tax = 0.020;
                            total = (montante*(Math.pow(1+tax, parc)));
                            parcela = renda * 0.3;//trinta porcento da renda
                            juros =  total - montante;
                            precoImovelUsado = total + transfere;
                        }

                        valorPacela =  precoImovelUsado / parc;
                        if (valorPacela < parcela) {
                            Intent intent = new Intent(Residencia.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
                            intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            intent.putExtra("calling-activity", Residencia.CONSTANTE_TELA2_USADO);
                            //intent.putExtra("calling-activity", Residencia.CONSTANTE_TELA2);
                            intent.putExtra("parametro", msg);
                            intent.putExtra("parametro1",valor);
                            intent.putExtra("parametro2",precoImovelUsado );
                            intent.putExtra("parametro3", entrada);
                            intent.putExtra("parametro4", parc);
                            intent.putExtra("parametro5", valorPacela);
                            intent.putExtra("parametro6", juros);
                            intent.putExtra("parametro7", transfere);
                            startActivityForResult(intent, 1);

                        } else if (valorPacela > parcela) {
                            Toast.makeText(Residencia.this, "Parcela Ultrapassa 30% da renda!\nTente outro Valor", Toast.LENGTH_LONG).show();

                        }

                }


                }
                //resNovo.setText("");
                //resUsado.setText("");
                valorImovel.setText("");
                entradaImovel.setText("");
                qtdeParcelaImovel.setText("");
                rendaImovel.setText("") ;
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
           // Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Simular_Residência){
            startActivity(new Intent(this,Residencia.class));
           // Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
        }
        if(id==R.id.Simular_Veículo){
            startActivity(new Intent(this,Veiculo.class));
            //Toast.makeText(this,"Menu inicio clicado",Toast.LENGTH_SHORT).show();
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

//https://dragaosemchama.com/2015/03/android-activities-e-como-alternar-entre-varias-telas/
    /*public void irResumoResidencia(View view) {
        Intent intent = new Intent(Residencia.this, Resumo.class);//parametro a tela  que esta e a tela a ser chamada
        intent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        intent.putExtra("calling-activity", Residencia.CONSTANTE_TELA2);

        startActivity(intent);
    }
*/



}

