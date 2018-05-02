package com.company.view;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerEquips;
import com.company.model.Corredor;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetCorredors;
import com.company.view.widget.WidgetEquips;

public class PantallaInscripcioCorredor {
    public static void mostrar(){

        Missatge.mostrarTitol("MARATHON :: Corredors :: Inscripció");

        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            if(ManagerCorredors.existeixCorredor(nom)){
                Missatge.mostrarError("Ja existeix un corredor amb aquest nom");
            } else {
                while(true) {
                    String nomEquip = LectorTeclat.llegirString("Equip:");

                    Equip[] equips = ManagerEquips.buscarEquipsPerNom(nomEquip);

                    if (equips.length == 0) {
                        Missatge.mostrarError("No existeix cap equip amb aquest nom");
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

                            Corredor corredor = ManagerCorredors.inscriureCorredor(nom, equip);
                            WidgetCorredors.seleccionar(corredor);
                            Missatge.mostrarOk("Corredor inscrit correctament");
                            LectorTeclat.llegirContinuar();

                            return;
                        }
                    }
                }
            }
        }
    }
}
