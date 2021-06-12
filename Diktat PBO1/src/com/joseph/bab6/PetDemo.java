/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab6;

public class PetDemo {
    public static void main(String[] args){
        Cat cat1 = new Cat("Willow",5);
        Cat cat2 = new Cat("Garfield",4);

        System.out.println(cat1.getName()+" Affection = "+cat1.getAffection()+
                      "\n"+cat2.getName()+" Affection = "+cat2.getAffection());
        System.out.println("Comparison : "+cat1.getName()+" and "+cat2.getName()+" : "+cat1.compareTo(cat2));
        cat1.patReaction();
        cat2.patReaction();
        cat2.patReaction();
        System.out.println("Comparison : "+cat1.getName()+" and "+cat2.getName()+" : "+cat1.compareTo(cat2));
    }
}
