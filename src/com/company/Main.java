package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Please Enter the radius of the circle");
        Integer radius = in.nextInt();

        Thread areaThread = new Thread(new AreaCalcultion(radius));
        Thread circumferenceThread = new Thread(new CircumferenceCalculation(radius));

        areaThread.start();
        circumferenceThread.start();
    }
}

class AreaCalcultion implements Runnable{
    Integer radius;
    AreaCalcultion(Integer radius){
        this.radius = radius;
    }

    @Override
    public void run() {
        System.out.println("The Area of the Circle is "+(3.14 * radius * radius));
    }
}

class CircumferenceCalculation implements Runnable{
    Integer radius;
    CircumferenceCalculation(Integer radius){
        this.radius = radius;
    }
    @Override
    public void run() {
        System.out.println("The Circumference of the Circle is "+( 2 * 3.14 * radius));
    }
}
