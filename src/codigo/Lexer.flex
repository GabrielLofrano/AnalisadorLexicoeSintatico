package codigo;
import static codigo.Tokens.*;
%%
%class Lexer
%type Tokens
L=[a-zA-Z_]+
D=[0-9]+
P = [^0-9a-zA-Z\n\t ]?
espaco=[ ]+
espacoString=[ ,\\t,\\n]+
quebraLinhaString=[\t,\n]+
barraN=[\n]+
barraT=[\t]+
%{
    public String lexeme;
%}
%%
{espaco} {/*Ignore*/}
"//".* {/*Ignore*/}
( "\n" ) {return Linha;}
"#" {return Hash;}
"include" {lexeme=yytext();return Include;}
"define" {lexeme=yytext();return Const;}
"int" {lexeme=yytext();return Inteiro;}
"double" {lexeme=yytext();return Double;}
"char" {lexeme=yytext();return Caractere;}
"float" {lexeme=yytext();return Float;}
"if" {lexeme=yytext();return Se;}
"else" {lexeme=yytext();return SeNao;}
"scanf" {lexeme=yytext();return Ler;}
"printf" {lexeme=yytext();return Imprimir;}
"main" {lexeme=yytext();return Principal;}
"return" {lexeme=yytext();return Retorna;}
"<stdio.h>" {lexeme=yytext();return Lib;}
"while" {lexeme=yytext();return Enquanto;}
"++" {lexeme=yytext();return MaisMais;}
"--" {lexeme=yytext();return MenosMenos;}
"for" {lexeme=yytext();return Para;}
"&&" {lexeme=yytext();return Uniao;}
"||" {lexeme=yytext();return Ou;}
"==" {lexeme=yytext();return Equivalente;}
"=" {lexeme=yytext();return Igual;}
"(" {lexeme=yytext();return AbreP;}
")" {lexeme=yytext();return FechaP;}
"[" {lexeme=yytext();return AbreCO;}
"]" {lexeme=yytext();return FechaCO;}
"{" {lexeme=yytext();return AbreCH;}
"}" {lexeme=yytext();return FechaCH;}
"+" {lexeme=yytext();return Mais;}
"-" {lexeme=yytext();return Menos;}
"<" {lexeme=yytext();return Menor;}
">" {lexeme=yytext();return Maior;}
"%" {lexeme=yytext();return Porcentagem;}
"*" {lexeme=yytext();return Multiplicacao;}
"/" {lexeme=yytext();return Divisao;}
"!=" {lexeme=yytext();return Diferente;}
">=" {lexeme=yytext();return MaiorIgual;}
"<=" {lexeme=yytext();return MenorIgual;}
"," {lexeme=yytext();return Virgula;}
";" {lexeme=yytext();return Pv;}
"/" {lexeme=yytext();return Divisao;}
{L}({L}|{D})* {lexeme=yytext(); return Id;}
("(-"{D}+")")|{D}+ {lexeme=yytext(); return Numero;}
(\"   ({espacoString} | {P} | {L} | {D})+ \")+ {lexeme=yytext(); return Literal;}


