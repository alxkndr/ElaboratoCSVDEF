package com.example.elaboratocsvdef;

import java.util.Random;

public class Functions {
    public static void addRecord(){
        int min = 10;
        int max = 20;
        int numero = (int)(Math.random() * (max - min + 1)) + min;
    }
}
