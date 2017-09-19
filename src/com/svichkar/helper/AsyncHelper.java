package com.svichkar.helper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHelper
{
  private static ExecutorService pool = Executors.newSingleThreadExecutor();

  public static void proceedAsync(Runnable runnable)
  {
    pool.submit(() -> {
      System.out.println(Thread.currentThread().getName());
      runnable.run();
    });
  }

  public static void proceedAsyncCF(Runnable runnable)
  {
    CompletableFuture.runAsync(() -> {
      System.out.println(Thread.currentThread().getName());
      runnable.run();
    });
  }
}
