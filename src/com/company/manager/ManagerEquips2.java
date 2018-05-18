package com.company.manager;

import com.company.model.Equip;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class ManagerEquips2 {
    static Equip[] equips = new Equip[100];
    static int MAXNOM = 6;
    static int MAXID = 4;

    public static Equip inscriureEquip(String nom){

        try {
            FileChannel fileChannel = FileChannel.open(FileSystems.getDefault().getPath("equipos.txt"), WRITE, CREATE);

            fileChannel.position(fileChannel.size());
            fileChannel.write(ByteBuffer.wrap(nom.getBytes()));
            fileChannel.position(fileChannel.size()+MAXNOM);
            fileChannel.write(ByteBuffer.wrap("1".getBytes()));

        } catch (IOException e) {
            e.printStackTrace();
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
        try {
            FileChannel fileChannel = FileChannel.open(FileSystems.getDefault().getPath("equipos.txt"), WRITE, CREATE);
            return (int) fileChannel.size()/32;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 0;
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
