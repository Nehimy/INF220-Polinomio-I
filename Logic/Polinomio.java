//https://es.stackoverflow.com/questions/9146/arreglos-din%C3%A1micos-en-metodosjava

package Logic;
import java.util.Scanner;
//import java.utils.Arrays.copyOf;
//import java.util.Arrays;
import java.util.*;

public class Polinomio{
  double[] V_Coef;
  int[] V_Exp;
  int dim;


  //constructor
  public Polinomio(){
    dim = -1;
    V_Exp = new int [5];
    V_Coef = new double [5];
    
  }
  
  /*------Operaciones auxiliares--------*/
  public void Redimensionar(){
    if(dim+1 == V_Coef.length){
      double aux1[] = new double[V_Coef.length+1];
      int aux2[] = new int [V_Coef.length+1];
    
      System.arraycopy(V_Coef,0,aux1,0,dim+1);
      System.arraycopy(V_Exp,0,aux2,0,dim+1);
    
      V_Coef = aux1;
      V_Exp = aux2;
    }
  }
  
  public boolean Pertenece(char signo){
    String auxSigno = Character.toString(signo);
    
    if(auxSigno.matches("[-+]")){
      return true;
    }else{
      return false;
    }
    
  }
  
  //Retorna todo el polinomio concatenado
  public String ObtenerTodo(){
    String cadena = "";
    int contador = 0;
    while(contador <= dim){
      if (V_Coef[contador]<0){
        cadena = cadena + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]) + " ";
        contador++;
      }else{
        cadena = cadena + "+" + String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]) + " ";
        contador++;
      }
        
    }
    return cadena;
  }
  
  //Preguntar si el coeficiente es 0 retorna falso
  public boolean SiCoeficienteEsCero(double coeficiente){
    if(coeficiente == 0){
        return true;
      }else{
        return false;
      }
  }
  
  //Si un monomio del vector es mayor que uno nuevo retornar la posicion del monomio en el vector
  public int BuscarPosicion(int exponente){
    int i = dim;
    while(i > -1 && exponente >= V_Exp[i]){
      i--;
    }
    i++;
    return i;    
  }
  
  //Insertar monomio en una posicion astras
  public void InsertarEn(int position, double coeficiente, int exponente){
    Redimensionar();
    int i = dim;
    while(i > position){
      i--;
      V_Coef[i+1] = V_Coef[i];
      V_Exp[i+1] = V_Exp[i];
    }
    V_Coef[position] = coeficiente;
    V_Exp[position] = exponente;
  }
  
  /*------------------------------------*/
  
  //Insertar monomio
  public void Insertar(char signo, double coeficiente, int exponente){
   
    if(!SiCoeficienteEsCero(coeficiente) && Pertenece(signo)){
      if(signo == '-'){
         coeficiente = - coeficiente;
      }
      
      if(dim == -1 ){
        dim++;
        V_Coef[dim] = coeficiente;
        V_Exp[dim] = exponente;
      } else {
        int position = BuscarPosicion(exponente);
        if(V_Exp[position] == exponente){
          V_Coef[position] = V_Coef[position] + coeficiente;
        }else{
          dim++;
          InsertarEn(position,coeficiente, exponente);
        }
        
      }
      
    }
  
  }
}
