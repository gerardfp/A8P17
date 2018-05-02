package com.company.view;

import com.company.manager.ManagerEquips;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetEquips;

public class PantallaLlistaEquips {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Equips :: Llista");

        WidgetEquips.llistar(ManagerEquips.obtenirLlistaEquips());

        LectorTeclat.llegirContinuar();
    }
}
