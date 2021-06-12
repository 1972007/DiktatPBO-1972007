/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab3;


import java.util.*;

public class CollectionDemo {
    public static void main(String[] args){
        String[] strArr = {"Joseph","Joseph","Setiawan","Hardadi"};
        Set<String> stringSet = new HashSet<>(Arrays.asList(strArr));
        System.out.println("Isi Set : "+stringSet);

        List<String> stringArrayList = new ArrayList<>(Arrays.asList(strArr));
        stringArrayList.add("1972007");
        System.out.println("Isi ArrayList : "+stringArrayList);

        List<String> stringLinkedList = new LinkedList<>(Arrays.asList(strArr));
        stringLinkedList.add("1972007");
        System.out.println("Isi LinkedList : "+stringLinkedList);
        System.out.println();

        System.out.println("Queue demo");
        Queue<String> stringQueue = new LinkedList<>(Arrays.asList("Joseph", "Joseph", "Setiawan", "Hardadi"));
        System.out.println(stringQueue);
        System.out.println(stringQueue.peek());
        System.out.println("Removed "+stringQueue.remove());
        System.out.println(stringQueue);
        System.out.println();

        System.out.println("Stack demo");
        Stack<String> stringStack = new Stack<>();
        stringStack.push("Joseph");
        stringStack.push("Setiawan");
        stringStack.push("Hardadi");
        System.out.println(stringStack);
        System.out.println("Removed "+stringStack.pop());
        System.out.println(stringStack);
    }
}
