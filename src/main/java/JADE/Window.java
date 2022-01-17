package JADE;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import java.util.jar.JarFile;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.glfwDefaultWindowHints;

public class Window {
    private int width, height;
    private String title;

    private static Window window = null;
    private JarFile Version;

    private Window() {
        this.width = 1920;
        this.height = 1080;
        this.title = "Mario";
    }

    public static Window get() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void run() {
        System.out.println("Hello LWGLJ" + Version.getVersion() + "!");

        init();
        loop();
    }

    public void init() {
        // Setup an error callback
        GLFWErrorCallback.createPrint(System.err).set();
        
        // Initialize GLFW
        if (!glfwinit()) {
            throw new IllegalStateException("Unable to initialize GLFW.");
        }
        
        // Configure GLFW
        glfwDefaultWindowHints();
        glfwDefaultWindowHint(GLFW_VSIBLE, GLFW_FALSE);
    }

    private boolean glfwinit() {
    }

    public void loop() {

    }
}
