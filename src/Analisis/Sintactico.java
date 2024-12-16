/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Analisis;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author pabloOriginal
 */
public class Sintactico {
    boolean valida=false, nohayerror=true, expresion=false;
    Stack<String> principal = new Stack<>();
    String columnas[]= {	"id",	"num",	"int",	"float",	"char",	",",	";",	"+",	"-",	"*",	"/",	"(",	")",	"$",	"P",	"Tipo",	"V",	"A",	"S",	"E",	"T",	"F",	"="	};
    String filas[]=
            {
            "I0",
            "I1",
            "I2",
            "I3",
            "I4",
            "I5",
            "I6",
            "I7",
            "I8",
            "I9",
            "I10",
            "I11",
            "I12",
            "I13",
            "I14",
            "I15",
            "I16",
            "I17",
            "I18",
            "I19",
            "I20",
            "I21",
            "I22",
            "I23",
            "I24",
            "I25",
            "I26",
            "I27",
            "I28",
            "I29",
            "I30",
            "I31",
            "I32",
            "I33",
            "I34",
            "I35",
            "I36",
            "I37"
            };
    String acciones[][]= 
            {
                {	"I7",	"",	"I4",	"I5",	"I6",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I1",	"I2",	"",	"I3",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P0",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I8",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P2",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"P3",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"P4",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"P5",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I9"	},
                {	"",	"",	"",	"",	"",	"I11",	"I12",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I10",	"",	"",	"",	"",	"",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"I14",	"I15",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"I13",	"I16",	"I17",	"I18",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P1",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I22",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I7",	"",	"I4",	"I5",	"I6",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I23",	"I2",	"",	"I3",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"I24",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"I25",	"I17",	"I18",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"I26",	"I17",	"I18",	""	},
                {	"",	"",	"",	"",	"",	"",	"P11",	"I27",	"I28",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P14",	"P14",	"P14",	"I29",	"I30",	"",	"P14",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P17",	"P17",	"P17",	"P17",	"P17",	"",	"P17",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"I31",	"I17",	"I18",	""	},
                {	"",	"",	"",	"",	"",	"",	"P19",	"P19",	"P19",	"P19",	"P19",	"",	"P19",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P20",	"P20",	"P20",	"P20",	"P20",	"",	"P20",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"I11",	"I12",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I32",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P7",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P8",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P9",	"I27",	"I28",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P10",	"I27",	"I28",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"",	"I33",	"I18",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"",	"I34",	"I18",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I35",	""	},
                {	"I20",	"I21",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I19",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"I36",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"I27",	"I28",	"",	"",	"",	"I37",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"",	"P6",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P12",	"P12",	"P12",	"I29",	"I30",	"",	"P12",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P13",	"P13",	"P13",	"I29",	"I30",	"",	"P13",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P15",	"P15",	"P15",	"P15",	"P15",	"",	"P15",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P16",	"P16",	"P16",	"P16",	"P16",	"",	"P16",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	},
                {	"",	"",	"",	"",	"",	"",	"P18",	"P18",	"P18",	"P18",	"P18",	"",	"P18",	"",	"",	"",	"",	"",	"",	"",	"",	"",	""	}
            };
    
    String producciones[][]={
        {	"P0",	"P'>P"	},
        {	"P1",	"P>Tipo_id_V"	},
        {	"P2",	"P>A"	},
        {	"P3",	"Tipo>int"	},
        {	"P4",	"Tipo>float"	},
        {	"P5",	"Tipo>char"	},
        {	"P6",	"V>,_id_V"	},
        {	"P7",	"V>;_P"	},
        {	"P8",	"A>id_=_S_;"	},
        {	"P9",	"S>+_E"	},
        {	"P10",	"S>-_E"	},
        {	"P11",	"S>E"	},
        {	"P12",	"E>E_+_T"	},
        {	"P13",	"E>E_-_T"	},
        {	"P14",	"E>T"	},
        {	"P15",	"T>T_*_F"	},
        {	"P16",	"T>T_/_F"	},
        {	"P17",	"T>F"	},
        {	"P18",	"F>(_E_)"	},
        {	"P19",	"F>id"	},
        {	"P20",	"F>num"	}
    };    
    
    
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
    Stack<String> pilaOperadores = new Stack<>();
    String codigoIntermedio="";
    Stack<String> pilaVariables = new Stack<>();
    String ocupado[] = {"desocupado","desocupado","desocupado","desocupado","desocupado","desocupado","desocupado","desocupado","desocupado"};
    int cont;
    
    
    public String Analizar(ArrayList<String> tokens, ArrayList<String> tablaSimbolosArray){
        System.out.println("\nAnalisis.Sintactico.Analizar() \n");
        valida=false;
        nohayerror=true;
        expresion=false;
        principal.clear();
        principal.push("$");
        principal.push("I0"); 
        tokens.add("$");
        int columna, fila;
        String cadRecorrido="";
        cadRecorrido+= mostrarPila(principal);
        
        String cadRecorridoSemantico="";
        String cadRecorridoOperadores="";
        String cimaPila, cimaPilaAnt, id="", num="", idAsignacion="", tipoDato="";
        codigoIntermedio="";
        
        for(int i=0, tam=tokens.size(); i<tam; i++)
        {
            boolean encontrado=false;                        
            do{
                if((tokens.get(i)).split("#")[0].equals("$") && principal.peek().equals("I1")){
                    valida=true;
                    break;
                }
                
                
//                if((tokens.get(i)).split("#")[0].equals(";"))
//                {
//                    expresion=false;
//                }
                

                //Verificar el fin de la expresion
                if((tokens.get(i)).split("#")[0].equals(";") && principal.peek().equals("I13")){
                    cimaPilaAnt = pilaSemantica.pop();
                    cimaPila = pilaSemantica.pop();
                    if(!ReglasSemanticasAsignacion[Integer.parseInt(cimaPila)][Integer.parseInt(cimaPilaAnt)]){
                        System.out.println("Variable: " + idAsignacion +", no coincide con el dato asignado");
                        System.exit(0);
                    }                        
                    cadRecorridoSemantico+= mostrarPila(pilaSemantica);
                    codigoIntermedio+=idAsignacion+" = "+"V1"+";\n";
                    expresion=false;                    
                }        
                //FIN de verificar el fin de la expresion

                //Verificar el inicio de una expresion
                if((tokens.get(i)).split("#")[0].equals("id") && principal.peek().equals("I12")){
                    idAsignacion=(tokens.get(i)).split("#")[2];
                    
                                boolean yaDefinida=false;

                                for(String tabla: tablaSimbolosArray){                                 
                                    if(idAsignacion.equals((tabla.split("#")[0]+"")))
                                    {
                                        pilaSemantica.push(tabla.split("#")[1]);
                                        yaDefinida=true;
                                        
                                        if(tabla.split("#")[1].equals("0")){
                                            codigoIntermedio+=" int V1;\n int V2;\n int V3;\n int V4;\n int V5;\n";
                                        } else if(tabla.split("#")[1].equals("1")){
                                            codigoIntermedio+=" float V1;\n float V2;\n float V3;\n float V4;\n float V5;\n";
                                        } else if(tabla.split("#")[1].equals("2")){
                                            codigoIntermedio+=" char V1;\n";
                                        }
                                    }
                                }
                                if(!yaDefinida){
                                    System.out.println("Variable: " + idAsignacion +", no definida");
                                    System.exit(0);
                                }                    
                                cadRecorridoSemantico+= mostrarPila(pilaSemantica);
                                
                                
                    cont=1;            
                    expresion=true;                    
                }
                //FIN de verificar el inicio de una expresion
                
                
                
                //System.out.println(" - "+ i);  

                if(fil(principal.peek())==-1){
                    //ahrita vemos
                }

                fila = fil(principal.peek());
                columna = col((tokens.get(i)).split("#")[0]);
                
                
                //System.out.println("Con: " + (tokens.get(i)).split("#")[0]+"\n");            
//                System.out.println((tokens.get(i)).split("#")[0]+"  - "+fila+" ."+ columna);            
                if(acciones[fila][columna].isEmpty()){
                    nohayerror=false;
                    System.out.println("Error()");
                    System.exit(0);
                    break;
                }

                if(acciones[fila][columna].startsWith("I")){
                    principal.push((tokens.get(i)).split("#")[0]);
                    principal.push(acciones[fila][columna]);
                    encontrado=true;
                    cadRecorrido+= mostrarPila(principal);
                    
                    //Inicio Pila de Operadores
                    if(expresion && operador((tokens.get(i)).split("#")[0])){
                        
                        if(pilaOperadores.isEmpty() || pilaOperadores.peek().equals("(")){
                            pilaOperadores.push((tokens.get(i)).split("#")[0]);
                        } else if(mayorPrioridad(pilaOperadores.peek(), (tokens.get(i)).split("#")[0])){
                            boolean seguir=true;
                            //mostrarPila(pilaOperadores);
                            do{
                                
                                    pilaOperadores.pop();
                                    cadRecorridoOperadores+= mostrarPila(pilaOperadores);
                                    
                                    if(!pilaOperadores.isEmpty() && !pilaOperadores.peek().equals("("))
                                        if(mayorPrioridad(pilaOperadores.peek(), (tokens.get(i)).split("#")[0])){
                                            seguir=true;
                                        } else {
                                            seguir=false;
                                        }  
                                    if(pilaOperadores.isEmpty() || pilaOperadores.peek().equals("("))
                                        seguir=false;
                                    
                            }while(seguir);
                            pilaOperadores.push((tokens.get(i)).split("#")[0]);
                            
                        } else
                            pilaOperadores.push((tokens.get(i)).split("#")[0]);
                        
                        cadRecorridoOperadores+= mostrarPila(pilaOperadores);
                    }
                    
                    if(expresion && (tokens.get(i)).split("#")[0].equals("(")){
                        pilaOperadores.push((tokens.get(i)).split("#")[0]);
                        
                        cadRecorridoOperadores+= mostrarPila(pilaOperadores);
                    }
                    
                    if(expresion && (tokens.get(i)).split("#")[0].equals(")")){
                        String op;
                        do{
                            op=pilaOperadores.pop();
                        }while(!op.equals("("));
                        
                        cadRecorridoOperadores+= mostrarPila(pilaOperadores);
                    }
                    //Fin pila de operadores
                    
                    
                    //Inicio Codigo intermedio 1
                    if(acciones[fila][columna].equals("I8") && (tokens.get(i)).split("#")[0].equals("id")){
                        codigoIntermedio+=(tokens.get(i)).split("#")[2]+";\n";
                        //System.out.println("Entramos a la primer variable");
                    }
                    if(acciones[fila][columna].equals("I22") && (tokens.get(i)).split("#")[0].equals("id")){
                        codigoIntermedio+=tipoDato + (tokens.get(i)).split("#")[2]+";\n";
                        //System.out.println("Entramos a las demas variable");
                    }
                    //Fin Codigo intermedio 1
                }

                if(acciones[fila][columna].startsWith("P")){
                    for(int j=0; j<producciones.length;j++)
                        if(acciones[fila][columna].equals(producciones[j][0])){
                            int pops=2*(producciones[j][1].split(">")[1].split("_").length);                        
                            for(int k=0; k<pops;k++){
                                principal.pop();
                                
                            }                                
                            int filaP = fil(principal.peek());
                            int columnaP = col(producciones[j][1].split(">")[0]);
                            principal.push(producciones[j][1].split(">")[0]);
                            principal.push(acciones[filaP][columnaP]);
                            cadRecorrido+= mostrarPila(principal)  + "     "+ (tokens.get(i)).split("#")[0] +"\n";
                            
                            
                            //InicioSemantico
                            if(expresion && acciones[fila][columna].equals("P19")){
                                boolean yaDefinida=false;

                                for(String tabla: tablaSimbolosArray){                                 
                                    if(id.equals((tabla.split("#")[0]+"")))
                                    {
                                        pilaSemantica.push(tabla.split("#")[1]);
                                        yaDefinida=true;
                                    }
                                }
                                if(!yaDefinida){
                                    System.out.println("Variable: " + id +", no definida");
                                    System.exit(0);
                                }                    
                                cadRecorridoSemantico+= mostrarPila(pilaSemantica);
                                //cadRecorridoOperadores+= mostrarPila(pilaOperadores);

                                
                                //Codigo Intermedio
                                codigoIntermedio+="V"+(cont)+" = "+id+";\n";
                                cont+=1;
                            }   
                            
                            if(expresion && acciones[fila][columna].equals("P20")){
                                pilaSemantica.push("0");                    
                                cadRecorridoSemantico+= mostrarPila(pilaSemantica);
                                //cadRecorridoOperadores+= mostrarPila(pilaOperadores);
                                
                                //Codigo Intermedio
                                codigoIntermedio+="V"+(cont)+" = "+num+";\n";
                                cont+=1;
                            }
                            
                            //SEMANTICO
                            if(expresion && (acciones[fila][columna].equals("P12") || acciones[fila][columna].equals("P13") || acciones[fila][columna].equals("P15") || acciones[fila][columna].equals("P16"))){
                                cimaPilaAnt = pilaSemantica.pop();
                                cimaPila = pilaSemantica.pop();
                                if(mapeoSemantico[Integer.parseInt(cimaPila)][Integer.parseInt(cimaPilaAnt)].equals("-1")){
                                    System.out.println("Variable: " + idAsignacion +", no coincide con el dato asignado");
                                    System.exit(0);
                                }
                                pilaSemantica.push(mapeoSemantico[Integer.parseInt(cimaPila)][Integer.parseInt(cimaPilaAnt)]);
                                cadRecorridoSemantico+= mostrarPila(pilaSemantica);
                                
                                //Codigointermedio
                                switch (acciones[fila][columna]) {
                                    case "P12":
                                        cont-=1;
                                        codigoIntermedio+="V"+(cont-1)+" = "+"V"+(cont-1)+" + "+"V"+(cont)+";\n";
                                        break;
                                    case "P13":
                                        cont-=1;
                                        codigoIntermedio+="V"+(cont-1)+" = "+"V"+(cont-1)+" - "+"V"+(cont)+";\n";
                                        break;
                                    case "P15":
                                        cont-=1;
                                        codigoIntermedio+="V"+(cont-1)+" = "+"V"+(cont-1)+" * "+"V"+(cont)+";\n";
                                        break;
                                    case "P16":
                                        cont-=1;
                                        codigoIntermedio+="V"+(cont-1)+" = "+"V"+(cont-1)+" / "+"V"+(cont)+";\n";
                                        break;
                                }
                            }
                            
                            if(expresion && (acciones[fila][columna].equals("P9") || acciones[fila][columna].equals("P10"))){
                                switch (acciones[fila][columna]) {
                                    case "P9":
                                        codigoIntermedio+="V1 = +V1;\n";
                                        break;
                                    case "P10":
                                        codigoIntermedio+="V1 = -V1;\n";
                                        break;
                                    default:
                                        throw new AssertionError();
                                }                                
                            } 
                            //FIn Intermwdio
                            //FinSemantica
                            
                            
                                       
                            //Inicio Codigo Intermedio 2
                            if(acciones[fila][columna].equals("P3")|| acciones[fila][columna].equals("P4") || acciones[fila][columna].equals("P5")){
                                switch (acciones[fila][columna]) {
                                    case "P3":
                                        codigoIntermedio+="int ";
                                        tipoDato="int ";
                                        break;
                                    case "P4":
                                        codigoIntermedio+="float ";
                                        tipoDato="float ";
                                        break;
                                    case "P5":
                                        codigoIntermedio+="char ";
                                        tipoDato="char ";
                                        break;
                                    default:
                                        throw new AssertionError();
                                }
                                //System.out.println("Entramos a tipos de dato");
                            }
                            
                            
                            //Fin codigo intermedio 2
                            
                            break;
                        }
                }
                
                //Guardar el nombre del ultimo id de la expresion
                if(expresion && (tokens.get(i)).split("#")[0].equals("id")){                    
                    id = (tokens.get(i)).split("#")[2];
                }                                                
                if(expresion && (tokens.get(i)).split("#")[0].equals("num")){                    
                    num = (tokens.get(i)).split("#")[2];
                }
                               
                    
                    
            }while(!encontrado);
        }               
        return cadRecorrido;
    }
    
    
    
    private int col(String car){
        for(int i=0; i<columnas.length;i++)
            if(columnas[i].equals(car))
                return i;        
        return -1;
    }
    
    private int fil(String car){
        for(int i=0; i<filas.length;i++)
            if(filas[i].equals(car))
                return i;        
        return -1;
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

    public boolean isValida() {
        return (valida && nohayerror);
    }
    
    
    
    
    
    private boolean operador(String op){        
        return op=="+" || op=="-" || op=="*" || op=="/";
    }
    
    private boolean mayorPrioridad(String operador1, String operador2){
        int prioridad1 = obtenerPrioridad(operador1);
        int prioridad2 = obtenerPrioridad(operador2);

        return prioridad1 >= prioridad2;
    }
    
        private static int obtenerPrioridad(String operador) {
            switch (operador) {
                case "+":
                case "-":
                    return 1;
                case "*":
                case "/":
                    return 2;
                default:
                    throw new IllegalArgumentException("Operador no válido: " + operador);
            }
        }
}
