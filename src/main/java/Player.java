import com.pi4j.io.gpio.GpioPinDigitalOutput;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Player {
    public static void play(GpioPinDigitalOutput relayController) {
        while (!Thread.currentThread().isInterrupted()) {
            System.out.println("Start playing");
            ProcessBuilder pb =
                    new ProcessBuilder("ffplay", "-autoexit", "-nodisp", "bip1.mp3");
            File log = new File("log");
            pb.redirectErrorStream(true);
            //pb.redirectOutput(ProcessBuilder.Redirect.appendTo(log));
            try {
                Process p = pb.start();
                assert pb.redirectInput() == ProcessBuilder.Redirect.PIPE;
                assert pb.redirectOutput().file() == log;
                assert p.getInputStream().read() == -1;
                relayController.high();
                p.waitFor();
                System.out.println("Stop playing");
                relayController.low();
                TimeUnit.SECONDS.sleep(20);
            } catch (IOException | InterruptedException e) {
                System.out.println("Player was interrupted");
                Thread.currentThread().interrupt();
            }

        }
    }

    public static void play(int i) {
        System.out.println(i);
        while (!Thread.currentThread().isInterrupted()) {

        }
    }
}

