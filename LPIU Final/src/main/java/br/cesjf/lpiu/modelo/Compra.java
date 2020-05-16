/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.modelo;

import java.io.Serializable;

/**
 *
 * @author benfi
 */
public class Compra implements Serializable{
    private Pessoa pessoa;
    private Automovel auto;

    public Compra(Pessoa pessoa, Automovel auto) {
        this.pessoa = pessoa;
        this.auto = auto;
    }

    public Compra() {
        pessoa = new Pessoa();
        auto = new Automovel();
    }
    
    public Object[] getcompra() {
        Object compra[] = {pessoa.getNome(),pessoa.getRg(), auto.getModelo(), auto.getPlaca()};
        return compra;
    }

    @Override
    public String toString() {
        return "Compra{" + "Nome=" + pessoa.getNome() + "RG=" + pessoa.getRg() + ", Placa=" + auto.getPlaca() + ", Modelo=" + auto.getModelo() +  '}';
    }

    
    
    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public Automovel getAuto() {
        return auto;
    }

    public void setAuto(Automovel auto) {
        this.auto = auto;
    }
    
    
    
    
}
