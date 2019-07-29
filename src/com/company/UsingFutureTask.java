package com.company;

import java.util.concurrent.*;

public class UsingFutureTask {
    public static void main(String[] args) throws Exception {
        ExecutorService service = Executors.newFixedThreadPool(2);
        FutureTask<Double> areaTask = new FutureTask<>(new AreaCalcultionFutureTask(7));
        FutureTask<Double> circumferenceTask = new FutureTask<>(new CircumferenceCalculationUsingFutureTask(7));

        service.execute(areaTask);
        service.execute(circumferenceTask);

        System.out.println(areaTask.get());
        System.out.println(circumferenceTask.get());
    }
}

class AreaCalcultionFutureTask implements Callable<Double> {
    Integer radius;
    AreaCalcultionFutureTask (Integer radius){
        this.radius = radius;
    }

    @Override
    public Double call() {
        return (Math.PI * radius * radius);
    }
}

class CircumferenceCalculationUsingFutureTask implements Callable<Double>{
    Integer radius;
    CircumferenceCalculationUsingFutureTask (Integer radius){
        this.radius = radius;
    }
    @Override
    public Double call() {
        return ( 2 * Math.PI * radius);
    }
}


