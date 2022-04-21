public class PramitThreads implements Runnable {
    private String name;
    private Thread t;
    public PramitThreads(String threadName){
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
}