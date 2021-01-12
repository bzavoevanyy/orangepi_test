import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Player {
    public static void play() {
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
                TimeUnit.SECONDS.sleep(10);
            } catch (IOException | InterruptedException e) {
                System.out.println("Player was interrupted");
                Thread.currentThread().interrupt();
            }
        }
    }
}

