package com.company;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerCorredors2;
import com.company.model.Corredor;
import com.company.model.Equip;

public class Main2 {

    public static void main(String[] args) {

//        Equip kk = new Equip("EquipoX");
//        ManagerCorredors2.inscriureCorredor("Sergio", kk);
//        ManagerCorredors2.inscriureCorredor("Raul", kk);

        boolean corredor = ManagerCorredors2.existeixCorredor("Josep");
        System.out.println(corredor);
        ManagerCorredors2.modificarNomCorredor(2008, "nyannyan");
    }
}
