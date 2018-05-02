package com.company.view;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerEquips;
import com.company.model.Corredor;
import com.company.model.Equip;
import com.company.view.widget.LectorTeclat;
import com.company.view.widget.Missatge;
import com.company.view.widget.WidgetCorredors;
import com.company.view.widget.WidgetEquips;

public class PantallaModificarCorredor {
    public static void mostrar(){
        Missatge.mostrarTitol("MARATHON :: Corredors :: Modificar");
        while(true){
            String nom = LectorTeclat.llegirString("Nom:");
            if("".equals(nom)){
                return;
            }

            Corredor[] corredors = ManagerCorredors.buscarCorredorsPerNom(nom);

            if(corredors.length == 0){
                Missatge.mostrarError("No s'ha trobat cap corredor");
            } else{
                int idCorredor;
                if(corredors.length == 1){
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
                    while (true) {
                        String nouNom = LectorTeclat.llegirString("Nou nom:");
                        if ("".equals(nouNom)) {
                           break;
                        } else if (ManagerCorredors.existeixCorredor(nouNom)) {
                            Missatge.mostrarError("Ja existeix un corredor amb aquest nom");
                        } else {
                            ManagerCorredors.modificarNomCorredor(idCorredor, nouNom);
                            Missatge.mostrarOk("Nom del corredor modificat correctament");
                            break;
                        }
                    }

                    while(true){
                        String nouEquip = LectorTeclat.llegirString("Nou equip:");
                        if("".equals(nouEquip)){
                            return;
                        }

                        Equip[] equips = ManagerEquips.buscarEquipsPerNom(nouEquip);

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

                                ManagerCorredors.modificarEquipCorredor(idCorredor, equip);

                                WidgetCorredors.seleccionar(corredor);
                                Missatge.mostrarOk("Equip del corredor modificat correctament");
                                LectorTeclat.llegirContinuar();

                                return;
                            }
                        }
                    }
                }
            }
        }
    }
}