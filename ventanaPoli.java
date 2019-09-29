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


public class ventanaPoli{
  //Atributos
  private Polinomio poli = new Polinomio();
  private Polinomio A = new Polinomio();
  private Polinomio B = new Polinomio(); 
  private Polinomio C = new Polinomio();
  private Polinomio D = new Polinomio();
  
  private JFrame ventana;
  private JTextField SignoTxt;
  private JTextField CoefTxt;
  private JTextField ExpTxt;
  private JTextField ResultadoTxt;
  
  private JButton Insertar;
  private JButton InsertarEn_A;
  private JButton InsertarEn_B;
  private JButton Sumar_AyB;
  private JButton Multiplicar_AyB;
  
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
    Insertar = new JButton("Insertar");
    Insertar.setBackground(Color.pink);
    
    //Declaramos botón Insertar en A
    InsertarEn_A = new JButton("Insert in A");
    InsertarEn_A.setBackground(Color.pink);

     //Declaramos botón Insertar en B
     InsertarEn_B = new JButton("Insert in B");  
     InsertarEn_B.setBackground(Color.pink); 
     
     //Declaramos botón Sumar_AyB
     Sumar_AyB = new JButton("Sumar");
     Sumar_AyB.setBackground(Color.pink);
     
     //Declaramos botón Multiplicar_AyB
     Multiplicar_AyB = new JButton("Multiplicar");
     Multiplicar_AyB.setBackground(Color.pink);
        
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

    
    //Añadir SignoTxt a la ventana
    ventana.add(SignoTxt, gridConf);
    
    //Confi de pocicion CoefTxt
    gridConf.gridx = 2;
    gridConf.gridy = 1;
    gridConf.insets = new Insets(0,0,3,3); //padding

    
    //Añadir CoefTxt a la ventana
    ventana.add(CoefTxt, gridConf);
    
    //Confi de pocicion ExpTxt
    gridConf.gridx = 2;
    gridConf.gridy = 2;
    
    gridConf.insets = new Insets(0,0,3,3);

    
    //Añadir ExpTxt a la ventana
    ventana.add(ExpTxt, gridConf);
    
    //Confi de pocicion ResultadoTxt
    gridConf.gridx = 0;
    gridConf.gridy = 4; 
    gridConf.ipady = 20;
    gridConf.ipadx = 15;
    gridConf.insets = new Insets(0,0,0,0);
    
    //Añadir ResultadoTxt a la ventana
    ventana.add(ResultadoTxt, gridConf);
    
    //Confi de Insertar 
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 1;
    gridConf.insets = new Insets(10,10,10,10);
      
    //Ayadir Insertar en la ventana
    gridConf.gridx = 0;
    gridConf.gridy = 3;
    ventana.add(Insertar, gridConf);
    
    //Confi de InsertarEn_A en la ventana
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 2;
    gridConf.insets = new Insets(10,10,10,10);
    
    //Ayadir InsertarEn_A en la ventana
    gridConf.gridx = 1;
    gridConf.gridy = 3;
    ventana.add(InsertarEn_A, gridConf);
    
    //Confi de InsertarEn_B
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 3;
    gridConf.insets = new Insets(10,10,10,10);
    
    //Ayadir InsertarEn_B en la ventana
    gridConf.gridx = 3;
    gridConf.gridy = 3;
    ventana.add(InsertarEn_B, gridConf);
    
    //Confi de Sumar_AyB
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 4;
    gridConf.insets = new Insets(10,10,10,10);
    
    //Ayadir Sumar_AyB en la ventana
    gridConf.gridx = 3;
    gridConf.gridy = 4;
    ventana.add(Sumar_AyB, gridConf);
      
    //Confi de Multiplicar_AyB
    gridConf.ipady = 20;
    gridConf.ipadx = 20;
    gridConf.gridwidth = 6;
    gridConf.insets = new Insets(10,10,10,10);
    
    //Ayadir Multiplicar_AyB en la ventana
    gridConf.gridx = 3;
    gridConf.gridy = 5;
    ventana.add(Multiplicar_AyB, gridConf);  
      
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
      
    //onclick Insertar
    Insertar.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        InsertarClick();
      }
    });
    
    //onclick Insertar en A
    InsertarEn_A.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        InsertarEn_AClick();
      }
    });
    
    //onclick Insertar en B
    InsertarEn_B.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        InsertarEn_BClick();
      }
    }); 
    
    //onclick Sumar_AyB
    Sumar_AyB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Sumar_AyBClick();
      }
    });
    
    //onclick Multiplicar_AyB
    Multiplicar_AyB.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        Multiplicar_AyBClick();
      }
    });
      
    /*------------------------*/
    //ventanaM.pack();
    ventana.setVisible(true);//Configurando visualización de la ventana
    /*------------------------*/
  }
  
  public void InsertarClick(){
    
    char signo = SignoTxt.getText().charAt(0);
    
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    
    
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
    
	public void InsertarEn_AClick(){
	
	  char signo = SignoTxt.getText().charAt(0);
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    int exponente = Integer.parseInt(ExpTxt.getText());
	  A.Insertar(signo,coeficiente,exponente);
	  ResultadoTxt.setText(A.ObtenerTodo());
	}
 
  public void InsertarEn_BClick(){
  
    char signo = SignoTxt.getText().charAt(0);
    double coeficiente = Double.parseDouble(CoefTxt.getText());
    int exponente = Integer.parseInt(ExpTxt.getText());
	  B.Insertar(signo,coeficiente,exponente);
	  ResultadoTxt.setText(B.ObtenerTodo());
  }
 
  public void Sumar_AyBClick(){
   C.Sumar(A,B);
   ResultadoTxt.setText(C.ObtenerTodo());
  }
 
  public void Multiplicar_AyBClick(){
    D.Multiplicar(A,B);
    ResultadoTxt.setText(D.ObtenerTodo());
  }
  
}
