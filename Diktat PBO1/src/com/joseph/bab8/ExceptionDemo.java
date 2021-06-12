/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab8;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static double multiply(double var1,double var2) throws CustomException{
        if(var1<0 || var2<0){
            throw new CustomException("This method only accept positive numbers");
        }
        return var1*var2;
    }
    public static void main(String[] args){
        try {
            System.out.println(multiply(-1.1,1.2));
        } catch (CustomException e) {
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Input integer : ");
            int scanInt = scan.nextInt();
            System.out.println("Hasil Input : "+scanInt);
        }catch (InputMismatchException exception){
            System.out.println("Input harus angka bulat");
        }
        finally {
            System.out.println("Ini akhir input");
        }
    }

}
