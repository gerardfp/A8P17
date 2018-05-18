package com.company.manager;

import com.company.model.Corredor;
import com.company.model.Equip;

import java.io.*;
import java.net.CookieHandler;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ManagerCorredors22 {
    static Corredor[] corredors = new Corredor[100];

    public static Corredor inscriureCorredor(String nom, Equip equip){
        if(equip == null){
            return null;
        }

        try {
            FileWriter fileWriter = new FileWriter("corredors.txt", true);
            fileWriter.write(nom);
            fileWriter.write(equip.id);
            fileWriter.write(String.valueOf(1002+1));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Corredor obtenirCorredor(int id){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("corredors.txt"));
            String lineaCorredor;
            while ((lineaCorredor = fileReader.readLine()) != null) {
                String[] partes = lineaCorredor.split(":");

                if(id == Integer.parseInt(partes[2])){
                    Corredor corredor = new Corredor(partes[0], Integer.parseInt(partes[1]));
                    corredor.id = id;
                    return corredor;

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Corredor[] obtenirLlistaCorredors(){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredors()];

        int j = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null){
                llistaCorredors[j] = corredors[i];
                j++;
            }
        }

        return llistaCorredors;
    }

    public static Corredor[] buscarCorredorsPerNom(String nom){
        Corredor[] llistaCorredors = new Corredor[obtenirNumeroCorredorsPerNom(nom)];

        int j = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].nom.toLowerCase().contains(nom.toLowerCase())){
                llistaCorredors[j] = corredors[i];
                j++;
            }
        }

        return llistaCorredors;
    }

    public static boolean existeixCorredor(String nom){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("corredors.txt"));
            String lineaCorredor;
            while ((lineaCorredor = fileReader.readLine()) != null) {
                String[] partes = lineaCorredor.split(":");

                if(nom.toLowerCase().equals(partes[0].toLowerCase())){
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false;
    }

    public static void modificarNomCorredor(int id, String nouNom){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("corredors.txt"));
            FileWriter fileWriter = new FileWriter("corredors_temp.txt", true);

            String lineaCorredor;
            while ((lineaCorredor = fileReader.readLine()) != null) {
                String[] partes = lineaCorredor.split(":");

                if(id == Integer.parseInt(partes[2])){
                    fileWriter.write(nouNom);
                    fileWriter.write(partes[1]);
                    fileWriter.write(partes[2]);
                    fileWriter.flush();
                }else{
                    fileWriter.write(lineaCorredor);
                }
            }
            fileWriter.close();
            fileReader.close();

            Files.move(FileSystems.getDefault().getPath("corredors_temp.txt"),
                    FileSystems.getDefault().getPath("corredors.txt"),
                    REPLACE_EXISTING);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void modificarEquipCorredor(int id, Equip nouEquip){
        if(nouEquip == null){
            return;
        }

        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i].idEquip = nouEquip.id;
            }
        }
    }

    public static void esborrarCorredor(int id){
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id == id){
                corredors[i] = null;
            }
        }
    }

    private static int obtenirUltimIdCorredor(){
        int maxId = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].id > maxId){
                maxId = corredors[i].id;
            }
        }

        return maxId;
    }

    private static int obtenirNumeroCorredors(){
        int count = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null){
                count++;
            }
        }

        return count;
    }

    private static int obtenirNumeroCorredorsPerNom(String nom){
        int count = 0;
        for (int i = 0; i < corredors.length; i++) {
            if(corredors[i] != null && corredors[i].nom.toLowerCase().contains(nom.toLowerCase())){
                count++;
            }
        }

        return count;
    }
}
