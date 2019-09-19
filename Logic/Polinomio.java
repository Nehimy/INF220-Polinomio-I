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
    V_Exp = new int [5];
    V_Coef = new double [5];
    
  }
  /*------Operaciones auxiliares--------*/
  public void Redimencionar(){
    System.out.println("Redi");
    System.out.println(Integer.toString(dim));
    
    if(dim+1 == V_Coef.length){
      double aux1[] = new double[V_Coef.length+1];
      int aux2[] = new int [V_Coef.length+1];
    
      System.arraycopy(V_Coef,0,aux1,0,dim+1);
      System.arraycopy(V_Exp,0,aux2,0,dim+1);
    
      V_Exp = new int [aux1.length + 5];
      V_Coef = new double [aux2.length + 5];
    }
    System.out.println(Integer.toString(V_Coef.length));
    
  }
  
  public boolean Pertenece(char caracter){
    String auxCadena = Character.toString(caracter);
    return auxCadena.matches("[-+]");
  }
  
  public String ObtenerTodo(){
    String cadena = "";
    int contador = 0;
    while(contador <= V_Coef.length-1){
      System.out.println("entro en obtener todo");
      System.out.println(String.valueOf(V_Coef[contador]));
      System.out.println(Integer.toString(V_Exp[contador]));
      cadena = cadena + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]) + " ";
      contador++;
    }
    return cadena;
  }
  
  //preguntar si el coeficiente es 0 retorna falso
  public boolean SiCoeficienteEsCero(double coeficiente){
    if(coeficiente == 0){
        System.out.println("Error: coeficiente es igual a cero");
        return false;
      }else{
        return true;
      }
  }
  
  //si un monomio del vector es mayor que uno nuevo retornar la pocicion del monomio en el vector
  public int MonomioMayor(int exponente){
    int i = V_Coef.length-1;
    int aux = -1;
    while(i>=0){
      if(exponente < V_Exp[i]){
        aux = i;
        i=-1;
      }
      i--;
    }
    if(aux>-1){
      System.out.println("aux");
      return aux;
      
    }else{
      System.out.println("i455");
      return i;
    }
    
  }
  /*------------------------------------*/
  
  //Insertar monomio
  public void Insertar(char signo, double coeficiente, int exponente){
  
    if(Pertenece(signo)){
      if(signo == '-'){
         coeficiente = - coeficiente;
      }
      
      if(SiCoeficienteEsCero(coeficiente) && dim == -1 ){
        dim++;
        System.out.println("adim");
        System.out.println(Integer.toString(dim));
        V_Coef[dim] = coeficiente;
        V_Exp[dim] = exponente;
      }
      
      if(SiCoeficienteEsCero(coeficiente) && dim > -1){
        System.out.println("dim");
        System.out.println(Integer.toString(dim));
        int mono = MonomioMayor(exponente);
        System.out.println("merwerwhjhgfdasghjhfdsoo");
        System.out.println(Integer.toString(mono));
        
        if(mono == dim){
          Redimencionar();
          //int i = dim;
          System.out.println("irrre");
          //System.out.println(Integer.toString(i));
          System.out.println("medfww333oo");
          System.out.println(Integer.toString(mono));
          /*while(i>=mono){
            V_Coef[i+1] = V_Coef[i];
            V_Exp[i+1] = V_Exp[i];
            i--;
          }*/
          V_Coef[dim+1] = coeficiente;
          V_Exp[dim+1] = exponente;
          System.out.println("a");
          //System.out.println(Integer.toString(V_Exp[i+1]));
          dim++;
        }
      }
      
    }
  
  }
}
