package juc;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		//û�з���ֵ
		CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(()->{
			System.out.println("hello");
		});
		
		completableFuture1.get();
		
		//�з���ֵ
		CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
			System.out.println("hi");
			return 1;
		});
		
		completableFuture2.whenComplete((u,t)-> {
			System.out.println(u);
			System.out.println(t);
		}).get();
	}

}
