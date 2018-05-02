package com.company.view;

import com.company.manager.ManagerEquips;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetEquips;

public class PantallaEsborrarEquip {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Equips :: Esborrar");
        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            Equip[] equips = ManagerEquips.buscarEquipsPerNom(nom);

            if(equips.length == 0){
                Missatge.mostrarError("No s'ha trobat cap equip");
            } else {
                int idEquip;
                if (equips.length == 1) {
                    idEquip = equips[0].id;
                } else {
                    WidgetEquips.llistar(equips);
                    idEquip = LectorTeclat.llegirInt("Id equip:");
                }

                Equip equip = ManagerEquips.obtenirEquip(idEquip);

                if (equip == null) {
                    Missatge.mostrarError("No s'ha trobat l'equip amb id " + idEquip);
                } else {
                    WidgetEquips.seleccionar(equip);
                    if (LectorTeclat.llegirConfirmacio("Esborrar equip (S/n)?", true)) {
                        ManagerEquips.esborrarEquip(idEquip);
                        Missatge.mostrarOk("Equip esborrat correctament");
                    } else {
                        Missatge.mostrarInfo("No s'ha esborrat l'equip");
                    }
                }
            }
        }
    }
}
