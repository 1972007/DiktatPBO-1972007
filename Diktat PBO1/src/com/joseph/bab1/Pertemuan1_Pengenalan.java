/**
 * @author Joseph Setiawan Hardadi (1972007)
 */

package com.joseph.bab1;

import java.util.ArrayList;
import java.util.Scanner;

public class Pertemuan1_Pengenalan {
    private ArrayList<Integer> listAngka = new ArrayList<>();



    public static void main(String[] args){
        byte bytes = 12;
        char chars = 687;
        int strToInt = Integer.parseInt("512");
        System.out.println("Diktat Pemrograman Berbasis Objek 1");
        System.out.println(bytes+" "+chars);

        Person person = new Person("Joseph",19);
        person.printDetail();

        if(person.getUmur()>18){
            System.out.println(person.getNama()+" berumur lebih dari 18 tahun");
        }
        else{
            System.out.println(person.getNama()+" masih dibawah 18 tahun");
        }
        int day  = 11;
        for(int i=1;i<=7;i+=1){
            dayName(i);
        }
        int i = 1;
        while(i<=7){
            dayName(i);
            i+=1;
        }
        int input = 0;
        Scanner scan = new Scanner(System.in);
        do{
            input = scan.nextInt();
            dayName(input);
        }while(input!=999);


    }

    public static void dayName(int day){
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("invalid day number");
                break;
        }
    }
}
