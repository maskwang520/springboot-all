package com.effectivejava.chapter20;

/**
 * Created by maskwang on 2017/8/17 0017.
 * disadvantage:tagged class is so long.they are more easier to make a mistake.They has low
 * efficiency
 */
public class Figure {
    enum Shap {
        RECTANGLE,CIRCLE
    };
    final Shap shap;
    double length;
    double width;
    double radius;
    Figure(double radius){
        shap=Shap.CIRCLE;
        this.radius=radius;
    }
    Figure(double length,double width){
        shap=Shap.RECTANGLE;
        this.length=length;
        this.width=width;
    }
    double area(){
        switch (shap){
            case RECTANGLE:return width*length;
            case CIRCLE:return Math.PI*radius*radius;
            default:throw  new AssertionError();
        }

    }

    public static void main(String[] args) {
        Figure figure=new Figure(2);
        System.out.println(figure.area());
    }
}
