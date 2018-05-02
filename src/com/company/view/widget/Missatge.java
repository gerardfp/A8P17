package com.company.view.widget;

public class Missatge {
    public static void mostrarTitol(String titol){
        System.out.println("\n\033[97;104m" + String.format("%-40s", titol) + "\033[0m\n");
    }

    public static void mostrarOk(String missatge){
        System.out.println("\033[32m" + missatge + "\033[0m");
    }

    public static void mostrarError(String missatge){
        System.out.println("\033[91m" + missatge + "\033[0m");
    }

    public static void mostrarInfo(String missatge){
        System.out.println("\033[93m" + missatge + "\033[0m");
    }

}
