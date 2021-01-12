import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = Player::play;
        Thread thread = new Thread(task);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
        thread.join();
        System.out.println(thread.isAlive());
    }
}
