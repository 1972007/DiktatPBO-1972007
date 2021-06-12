/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab4;

public class Square extends Shape{
    private double length;

    public Square(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    @Override
    public double getArea() {
        return length*length;
    }

    @Override
    public double getCircumference() {
        return 4*length;
    }

}
