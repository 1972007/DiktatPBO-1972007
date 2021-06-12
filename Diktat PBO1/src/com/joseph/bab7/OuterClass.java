/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab7;

public class OuterClass {
    private int angka1;
    private String string1;
    private final InnerClass INNER_CLASS;

    public OuterClass(int angka1, String string1) {
        this.angka1 = angka1;
        this.string1 = string1;
        INNER_CLASS = new InnerClass(2,"Ini inner");
    }
    public void printDetail(){
        System.out.println("Angka : "+angka1);
        System.out.println("String : "+string1);
        INNER_CLASS.printDetail();
    }

    static class InnerClass{
        private int angka2;
        private String string2;

        public InnerClass(int angka2, String string2) {
            this.angka2 = angka2;
            this.string2 = string2;
        }
        public void printDetail(){
            System.out.println("Angka : "+angka2);
            System.out.println("String : "+string2);
        }
    }
}
