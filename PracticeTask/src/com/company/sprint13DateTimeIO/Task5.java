package com.company.sprint13DateTimeIO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Task5 {

  public static void main(String[] args) {
    System.out.println(readFile("data.txt"));
  }

  public static String readFile(String filename) {

    File file = new File(filename);
    String line = "";
    String result = "";
    try {
      FileReader fr = new FileReader(file);
      BufferedReader br = new BufferedReader(fr);

      while ((line = br.readLine()) != null) {
        result += line + "\n";
      }
    } catch (IOException e) {
      e.printStackTrace();
    }

    return result;
  }
}

//  Write a method to read from a file a character-oriented data and return these data as String object.
//
//    For example, next fragment:
//
//
//
//    after reading will be transform to the next String object:
//
//
//    "This is text fragment\nthat contains some text data\nand can be read!"