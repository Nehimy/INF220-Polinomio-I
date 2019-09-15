package Logic;
import java.util.Scanner;

public class Polinomio{
  double V_Coef[];
  int V_Exp[];
  int dim;
  
  //constructor
  public Polinomio(){
    dim = -1;
    V_Coef = new double [10];
    V_Exp = new int [10];
    
  }
  ///Operaciones auxiliares
  public void Redimencionar(){
    V_Coef = new double[15];
    V_Exp = new int [15];
  }
  ///
  
  //Insertar monomio
  public void Insertar(char signo, float coeficiente, int exponente){
    
    if(coeficiente == 0){
        System.out.println("Error: coeficiente es igual a cero");
    }else{
      if(signo == '-'){
        coeficiente = - coeficiente;
        if(dim == -1){
          dim++;
          V_Coef[dim] = coeficiente;
          V_Exp[dim] = exponente;
          System.out.println(V_Coef[dim]);
          System.out.println(exponente);
        }
      }else{
        int i=0;
        while ((i <= dim)&&(V_Exp[i] > exponente)){
          i++;
        }
        if(i <= dim){
          if( exponente != V_Exp[i]){
            //redimencionar();
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
