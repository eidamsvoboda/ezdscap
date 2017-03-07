import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static final String VERSION = "0.1";

    public static void main(String[] args) {
        System.out.println("Easy device screen capture " + VERSION + "\n\n"
                + "Shift + Alt + P - take screenshot of all connected Android devices");

        initializeGlobalKeyListener();
    }

    public static void initializeGlobalKeyListener() {
        //Disable logging for key listening
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.OFF);
        logger.setUseParentHandlers(false);

        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            System.out.println("Native hook cant be registered, accessibility settings probably not set");
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyListener());
    }

}