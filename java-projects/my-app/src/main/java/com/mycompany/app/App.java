package com.mycompany.app;

public class App {
    public static void main(String[] args) {
        double val = args.length == 0 ? 2.0 : Double.parseDouble(args[0]);
        Sqrt sqrt = new Sqrt(val);
        System.out.println("Sqrt of " + val + " = " + sqrt.calc());
    }
}
