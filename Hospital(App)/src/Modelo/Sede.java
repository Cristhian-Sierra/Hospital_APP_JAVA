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
public class Sede {
    private int codigo;
    private int consultorio;
    private String direccion;

    public Sede(int codigo, int consultorio, String direccion) {
        this.codigo = codigo;
        this.consultorio = consultorio;
        this.direccion = direccion;
    }

       public Sede() {
        this.codigo = 0;
        this.consultorio = 0;
        this.direccion = "";
    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getConsultorio() {
        return consultorio;
    }

    public void setConsultorio(int consultorio) {
        this.consultorio = consultorio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Datos registrados de la sede" + "\nCódigo= " + codigo + "\nConsultorio= " + consultorio + "\nDirección= " + direccion ;
    }
    
}
