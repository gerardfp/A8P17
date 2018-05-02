package com.company.view;

import com.company.manager.ManagerEquips;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetEquips;

import java.util.Scanner;

public class PantallaInscripcioEquip {
    public static void mostrar(){

        Missatge.mostrarTitol("MARATHON :: Equips :: Inscripció");

        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            if(ManagerEquips.existeixEquip(nom)){
                Missatge.mostrarError("Ja existeix un equip amb aquest nom");
            } else {
                Equip equip = ManagerEquips.inscriureEquip(nom);
                if (equip == null) {
                    Missatge.mostrarError("Error: no s'ha pogut inscriure l'equip. La llista és plena.");
                } else {
                    WidgetEquips.seleccionar(equip);
                    Missatge.mostrarOk("Equip inscrit correctament");
                }
            }
        }
    }
}
