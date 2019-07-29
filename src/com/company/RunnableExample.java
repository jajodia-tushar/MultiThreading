package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class RunnableExample {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        List<Future<String>> list = new ArrayList<Future<String>>();
        Callable<String> call = new ThreadNameExample();
        for(int i = 0; i < 1000; i++){
            Future<String> future = service.submit(call);
            list.add(future);
        }

        for (Future<String> future:
                list) {
            System.out.println(System.currentTimeMillis()+"::::"+future.get());
        }
    }
}

class ThreadNameExample implements Callable<String>{

    public String call() throws Exception{
        Thread.sleep(1000);
        return Thread.currentThread().getName();
    }
}
