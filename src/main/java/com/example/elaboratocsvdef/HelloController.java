package com.example.elaboratocsvdef;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputControl;

import java.io.*;
import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextArea textArea;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    public static void aggiungiCampo() {
        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void mostraCampi() {
        try {
            File file = new File("src/main/resources/com.example.elaboratocsvdef/Longo.csv");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String riga;
            int numRiga = 1;

            while ((riga = br.readLine()) != null) {
                int numCampi = riga.split(";").length;
                textArea.appendText("Riga " + numRiga + ": " + numCampi + " campi\n");
                numRiga++;
            }
        } catch (IOException e) {
            textArea.appendText("Errore nella lettura del file.");
        }
    }
}