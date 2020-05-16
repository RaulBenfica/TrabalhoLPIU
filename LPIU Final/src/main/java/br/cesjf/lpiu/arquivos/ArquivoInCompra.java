/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Compra;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author benfi
 */
public class ArquivoInCompra {
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;
    
    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_compra.txt");
        objIn = new ObjectInputStream(fin);
    }
    
    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCompra.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Compra getcompra() throws IOException, ClassNotFoundException {
        Compra compra = null;

        try {
            compra = (Compra) objIn.readObject();
        } catch (EOFException ex) {
            compra = null;
        }
        return compra;
    }
    
    public List getTodasCompras() {
        List<Compra> lista = new ArrayList<Compra>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInCompra.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInCompra.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        Compra compra = null;
        while (continua) {
            try {
                compra = (Compra) objIn.readObject();
                lista.add(compra);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInCompra.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return lista;

    }
}
