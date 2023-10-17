package MetodosNumericos.tarea5;
import java.util.Arrays;

public class Gauss{
    public static double[] Gauss_Seidel(int n, double[][] A, double[] b, double[] X0, double TOL, int N) {
        //PASO 1
        int k = 1; // Inicializamos el contador de iteraciones a 1
        double[] x = new double[n]; // Inicializamos x con los valores iniciales en X0
        //PASO 2:Comenzamos un bucle que realizará las iteraciones
        while (k <= N) {
            //PASO 3
            for (int i = 0; i < n; i++) {
                double sumatoria1 = 0; // Inicializamos una suma para la parte izquierda de la ecuación
                double sumatoria2 = 0; // Inicializamos una suma para la parte derecha de la ecuación
                // Calculamos las sumas 
                for (int j1 = 0; j1 < i; j1++) {
                    sumatoria1 += A[i][j1] * x[j1];
                }

                for (int j = i + 1; j < n; j++) {
                    sumatoria2 += A[i][j] * X0[j];
                }
                x[i] = (1/A[i][i])*(-sumatoria1-sumatoria2+b[i]);
                X0[i] = x[i];//reasignamos valores
            }
            //PASO 4
            if (isConverged(x, X0, TOL)) {
                return x;
            }
            k++;
        }
        return null;
    }
    //PASO 4
    public static boolean isConverged(double[] x, double[] X0,double TOL) {
        double norm = 0; // Inicializamos una variable para calcular la norma
        for (int i = 0; i < x.length; i++) {
            norm += Math.pow(x[i] - X0[i], 2);
        }
        return Math.sqrt(norm)<TOL;
    }

    /*vamos a usar los datos de la diapositiva de la clase 10 
     * a continuacion los datos de la clase
     * (*1)->    A= {{10,-1,2,0},{-1,11,-1,3},{2,-1,10,-1},{0,3,-1,8}};
     *          b={6,25,-11,15};
     *          X0={0,0,0,0};
     */
     public static void main(String[] args) {
        // Input de variables iniciales de acuerdo a lo solicitado:
        int n = 4; // Número de ecuaciones e incógnitas n
        double[][] A = {{10, -1, 2, 0},{-1, 11, -1, 3},{2, -1, 10, -1},{0, 3, -1, 8}}; // entradas aij i>=1 y j<=n
        double[] b = {6, 25, -11, 15}; // entradas bi 
        double[] X0 = {0, 0, 0, 0}; // entradas X0i (aproximacion)
        /*x^(1)= {0.6000000000000001, 2.3272727272727276, -0.9872727272727273, 0.8788636363636363}
         *x^(2)= {1.0301818181818183, 2.036938016528926, -1.0144561983471074, 0.9843412190082643}
         *x^(3)= {1.006585041322314, 2.003555016904583, -1.0025273846731781, 0.9983509455766341}
         *x^(4)= {1.000860978625094, 2.000298250656547, -1.0003072761017007, 0.9998497464910823}
         *x^(5)= {1.000091280285995, 2.0000213422464586, -1.0000311471834449, 0.9999881032596475}
        */
        double TOL = 0.001; // Tolerancia
        int N = 5; // Número máximo de iteraciones
        // Llamamos a la función y le damos valores a un arreglo de tamaño no definido
        double[] x = Gauss_Seidel(n, A, b, X0, TOL, N);
        // Comprobamos si encontramos una solución o si se superó el número máximo de iteraciones:
        if (x != null) {
            System.out.println("Solución aproximada:");
            System.out.println(Arrays.toString(x));
        } else {
            System.out.println("Se superó el número máximo de iteraciones.");
        }
    }
}
    }
}
