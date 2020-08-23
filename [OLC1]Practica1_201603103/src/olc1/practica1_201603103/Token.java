/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.practica1_201603103;

/**
 *
 * @author crist
 */
public class Token {
    public int No;
    public String nombre;
    public int fila;
    public int columna;

    public Token(int No, String nombre, int fila, int columna) {
        this.No = No;
        this.nombre = nombre;
        this.fila = fila;
        this.columna = columna;
    }

    public int getNo() {
        return No;
    }

    public void setNo(int No) {
        this.No = No;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFila() {
        return fila;
    }

    public void setFila(int fila) {
        this.fila = fila;
    }

    public int getColumna() {
        return columna;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
    
    
}
