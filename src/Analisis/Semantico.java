/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisis;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author pablo
 */
public class Semantico {
    
    String mapeoSemantico[][]={
        {	"0",	"1",	"-1"	},
        {	"1",	"1",	"-1"	},
        {	"-1",	"-1",	"-1"	}
    };
    
    boolean ReglasSemanticasAsignacion[][]={
        {	true,	false,	false	},
        {	true,	true,	false	},
        {	false,	false,	true	}
    };
   
    Stack<String> pilaSemantica = new Stack<>();    
    Stack<Character> pilaOperadores = new Stack<>(); 
    
    boolean errores, yaDefinida;
    String primero;
    public boolean AnalisisExpresion(ArrayList<String> tablaSimbolosArray, String expresion){        
        
        errores=false;
        yaDefinida=false;        
        pilaSemantica.clear();        
        String cadRecorrido="";
        String cadRecorridoOpradores="";
        
        // Primer push en la pila (variable a la que se asigna el valor)
        for(String tabla: tablaSimbolosArray){                                 
            if((expresion.split("=")[0]+"").equals((tabla.split("#")[0]+"")))
            {
                pilaSemantica.push(tabla.split("#")[1]);
                yaDefinida=true;
            }
        }        
        cadRecorrido+= mostrarPila(pilaSemantica);        
        mostrarPila(pilaSemantica);
                
        char[] expresionSeparada= expresion.split("=")[0].toCharArray();
        
        
        
        
        for(int i = 0; i<expresionSeparada.length; i++){
            
            if(expresionSeparada[i]=='(')
                pilaOperadores.push(expresionSeparada[i]);
                
            if(pilaOperadores.isEmpty() || pilaOperadores.peek()=='('){
                if(operador(expresionSeparada[i]))
                    pilaOperadores.push(expresionSeparada[i]);
            } else {
                if(operador(expresionSeparada[i]) && pilaOperadores.peek()!='('){
                    if(mayorPrioridad(pilaOperadores.peek(), expresionSeparada[i])){
                        while(mayorPrioridad(pilaOperadores.peek(), expresionSeparada[i])){                            
                            pilaOperadores.pop();                            
                            cadRecorridoOpradores+= mostrarPilaChar(pilaOperadores);
                        }
                    } else {
                        pilaOperadores.push(expresionSeparada[i]);
                    }
                }
            }
            System.out.println("aquui");
            cadRecorridoOpradores+= mostrarPilaChar(pilaOperadores);
            
            
            
        }
                
        
        
        return yaDefinida&&!errores;
    }
    
    
    
    private boolean operador(char op){        
        return op=='+' || op=='-' || op=='*' || op=='/';
    }
    
    private boolean mayorPrioridad(char operador1, char operador2){
        int prioridad1 = obtenerPrioridad(operador1);
        int prioridad2 = obtenerPrioridad(operador2);

        return prioridad1 >= prioridad2;
    }
    
        private static int obtenerPrioridad(char operador) {
            switch (operador) {
                case '+':
                case '-':
                    return 1;
                case '*':
                case '/':
                    return 2;
                case '(':
                    return 3;
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operador);
            }
        }
    
        private String mostrarPila(Stack<String> pila){
            String cadena="";
            if(pila.isEmpty())
                System.out.println("Pila Vacia");
            else
                for(int i=0; i<pila.size(); i++) {
                    cadena+=pila.get(i);
                    System.out.print(pila.get(i)); 
                }
            System.out.println("");               
            return cadena;
        }
           
            private String mostrarPilaChar(Stack<Character> pila){
            String cadena="";
            if(pila.isEmpty())
                System.out.println("Pila Vacia Char");
            else
                for(int i=0; i<pila.size(); i++) {
                    cadena+=pila.get(i);
                    System.out.print(pila.get(i)); 
                }
            System.out.println("");               
            return cadena;
        }
    
}
