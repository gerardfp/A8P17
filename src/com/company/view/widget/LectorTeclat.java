package com.company.view.widget;

import java.util.Scanner;

public class LectorTeclat {
    private static Scanner scanner = new Scanner(System.in);

    public static String llegirString(String hint){
        System.out.println(hint);
        return scanner.nextLine();
    }

    public static int llegirInt(String hint){
        String valorLlegit;
        int valor = -1;
        boolean valid;
        do {
            System.out.println(hint);
            valorLlegit = scanner.nextLine();
            valid = true;

            try {
                valor = Integer.parseInt(valorLlegit);
            } catch (Exception e){
                Missatge.mostrarError("Introdueixi un número");
                valid = false;
            }
        } while(!valid);

        return valor;
    }

    public static boolean llegirConfirmacio(String hint, Boolean defecte){
        String valorLlegit;
        boolean valor = false;
        boolean valid;
        do {
            System.out.println(hint);
            valorLlegit = scanner.nextLine();
            valid = true;
            if(valorLlegit.toLowerCase().contains("s")){
                valor = true;
            } else if(valorLlegit.toLowerCase().contains("n")){
                valor = false;
            } else if("".equals(valorLlegit) && defecte != null){
                    valor = defecte;
            } else {
                Missatge.mostrarError("Introdueixi s/n");
                valid = false;
            }
        } while(!valid);

        return valor;
    }

    public static String llegirOpcio(){
        return llegirString("\033[90mOpció:\033[0m");
    }

    public static void llegirContinuar(){
        llegirString("\033[90mPremi una tecla per continuar...\033[0m");
    }
}
