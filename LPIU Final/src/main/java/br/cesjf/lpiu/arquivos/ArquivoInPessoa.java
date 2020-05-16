/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.lpiu.arquivos;

import br.cesjf.lpiu.modelo.Pessoa;
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
public class ArquivoInPessoa {
    
    private FileInputStream fin = null;
    private ObjectInputStream objIn = null;
    
    public void abrir() throws FileNotFoundException, IOException {
        fin = new FileInputStream("informacoes_pessoa.txt");
        objIn = new ObjectInputStream(fin);
    }
    
    public void fechar() {
        try {
            objIn.close();
            fin.close();
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Pessoa getpessoa() throws IOException, ClassNotFoundException {
        Pessoa pessoa = null;

        try {
            pessoa = (Pessoa) objIn.readObject();
        } catch (EOFException ex) {
            pessoa = null;
        }
        return pessoa;
    }
    
    public List getTodasPessoas() {
        List<Pessoa> lista = new ArrayList<Pessoa>();

        try {
            this.abrir();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
        }


        boolean continua = true;
        Pessoa pessoa = null;
        while (continua) {
            try {
                pessoa = (Pessoa) objIn.readObject();
                lista.add(pessoa);
            } catch (EOFException ex) {
                continua = false;
            } catch (IOException ex) {
                continua = false;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ArquivoInPessoa.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        fechar();
        return lista;
    }   
}
