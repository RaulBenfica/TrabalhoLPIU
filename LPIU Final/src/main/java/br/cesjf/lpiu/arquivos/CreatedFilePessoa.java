package br.cesjf.lpiu.arquivos;



import br.cesjf.lpiu.modelo.Pessoa;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author benfi
 */
public class CreatedFilePessoa {
    
    
    public static void main(String[] args) {
             try {
                    FileOutputStream fout = new FileOutputStream("informacoes_pessoa.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
                    
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
                    
                    objOut.writeObject(pessoa);
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
  
       }
    
}

