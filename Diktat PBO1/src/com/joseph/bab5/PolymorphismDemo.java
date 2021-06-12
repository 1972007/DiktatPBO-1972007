/**
 * @author Joseph Setiawan Hardadi (1972007)
 */
package com.joseph.bab5;

import com.joseph.bab4.Circle;
import com.joseph.bab4.Shape;
import com.joseph.bab4.Square;

public class PolymorphismDemo {
    public static void main(String[] args){
        /** menggunakan code dari com.joseph.bab4*/
        Circle circle1 = new Circle(4.9);
        Circle circle2 = new Circle(5.4);
        Square square1 = new Square(4.9);
        Square square2 = new Square(5.4);
        Shape[] shapes = {circle1,circle2,square1,square2};
        for (Shape shape : shapes) {
            System.out.println(shape.getArea());
        }
        for (Shape shape : shapes) {
            if(shape instanceof Circle){
                System.out.print("Circle's Area : ");
            }
            else if(shape instanceof  Square){
                System.out.print("Square's Area : ");
            }
            System.out.println(shape.getArea());
        }

        Circle circleTemp = (Circle) shapes[1];
        System.out.println(circleTemp.getArea());

        Shape shapeTemp = (Circle) circle1;
    }
}
