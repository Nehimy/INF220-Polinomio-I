/*
Enlaces de referencia:
  - https://www.smartick.es/blog/matematicas/algebra/sumas-polinomios/
  - http://www.sc.ehu.es/sbweb/fisica/cursoJava/fundamentos/introduccion/primero.htm
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
  private JFrame ventana;
  private JTextField SignoTxt;
  private JTextField CoefTxt;
  private JTextField ExpTxt;
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
    
    //Declarando caja de Coeficiente
    SignoTxt = new JTextField("        ");
    Border bordeSigno = BorderFactory.createLineBorder(Color.pink, 2);
    SignoTxt.setBorder(bordeSigno);
    
    CoefTxt = new JTextField("        ");
    Border bordeCoef = BorderFactory.createLineBorder(Color.pink, 2);
    CoefTxt.setBorder(bordeCoef);
    
    ExpTxt = new JTextField("       ");
    Border bordeExp = BorderFactory.createLineBorder(Color.pink, 2);
    ExpTxt.setBorder(bordeExp);
    
    //Declaramos botón Sumar
    SumarBoton = new JButton("Suma");
    SumarBoton.setBackground(Color.pink);
    
    //Declaramos los labels
    
    labelSigno= new JLabel("Signo");
    labelSigno.setFont(new Font("Arial", 0, 18));
    
    labelCoef= new JLabel("Coeficiente");
    labelCoef.setFont(new Font("Arial", 0, 18));
    
    labelExp = new JLabel("Exponente");
    labelExp.setFont(new Font("Arial", 0, 18));
    
    //Objeto de configuración del grid
    GridBagConstraints gridConf = new GridBagConstraints();
    gridConf.fill = GridBagConstraints.HORIZONTAL;
    
    /*-------------------------------*/
    /* Adherir elementos a la ventana*/
    /*-------------------------------*/
    
    //Confi de pocicion SignoTxt
    gridConf.gridx = 2;
    gridConf.gridy = 0;
    gridConf.ipady = 20;
    gridConf.ipadx = 15;
    gridConf.insets = new Insets(0,0,3,3); //padding
    gridConf.gridwidth = 2;
    
    //Añadir SignoTxt a la ventana
    ventana.add(SignoTxt, gridConf);
    
    //Confi de pocicion CoefTxt
    gridConf.gridx = 2;
    gridConf.gridy = 1;
    gridConf.insets = new Insets(0,0,3,3); //padding
    gridConf.gridwidth = 2;
    
    //Añadir CoefTxt a la ventana
    ventana.add(CoefTxt, gridConf);
    
    //Confi de pocicion ExpTxt
    gridConf.gridx = 2;
    gridConf.gridy = 2;
    gridConf.insets = new Insets(0,0,0,0);
    
    //Añadir ExpTxt a la ventana
    ventana.add(ExpTxt, gridConf);
    
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
      //gridConf.insets = new Insets(0,0,0,0); //padding
      //gridConf.gridwidth = 2;
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
    System.out.println("the button is pressed");
    char s = JOptionPane.showInputDialog(ventana, "Ingresa un caracter: ").charAt(0);
    double c = Double.parseDouble(JOptionPane.showInputDialog(ventana, "Ingresa un caracter: "));
    int e = Integer.parseInt(JOptionPane.showInputDialog(ventana, "Ingresa un caracter: "));
    poli.Insertar(s,c,e);
    
  }
    
	
  
}
