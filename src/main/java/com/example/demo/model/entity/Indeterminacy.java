package com.example.demo.model.entity;

public class Indeterminacy extends Thread{

    public static int cont = 0;

    public void run () {
        for(int i = 0; i < 100; i++){
            cont ++;
        }
        System.out.println(cont);
    }

}
