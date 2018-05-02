package com.company.view.widget;

import com.company.manager.ManagerEquips;
import com.company.model.Corredor;

public class WidgetCorredors {
    public static void llistar(Corredor[] corredors){
        System.out.println(String.format("%4s   %-16s   %-16s", "ID", "NOM", "EQUIP"));
        for (int i = 0; i < corredors.length; i++) {
            System.out.println(String.format("%4s   %-16s   %-16s", corredors[i].id, corredors[i].nom, ManagerEquips.obtenirNomEquip(corredors[i].idEquip)));
        }
        System.out.println();
    }

    public static void seleccionar(Corredor corredor){
        System.out.println(String.format("\033[34mCORREDOR => ID: %s   NOM: %s   EQUIP: %s\033[0m", corredor.id, corredor.nom, ManagerEquips.obtenirNomEquip(corredor.idEquip)));
    }
}
