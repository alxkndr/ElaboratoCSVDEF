package com.example.elaboratocsvdef;

import java.util.Random;
import java.io.*;
import java.util.*;

public class Functions {
        public static void aggiungiCampo(){
            try{
            BufferedReader br = new BufferedReader(new FileReader("com/example/elaboratocsvdef/Longo.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("com/example/elaboratocsvdef/Longo.csv"));
            String riga;
            boolean primaRiga = true;
            Random random = new Random();

            while ((riga = br.readLine()) != null) {
                if (primaRiga) {
                    riga += ",miovalore,cancellato";
                    primaRiga = false;
                } else {
                    int numero = random.nextInt(11) + 10;
                    riga += "," + numero + ",false";
                }
                bw.write(riga);
                bw.newLine();
            }

            br.close();
            bw.close();
            System.out.println("Campo aggiunto con successo");
        }catch (IOException e){
                e.printStackTrace();
            }
    }
    public static void contaCampi(){
            try{
                BufferedReader br = new BufferedReader(new FileReader("com/example/elaboratocsvdef/Longo.csv"));
                String riga;
                int rigaNumero = 1;

                while ((riga = br.readLine()) != null) {
                    String[] campi = riga.split(";");
                    System.out.println("Riga " + rigaNumero + " ha " + campi.length + " campi.");
                    rigaNumero++;
                }

                br.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }

    }
