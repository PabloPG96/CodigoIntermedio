 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisis;

import java.util.ArrayList;

/**
 *
 * @author pablo
 */
public class Prueba {
    public static void main(String[] args) {
        ArrayList<String> tablaSimbolosArray = new ArrayList<>();    
        String expresion="d = -(a+b/f-b)/a*5;";
        tablaSimbolosArray.add("d#1");
        tablaSimbolosArray.add("f#1");
        tablaSimbolosArray.add("c#1");
        tablaSimbolosArray.add("a#0");
        tablaSimbolosArray.add("b#0");
        
        if(
        new Semantico().AnalisisExpresion(tablaSimbolosArray, expresion.replace(" ", ""))
           )
        {
            System.out.println("Correcta");
        } else
            System.out.println("Incorrecta");
            
            
    }
    
    
}
