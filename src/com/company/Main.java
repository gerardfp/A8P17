package com.company;

import com.company.manager.ManagerCorredors;
import com.company.manager.ManagerEquips;
import com.company.view.PantallaMenuPrincipal;

public class Main {

    public static void main(String[] args) {
        ManagerEquips.inscriureEquip("LLiure");
        ManagerEquips.inscriureEquip("Equip A");
        ManagerEquips.inscriureEquip("Equip B");
        ManagerEquips.inscriureEquip("Equip C");
        ManagerEquips.inscriureEquip("Equip D");
        ManagerCorredors.inscriureCorredor("Corredor Lliure", ManagerEquips.obtenirEquip("LLiure"));
        ManagerCorredors.inscriureCorredor("Corredor A", ManagerEquips.obtenirEquip("Equip A"));
        ManagerCorredors.inscriureCorredor("Corredor AA", ManagerEquips.obtenirEquip("Equip A"));
        ManagerCorredors.inscriureCorredor("Corredor AAA", ManagerEquips.obtenirEquip("Equip A"));
        ManagerCorredors.inscriureCorredor("Corredor B", ManagerEquips.obtenirEquip("Equip B"));
        ManagerCorredors.inscriureCorredor("Corredor BB", ManagerEquips.obtenirEquip("Equip B"));
        ManagerCorredors.inscriureCorredor("Corredor C", ManagerEquips.obtenirEquip("Equip C"));

        PantallaMenuPrincipal.mostrar();
    }
}
