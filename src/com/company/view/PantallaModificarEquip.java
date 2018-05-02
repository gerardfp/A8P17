package com.company.view;

import com.company.manager.ManagerEquips;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetEquips;

public class PantallaModificarEquip {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Equips :: Modificar");
        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            Equip[] equips = ManagerEquips.buscarEquipsPerNom(nom);

            if(equips.length == 0){
                Missatge.mostrarError("No s'ha trobat cap equip");
            } else{
                int idEquip;
                if(equips.length == 1){
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
                    while (true) {
                        String nouNom = LectorTeclat.llegirString("Nou nom:");
                        if ("".equals(nouNom)) {
                            return;
                        } else if (ManagerEquips.existeixEquip(nouNom)) {
                            Missatge.mostrarError("Ja existeix un equip amb aquest nom");
                        } else {
                            ManagerEquips.modificarNomEquip(idEquip, nouNom);
                            Missatge.mostrarOk("Equip modificat correctament");
                            return;
                        }
                    }
                }
            }
        }
    }
}
