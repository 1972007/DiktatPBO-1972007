/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab4;

public class EmployeeDemo {
    public static void main(String[] args){
        Lecturer lecturer = new Lecturer("Joseph","972007");
        lecturer.setLectureList(new String[]{"Dasar Pemrograman","Pemrograman Web"});
        Employee employee = new Employee("Budi","112233");
        System.out.println(lecturer.toString());
        System.out.println();
        System.out.println(employee.toString());
    }
}
