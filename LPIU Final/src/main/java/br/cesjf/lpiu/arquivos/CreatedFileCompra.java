/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Automovel;
import br.cesjf.lpiu.modelo.Compra;
import br.cesjf.lpiu.modelo.Pessoa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author benfi
 */
public class CreatedFileCompra {
    
    public static void main(String[] args) {
             try {
                    FileOutputStream fout = new FileOutputStream("informacoes_compra.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
                    
                    Compra compra = new Compra();
                    
                    Pessoa pessoa = new Pessoa();
                    pessoa.setNome("Kleiton");
                    pessoa.setRg("12.123.123-1");
                    pessoa.setCpf("123.123.123.-12");
                    pessoa.setDataNascimento("11/12/2020");
                    pessoa.setCnh("123456");
                    pessoa.setCep("12345-123");
                    pessoa.setEstado("MG");
                    pessoa.setCidade("Santos Dumont");                
                    pessoa.setBairro("cacaca");
                    pessoa.setNumero("12345");
                    pessoa.setEndereco("Av. Wilson");
        
                    Automovel auto = new Automovel();
                    auto.setPlaca("ABC-1234");
                    auto.setModelo("Uno");
                    auto.setData("1996");
                    auto.setValorBasico(10000);
                    auto.setMotorizacao("1.0");
                    auto.setCategoria("Carga");
                    
                    compra.setPessoa(pessoa);
                    compra.setAuto(auto);
                    
                    
                    objOut.writeObject(compra);
                    
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
  
       }
}
