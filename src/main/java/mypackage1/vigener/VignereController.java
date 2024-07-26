package mypackage1.vigener;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.Node;

public class VignereController {

    @FXML
    TextField tfeld1;
    @FXML
    TextField tfeld2;
    @FXML
    TextField tfeld3;
    @FXML
    public void btn_loeschen(ActionEvent loeschen){
        tfeld1.clear();
        tfeld2.clear();
        tfeld3.clear();

    }
    @FXML
    public void btn_beenden(ActionEvent beenden){
        Node source = (Node) beenden.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();

    }

    @FXML
    public void btn_Ver(ActionEvent ver){
        String nachricht = tfeld1.getText();
        String schluessle= tfeld2.getText();
        tfeld3.setText(verF(nachricht,schluessle));
    }
    @FXML
    public void btn_Ent(ActionEvent ent){
        String ergebnis= tfeld3.getText();
        String schluessle= tfeld2.getText();
        tfeld1.setText(entF(ergebnis,schluessle));
    }

    public static String verF(String nachricht, String schluessle){
        StringBuilder vererg = new StringBuilder();
        schluessle = schluessle.toUpperCase();
        nachricht = nachricht.toUpperCase();
        for (int i = 0, j = 0; i < nachricht.length(); i++){
            char bustabe = nachricht.charAt(i);
            if (bustabe < 'A' || bustabe > 'Z'){
                vererg.append(bustabe);
                continue;
            }
            char rechen = schluessle.charAt(j % schluessle.length());
            char versch = (char)((bustabe + rechen - 2 * 'A') % 26 + 'A');
            vererg.append(versch);
            j++;
        }
        return vererg.toString();

    }
    public static String entF(String ergebnis, String schluessle){
        StringBuilder enterg = new StringBuilder();
        schluessle = schluessle.toUpperCase();
        ergebnis = ergebnis.toUpperCase();
        for (int i = 0, j = 0; i < ergebnis.length(); i++){
            char bustabe = ergebnis.charAt(i);
            if (bustabe < 'A' || bustabe > 'Z'){
                enterg.append(bustabe);
                continue;
            }
            char rechen = schluessle.charAt(j % schluessle.length());
            char entsch = (char)((bustabe - rechen  + 26 ) % 26 + 'A');
            enterg.append(entsch);
            j++;
        }
        return enterg.toString();

    }



}