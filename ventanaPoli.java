/*
Enlaces de referencia:
  - https://www.smartick.es/blog/matematicas/algebra/sumas-polinomios/
  - http://www.sc.ehu.es/sbweb/fisica/cursoJava/fundamentos/introduccion/primero.htm
  - http://chuwiki.chuidiang.org/index.php?title=Ejemplos_con_JTextField
  - http://www.chuidiang.org/java/ejemplos/JFormattedTextField/EjemplosJFormattedTextField.php
  - http://www.chuidiang.org/java/ejemplos/JFormattedTextField/EjemplosJFormattedTextField.php
  - https://es.stackoverflow.com/questions/1487/guia-definitiva-de-conversi%C3%B3n-de-tipos-en-java
*/

import Logic.Polinomio;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.border.Border;
import javax.swing.JOptionPane;
//import javax.swing.JFormattedTextField;
//import java.lang.Integer;
//import javax.swing.text.MaskFormatter;

public class ventanaPoli{
  //Atributos
  private Polinomio poli = new Polinomio();
  private JFrame ventana;
  private JTextField SignoTxt;
  private JTextField CoefTxt;
  private JTextField ExpTxt;
  private JTextField ResultadoTxt;
  //private JFormattedTextField ExpTxt;
  private JButton SumarBoton;
  private JLabel labelSigno;
  private JLabel labelCoef;
  private JLabel labelExp;
  
  //Clase pincipal
  public static void main(String[] args){  
    new ventanaPoli();
  }
  
  //Constructor de ventanaPoli
  public ventanaPoli(){
  
    //Variablede tipo JFrame    
    ventana = new JFrame("ventanita");
    ventana.setSize(550,550);
    ventana.getContentPane().setBackground(Color.white);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);/*Finaliza el programa*/
    ventana.setLayout(new GridBagLayout());  
    
    //Declarando todas las cajas de texto
    SignoTxt = new JTextField("");
    Border bordeSigno = BorderFactory.createLineBorder(Color.pink, 2);
    SignoTxt.setBorder(bordeSigno);
    
    CoefTxt = new JTextField("");
    Border bordeCoef = BorderFactory.createLineBorder(Color.pink, 2);
    CoefTxt.setBorder(bordeCoef);
    
    ExpTxt = new JTextField("");
    Border bordeExp = BorderFactory.createLineBorder(Color.pink, 2);
    ExpTxt.setBorder(bordeExp);
    
    ResultadoTxt = new JTextField("");
    Border bordeResultado = BorderFactory.createLineBorder(Color.pink, 2);
    ResultadoTxt.setBorder(bordeResultado);
    
    //Declaramos botón Insertar
    SumarBoton = new JButton("Insertar");
    SumarBoton.setBackground(Color.pink);
    
    //Declaramos todos los labels
    
    labelSigno= new JLabel("Signo");
    labelSigno.setFont(new Font("Arial", 0, 18));
    
    labelCoef= new JLabel("Coeficiente");
    labelCoef.setFont(new Font("Arial", 0, 18));
    
    labelExp = new JLabel("Exponente");
    labelExp.setFont(new Font("Arial", 0, 18));
    
    /*Objeto de configuración del grid*/
    GridBagConstraints gridConf = new GridBagConstraints();
    gridConf.fill = GridBagConstraints.HORIZONTAL;
    
    /*-------------------------------*/
    /* Adherir elementos a la ventana*/
    /*-------------------------------*/
    
    //Confi de pocicion SignoTxt
    gridConf.gridx = 2;
    gridConf.gridy = 0;
    gridConf.ipady = 20;
    gridConf.ipadx = 50;
    gridConf.insets = new Insets(0,0,3,3); //padding
    //gridConf.gridwidth = 2;
    
    //Añadir SignoTxt a la ventana
    ventana.add(SignoTxt, gridConf);
    
    //Confi de pocicion CoefTxt
    gridConf.gridx = 2;
    gridConf.gridy = 1;
    gridConf.insets = new Insets(0,0,3,3); //padding
    //gridConf.gridwidth = 2;
    
    //Añadir CoefTxt a la ventana
    ventana.add(CoefTxt, gridConf);
    
    //Confi de pocicion ExpTxt
    gridConf.gridx = 2;
    gridConf.gridy = 2;
    
    gridConf.insets = new Insets(0,0,3,3);
    //gridConf.gridwidth = 2;
    
    //Añadir ExpTxt a la ventana
    ventana.add(ExpTxt, gridConf);
    
    //Confi de pocicion ResultadoTxt
    gridConf.gridx = 0;
    gridConf.gridy = 4; 
    gridConf.ipady = 20;
    gridConf.ipadx = 15;
    //gridConf.gridwidth = 1;
    gridConf.insets = new Insets(0,0,0,0);
    
    //Añadir ResultadoTxt a la ventana
    ventana.add(ResultadoTxt, gridConf);
    
    //Confi de los SumaBoton
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 1;
    gridConf.insets = new Insets(10,10,10,10);
      
    //Ayadir SumaBoton a la ventana
    gridConf.gridx = 0;
    gridConf.gridy = 3;
    ventana.add(SumarBoton, gridConf);
      
    //Añadir labels a la ventana
      gridConf.gridx = 0;
      gridConf.gridy = 0;
      gridConf.ipady = 20;
      gridConf.ipadx = 15;
      ventana.add(labelSigno, gridConf); 
      
      gridConf.gridy = 1;
      ventana.add(labelCoef, gridConf);
      
      gridConf.gridy = 2;
      ventana.add(labelExp, gridConf);
      
    //onclick SumaBoton
    SumarBoton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        SumaClick();
      }
    });
      
    /*------------------------*/
    //ventanaM.pack();
    ventana.setVisible(true);//Configurando visualización de la ventana
    /*------------------------*/
  }
  
  public void SumaClick(){
    //System.out.println("the button is pressed"); 
    char signo = SignoTxt.getText().charAt(0);
    
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    
    //System.out.println(ExpTxt.getText());
    int exponente = Integer.parseInt(ExpTxt.getText());
    
    //Insgresar monomio
    poli.Insertar(signo,coeficiente,exponente);
    
    //Mostrar polinomio en la ventana 
    ResultadoTxt.setText(poli.ObtenerTodo());
    
    //Limpiar todas las cajas de texto
    //SignoTxt.setText("");
    //CoefTxt.setText("");
    //ExpTxt.setText("");
    
    
    
  }
    
	
  
}
