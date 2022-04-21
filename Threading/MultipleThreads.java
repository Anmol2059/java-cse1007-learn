
import java.util.*;
/**
 * Creating Multiple Threads by implementing Runnable Inteface
 * Thread.sleep(ms) will put currently running thread on sleep
 */
public class MultipleThreads implements Runnable {
    private String name;
    private Thread t;
    public MultipleThreads(String threadName){
        this.name = threadName;
        t = new Thread(this, name);
        System.out.println(t.getName() + " thread has started ..");
        t.start();
    }

    public long factorial(int n){
        return (n == 0 || n == 1)? 1 :n * factorial(n-1);
    }

    @Override
    public void run() {
        System.out.println(factorial(5));
    }

    public static void main(String[] args) throws InterruptedException {
        //MultipleThreads mt1 =  new MultipleThreads("Alpha");
        //System.out.println(mt1.factorial(5));
        Thread.sleep(1000);
        new MultipleThreads("Pramit");
        new MultipleThreads("Beta");
        new MultipleThreads("Gamma");
    }
}