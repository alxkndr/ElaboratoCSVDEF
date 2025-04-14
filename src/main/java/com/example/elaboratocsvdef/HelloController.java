package com.example.elaboratocsvdef;
import java.io.*;
import java.nio.file.*;
import java.util.*;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;

import java.util.Random;

public class HelloController {

    @FXML
    private TextArea textArea;

    @FXML

    //METODO MOSTRA CAMPI
    public void mostraCampi() {
        try {
            File file = new File("Longo.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String riga;
            int numRiga = 1;

            while ((riga = br.readLine()) != null) {
                int numCampi = riga.split(";").length;
                textArea.appendText(riga + "\n");
                numRiga++;
            }
        } catch (IOException e) {
            textArea.appendText("Errore nella lettura del file.");
        }
    }

    //METODO CONTA CAMPI
    public void contaCampi(){
        try{
            BufferedReader br = new BufferedReader(new FileReader("Longo.csv"));
            String riga;
            int rigaNumero = 1;

            while ((riga = br.readLine()) != null) {
                String[] campi = riga.split(";");
                textArea.appendText("Riga " + rigaNumero + " ha " + campi.length + " campi\n");
                rigaNumero++;
            }

            br.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void aggiungiCampo() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("Longo.csv"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("Longo.csv"));
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML

    public void generaHTML() {
        String percorsoCSV = "Longo.csv";
        String percorsoHTML = "Longo.html";

        try (
                BufferedReader reader = new BufferedReader(new FileReader(percorsoCSV));
                PrintWriter writer = new PrintWriter(percorsoHTML);
        ) {
            String riga = reader.readLine();

            if (riga == null) {
                System.out.println("Il file CSV è vuoto.");
                return;
            }

            writer.println("<html><head><title>ElaboratoCSV</title></head><body>");
            writer.println("<h2>CSV</h2>");

            String[] intestazioni = riga.split(",");
            writer.print("<tr>");
            for (String colonna : intestazioni) {
                writer.print("<th>" + colonna.trim() + "</th>");
            }
            writer.println("</tr>");

            while ((riga = reader.readLine()) != null) {
                String[] valori = riga.split(",");
                writer.print("<tr>");
                for (String valore : valori) {
                    writer.print("<td>" + valore.trim() + "</td>");
                }
                writer.println("</tr>");
            }

            writer.println("</table></body></html>");
            System.out.println("File HTML generato con successo: " + percorsoHTML);

        } catch (IOException e) {
            System.out.println("Errore durante la lettura o scrittura: " + e.getMessage());
        }
    }
}