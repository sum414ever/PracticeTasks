package com.company.sprint13DateTimeIO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class Task7 {

  public static void main(String[] args) {

    System.out.println(readFile("data2.txt"));
  }

  public static String readFile(String filename) {

    String data = "";

    try (FileInputStream fileInputStream = new FileInputStream(filename)) {

      data = new BufferedReader(new InputStreamReader(fileInputStream))
          .lines()
          .collect(Collectors.joining());

    } catch (IOException e) {
      e.printStackTrace();
    }

    String result = "";
    for (int i = 0; i < data.length(); i += 7) {
      result += (char) Integer.parseUnsignedInt(data.substring(i, i + 7), 2);
    }
    return result;
  }
}

//
//  Create the method readFile(String filename) that read from file a sequence of bytes in binary format from previous task and return ridable string.
