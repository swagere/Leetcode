package juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

//Fork/Join分支合并框架
public class forkJoinDemo {

	public static void main(String[] args) throws Exception, Exception {
		MyTask task = new MyTask(1, 100);
		//创建分支合并池对象
		ForkJoinPool forkJoinPool = new ForkJoinPool();
		ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);
		Integer res = forkJoinTask.get();
		System.out.println(res);
		//关闭池对象
		forkJoinPool.shutdown();
	}

}

class MyTask extends RecursiveTask<Integer> {
	private static final int VALUE = 10;
	private int begin;
	private int end;
	private int result;
	
	public MyTask(int begin, int end) {
		this.begin = begin;
		this.end = end;
		this.result = 0;
	}

	@Override
	protected Integer compute() {
		if (end - begin <= VALUE) {
			for (int i = begin; i <= end; i++) {
				result += i;
			}
		}
		else {
			int mid = (this.begin + this.end) / 2;
			MyTask task1 = new MyTask(begin, mid);
			MyTask task2 = new MyTask(mid + 1, end);
			task1.fork();
			task2.fork();
			result = task1.join() + task2.join();
		}
		return result;
	}
	
}
