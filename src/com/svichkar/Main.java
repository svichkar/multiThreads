package com.svichkar;

import static com.svichkar.helper.AsyncHelper.proceedAsync;
import static com.svichkar.helper.AsyncHelper.proceedAsyncCF;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    new Thread(() -> System.out.println("Started " + Thread.currentThread().getName())).start();

    proceedAsync(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 1 " + Thread.currentThread().getName());
    });

    proceedAsync(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 2 " + Thread.currentThread().getName());
    });

    int i = 5;
    while(i-- != 0) {
      new Thread(() -> proceedAsync(() -> {
        try
        {
          Thread.sleep(1000L);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        System.out.println("Async Task 0 " + Thread.currentThread().getName());
      })).start();
    }

    proceedAsync(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 3 " + Thread.currentThread().getName());
    });

    proceedAsync(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 4 " + Thread.currentThread().getName());
    });

    proceedAsync(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 5 " + Thread.currentThread().getName());
    });


    /*

    proceedAsyncCF(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 1 " + Thread.currentThread().getName());
    });

    proceedAsyncCF(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 2 " + Thread.currentThread().getName());
    });

    proceedAsyncCF(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 3 " + Thread.currentThread().getName());
    });

    proceedAsyncCF(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 4 " + Thread.currentThread().getName());
    });

    proceedAsyncCF(() -> {
      try
      {
        Thread.sleep(5000L);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
      System.out.println("Async Task 5 " + Thread.currentThread().getName());
    });
*/
  }
}
