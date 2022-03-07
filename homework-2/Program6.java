

/*

Program 6 (Stretch homework)
Create a class Line having attributes slope(m) and y-intercept(c) and a constructor to
initialize the values.
Take as input the slope and y-intercept for two lines, throw a custom Exception
ParallelLinesException if the lines are parallel to each other else, display the point of
intersection, also handle other runtime errors.

 */

import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter slope 1: ");
        Double m1 = s.nextDouble();
        System.out.println("Enter y-intercept 1: ");
        Double c1 = s.nextDouble();
        System.out.println("Enter slope 2: ");
        Double m2 = s.nextDouble();
        System.out.println("Enter y-intercept 2: ");
        Double c2 = s.nextDouble();
        try{
            solve(m1, c1, m2, c2);
        }
        catch (ParallelLineException p) {
            System.out.println("Error: " + p);
        }

    }
    static void solve(Double m1, Double c1, Double m2, Double c2) throws ParallelLineException {
        if(Double.compare(m1, m2) == 0) {
            throw new ParallelLineException("Lines are parallel.");
        }
        else {
            double y = (m1*c2 - m2*c1) / (m1 - m2);
            double x = (y - c1) / m1;
            System.out.println("Point of intersection is:"+ x + " " + y);
        }
    }
}

class ParallelLineException extends Exception {
    public ParallelLineException(String s) {
        super(s);
    }
}


class Line {
    Double m, c;
    Line(Double m, Double c) {
        this.m = m;
        this.c = c;
    }
}