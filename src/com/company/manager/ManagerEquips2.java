package com.company.manager;

import com.company.model.Equip;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;

import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.READ;
import static java.nio.file.StandardOpenOption.WRITE;


public class ManagerEquips2 {
    static Equip[] equips = new Equip[100];
    static int MAXNOM = 12;
    static int MAXID = 4;

    public static Equip inscriureEquip(String nom){

        try (FileChannel fc = (FileChannel.open(FileSystems.getDefault().getPath("equips2.txt"), CREATE, READ, WRITE))) {
            long posFinal = fc.size();

            fc.position(posFinal);
            fc.write(ByteBuffer.wrap(nom.getBytes()));

            int id = (int) posFinal/(MAXNOM+MAXID)+1;
            ByteBuffer byteBuffer = ByteBuffer.allocate(MAXID);
            byteBuffer.putInt(0,id);

            fc.position(posFinal+MAXNOM);
            fc.write(byteBuffer);


        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
        }

        return null;
    }

    public static Equip obtenirEquip(int id){
        try (FileChannel fc = (FileChannel.open(FileSystems.getDefault().getPath("equips2.txt"), CREATE, READ, WRITE))) {
            long posFinal = fc.size();
            fc.position((id-1)*(MAXNOM+MAXID));
            ByteBuffer byteBufferNom = ByteBuffer.allocate(MAXNOM);

            fc.read(byteBufferNom);

            String nom = new String(byteBufferNom.array(), Charset.forName("UTF-8"));

            System.out.println("NOM: " + nom);

        } catch (IOException x) {
            System.out.println("I/O Exception: " + x);
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
