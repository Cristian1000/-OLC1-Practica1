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
public class Lexico {
    public ArrayList<Token> lista;
    
    public Lexico(){
        this.lista = new ArrayList<Token>();
    }

    public ArrayList<Token> getLista() {
        return lista;
    }

    public void setLista(ArrayList<Token> lista) {
        this.lista = lista;
    }
    
    
    public ArrayList<Token> Analisis(String texto){
        int estado = 1;
        String cadena = "";
        String lineas[] = texto.split("\n");
//        System.out.println(lineas.length);
        for (int i = 0; i < lineas.length; i++) {
//            System.err.println(i);
            char letra [] = lineas[i].trim().toCharArray();
            for (int j = 0; j < letra.length; j++) {
                System.out.println(estado);
                switch(estado){
                    case 1:
                        if(letra[j] == '/' || letra[j] == '<'){
                            cadena+=letra[j];
                            estado = 5;
                        }else{
                            if(Character.isLetter(letra[j])){
                            cadena+=letra[j];
                            estado = 2;
                        }
                        if(Character.isDigit(letra[j])){
                            cadena+=letra[j];
                            estado = 3;
                        }
                        
                        if(!(Character.isLetter(letra[j])) && !(Character.isDigit(letra[j])) && !(Character.isWhitespace(letra[j]))){
                            if(letra[j] == '"' ){
                               estado = 4;
                            }else if(letra[j] != '/' && letra[j] != '<'){
//                                estado = 4;
                                cadena+=letra[j];
                                Token nuevo = new Token(1, cadena, i, j);
                                lista.add(nuevo);
                                cadena = "";
//                                j--;
                            }
//                            if(letra[j] == '/'){
//                                cadena+=letra[j];
//                                estado=5;
//                            }
//                            if(letra[j] == '<'){
//                                cadena+=letra[j];
//                                estado = 6;
//                            }
                            }
                        }
                        
                        
//                        if(!(Character.isDigit(letra[j])) && !(Character.isLetter(letra[j]))){
//                            if(letra[j] == '"'){
//                                estado = 4;
//                            }else{
//                                cadena+=letra[j];
//                                System.out.println(cadena);
//                                Token nuevo = new Token(1, cadena, i, j);
//                                lista.add(nuevo);
//                                cadena = "";
//                            }
//                        }
                        break;
                    case 2:
                        if(Character.isLetter(letra[j]) || Character.isDigit(letra[j])){
                            cadena+=letra[j];
                        }else{
//                            System.out.println(cadena);
                            Token nuevo = new Token(1, cadena, i, j);
                            lista.add(nuevo);
                            cadena = "";
                            j--;
                            estado = 1;
                        }
                        
                        break;
                    case 3:
                        if(Character.isDigit(letra[j])){
                            cadena+=letra[j];
                        }else{
                            Token nuevo = new Token(1, cadena, i, j);
                            lista.add(nuevo);
//                            System.out.println(cadena);
                            cadena = "";
                            estado = 1;
                            j--;
                        }
                        break;
                    case 4:
                        if(letra[j] == '"'){
                            Token nuevo = new Token(1, cadena, i, j);
                            lista.add(nuevo);
                            cadena = "";
                            estado = 1;
                        }else{
                            cadena+=letra[j];
                        }
                        
                        break;
                    case 5:
                        if(letra[j] == '/' && cadena == "/"){
                            i++;
                            j=0;
                        }
                        if(letra[j] == '!' && cadena == "<"){
                            estado = 6;
                        }
                        
                        if(letra[j] != '/' && letra[j] != '!' ){
                            Token nuevo = new Token(1, cadena, i, j);
                            lista.add(nuevo);
                            cadena = "";
                            estado = 1;
                         }
//                        if(letra[j] == '/'){
//                            i++;
//                            j=0;
//                            estado = 1;
//                        }else{
//                            Token nuevo = new Token(1, cadena, i, j);
//                            lista.add(nuevo);
//                            cadena = "";
//                            j--;
//                            estado =1;
//                        }
//                        if(letra[j] == '/'){
//                            j=0;
//                            i++;
//                            estado = 1;
//                        }else if(letra[j] == '!'){
//                            estado = 6;
//                        }else if(letra[j] != '!' && letra[j] != '/'){
//                            Token nuevo = new Token(1, cadena, i, j);
//                            lista.add(nuevo);
//                            cadena = "";
//                            estado = 1;
//                            j--;
//                        }
                        
                        break;
                    case 6:
                        if(letra[j] == '!'){
                            estado = 7;
                        }
//                        if(letra[j] == '!'){
//                            estado = 7;
//                        }else{
//                            Token nuevo = new Token(1, cadena, i, j);
//                            lista.add(nuevo);
//                            cadena = "";
//                            j--;
//                        }
                        break;
                    case 7:
                        if(letra[j] == '>'){
                            estado = 1;
                        }else{
                            estado=6;
                        }
//                        if(letra[j] == '!'){
//                            estado = 8;
//                        }
                        break;
                    case 8:
                        if (letra[j] == '>') {
                            estado = 1;
                        }else{
                        estado = 7;
                        }
                        break;
//                    case 6:
//                        if (letra[j] == '\"') {
//                            System.out.println(cadena);
//                            Token nuevo = new Token(1, cadena, i, j);
//                            lista.add(nuevo);
//                            cadena = "";
//                            estado = 1;
//                        } else {
//                            cadena+= letra[j];
//                            cadena = "";
//                        }
//                        break;
//                    case 7:
//                        if(letra[j] == '!' && letra[j+1] == '>'){
//                            estado = 1;
//                        }
//                        break;
                }
            }
            
        }
        return lista;
    }
    
    public void imprimir(){
        for (Token to: lista) {
                System.out.println(to.getNombre());
            }
            System.out.println(lista.size());
    }
}
