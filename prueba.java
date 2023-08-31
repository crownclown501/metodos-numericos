package MetodosNumericos.tarea1;

import java.util.Scanner;
// vamos a probar nuestro codigo de metodo de biseccion 
public class prueba {
    double a;// esta variable la podemos ingresar una vez ejecutado el codigo en caso de querer asignarle una seria cambiar la parte de la interfaz en el main
    double b;
    double TOL;//tolerance
    static int N0;//maximum number of itarations
    static int i = 1;
    public static double f(double n) //esta funcion sirve para que ingresemos nuestra funcion y de ahi el programa sepa calcular las funciones
    {
        return n-(Math.cos(n));
    }
    
    public static double metodo_de_biseccion(double a,double b,double TOL,int N0){ //mandamos a llamar los datos que se ingresan en el main
        //double array[] = new double[N0];//guarda los datos en el arreglo que entren en el while 
        double FA = f(a);
        while (i<=N0 )
        {
            double p = Math.abs(a+(b-a)/2);
                double FP = f(p);
                if (FP == 0 || (b - a)/2 < TOL) 
                {
                    System.out.println("Procedure completed succesfully");
                    System.out.println("Num of iteration: " + i);
                    return p;
                }
            i+=1;
            if (FA*FP > 0)
            {
                a = p;
                FA = FP;
            }
            else{
                b=p;
            }
        }
        System.out.println("Method failed after N0 iterations, N0 = "+ N0);
        return Double.NaN;
    }

   public static void main(String[] args) {
        Scanner input = new Scanner (System.in); //los datos los podemos modificar mientras no excedamos un limite 
        double a1 = input.nextDouble();
        double b1 = input.nextDouble();
        double tol = 0.0005;
        int it= 100;
        double resultado = metodo_de_biseccion(a1, b1, tol, it);
        if (Double.isNaN(resultado)) {
            System.out.println("Method failed after " + N0 + " iterations.");
        } else {
            System.out.println("Approximate solution: " + resultado);
        }
   }     
    
}
