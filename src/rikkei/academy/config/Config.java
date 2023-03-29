package rikkei.academy.config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Config<T> {
    public static final String PATH_CATEGORY = "C:\\Java10\\testProject\\demo\\src\\rikkei\\academy\\database\\catarory.txt";

    public static Scanner scanner(){
        Scanner scanner = new Scanner(System.in);
        return scanner;
    }

    // phương thức đọc file vs tham số generic
    public List<T> readFromFile(String pathFile){
        List<T> tList = new ArrayList<>();
        try {
        FileInputStream fileInputStream = new FileInputStream(pathFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        tList = (List<T>) objectInputStream.readObject();
        fileInputStream.close();
        objectInputStream.close();
        }catch (FileNotFoundException f){
            System.err.println(" file not found!");
        } catch (IOException i) {
            System.err.println("IOE exception!");
        } catch (ClassNotFoundException c) {
            System.err.println("Class not found!");
        }
        return tList;
    }

    // phương thức ghi file tham số generic
    public void writeToFile(String pathFile,List<T> tList){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(pathFile);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(tList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (FileNotFoundException f) {
            System.err.println("File not found!");
        } catch (IOException i) {
            System.err.println("IOE exception");
        }
    }

}
