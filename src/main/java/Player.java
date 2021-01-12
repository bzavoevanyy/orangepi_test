import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class Player {
    public static void play() {
//        Runnable task = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.println("Start playing");
                ProcessBuilder pb =
                        new ProcessBuilder("ffplay", "-autoexit", "-nodisp", "bip.mp3");
                File log = new File("log");
                pb.redirectErrorStream(true);
                pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
                try {
                    Process p = pb.start();
                    assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
                    assert pb.redirectOutput().file() == log;
                    assert p.getInputStream().read() == -1;
                    p.waitFor();
                    System.out.println("Stop playing");

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    TimeUnit.SECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
//        Thread thread = new Thread(task);
//        thread.start();
//        System.out.println("stop playing");
    }
//}
