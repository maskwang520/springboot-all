package com.effectivejava.chapter20.rectify;

/**
 * Created by maskwang on 2017/8/17 0017.
 * class hierarchy replacement for tagged class
 */
abstract class Figure {
    abstract double area();
}
class Rectangle extends Figure{
    final double length;
    final double width;
    Rectangle(double length,double width){
        this.length=length;
        this.width=width;
    }

    @Override
    double area() {
        return width*length;
    }
}
class Circle extends  Figure{
    final double radius;
    Circle(double radius){
        this.radius=radius;
    }
    @Override
    double area() {
        return Math.PI*radius*radius;
    }
}
