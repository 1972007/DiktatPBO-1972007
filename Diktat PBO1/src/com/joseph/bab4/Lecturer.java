/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab4;

import java.util.Arrays;

public class Lecturer extends Employee{
    private String[] lectureList;

    public Lecturer(String name, String id) {
        super(name, id);
    }

    public void setLectureList(String[] lectureList) {
        this.lectureList = lectureList;
    }

    @Override
    public String toString() {
        return  "Name : " + name + '\n' +
                "Id : " + getId() + '\n' +
                "Lecture List : " + Arrays.toString(lectureList);
    }
}
