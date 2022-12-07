/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package codigo;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringReader;
import java.nio.file.Files;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;
import javax.swing.JFileChooser;
import jdk.nashorn.internal.parser.Token;

/**
 *
 * @author gabri
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void analisarlexico() throws IOException{
        int cont = 1;
        String expr = (String) txtresultado.getText();
        Lexer lexer = new Lexer (new StringReader(expr));
        String resultado = "LINHA" + cont + "\t\tSIMBOLO\n";
        
        while(true){
        
        Tokens token = lexer.yylex();
        
        if (token == null){
            txtAnalisarLex.setText(resultado);
            return;
        }
        
        switch (token) {
               case Linha:
                    cont++;
                    resultado += "Linha " + cont + "\n";
                    break;
               case Hash:
                    resultado += "  <#>\t\t" + lexer.lexeme + "\n";
                    break; 
               case Include:
                    resultado += "  <Includes>\t\t" + lexer.lexeme + "\n";
                    break; 
               case Const:
                    resultado += "  <Define>\t\t" + lexer.lexeme + "\n";
                    break; 
               case Inteiro:
                    resultado += "  <Inteiro>\t\t" + lexer.lexeme + "\n";
                    break;       
               case Double:
                    resultado += "  <Double>\t\t" + lexer.lexeme + "\n";
                    break;       
               case Caractere:
                    resultado += "  <Char>\t\t" + lexer.lexeme + "\n";
                    break;  
               case Float:
                    resultado += "  <Float>\t\t" + lexer.lexeme + "\n";
                    break; 
               case Ler:
                    resultado += "  <Scanf>\t\t" + lexer.lexeme + "\n";
                    break;
               case Imprimir:
                    resultado += "  <Printf>\t\t" + lexer.lexeme + "\n";
                    break;
               case Retorna:
                    resultado += "  <Return>\t\t" + lexer.lexeme + "\n";
                    break;
               case Lib:
                    resultado += "  <stdio.h>\t\t" + lexer.lexeme + "\n";
                    break;
               case Uniao:
                    resultado += "  <&&>\t\t" + lexer.lexeme + "\n";
                    break;
               case Ou:
                    resultado += "  <||>\t\t" + lexer.lexeme + "\n";
                    break;
               case Equivalente:
                    resultado += "  <==>\t\t" + lexer.lexeme + "\n";
                    break;
               case Underline:
                    resultado += "  <_>\t\t" + lexer.lexeme + "\n";
                    break;
               case MaisMais:
                    resultado += "  <++>\t\t" + lexer.lexeme + "\n";
                    break;
               case MenosMenos:
                    resultado += "   <–>\t\t" + lexer.lexeme + "\n";
                    break;
               case AspasS:
                    resultado += "  <Aspas simples>\t\t" + lexer.lexeme + "\n";
                    break;
               case Exclamacao:
                    resultado += "  <!>\t\t" + lexer.lexeme + "\n";
                    break;
               case Porcentagem:
                    resultado += "  <%>\t\t" + lexer.lexeme + "\n";
                    break;
               case Menor:
                    resultado += "  <<>\t\t" + lexer.lexeme + "\n";
                    break;
               case Maior:
                    resultado += "  <>>\t\t" + lexer.lexeme + "\n";
                    break;
               case QuebraL:
                    resultado += "  <\\n>\t\t" + lexer.lexeme + "\n";
                    break;
               case QuebraC:
                    resultado += "  <\\t>\t\t" + lexer.lexeme + "\n";
                    break;
               case Diferente:
                    resultado += "  <!=s>\t\t" + lexer.lexeme + "\n";
                    break;
               case MaiorIgual:
                    resultado += "  <>=>\t\t" + lexer.lexeme + "\n";
                    break;
               case MenorIgual:
                    resultado += "  <<=>\t\t" + lexer.lexeme + "\n";
                    break;
               case Ponto:
                    resultado += "  <.>\t\t" + lexer.lexeme + "\n";
                    break;
               case Virgula:
                    resultado += "  <,>\t\t" + lexer.lexeme + "\n";
                    break;
               case Comercial:
                    resultado += "  <&>\t\t" + lexer.lexeme + "\n";
                    break;
               case Id:
                    resultado += "  <id>\t\t" + lexer.lexeme + "\n";
                    break;
               case AspasD:
                    resultado += "  <Aspas duplas>\t\t" + lexer.lexeme + "\n";
                    break;       
                case Se:
                    resultado += "  <Reservada if>\t" + lexer.lexeme + "\n";
                    break;
                case SeNao:
                    resultado += "  <Reservada else>\t" + lexer.lexeme + "\n";
                    break;
                case Enquanto:
                    resultado += "  <Reservada while>\t" + lexer.lexeme + "\n";
                    break;
                case Para:
                    resultado += "  <Reservada for>\t" + lexer.lexeme + "\n";
                    break;
                case Igual:
                    resultado += "  <Operador igual>\t" + lexer.lexeme + "\n";
                    break;
                case Mais:
                    resultado += "  <Operador soma>\t" + lexer.lexeme + "\n";
                    break;
                case Menos:
                    resultado += "  <Operador menos>\t" + lexer.lexeme + "\n";
                    break;
                case Multiplicacao:
                    resultado += "  <Operador multiplicacao>\t" + lexer.lexeme + "\n";
                    break;
                case Divisao:
                    resultado += "  <Operador divisao>\t" + lexer.lexeme + "\n";
                    break;
                case AbreP:
                    resultado += "  <Abre parenteses>\t" + lexer.lexeme + "\n";
                    break;
                case FechaP:
                    resultado += "  <Fecha Parenteses>\t" + lexer.lexeme + "\n";
                    break;
                case AbreCH:
                    resultado += "  <Abre chaves>\t" + lexer.lexeme + "\n";
                    break;
                case FechaCH:
                    resultado += "  <Fecha Chaves>\t" + lexer.lexeme + "\n";
                    break;
                case AbreCO:
                    resultado += "  <Abre colchetes>\t" + lexer.lexeme + "\n";
                    break;
                case FechaCO:
                    resultado += "  <Fecha colchetes>\t" + lexer.lexeme + "\n";
                    break;
                case Principal:
                    resultado += "  <Reservada main>\t" + lexer.lexeme + "\n";
                    break;
                case Pv:
                    resultado += "  <Ponto e virgula>\t" + lexer.lexeme + "\n";
                    break;
                case Literal:
                    resultado += "  <Literal>\t\t" + lexer.lexeme + "\n";
                    break;
                case Numero:
                    resultado += "  <Numero>\t\t" + lexer.lexeme + "\n";
                    break;
                case ERROR:
                    resultado += "  <Simbolo nao definido>\n";
                    break;
                default:
                    resultado += "  < " + lexer.lexeme + " >\n";
                    break;  

            
            
        }
        
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnArquivo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtresultado = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAnalisarSin = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtAnalisarLex = new javax.swing.JTextArea();
        btnAnalisarLex = new javax.swing.JButton();
        btnLimparSin = new javax.swing.JButton();
        btnAnalisarSin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnLimparLex = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnArquivo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnArquivo.setText("Abrir arquivo");
        btnArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArquivoActionPerformed(evt);
            }
        });

        txtresultado.setColumns(20);
        txtresultado.setRows(5);
        jScrollPane1.setViewportView(txtresultado);

        txtAnalisarSin.setColumns(20);
        txtAnalisarSin.setRows(5);
        jScrollPane2.setViewportView(txtAnalisarSin);

        txtAnalisarLex.setColumns(20);
        txtAnalisarLex.setRows(5);
        jScrollPane3.setViewportView(txtAnalisarLex);

        btnAnalisarLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalisarLex.setText("Analisar");
        btnAnalisarLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarLexActionPerformed(evt);
            }
        });

        btnLimparSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimparSin.setText("Limpar");
        btnLimparSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparSinActionPerformed(evt);
            }
        });

        btnAnalisarSin.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAnalisarSin.setText("Analisar");
        btnAnalisarSin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnalisarSinActionPerformed(evt);
            }
        });

        btnLimparLex.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnLimparLex.setText("Limpar");
        btnLimparLex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparLexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btnAnalisarSin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnLimparSin))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnArquivo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 367, Short.MAX_VALUE)
                                .addComponent(btnAnalisarLex)
                                .addGap(146, 146, 146)
                                .addComponent(btnLimparLex)))))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(193, 193, 193)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(535, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 378, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(9, 9, 9)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnArquivo)
                    .addComponent(btnAnalisarLex)
                    .addComponent(btnLimparLex))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 495, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimparSin)
                    .addComponent(btnAnalisarSin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(69, 69, 69)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 485, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(277, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArquivoActionPerformed
        // TODO add your handling code here:
        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File arquivo = new File(chooser.getSelectedFile().getAbsolutePath());
        
        try {
            String ST = new String(Files.readAllBytes(arquivo.toPath()));
            txtresultado.setText(ST);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnArquivoActionPerformed

    private void btnLimparSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparSinActionPerformed
        // TODO add your handling code here:
        txtAnalisarSin.setText(null);
    }//GEN-LAST:event_btnLimparSinActionPerformed

    private void btnAnalisarSinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarSinActionPerformed
        // TODO add your handling code here:\
        String ST = txtresultado.getText();
        Sintax s = new Sintax(new codigo.LexerCup(new StringReader(ST)));
        
        try {
            s.parse();
            txtAnalisarSin.setText("Analise realizada corretamente");
            txtAnalisarSin.setForeground(new Color(25, 111, 61));
        } catch (Exception ex) {
            Symbol sym = s.getS();
            txtAnalisarSin.setText("Erro de sintaxe. Linha: " + (sym.right + 1) + " Coluna: " + (sym.left + 1) + ", Texto: \"" + sym.value + "\"");
            txtAnalisarSin.setForeground(Color.red);
        }

    }//GEN-LAST:event_btnAnalisarSinActionPerformed

    private void btnLimparLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparLexActionPerformed
        // TODO add your handling code here:
         txtAnalisarLex.setText(null);
    }//GEN-LAST:event_btnLimparLexActionPerformed

    private void btnAnalisarLexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnalisarLexActionPerformed
        try {
            // TODO add your handling code here:
            analisarlexico();
        } catch (IOException ex) {
            Logger.getLogger(FrmPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btnAnalisarLexActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnalisarLex;
    private javax.swing.JButton btnAnalisarSin;
    private javax.swing.JButton btnArquivo;
    private javax.swing.JButton btnLimparLex;
    private javax.swing.JButton btnLimparSin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea txtAnalisarLex;
    private javax.swing.JTextArea txtAnalisarSin;
    private javax.swing.JTextArea txtresultado;
    // End of variables declaration//GEN-END:variables
}
