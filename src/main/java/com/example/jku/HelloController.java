package com.example.jku;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import javax.swing.*;
import java.io.*;

public class HelloController {

    @FXML
    private TextField Lightday;

    @FXML
    private TextField Lightnight;

    @FXML
    private Label Test;

    @FXML
    private TextField Watercold;

    @FXML
    private TextField Waterhot;

    @FXML
    private Button pay;
    @FXML
    private Label April;

    @FXML
    private Label August;

    @FXML
    private Label December;

    @FXML
    private Label February;

    @FXML
    private Label January;

    @FXML
    private Label July;

    @FXML
    private Label June;
    @FXML
    private Label March;

    @FXML
    private Label May;

    @FXML
    private Label November;

    @FXML
    private Label October;

    @FXML
    private Label September;
    private static double message;
    @FXML
    private Label month;
    double ligday;
    double lignig;
    double wathot;
    double watcold;

    public String traf;

    String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November",  "December"};

    String[] trafic = {"Ligday", "Lignig", "Wathot", "Watcold"};
    public void Message(){
        File messageRead = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\message.txt");
        try (BufferedReader br = new BufferedReader(new FileReader(messageRead))) {
            String line;
            while ((line = br.readLine()) != null) {
                message = Double.parseDouble(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (message >= 10000){
    JOptionPane.showMessageDialog(null, "Вы привысили лимит в 10.000 рублей!");
}
    }

    @FXML
    void initialize() {
        File read = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\i.txt");

        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(read))) {
            String line;
            while ((line = br.readLine()) != null) {
                k = Integer.parseInt(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Screen(k);
        Message();
    }
    public void Screen(int a){
        month.setText(months[a]);
        File read = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\i.txt");

        int k = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(read))) {
            String line;
            while ((line = br.readLine()) != null) {
                k = Integer.parseInt(line);
                month.setText(months[k]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < months.length; i++){
            File chit = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + ".txt");
            try (BufferedReader br = new BufferedReader(new FileReader(chit))) {
                String line;

                while ((line = br.readLine()) != null) {
                    if (months[i].equals("January")){
                        January.setText(line);
                    }
                    if (months[i].equals("February")){
                        February.setText(line);
                    }
                    if (months[i].equals("March")){
                        March.setText(line);
                    }
                    if (months[i].equals("April")){
                        April.setText(line);
                    }
                    if (months[i].equals("May")){
                        May.setText(line);
                    }
                    if (months[i].equals("June")){
                        June.setText(line);
                    }
                    if (months[i].equals("July")){
                        July.setText(line);
                    }
                    if (months[i].equals("August")){
                        August.setText(line);
                    }
                    if (months[i].equals("September")){
                        September.setText(line);
                    }
                    if (months[i].equals("October")){
                        October.setText(line);
                    }
                    if (months[i].equals("November")){
                        November.setText(line);
                    }
                    if (months[i].equals("December")){
                        December.setText(line);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }


    public void Pay(ActionEvent actionEvent) throws IOException {

        File read = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\i.txt");

        int i = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(read))) {
            String line;
            while ((line = br.readLine()) != null) {
                i = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


            if (i < months.length) {
                File createFile = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + ".txt");
                createFile.createNewFile();

                File createLightFile = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[0] + ".txt");
                createLightFile.createNewFile();

                File createNightFile = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[1] + ".txt");
                createNightFile.createNewFile();

                File createHotFile = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[2] + ".txt");
                createHotFile.createNewFile();

                File createColdFile = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[3] + ".txt");
                createColdFile.createNewFile();
                System.out.println("Файл" + months[i]);


                    if (Lightday.getText().equals("") && i <= 2){
                        ligday = 60 * 3.24;
                        traf = Double.toString(ligday);
                        File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[0] + ".txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                        writer.write(traf);
                        writer.flush();
                    }
                    else if (Lightday.getText().equals("") && 2 < i) {
                        ligday = 0;
                        int k = i - 3;
                        for (; k < i ; k++) {
                            File chit = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[k] + trafic[0] + ".txt");
                            try (BufferedReader br = new BufferedReader(new FileReader(chit))) {
                                String line;
                                while ((line = br.readLine()) != null) {
                                    double errorDay = Double.parseDouble(line);
                                    ligday += errorDay;
                                }
                            }
                        }
                        ligday = (ligday / 3);
                        traf = Double.toString(ligday);
                        File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[0] + ".txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                        writer.write(traf);
                        writer.flush();
                    }
                    else{
                        ligday = Double.parseDouble(Lightday.getText());
                        ligday = ligday * 3.24;
                        traf = Double.toString(ligday);
                        File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[0] + ".txt");
                        BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                        writer.write(traf);
                        writer.flush();
                    }

                if (Lightnight.getText().equals("") && i <= 2){
                    lignig = 30 * 1.69;
                    traf = Double.toString(lignig);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[1] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else if (Lightnight.getText().equals("") && 2 < i) {
                    lignig = 0;
                    int k = i - 3;
                    for (; k < i ; k++) {
                        File chit = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[k] + trafic[1] + ".txt");
                        try (BufferedReader br = new BufferedReader(new FileReader(chit))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                double errorDay = Double.parseDouble(line);
                                lignig += errorDay;

                            }
                        }
                    }
                    lignig = (lignig / 3);
                    traf = Double.toString(lignig);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[1] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else {
                    lignig = Double.parseDouble(Lightnight.getText());
                    lignig = lignig * 1.69;
                    traf = Double.toString(lignig);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[1] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }

                if (Waterhot.getText().equals("") && i <= 2){
                    wathot = 100 * 49.3;
                    traf = Double.toString(wathot);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[2] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else if (Waterhot.getText().equals("") && 2 < i) {
                    wathot = 0;
                    int k = i - 3;
                    for (; k < i ; k++) {
                        File chit = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[k] + trafic[2] + ".txt");
                        try (BufferedReader br = new BufferedReader(new FileReader(chit))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                double errorDay = Double.parseDouble(line);
                                wathot += errorDay;

                            }
                        }
                    }
                    wathot = (wathot / 3);
                    traf = Double.toString(wathot);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[2] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else {
                    wathot = Double.parseDouble(Waterhot.getText());
                    wathot = wathot * 49.3;
                    traf = Double.toString(wathot);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[2] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                if (Watercold.getText().equals("") && i <= 2){
                    watcold = 50 * 49.3;
                    traf = Double.toString(watcold);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[3] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else if (Watercold.getText().equals("") && 2 < i) {
                    watcold = 0;
                    int k = i - 3;
                    for (; k < i ; k++) {
                        File chit = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[k] + trafic[3] + ".txt");
                        try (BufferedReader br = new BufferedReader(new FileReader(chit))) {
                            String line;
                            while ((line = br.readLine()) != null) {
                                double errorDay = Double.parseDouble(line);
                                watcold += errorDay;

                            }
                        }
                    }
                    watcold = (watcold / 3);
                    traf = Double.toString(watcold);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[3] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();
                }
                else {
                    watcold = Double.parseDouble(Watercold.getText());
                    watcold = watcold * 26.5;
                    traf = Double.toString(watcold);
                    File write = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + trafic[3] + ".txt");
                    BufferedWriter writer = new BufferedWriter(new FileWriter(write));
                    writer.write(traf);
                    writer.flush();

                }

                    double all = ligday + lignig + watcold + wathot;
                Screen(i);

                File messageRead = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\message.txt");
                try (BufferedReader br = new BufferedReader(new FileReader(messageRead))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        message = Double.parseDouble(line);
                    }
                }
                message += all;
                String mes = Double.toString(message);
                File messageWrite = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\message.txt");
                BufferedWriter messager = new BufferedWriter(new FileWriter(messageWrite));
                messager.write(mes);


                String str = Double.toString(all);
                File writeAll = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + ".txt");
                BufferedWriter writerAll = new BufferedWriter(new FileWriter(writeAll));
                writerAll.write(str);
                writerAll.flush();
                System.out.println(all);



                i++;
                String str2 = Integer.toString(i);
                BufferedWriter writer = new BufferedWriter(new FileWriter(read));
                writer.write(str2);

                writer.close();
                Screen(i);
                Message();

            }
            else {
                JOptionPane.showMessageDialog(null, "Вы оплатили все месяца!");
            }

        }

    public void Delete(ActionEvent actionEvent) throws IOException {
        for (int i = 0; i < months.length; i++) {
            File writeAll = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\" + months[i] + ".txt");
            BufferedWriter writerAll = new BufferedWriter(new FileWriter(writeAll));
            writerAll.write("0");
            Screen(i);
            writerAll.flush();

            for (int q = 0; q <= months.length; q++) {
                File messageNull = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\message.txt");
                BufferedWriter mesNull = new BufferedWriter(new FileWriter(messageNull));
                mesNull.write("0");
                Screen(i);
                mesNull.flush();


            }
        }
    }

    public void January(ActionEvent actionEvent) throws IOException {
        File writeAll = new File("D:\\Java\\JKU\\src\\main\\resources\\com\\example\\jku\\i.txt");
        BufferedWriter writerAll = new BufferedWriter(new FileWriter(writeAll));
        writerAll.write("0");
        Screen(0);
    }
}
