package com.svichkar.helper;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AsyncHelper
{
  private static ExecutorService executorService = Executors.newSingleThreadExecutor();

  public static void proceedAsync(Runnable runnable)
  {
    executorService.submit(() -> {
      runnable.run();
      System.out.println("After " + Thread.currentThread().getName());
    });
  }
}
