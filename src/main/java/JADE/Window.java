package JADE;

import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;
import org.lwjgl.opengl.GL;
import org.lwjgl.system.MemoryUtil;

import java.util.jar.JarFile;

import static org.lwjgl.glfw.GLFW.*;

public class Window {
    private static final int GLFE_MAXIMIZED = ;
    private int width, height;
    private String title;
    private long glfwWindow;

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
        glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE);
        glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE);
        glfwWindowHint(GLFE_MAXIMIZED, GLFW_TRUE);

        // Create the window
        glfwWindow = glfwCreateWindow(this.width, this.height, this.title, MemoryUtil.NULL, MemoryUtil.NULL);
        if (glfwWindow == MemoryUtil.NULL) {
            throw new IllegalStateException("Failed to vreate GLFW window.");
        }

        // make the OpenGl context current
        glfwMakeContextCurrent(glfwWindow);
        // Enable v-sync
        glfwSwapInterval(1);

        //Make window visible
        glfwShowWindow(glfwWindow);

        // This line is critical for LWJGL's interoperation with GLFW's
        //OpenGL context, or any context that is managed externally.
        //LWJGL detects the context that is current in the current thread,
        //bindings available to use.
        GL.createCapabilities();
    }

    private boolean glfwinit() {
    }

    public void loop() {

    }
}
