import java.util.Scanner;

public class Muller 
{
     // Define the function f(x) here
    public static double function(double x) 
    {
        double n=Math.pow(x, 3);
        return Math.exp(-n) - n;
    }
    
    public static double mullerMethod(double p0, double p1, double p2, double TOL, int N0) {
        int i = 3;
        double h1, h2, S1, S2, d, p, b, D, E, h;

        while (i <= N0) 
        {
            h1 = p1 - p0;
            h2 = p2 - p1;
            S1 = (function(p1) - function(p0)) / h1;
            S2 = (function(p2) - function(p1)) / h2;
            d = (S2 - S1) / (h2 + h1);
            b = S2 + h2 * d;
            D = Math.sqrt(b * b - 4 * function(p2) * d);

            if (Math.abs(b - D) < Math.abs(b + D)) 
            {
                E = b + D;
            } 
            else 
            {
                E = b - D;
            }
            h = (-2 * function(p2)) / E;
            p = p2 + h;
            if (Math.abs(h) < TOL) 
            {
                return p;
            }
            p0 = p1;
            p1 = p2;
            p2 = p;
            h1 = p1 - p0;
            h2 = p2 - p1;
            S1 = (function(p1) - function(p0)) / h1;
            S2 = (function(p2) - function(p1)) / h2;
            d = (S2 - S1) / (h2 + h1);
            i++;
        }
        return Double.NaN;
    }
   public static void main(String[] args) 
   {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Muller Method to find a solution to f(x) = 0");
        System.out.print("Enter p0: ");
        double p0 = scanner.nextDouble();
        System.out.print("Enter p1: ");
        double p1 = scanner.nextDouble();
        System.out.print("Enter p2: ");
        double p2 = scanner.nextDouble();
        // la tolerancia se saca del valor absoluto de delta X sub k-1 puede ser de los datos de la tabla
        //del archivo de la clase 6  que son .47,.29,.0065,.0000381634,.0000000063934,.00000000000000
        System.out.print("Enter tolerance (TOL): ");
        double TOL = scanner.nextDouble();
        
        System.out.print("Enter maximum number of iterations (N0): ");
        int N0 = scanner.nextInt();

        double result = mullerMethod(p0, p1, p2, TOL, N0);

        if (!Double.isNaN(result)) 
        {
            System.out.println("Approximate solution: " + result);
        } 
        else 
        {
            System.out.println("Method failed after " + N0 + " iterations.");
        }
    }
}
