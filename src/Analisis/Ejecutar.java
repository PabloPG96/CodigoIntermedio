/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisis;
import static Analisis.Tokens.ID;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
/**
 *
 * @author pablo
 */
//public class Ejecutar {
//    public static void main(String[] args) {
//        Stack<String> tablaSimbolos = new Stack<>();
//        
//        Sintactico sin = new Sintactico();
//        try {
//            // Crear un ArrayList para almacenar los tokens
//            ArrayList<String> tokens = new ArrayList<>();
//
//            // Pedir al usuario que introduzca una cadena
//            Scanner scanner = new Scanner(System.in);
//            System.out.println("Introduce una cadena para analizar:");
//            String input = scanner.nextLine();
//
//            // Crear un Reader a partir de la cadena introducida por el usuario
//            Reader reader = new StringReader(input);
//
//            // Instancia el analizador léxico
//            Lexer lexer = new Lexer(reader);
//
//            // Procesar los tokens y agregarlos al ArrayList
//            Tokens token;
//            while ((token = lexer.yylex()) != null) {
//                switch (token) {
//                    case ID:
//                        
//                    switch (tokens.getLast()) {
//                        case "int":
//                            
//                            break;
//                        case "float":
//                            break;
//                        case "char":
//                            break;
//                        default:
//                            break;
//                    }
//                            
//                        tokens.add("id");
//                        
//                        break;
//
//                    case NUM:
//                        tokens.add("num");
//                        break;
//                    case ENTERO:
//                        tokens.add("int");
//                        break;
//                    case FLOTANTE:
//                        tokens.add("float");
//                        break;
//                    case CHAR:
//                        tokens.add("char");
//                        break;
//                    case COMA:
//                        tokens.add(",");
//                        break;
//                    case TOCOM:
//                        tokens.add(";");
//                        break;
//                    case MAS:
//                        tokens.add("+");
//                        break;
//                    case MENOS:
//                        tokens.add("-");
//                        break;
//                    case ASTERISCO:
//                        tokens.add("*");
//                        break;
//                    case DIAGONAL:
//                        tokens.add("/");
//                        break;
//                    case ABRIR_PARENT:
//                        tokens.add("(");
//                        break;
//                    case CERRAR_PARENT:
//                        tokens.add(")");
//                        break;
//                    case IGUAL:
//                        tokens.add("=");
//                        break;
//                    case ERROR:
//                        tokens.add("error");
//                        break;
//                    default:
//                        tokens.add("desconocido");
//                        break;
//                }
//            }
//
//            // Imprimir los tokens almacenados en el ArrayList
//            System.out.println("Tokens reconocidos:");
//            for (String t : tokens) {
//                System.out.println(t);
//            }
//            
//            sin.Analizar(tokens);
//            if(sin.isValida())
//                System.out.println("Cadena Valida");
//            else
//                System.out.println("Cadena NO Valida");
//            
//        } catch (IOException e) {
//        }
//    }
//}


//-----------------------------------------------------------------------------------------

public class Ejecutar {
    public static void main(String[] args) {
        ArrayList<String> tablaSimbolosArray = new ArrayList<>(); // Tabla de símbolos
        String tipoActual = ""; // Tipo de dato actual
        boolean enDeclaracion = false; // Bandera para indicar si estamos en una declaración

        Sintactico sin = new Sintactico();
        try {
            // Crear un ArrayList para almacenar los tokens
            ArrayList<String> tokens = new ArrayList<>();
            // Pedir al usuario que introduzca una cadena
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce una cadena para analizar:");
            String input = scanner.nextLine();
            // Crear un Reader a partir de la cadena introducida por el usuario
            Reader reader = new StringReader(input);
            // Instancia el analizador léxico
            Lexer lexer = new Lexer(reader);
            // Procesar los tokens y agregarlos al ArrayList
            Tokens token;
            while ((token = lexer.yylex()) != null) {
                switch (token) {
                    case ENTERO:
                        tipoActual = "0";
                        enDeclaracion = true; // Inicia declaración
                        tokens.add("int#");
                        break;
                    case FLOTANTE:
                        tipoActual = "1";
                        enDeclaracion = true; // Inicia declaración
                        tokens.add("float");
                        break;
                    case CHAR:
                        tipoActual = "2";
                        enDeclaracion = true; // Inicia declaración
                        tokens.add("char");
                        break;
                    case ID:
                        String nombreVar = lexer.yytext(); // Nombre de la variable
                        String tipoValor = "desconocido"; // Tipo de valor (se define después)

                        // Verificar si ya está definida en la tabla de símbolos
                        boolean yaDefinida = false;
                        for (String entrada : tablaSimbolosArray) {
                            if (entrada.startsWith(nombreVar + "#")) {
                                yaDefinida = true;
                                break;
                            }
                        }

                        // Solo agregar a la tabla de símbolos si estamos en una declaración y no está ya definida
                        if (enDeclaracion && !yaDefinida) {
                            String entradaTabla = nombreVar + "#" + tipoActual;
                            tablaSimbolosArray.add(entradaTabla);
                        } else if (yaDefinida && enDeclaracion) {
                            System.out.println("Error: La variable '" + nombreVar + "' ya ha sido declarada.");
                            System.exit(0);
                        } else
                            for (String entrada : tablaSimbolosArray) {
                                if (entrada.startsWith(nombreVar + "#")) {
                                    yaDefinida = true;
                                    break;
                                }
                            }
                        
                        tokens.add("id#numPag#"+nombreVar);
                        break;
                    case TOCOM: // Punto y coma indica el final de una declaración
                        enDeclaracion = false;
                        tipoActual = ""; // Restablece el tipo actual
                        tokens.add(";");
                        break;
                    case NUM:
                        tokens.add("num#numPag#"+lexer.yytext());
                        break;
                    case COMA:
                        tokens.add(",");
                        break;
                    case MAS:
                        tokens.add("+");
                        break;
                    case MENOS:
                        tokens.add("-");
                        break;
                    case ASTERISCO:
                        tokens.add("*");
                        break;
                    case DIAGONAL:
                        tokens.add("/");
                        break;
                    case ABRIR_PARENT:
                        tokens.add("(");
                        break;
                    case CERRAR_PARENT:
                        tokens.add(")");
                        break;
                    case IGUAL:
                        tokens.add("=");
                        break;
                    case ERROR:
                        tokens.add("error");
                        break;
                    default:
                        tokens.add("desconocido");
                        break;
                }
            }

            // Imprimir los tokens almacenados en el ArrayList
            System.out.println("Tokens reconocidos:");
            for (String t : tokens) {
                System.out.println(t.split("#")[0]);
            }
            
            // Imprimir la tabla de símbolos
            System.out.println("Tabla de Símbolos:");
            for (String entrada : tablaSimbolosArray) {
                System.out.println(entrada);
            }
            
            sin.Analizar(tokens, tablaSimbolosArray);
            if (sin.isValida())
                System.out.println("Cadena Válida");
            else
                System.out.println("Cadena NO Válida");
            
            System.out.println("\nCodigo  intermedio:\n"+sin.codigoIntermedio);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

