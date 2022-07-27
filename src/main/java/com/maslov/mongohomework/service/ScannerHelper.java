package com.maslov.mongohomework.service;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ScannerHelper {

    Scanner scanner = new Scanner(System.in);

    public int getIntFromUser() {
        return scanner.nextInt();
    }

    public String getFromUser() {
        return scanner.nextLine();
    }

    public String getEmptyString() {
        return scanner.nextLine();
    }
}
