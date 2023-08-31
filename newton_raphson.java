package MetodosNumericos.tarea2;

import java.util.Scanner;
/*algoritmo numérico utilizado para encontrar las raíces (soluciones) de una ecuación no lineal. 
Su principal objetivo es aproximar la solución a una ecuación mediante iteraciones sucesivas. 
Este método es especialmente eficiente cuando se busca encontrar

*objetivo del metodo: estimar la solucion de una ecuacuin f(x)=0
 * en resumen es producir una sucesion de aproximaciones 
 * que se acerquen a la solucion (iteraciones)
 * se escoge el primer numero X0 de la secuencia y luego en 
 * ciertas circunstancias favorables el metodo hace el resto movviendose paso a paso hacia la raiz
 * 
 * puede no converger dependiendo de la funcion y la estimacion inicial 
 */
public class newton_raphson {
    static double TOL;
    static int N0;
    //static int x = 1;

    public static double f(double n) {
        return Math.pow(n, 2)-4;//return n - (Math.cos(n));
    }

    public static double fderivada(double n) {
        return 2 * n;//return 1 + Math.sin(n);
    }

    public static double n_r(double TOL, int N0, double p0) {
        double p;
        int i=1;
        //hasat que alcanzemos el numero de iteraciones dadas 
        while (i <= N0) {
            p = p0 - f(p0) / fderivada(p0);
            double error = Math.abs(p - p0); //asignamos el valor absolutp a error restando al valor aproximado con el valor inicial dado en terminal
            if (error < TOL) { //comparamos si es menor a la tolerancia que dimos si si regresamos ese valor si no terminamos
                System.out.println("Procedure completed successfully");
                return p;
            }
            i += 1;
            p0 = p;//cambiamos el valor inicial por el nuevo valor aproximado 
        }
        return Double.NaN;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double p0 = input.nextDouble();
        double tol = 0.0005;
        int it = 100;
        double resultado = n_r(tol, it, p0);
        if (Double.isNaN(resultado)) {
            System.out.println("Method failed after " + N0 + " iterations.");
        } else {
            System.out.println("Approximate solution:  " + resultado);
        }
    }
}

/*¿Para que sirve? 
 * Sirve para encontrar las raíces (soluciones) de una ecuación no lineal aunque mas que nada es una aproximacion a ellas
 * mediante las iteraciones vamos aproximandonos alo buscado que es f(x)=0
*/