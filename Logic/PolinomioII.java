package Logic;
import Logic.Polinomio;
import java.util.Scanner;
import java.util.*;

public class PolinomioII{
  private Polinomio p = new Polinomio();
  Polinomio[] A;
  Polinomio[] B;
  int dim_A;
  int dim_B;
  
  //constructor
  public PolinomioII(){
    dim_A = -1;
    dim_B = -1;
    A = new Polinomio [5];
    B = new Polinomio [5];
  }
  
  /*----------------------*/
  public void RedimensionarA(){
    if(dim_A+1 == A.length){
      Polinomio aux1[] = new Polinomio[A.length+1];   
      System.arraycopy(A,0,aux1,0,dim_A+1);
      A = aux1;
    }
  }
  /*---------------------*/
  public void InsertarPolinomio_A(char signo, double coeficiente, int exponente){
    RedimensionarA();
    A = p.Insertar(signo,coeficiente,exponente);
    System.out.println("Insertar polinomio A");
  }
  
  
  
}
