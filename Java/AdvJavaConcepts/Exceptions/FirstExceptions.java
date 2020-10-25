package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class FirstExceptions {

    public void errorWithNoHandler() {
        sayHello(null); //this will throw a NullPointerException and log the call stack
    }

    public void errorWithHandler(String fileName) {
        try {
            FileReader reader = new FileReader(fileName);
        } catch (FileNotFoundException exception) {
            System.out.println("File does not exist");
        }
    }

    public void multipleExceptionsHandled ( String fileName ) {
        FileReader reader = null;
        try {
            reader = new FileReader(fileName);
            var textValue = reader.read();
            new SimpleDateFormat().parse("");
        }catch (IOException exception) {
            System.out.println("Could not read file's data");
        } catch (ParseException exception) {
            exception.printStackTrace();
            System.out.println("Parsing Error Occured");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
            }
        }
    }

    public void exceptionHandlingWithResources ( String inFileName,  String outFileName ) {
        try (
                FileReader reader = new FileReader(inFileName);
                FileWriter writer = new FileWriter(outFileName);
        ) {
            var fileValue = reader.read();
            //do something with file contents
            writer.write(fileValue);
        } catch ( IOException exception ) {
            System.out.println("Could Not Read/Write File");
        }
    }

    public void throwingExceptionsManually (int value) {
        Account myAccount = new Account();
        myAccount.deposit(value);
    }

    public static void sayHello( String name ) {
        System.out.println(name.toUpperCase());
    }

}
