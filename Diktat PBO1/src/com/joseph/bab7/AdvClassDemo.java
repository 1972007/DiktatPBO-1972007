/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab7;

public class AdvClassDemo {
    public static void main(String[] args){
        Dog dog1 = new Dog("Hachi", "Male");
        Dog dog2 = new Dog("Diego", "Male");

        System.out.println(dog1.getName()+" and "+dog2.getName());
        System.out.println("Dog count : "+Dog.getCount());

        OuterClass outerClass = new OuterClass(1,"Ini outer");
        outerClass.printDetail();
    }
}
