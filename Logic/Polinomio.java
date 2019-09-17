package Logic;
import java.util.Scanner;

public class Polinomio{
  double V_Coef[];
  int V_Exp[];
  int dim;
  //int dimFinal;
  //constructor
  public Polinomio(){
    dim = -1;
    dim= 10;
    V_Coef = new double [dim];
    V_Exp = new int [dim];
    //V_Coef = new double [10];
    //V_Exp = new int [10];
    
  }
  /*------Operaciones auxiliares--------*/
  public void Redimencionar(){
    V_Coef = new double[dim+5];
    V_Exp = new int [dim+5];
  }
  
  public boolean Pertenece(char caracter){
    String auxCadena = Character.toString(caracter);
    return auxCadena.matches("[-+]");
  }
  
  public String ObtenerTodo(){
    String cadena = "";
    int contador = 0;
    while(contador<=dim){
      cadena = String.valueOf(V_Coef[contador]) + "x" + "^" + Integer.toString(V_Exp[contador]);
      contador++;
    }
    return cadena;
  }
  /*------------------------------------*/
  
  //Insertar monomio
  public void Insertar(char signo, double coeficiente, int exponente){
  
    if(Pertenece(signo)){
      if(coeficiente == 0){
          System.out.println("Error: coeficiente es igual a cero");
      }else{
        if(signo == '-'){
          coeficiente = - coeficiente;
        }
        if(dim == -1){
            dim++;
            V_Coef[dim] = coeficiente;
            V_Exp[dim] = exponente;
            System.out.println(V_Coef[dim]);
            System.out.println(exponente);
        }else{
          int i=0;
          while ((i <= dim)&&(V_Exp[i] > exponente)){
            i++;
          }
          if(i <= dim){
            if( exponente != V_Exp[i]){
              Redimencionar();
              for(int aux=dim; aux > 1; aux--){
                V_Coef[aux+1] = V_Coef[aux];
                V_Exp[aux+1] = V_Exp[aux];
              }
              V_Coef[i] = coeficiente;
              V_Exp[i] = exponente;
              dim++;
            }else{
              double Suma = coeficiente + V_Coef[i];
              if (Suma == 0){
                for (int aux2 = i; aux2 < dim; aux2++){
                  V_Coef[aux2] = V_Coef[aux2 + 1];
                  V_Exp[aux2] = V_Exp[aux2+1];
                }
                dim--;
              }else{
                V_Coef[i] = Suma;
              }
            }
          }
        }
      }
    }
  
  }
}
