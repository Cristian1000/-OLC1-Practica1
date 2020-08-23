/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package olc1.practica1_201603103;

import java.util.ArrayList;

/**
 *
 * @author crist
 */
public class Conjunto {
    String nombre;
    char inicio;
    char fin;
    ArrayList<Object> conjunto;

    public Conjunto(String nombre, char inicio, char fin) {
        
        this.nombre = nombre;
        this.inicio = inicio;
        this.fin = fin;
        llenado(inicio, fin);
    }

    public Conjunto() {
        conjunto = new ArrayList<>();
    }
    
    
    public Conjunto(char caracter){
        llenar(caracter);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Object> getConjunto() {
        return conjunto;
    }

    public void setConjunto(ArrayList<Object> conjunto) {
        this.conjunto = conjunto;
    }
    
    public boolean existe(char a){
        if (conjunto.contains((int)a)) {
            return true;
        } else {
            return false;
        }
    }
    
    public void llenar(char a){
        System.out.println(a);
        int b = (int)a;
        conjunto.add(b);
    }
    public void llenado(char ini, char fin){
        if ((int)ini>= 32 &&  (int)fin<=125) {
            this.conjunto = new ArrayList<Object>();
            for (int i = (int)ini; i <= (int)fin; i++){
            conjunto.add(i);
        }
        } else {
            if((int)ini<= 32 &&  (int)fin>=125){
                System.out.println("El parametro inicial y final no estan detro de los limites permitidos");
            }else{
                if((int)ini<= 32 || (int)ini>= 125){
                    System.out.println("El limite inicial no esta fuera de los permitido");
                }else if((int)fin<= 32 || (int)fin>= 125){
                    System.out.println("El limite finañl no esta fuera de los permitido");
                }
            }
        }
    }
}
