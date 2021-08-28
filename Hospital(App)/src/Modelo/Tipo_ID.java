/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Camilo
 */
public class Tipo_ID {
    private int codigo;
    private String tipo;
    
    public Tipo_ID(int codigo, String tipo) {
        this.codigo = codigo;
        this.tipo = tipo;
    }

     public Tipo_ID() {
        this.codigo = 0;
        this.tipo = "";
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Codigo de hora tipo Id:  "+codigo+"\nTipo de Id "  + tipo;
    }
    
   
}
