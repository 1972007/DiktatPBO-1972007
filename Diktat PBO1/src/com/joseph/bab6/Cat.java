/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab6;

public class Cat implements Pet,Comparable<Cat>{
    private String name;
    private int affection;

    public Cat(String name,int affection) {
        this.name = name;
        this.affection = affection;
    }

    @Override
    public void patReaction() {
        if(affection>=5){
            System.out.println(name + " seems to like your pat");
        }
        else{
            System.out.println(name + " hisses");
            addAffection();
        }
    }
    @Override
    public void addAffection() {
        affection++;
    }

    public int getAffection() {
        return affection;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Cat o) {
        int result = 0;
        if(o.getAffection()>affection){
            result = 1;
        }
        else if(o.getAffection()<affection){
            result = -1;
        }
        return result;
    }
}
