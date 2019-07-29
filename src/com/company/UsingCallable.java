package com.company;

import java.util.concurrent.*;

public class UsingCallable {

    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<Double> taskAreaCalculation = service.submit(new AreaCalcultionUsingCallable(7));
        Future<Double> taskCircumferenceCalculation = service.submit(new CircumferenceCalculationUsingCallable(7));

        System.out.println(taskAreaCalculation.get());
        System.out.println(taskCircumferenceCalculation.get());
    }
}

class AreaCalcultionUsingCallable implements Callable<Double> {
    Integer radius;
    AreaCalcultionUsingCallable(Integer radius){
        this.radius = radius;
    }

    @Override
    public Double call() {
        return (Math.PI * radius * radius);
    }
}

class CircumferenceCalculationUsingCallable implements Callable<Double>{
    Integer radius;
    CircumferenceCalculationUsingCallable(Integer radius){
        this.radius = radius;
    }
    @Override
    public Double call() {
        return ( 2 * Math.PI * radius);
    }
}
