package com.company.view;

import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;

public class PantallaMenuEquips {
    public static void mostrar(){
        while(true) {
            Missatge.mostrarTitol("MARATHON :: Equips");
            System.out.println("a) Inscriure equip");
            System.out.println("b) Llistar equips");
            System.out.println("c) Modificar equip");
            System.out.println("d) Esborrar equip");
            System.out.println("*) Enrrere");

            String opcio = LectorTeclat.llegirOpcio();

            switch (opcio) {
                case "a":
                    PantallaInscripcioEquip.mostrar();
                    break;
                case "b":
                    PantallaLlistaEquips.mostrar();
                    break;
                case "c":
                    PantallaModificarEquip.mostrar();
                    break;
                case "d":
                    PantallaEsborrarEquip.mostrar();
                    break;
                default:
                    return;
            }
        }
    }
}
