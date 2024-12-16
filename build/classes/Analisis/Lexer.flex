package Analisis;
import java.io.*;
import static Analisis.Tokens.*;

%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+|(([0-9]+[.]?[0-9]*)|([.][0-9]+))(e[+-]?[0-9]+)?
espacio=[ ]+
%{
    public String lexeme;
    Informacion c=new Informacion();
%}
%%

{espacio} {/*Ignore*/}
<YYINITIAL> "int" {c.linea=yyline; lexeme = yytext(); return ENTERO;}
<YYINITIAL> "float" {c.linea=yyline; lexeme = yytext(); return FLOTANTE;}
<YYINITIAL> "char" {c.linea=yyline; lexeme = yytext(); return CHAR;}
<YYINITIAL> {L}({L}{D})* {c.linea=yyline; lexeme = yytext(); return ID;}
<YYINITIAL> "+" {c.linea=yyline; lexeme = yytext(); return MAS;}
<YYINITIAL> "-" {c.linea=yyline; lexeme = yytext(); return MENOS;}
<YYINITIAL> {D} {c.linea=yyline; lexeme = yytext(); return NUM;}
<YYINITIAL> "," {c.linea=yyline; lexeme = yytext(); return COMA;}
<YYINITIAL> ";" {c.linea=yyline; lexeme = yytext(); return TOCOM;}
<YYINITIAL> "*" {c.linea=yyline; lexeme = yytext(); return ASTERISCO;}
<YYINITIAL> "/" {c.linea=yyline; lexeme = yytext(); return DIAGONAL;}
<YYINITIAL> "(" {c.linea=yyline; lexeme = yytext(); return ABRIR_PARENT;}
<YYINITIAL> ")" {c.linea=yyline; lexeme = yytext(); return CERRAR_PARENT;}
<YYINITIAL> "=" {c.linea=yyline; lexeme = yytext(); return IGUAL;}
. {c.linea=yyline; lexeme = yytext(); return ERROR;}