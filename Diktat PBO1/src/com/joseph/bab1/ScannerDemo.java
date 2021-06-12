/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab1;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.println("Type something :");
        String code = scan.next();
        scan.nextLine();

        System.out.println("Type something with space: ");
        String longerCode = scan.nextLine();

        System.out.println(code);
        System.out.println(longerCode);
    }
}
