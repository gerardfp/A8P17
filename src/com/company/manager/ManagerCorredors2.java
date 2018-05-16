package com.company.manager;

import com.company.model.Corredor;
import com.company.model.Equip;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class ManagerCorredors2 {
    static Corredor[] corredors = new Corredor[100];

    public static Corredor inscriureCorredor(String nom, Equip equip){
        if(equip == null){
            return null;
        }

        try {
            FileWriter fileWriter = new FileWriter("corredores.txt", true);
            fileWriter.write(nom);
            fileWriter.write(String.valueOf(1));
            fileWriter.write(String.valueOf(2000+1));
            fileWriter.close();

        } catch (IOException e) {
            System.out.println("No se pudo crear el fichero");
        }

        return null;
    }

    public static Corredor obtenirCorredor(int id){
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader("corredores.txt"));

            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if(id == Integer.parseInt(partes[1])){
                    Corredor corredor = new Corredor(partes[0], Integer.parseInt(partes[2]));
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
            BufferedReader fileReader = new BufferedReader(new FileReader("corredores.txt"));

            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if(nom.equals(partes[0])){
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
            BufferedReader fileReader = new BufferedReader(new FileReader("corredores.txt"));
            FileWriter fileWriter = new FileWriter("corredores2.txt", true);

            String linea;
            while((linea = fileReader.readLine()) != null){
                String[] partes = linea.split(":");
                if(Integer.parseInt(partes[2]) == id){
                    fileWriter.write(nouNom);
                    fileWriter.write(partes[1]);
                    fileWriter.write(id);
                }else{
                    fileWriter.write(linea);
                }
            }
            fileWriter.close();
            fileReader.close();
            //mv corredores2.txt corredores.txt
            Files.move(FileSystems.getDefault().getPath("corredores2.txt"), FileSystems.getDefault().getPath("corredores.txt"), REPLACE_EXISTING);
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
