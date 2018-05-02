package com.company.view;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerEquips;
import com.company.model.Corredor;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetCorredors;
import com.company.view.widget.WidgetEquips;

public class PantallaEsborrarCorredor {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Corredors :: Esborrar");
        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            Corredor[] corredors = ManagerCorredors.buscarCorredorsPerNom(nom);

            if(corredors.length == 0){
                Missatge.mostrarError("No s'ha trobat cap corredor");
            } else {
                int idCorredor;
                if (corredors.length == 1) {
                    idCorredor = corredors[0].id;
                } else {
                    WidgetCorredors.llistar(corredors);
                    idCorredor = LectorTeclat.llegirInt("Id corredor:");
                }

                Corredor corredor = ManagerCorredors.obtenirCorredor(idCorredor);

                if (corredor == null) {
                    Missatge.mostrarError("No s'ha trobat el corredor amb id " + idCorredor);
                } else {
                    WidgetCorredors.seleccionar(corredor);
                    if (LectorTeclat.llegirConfirmacio("Esborrar corredor (S/n)?", true)) {
                        ManagerCorredors.esborrarCorredor(idCorredor);
                        Missatge.mostrarOk("Corredor esborrat correctament");
                    } else {
                        Missatge.mostrarInfo("No s'ha esborrat el corredor");
                    }
                }
            }
        }
    }
}
