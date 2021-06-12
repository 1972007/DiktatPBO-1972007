/**
 * @author Joseph Setiawan Hardadi (1972007)
 */

package com.joseph.bab1;

import java.util.Random;

public class Person {
    private String nama;
    private int umur;
    private final int KEY;
    public Person() {
        KEY =new Random().nextInt();
    }
    public Person(String nama, Integer umur) {
        this.nama = nama;
        this.umur = umur;
        KEY =new Random().nextInt();
    }



    public void printDetail(){
        System.out.println("Nama = "+nama);
        System.out.println("Umur = "+umur);
        System.out.println("Id = "+KEY);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getUmur() {
        return umur;
    }

    public void setUmur(Integer umur) {
        this.umur = umur;
    }
}
