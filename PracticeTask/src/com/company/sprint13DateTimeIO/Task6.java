package com.company.sprint13DateTimeIO;

import java.io.FileOutputStream;
import java.io.IOException;

public class Task6 {

  public static void main(String[] args) {

    writeFile("data2.txt", "Hello!");

  }

  public static void writeFile(String filename, String text) {

    String result = "";
    char[] messChar = text.toCharArray();

    for (int i = 0; i < messChar.length; i++) {
      String s = Integer.toBinaryString(messChar[i]);
      while (s.length() < 7) {
        s = "0" + s;
      }
      result += s;
    }

    byte[] wData = result.getBytes();
    try (FileOutputStream fileOutputStream = new FileOutputStream(filename)) {
      fileOutputStream.write(wData);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}

//  Create the method writeFile(String filename, String text) that write the text to file as sequence of bytes in binary format.
//
//    For example, the text fragment
//
//
//    should be represented in the file as a sequence of 7-bit bytes without spaces between them:
//
//
//    If less than 7 bits are required to represent the character then add to binary sequence leading zeros '0'.