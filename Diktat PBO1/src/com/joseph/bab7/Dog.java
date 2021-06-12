/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab7;

public class Dog {
    private String name;
    private static int count;
    public final String gender;

    public Dog(String name, String gender) {
        this.name = name;
        this.gender = gender;
        addCount();
    }

    public String getGender() {
        return gender;
    }


    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }

    public static void addCount(){
        count++;
    }
}
