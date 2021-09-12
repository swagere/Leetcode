package real.m9_12_aqy;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main3 {
    public static void main(String[] args) throws InterruptedException {
        final Scanner reader = new Scanner(System.in);
        final String next = reader.next();
        String[] orders = next.substring(1, next.length() - 1).split(",");
        FooPrint foo = new FooPrint();
        Thread thread1 = new Thread(() -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        List<Thread> threads = Arrays.asList(thread1, thread2, thread3);
        for (int i = 0; i < orders.length; i++) {
            threads.get(Integer.parseInt(orders[i]) - 1).start();
        }
        reader.close();
    }
}

class FooPrint {
	int flag = 1;
	
	ReentrantLock lock = new ReentrantLock();
			
	Condition condition1 = lock.newCondition();
	Condition condition2 = lock.newCondition();
	Condition condition3 = lock.newCondition();
	

    public FooPrint() {
    }

    public void first(Runnable printFirst) throws InterruptedException {
    	lock.lock();
    	try {
    		while (flag != 1) {
        		condition1.await();
        	}
        	
        	flag = 2;
        	System.out.print("first");
        	condition2.signal();
    	}
    	catch (Exception e) {}
    	finally {
    		lock.unlock();
    	}
    }

    public void second(Runnable printSecond) throws InterruptedException {
    	lock.lock();
    	try {
    		while (flag != 2) {
        		condition2.await();
        	}
        	
        	flag = 3;
        	System.out.print("second");
        	condition3.signal();
    	}
    	catch (Exception e) {}
    	finally {
    		lock.unlock();
    	}
    }

    public void third(Runnable printThird) throws InterruptedException {
    	lock.lock();
    	try {
    		while (flag != 3) {
        		condition3.await();
        	}
        	
        	flag = 1;
        	System.out.print("third");
        	condition1.signal();
    	}
    	catch (Exception e) {}
    	finally {
    		lock.unlock();
    	}
    }
}
