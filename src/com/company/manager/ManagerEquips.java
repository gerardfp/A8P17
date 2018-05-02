package com.company.manager;

import com.company.model.Equip;

public class ManagerEquips {
    static Equip[] equips = new Equip[100];

    public static Equip inscriureEquip(String nom){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] == null){
                Equip equip = new Equip(nom);
                equip.id = obtenirUltimIdEquip() + 1;
                equips[i] = equip;

                return equip;
            }
        }

        return null;
    }

    public static Equip obtenirEquip(int id){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].id == id){
                return equips[i];
            }
        }

        return null;
    }

    public static Equip obtenirEquip(String nom){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].nom.equals(nom)){
                return equips[i];
            }
        }

        return null;
    }

    public static String obtenirNomEquip(int id){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].id == id){
                return equips[i].nom;
            }
        }

        return "";
    }

    public static Equip[] obtenirLlistaEquips(){
        Equip[] llistaEquips = new Equip[obtenirNumeroEquips()];

        int j = 0;
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null){
                llistaEquips[j] = equips[i];
                j++;
            }
        }

        return llistaEquips;
    }

    public static Equip[] buscarEquipsPerNom(String nom){
        Equip[] llistaEquips = new Equip[obtenirNumeroEquipsPerNom(nom)];

        int j = 0;
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].nom.toLowerCase().contains(nom.toLowerCase())){
                llistaEquips[j] = equips[i];
                j++;
            }
        }

        return llistaEquips;
    }

    public static boolean existeixEquip(String nom){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].nom.toLowerCase().equals(nom.toLowerCase())){
                return true;
            }
        }

        return false;
    }

    public static void modificarNomEquip(int id, String nouNom){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].id == id){
                equips[i].nom = nouNom;
            }
        }
    }

    public static void esborrarEquip(int id){
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].id == id){
                equips[i] = null;
            }
        }
    }

    private static int obtenirUltimIdEquip(){
        int maxId = 0;
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].id > maxId){
                maxId = equips[i].id;
            }
        }

        return maxId;
    }

    private static int obtenirNumeroEquips(){
        int count = 0;
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null){
                count++;
            }
        }

        return count;
    }

    private static int obtenirNumeroEquipsPerNom(String nom){
        int count = 0;
        for (int i = 0; i < equips.length; i++) {
            if(equips[i] != null && equips[i].nom.toLowerCase().contains(nom.toLowerCase())){
                count++;
            }
        }

        return count;
    }
}
