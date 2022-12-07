/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package codigo;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author gabri
 */
public class Principal {
    public static void main(String[] args) throws Exception{
        String rota1 = "C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/Lexer.flex";
        String rota2 = "C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/LexerCup.flex";
        String[] rotaS = {"-parser", "Sintax", "C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/Sintax.cup"};
         gerar(rota1, rota2, rotaS);
        
    }
    public static void gerar(String rota1, String rota2, String[] rotaS) throws IOException, Exception{
        File arquivo;
        arquivo = new File(rota1);
        JFlex.Main.generate(arquivo);
        arquivo = new File(rota2);
        JFlex.Main.generate(arquivo);
        java_cup.Main.main(rotaS);
        
        Path rotaSym = Paths.get("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/sym.java");
        if (Files.exists (rotaSym)) {
        Files.delete(rotaSym);
        
        }
        Files.move(
                Paths.get ("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/sym.java"),
                Paths.get ("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/sym.java")
        );
        
        Path rotaSin = Paths.get("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/Sintax.java");
        if (Files.exists (rotaSin)) {
            Files.delete(rotaSin);
        
        }
        
        Files.move(
                Paths.get ("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/Sintax.java"),
                Paths.get ("C:/Users/gabri/OneDrive/Documentos/NetBeansProjects/Analisadores-Lexico-e-Sintatico/src/codigo/Sintax.java")
        );
        
        
    }
}
