package com.example.admin.birthday;

import java.util.Calendar;

/**
 * Created by admin on 27/01/17.
 */

public class Pessoa {

    private int codigo;
    private String nome;
    private Calendar data;


    public Pessoa(String nome, int dia, int mes, int ano){
        this.nome = nome;
        this.data = Calendar.getInstance();
        this.data.set(ano,mes,dia);
    }

    public Pessoa(int codigo, String nome, Long aniversario){
        this.codigo = codigo;
        this.nome = nome;
        this.data = Calendar.getInstance();
        this.data.setTimeInMillis(aniversario);
    }

    public void setNome(String nome){

        this.nome = nome;
    }

    public String getNome(){

        return this.nome;
    }

    public void setData(Calendar data){

        this.data = data;
    }

    public Calendar getData(){
        return this.data;
    }

    public String getDataSt(){
        return String.format("%d/%d/%d", this.data.get(Calendar.DAY_OF_MONTH),
                this.data.get(Calendar.MONTH)+1,
                this.data.get(Calendar.YEAR));
    }

    @Override
    public String toString() {

        return String.format("%s - %s", this.nome, this.getDataSt());
    }
}
