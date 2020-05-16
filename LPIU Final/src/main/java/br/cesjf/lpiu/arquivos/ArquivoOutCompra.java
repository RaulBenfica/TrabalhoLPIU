/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Compra;
import java.io.EOFException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benfi
 */
public class ArquivoOutCompra {
    
    private FileOutputStream fout = null;
    private ObjectOutputStream objOut = null;
    private List<Compra> lista = new ArrayList<Compra>();
    
    public void abrir() throws FileNotFoundException, IOException { //throws, trata exceção para cada coisa que possa acontecer
        preparar();
        fout = new FileOutputStream("informacoes_compra.txt");
        objOut = new ObjectOutputStream(fout);
        for (int i = 0; i < lista.size(); i++) {
            objOut.writeObject(lista.get(i));
        }
    }
    
    private void preparar() {
        ArquivoInCompra arq = new ArquivoInCompra();
        try {
            arq.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoOutCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoOutCompra.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        Compra compra = null;
        while (continua) {
            try {
                compra = arq.getcompra();
                if (compra != null) {
                    lista.add(compra);
                } else {
                    continua = false;
                }
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                Logger.getLogger(ArquivoOutCompra.class.getName()).log(Level.SEVERE, null, ex);
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoOutCompra.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        arq.fechar();
    }
    
    public void fechar() throws IOException {//throws, trata a exceção IOException
        objOut.close();
        fout.close();
    }
    
    public void Adicionar(Compra compra) throws IOException {
        objOut.writeObject(compra);//grava o objeto todo
    }

    public void recadastrar_todos(ArrayList<Compra> lista2) throws IOException {
        fout = new FileOutputStream("informacoes_compra.txt");
        objOut = new ObjectOutputStream(fout);

        for (int i = 0; i < lista2.size(); i++) {
            objOut.writeObject(lista2.get(i));
        }

    }
    
}
