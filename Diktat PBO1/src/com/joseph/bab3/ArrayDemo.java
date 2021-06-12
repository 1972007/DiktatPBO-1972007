/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab3;

import com.joseph.bab1.Person;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArrayDemo {
    public static void main(String[] args){
        /** * 3 Cara deklarasi array*/
        Person arrayPerson1[] = new Person[3];
        Person[] arrayPerson2 = new Person[3];
        /** * cara ini memperlukan import java.lang.reflect.Array; */
        Person[] arrayPerson3 = (Person[]) Array.newInstance(Person.class,3);

        arrayPerson1[0]=new Person("Joseph",19);
        arrayPerson1[1] = new Person("Setiawan",18);
        arrayPerson1[2] = new Person("Hardadi",17);

        for(int i=0;i<arrayPerson1.length;i+=1){
            arrayPerson1[i].printDetail();
        }

        for(Person person:arrayPerson1){
            person.printDetail();
        }

        int[] arrayNumber = {7,2,51,6,1,654,3};
        Arrays.sort(arrayNumber);
        for(int i=0;i<arrayNumber.length;i+=1){
            System.out.print(arrayNumber[i]+" ");
        }
        System.out.println();

        arrayNumber = Arrays.copyOf(arrayNumber,arrayNumber.length+1);
        arrayNumber[arrayNumber.length-1]=5;

        Set<String> stringSet = new HashSet<>();
    }
}
