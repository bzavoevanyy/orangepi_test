import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
import com.pi4j.util.ConsoleColor;

public class App {
    public static void main(String[] args) {
        final GpioController gpio = GpioFactory.getInstance();
        Pin pin = CommandArgumentParser.getPin(OrangePiPin.class, OrangePiPin.GPIO_00, args);

        GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(pin);
        PinState myButtonState = myButton.getState();
        Console console = new Console();
        console.println(pin.getSupportedPinModes());
//        System.out.println(myButtonState.toString());
    }
}
