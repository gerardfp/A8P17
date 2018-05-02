package com.company.view.widget;

import com.company.model.Equip;

public class WidgetEquips {
    public static void llistar(Equip[] equips){
        System.out.println(String.format("%4s   %-16s", "ID", "NOM"));
        for (int i = 0; i < equips.length; i++) {
            System.out.println(String.format("%4s   %-16s", equips[i].id, equips[i].nom));
        }
        System.out.println();
    }

    public static void seleccionar(Equip equip){
        System.out.println(String.format("\033[34mEQUIP => ID: %s   NOM: %s\033[0m", equip.id, equip.nom));
    }
}
