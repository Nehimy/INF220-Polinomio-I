//https://es.stackoverflow.com/questions/9146/arreglos-din%C3%A1micos-en-metodosjava

package Logic;
import java.util.Scanner;
//import java.utils.Arrays.copyOf;
import java.util.Arrays;
//import java.util.*;

public class Polinomio{
  double[] V_Coef;
  //double V_Coef[];
  int[] V_Exp;
  //double V_Coef[];
  //int V_Exp[];
  int dim;


  //constructor
  public Polinomio(){
    dim = -1;
    //int [] V_Coef = {};
    //int [] V_Exp = {};
    //V_Coef = new double [1];
    //V_Exp = new int [1];
    V_Exp = new int [1];
    V_Coef = new double [1];
    
  }
  /*------Operaciones auxiliares--------*/
  public void Redimencionar(){
    System.out.println("Redi");
    System.out.println(Integer.toString(dim+1));
    if(dim+1 == V_Coef.length){
      double aux1[] = new double[dim+1];
      int aux2[] = new int [dim+1];
    
      System.arraycopy(V_Coef,0,aux1,0,dim+1);
      System.arraycopy(V_Exp,0,aux2,0,dim+1);
    
      V_Exp = new int [aux1.length + 5];
      V_Coef = new double [aux2.length + 5];
    }
    System.out.println(Integer.toString(V_Coef.length));
    
    /*aux1 = new Monomio[P.length];
    System.arraycopy(P, 0, aux1, 0, P.length);
    P = new Monomio[aux1.length + 10];
    System.arraycopy(aux1, 0, P, 0, aux1.length);*/
  
    //V_Coef = (int[])resizeArray(V_Coef,2);
    //V_Exp = (int[])resizeArray(V_Exp,2);
    //dim = dim +1;
    //V_Coef = V_Coef[dim];
    //V_Exp = V_Exp[dim];
    /*V_Exp = new int [5];
    V_Coef = new double [5];*/
    
  }
  
  public boolean Pertenece(char caracter){
    String auxCadena = Character.toString(caracter);
    return auxCadena.matches("[-+]");
  }
  
  public String ObtenerTodo(){
    String cadena = "";
    int contador = 0;
    while(contador<=dim && V_Coef[contador] !=0){
      System.out.println("entro en obtener todo");
      System.out.println(String.valueOf(V_Coef[contador]));
      System.out.println(Integer.toString(V_Exp[contador]));
      cadena = cadena + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]);
      contador++;
    }
    return cadena;
  }
  /*------------------------------------*/
  
  //Insertar monomio
  public void Insertar(char signo, double coeficiente, int exponente){
  
    if(Pertenece(signo)){
      if(signo == '-'){
         coeficiente = - coeficiente;
      }
      
      if(coeficiente == 0){
        System.out.println("Error: coeficiente es igual a cero");
      }else{
        if(dim == -1){
          dim++;
          V_Coef[dim] = coeficiente;
          V_Exp[dim] = exponente;
        }
      }
    }
  
  }
}
