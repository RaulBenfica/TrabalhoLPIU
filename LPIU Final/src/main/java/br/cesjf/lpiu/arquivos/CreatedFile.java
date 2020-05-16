/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Automovel;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 *
 * @author tassio
 */
public class CreatedFile {
    
    /**
        * @param args
        * @throws
        */
       public static void main(String[] args) {
             try {
                    FileOutputStream fout = new FileOutputStream("informacoes_carro.txt");
                    ObjectOutputStream objOut = new ObjectOutputStream(fout);
        
                    Automovel auto = new Automovel();
                    auto.setPlaca("ABC-1234");
                    auto.setModelo("Uno");
                    auto.setData("1996");
                    auto.setValorBasico(10000);
                    auto.setMotorizacao("1.0");
                    auto.setCategoria("Carga");
                    
                    
                    objOut.writeObject(auto);
                   
                    objOut.close();
             } catch (IOException e) {
                    e.printStackTrace();
             }
             
             
  
       }
    
}
