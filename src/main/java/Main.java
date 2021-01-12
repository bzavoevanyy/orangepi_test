public class Main {
    public static void main(String[] args) throws InterruptedException {

        Runnable task = Player::play;
        Thread thread = new Thread(task);
        thread.start();
    }
}
