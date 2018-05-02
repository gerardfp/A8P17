package com.company.view;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerEquips;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetCorredors;
import com.company.view.widget.WidgetEquips;

public class PantallaLlistaCorredors {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Corredors :: LLista");

        WidgetCorredors.llistar(ManagerCorredors.obtenirLlistaCorredors());

        LectorTeclat.llegirContinuar();
    }
}
