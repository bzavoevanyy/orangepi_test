import com.pi4j.io.gpio.*;

public class App {
    public static void main(String[] args) {
        final GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalInput myButton = gpio.provisionDigitalInputPin(OrangePiPin.GPIO_00);
        PinState myButtonState = myButton.getState();
        System.out.println(myButtonState.toString());
    }
}
