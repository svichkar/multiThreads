package com.svichkar;

import static com.svichkar.helper.AsyncHelper.proceedAsync;

public class Main
{
  public static void main(String[] args) throws Exception
  {
    System.out.println("Main Task" + " "
        + Thread.currentThread().getName() + " started");

    int i = 0;
    while (i++ != 1000)
    {
      int finalI = i;
      System.out.println("Before starting task" + finalI + " " + Thread.currentThread().getName());
      proceedAsync(() -> {
        System.out.println("Async Task " + finalI + " "
            + Thread.currentThread().getName() + " started");
        try
        {
          Thread.sleep(15_000L);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
        System.out.println("Async Task " + finalI + " "
            + Thread.currentThread().getName() + " finished");
      });
      System.out.println("After starting task" + finalI + " " + Thread.currentThread().getName());
    }

    System.out.println("Main Task" + " "
        + Thread.currentThread().getName() + " continued");

    Thread.sleep(600_000L);

    System.out.println("Main Task" + " "
        + Thread.currentThread().getName() + " finished");

    System.exit(0);
  }
}
