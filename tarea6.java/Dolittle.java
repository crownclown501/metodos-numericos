

public class Dolittle {
    

    public static void doolittle(double[][] A, double[] b) {
        int n = A.length;
        double[][] L = new double[n][n];
        double[][] U = new double[n][n];

        for (int i = 0; i < n; i++) {
            L[i][i] = 1; // La diagonal de L siempre es 1
            for (int j = i; j < n; j++) {
                double sumat = 0;
                for (int k = 0; k < i; k++) {
                    sumat += L[i][k] * U[k][j];
                }
                U[i][j] = A[i][j] - sumat;
                
            }
            for (int j = i + 1; j < n; j++) {
                if (U[i][i] == 0) {
                    System.out.println("No existe solución única");
                    return;
                }
                double sumat = 0;
                for (int k = 0; k < i; k++) {
                    sumat += L[j][k] * U[k][i];
                }
                L[j][i] = (A[j][i] - sumat) / U[i][i];
            }
        }
       
        System.out.println();
        System.out.println("\nMatriz L: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A.length; j++) {
                System.out.print(L[j][i] + ", ");
            }
            System.out.println("]");
        }
        System.out.println();
        double[] z = new double[n];
        double[] x = new double[n];

        // Hacia adelante: Lz = b
        for (int i = 0; i < n; i++) {
            double sumat = 0;
            for (int j = 0; j < i; j++) {
                sumat += L[j][i] * z[j];
            }
            z[i] = b[i] - sumat;
            System.out.println("z[" + i + "] = [" + z[i]+"]");
        }
        System.out.println();
        // Hacia atrás: Ux = z
          System.out.println("\nMatriz U: ");
        for (int i = 0; i < A.length; i++) {
            System.out.print("[");
            for (int j = 0; j < A.length; j++) {
                System.out.print(U[i][j] + ", ");
            }
            System.out.println("]");
        } 
        for (int i = n - 1; i >= 0; i--) {
            double sumat = 0;
            for (int j = i + 1; j < n; j++) {
                sumat += U[j][i] * x[j];
            }
            x[i] = (z[i] - sumat) / U[i][i];
            //System.out.println("x[" + i + "] = [" + x[i]+"]");
        }
        for (int i = 0; i < x.length; i++) {
            System.out.println("x[" + i + "] = [" + x[i] + "]");
        }
    }
    public static void main(String[] args) {
       // double[][] A = {{2, 5, 3, 0},{2, 6, 0, 4},{-1, -2, 0, 1},{0, 2, 9, 9}}; // entradas aij i>=1 z j<=n
        //double[] b = {4,10,0,13}; // entradas bi
        double[][] A={{2,5,3,0},{2,6,0,4},{-1,-2,0,1},{0,2,9,9}};
        double[] b = {4,10,0,13}; 
        doolittle(A, b);
    }
}