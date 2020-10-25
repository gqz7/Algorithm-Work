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

    public void throwingExceptionsManually (int value) throws IOException {
        Account myAccount = new Account();
        try {
            myAccount.deposit(-1);
        } catch (IOException exception) {
//            exception.printStackTrace(); //this would give info to devs as to where to look in the code for the reason for the error
//            System.out.println("An Error Occurred Depositing"); //this is where a detailed message could go to give the the user
            throw exception; // this will make the exception need to be handled by the caller of this method
        }
    }

    public static void sayHello( String name ) {
        System.out.println(name.toUpperCase());
    }

}
