import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int i = 1;
        Runnable task = () -> Player.play(i);
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        thread.join();
        System.out.println(thread.isAlive());
    }
}
