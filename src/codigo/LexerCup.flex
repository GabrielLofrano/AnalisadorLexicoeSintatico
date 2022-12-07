package codigo;
import java_cup.runtime.Symbol;
%%
%class LexerCup
%type java_cup.runtime.Symbol
%cup
%full
%line
%char
L=[a-zA-Z_]+
D=[0-9]+
P = [^0-9a-zA-Z\n\t ]?
espaco=[ ]+
espacoString=[ ,\\t,\\r,\\n]+
quebraLinhaString=[\t,\r,\n]+
barraN=[\n]+
barraT=[\t]+
barraR=[\r]+
%{
    private Symbol symbol(int type, Object value){
        return new Symbol(type, yyline, yycolumn, value);
    }
    private Symbol symbol(int type){
        return new Symbol(type, yyline, yycolumn);
    }
%}
%%
{espaco} {/*Ignore*/}
"//".* {/*Ignore*/}
"\n" {/*Ignore*/}
"#" {return new Symbol(sym.Hash, yychar, yyline, yytext());}
"include" {return new Symbol(sym.Include, yychar, yyline, yytext());}
"define" {return new Symbol(sym.Const, yychar, yyline, yytext());}
"int" {return new Symbol(sym.Inteiro, yychar, yyline, yytext());}
"double" {return new Symbol(sym.Double, yychar, yyline, yytext());}
"char" {return new Symbol(sym.Caractere, yychar, yyline, yytext());}
"float" {return new Symbol(sym.Float, yychar, yyline, yytext());}
"if" {return new Symbol(sym.Se, yychar, yyline, yytext());}
"else" {return new Symbol(sym.Senao, yychar, yyline, yytext());}
"scanf" {return new Symbol(sym.Ler, yychar, yyline, yytext());}
"printf" {return new Symbol(sym.Imprimir, yychar, yyline, yytext());}
"main" {return new Symbol(sym.Principal, yychar, yyline, yytext());}
"return" {return new Symbol(sym.Retorna, yychar, yyline, yytext());}
"<stdio.h>" {return new Symbol(sym.Lib, yychar, yyline, yytext());}
"while" {return new Symbol(sym.Enquanto, yychar, yyline, yytext());}
"++" {return new Symbol(sym.MaisMais, yychar, yyline, yytext());}
"--" {return new Symbol(sym.MenosMenos, yychar, yyline, yytext());}
"for" {return new Symbol(sym.Para, yychar, yyline, yytext());}
"&&" {return new Symbol(sym.Uniao, yychar, yyline, yytext());}
"||" {return new Symbol(sym.Ou, yychar, yyline, yytext());}
"==" {return new Symbol(sym.Equivalente, yychar, yyline, yytext());}
"=" {return new Symbol(sym.Igual, yychar, yyline, yytext());}
"(" {return new Symbol(sym.AbreP, yychar, yyline, yytext());}
")" {return new Symbol(sym.FechaP, yychar, yyline, yytext());}
"[" {return new Symbol(sym.AbreCO, yychar, yyline, yytext());}
"]" {return new Symbol(sym.FechaCO, yychar, yyline, yytext());}
"{" {return new Symbol(sym.AbreCH, yychar, yyline, yytext());}
"}" {return new Symbol(sym.FechaCH, yychar, yyline, yytext());}
"+" {return new Symbol(sym.Mais, yychar, yyline, yytext());}
"-" {return new Symbol(sym.Menos, yychar, yyline, yytext());}
"<" {return new Symbol(sym.Menor, yychar, yyline, yytext());}
">" {return new Symbol(sym.Maior, yychar, yyline, yytext());}
"%" {return new Symbol(sym.Porcentagem, yychar, yyline, yytext());}
"*" {return new Symbol(sym.Multiplicacao, yychar, yyline, yytext());}
"/" {return new Symbol(sym.Divisao, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.Diferente, yychar, yyline, yytext());}
">=" {return new Symbol(sym.MaiorIgual, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.MenorIgual, yychar, yyline, yytext());}
"," {return new Symbol(sym.Virgula, yychar, yyline, yytext());}
";" {return new Symbol(sym.Pv, yychar, yyline, yytext());}
{L}({L}|{D})* {return new Symbol(sym.Id, yychar, yyline, yytext());}
("(-"{D}+")")|{D}+ {return new Symbol(sym.Numero, yychar, yyline, yytext());}
(\"   ({espacoString} | {P} | {L} | {D})+ \") {return new Symbol(sym.Literal, yychar, yyline, yytext());}

