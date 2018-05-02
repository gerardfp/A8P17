package com.company.view;

import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;

public class PantallaMenuCorredors {
    public static void mostrar(){
        while(true) {
            Missatge.mostrarTitol("MARATHON :: Corredors");
            System.out.println("a) Inscriure corredor");
            System.out.println("b) Llistar corredors");
            System.out.println("c) Modificar corredor");
            System.out.println("d) Esborrar corredor");
            System.out.println("*) Enrrere");

            String opcio = LectorTeclat.llegirOpcio();

            switch (opcio) {
                case "a":
                    PantallaInscripcioCorredor.mostrar();
                    break;
                case "b":
                    PantallaLlistaCorredors.mostrar();
                    break;
                case "c":
                    PantallaModificarCorredor.mostrar();
                    break;
                case "d":
                    PantallaEsborrarCorredor.mostrar();
                    break;
                default:
                    return;
            }
        }
    }
}
