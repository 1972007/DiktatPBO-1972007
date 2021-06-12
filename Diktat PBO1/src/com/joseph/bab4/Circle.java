/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab4;

public class Circle extends Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.PI*radius*radius;
    }

    @Override
    public double getCircumference() {
        return 2*Math.PI*radius;
    }
}
