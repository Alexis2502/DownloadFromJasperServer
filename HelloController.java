package com.example.szkola;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class HelloController {
    @FXML
    private Button Compete;

    @FXML
    private TextField Param1;

    @FXML
    private TextField Param2;


    @FXML
    private Button Form;

    @FXML
    private Button Teachers;

    @FXML
    private Button Trip;

    @FXML
    private Button Students;

    @FXML
    void onCompete(ActionEvent event) throws IOException {
        String urlpath = "http://localhost:8081/jasperserver/rest_v2/reports/reports/Reports_parameter/Konkursy_par2.pdf?";
        String par1 = Param1.getText();
        String par2 = Param2.getText();
        String strurl=urlpath+"RangaPar="+par1+"&"+"OrganizatorPar="+par2;
        URL url = new URL(strurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization","Basic amFzcGVyYWRtaW46amFzcGVyYWRtaW4=");
        con.setRequestMethod("GET");
        InputStream responseStream = con.getInputStream();
        Files.copy(responseStream, Paths.get("D:/Studia/Podstawy baz danych/Raporty/konkursy.pdf"), StandardCopyOption.REPLACE_EXISTING);
        File pdfFile = new File("D:/Studia/Podstawy baz danych/Raporty/konkursy.pdf");
        Desktop.getDesktop().open(pdfFile);
    }

    @FXML
    void onTeachers(ActionEvent event) throws IOException {
        String urlpath = "http://localhost:8081/jasperserver/rest_v2/reports/reports/Reports_parameter/Nauczyciele_par2.pdf?";
        String par1 = Param1.getText();
        String par2 = Param2.getText();
        String strurl=urlpath+"PrzedmiotP="+par1+"&"+"StopienP="+par2;
        URL url = new URL(strurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization","Basic amFzcGVyYWRtaW46amFzcGVyYWRtaW4=");
        con.setRequestMethod("GET");
        InputStream responseStream = con.getInputStream();
        Files.copy(responseStream, Paths.get("D:/Studia/Podstawy baz danych/Raporty/nauczyciele.pdf"),StandardCopyOption.REPLACE_EXISTING);
        File pdfFile = new File("D:/Studia/Podstawy baz danych/Raporty/nauczyciele.pdf");
        Desktop.getDesktop().open(pdfFile);
    }

    @FXML
    void onTrip(ActionEvent event) throws IOException, InterruptedException {
        String urlpath = "http://localhost:8081/jasperserver/rest_v2/reports/reports/Reports_parameter/WycieczkiPar.pdf?";
        String par1 = Param1.getText();
        String par2 = Param2.getText();
        String strurl=urlpath+"TypPar="+par1+"&"+"DlugoscPar="+par2;
        URL url = new URL(strurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization","Basic amFzcGVyYWRtaW46amFzcGVyYWRtaW4=");
        con.setRequestMethod("GET");
        InputStream responseStream = con.getInputStream();
        Files.copy(responseStream, Paths.get("D:/Studia/Podstawy baz danych/Raporty/Wycieczki.pdf"),StandardCopyOption.REPLACE_EXISTING);
        File pdfFile = new File("D:/Studia/Podstawy baz danych/Raporty/Wycieczki.pdf");
        Desktop.getDesktop().open(pdfFile);
    }

    @FXML
    void onStudents(ActionEvent event) throws IOException {
        String urlpath = "http://localhost:8081/jasperserver/rest_v2/reports/reports/Reports_parameter/UczniowiePar.pdf?";
        String par1 = Param1.getText();
        String par2 = Param2.getText();
        String strurl=urlpath+"KlasaPar="+par1+"&"+"Id_SPar="+par2;
        URL url = new URL(strurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization","Basic amFzcGVyYWRtaW46amFzcGVyYWRtaW4=");
        con.setRequestMethod("GET");
        InputStream responseStream = con.getInputStream();
        Files.copy(responseStream, Paths.get("D:/Studia/Podstawy baz danych/Raporty/Uczniowie.pdf"),StandardCopyOption.REPLACE_EXISTING);
        File pdfFile = new File("D:/Studia/Podstawy baz danych/Raporty/Uczniowie.pdf");
        Desktop.getDesktop().open(pdfFile);
    }

    @FXML
    void onForm(ActionEvent event) throws IOException {
        String urlpath = "http://localhost:8081/jasperserver/rest_v2/reports/reports/Reports_Form/Form.docx?";
        String par1 = Param1.getText();
        String strurl=urlpath+"id_kon="+par1;
        URL url = new URL(strurl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestProperty("Authorization","Basic amFzcGVyYWRtaW46amFzcGVyYWRtaW4=");
        con.setRequestMethod("GET");
        InputStream responseStream = con.getInputStream();
        Files.copy(responseStream, Paths.get("D:/Studia/Podstawy baz danych/Raporty/Dyplom.docx"),StandardCopyOption.REPLACE_EXISTING);
        File pdfFile = new File("D:/Studia/Podstawy baz danych/Raporty/Dyplom.docx");
        Desktop.getDesktop().open(pdfFile);
    }
}
