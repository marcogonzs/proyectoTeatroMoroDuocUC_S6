/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectos5teatromoro;

/**
 *
 * @author marco
 */
import java.util.UUID;

public class BoletaEntrada {
    private String estado; //Vendido, Reservado, Anulado

    String nombre;
    int fila;
    int columna;
    int funcionSelec;
    String zonaEntrada;
    int edad;
    int precioFinal;
    String codigo;

    public BoletaEntrada(String nombre,int fila, int columna, int funcionSelec, String zonaEntrada, int edad, int precioFinal) {
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
        this.funcionSelec= funcionSelec;
        this.zonaEntrada = zonaEntrada;
        this.edad=edad;
        this.precioFinal=precioFinal;
        this.codigo = generarCodigo();
        this.estado="vendido";
    }
    public String getEstado(){
        return estado;
    }
    public void setEstado(String estado){
        this.estado=estado;
    }
    public int getPrecio(){
        return precioFinal;
    }

    private String generarCodigo() {
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public void mostrarBoleta(){
        System.out.println("");
        System.out.println("================================================================");
        System.out.println("                         BOLETA DE VENTA                        ");
        System.out.println("================================================================");
        System.out.println("Nombre Cliente Principal:"+nombre);
        System.out.println("Funcion: "+funcionSelec);
        System.out.println("Zona: "+zonaEntrada);
        System.out.println("ASIENTO: FILA: "+fila+" | COLUMNA: "+columna);
        System.out.println("Edad: "+edad);
        System.out.println("Precio Final: $"+precioFinal);
        System.out.println("=================================================================");
        System.out.println("CODIGO DE ENTRADA: "+codigo);
        System.out.println("=================================================================");
    }
    public String getCodigo(){
        return codigo;
    }
    public int funcionSelec(){
        return funcionSelec;
    }
    public String getZonaEntrada(){
        return zonaEntrada;
    }
    
    @Override
    public String toString(){
        return  "Boleta:   " +
                "nombre='" + nombre + '\'' + 
                "Zona="+zonaEntrada+ ", fila=" + fila +
                ", columna=" + columna +
                ", codigo='" + codigo + '\'' +
                '}';
    }
    
}
