package com.ucv;

import com.jogamp.opengl.util.FPSAnimator;

import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.swing.*;
import java.io.IOException;

public class Window {
    private JFrame frame;
    private GLCanvas canvas;
    private GLCapabilities cap;
    private FPSAnimator animator;
    private Render render;

    /**
     * Crates a JFrame and sets default settings (title, exit, size). Defines GL Canvas to draw with.
     */
    public Window() {
        frame = new JFrame("Computer graphics - desert");
        cap = new GLCapabilities(GLProfile.getDefault());
        cap.setDoubleBuffered(true);
        canvas = new GLCanvas(cap);

        frame.setSize(921*2, 529*2);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);

        render = new Render();
        canvas.addGLEventListener(render);

        //stabilim numarul de fps-uri. fpsanimator este un thread care incearca sa nu foloseasca mereu cpu
        animator = new FPSAnimator(120);
        animator.add(canvas);
        animator.start();

        canvas.addKeyListener(render);
        frame.addKeyListener(render);
    }

    /**
     * Creates a new OpenGL Window
     *
     * @throws IOException
     */
    public static void main(String[] args) {
        new Window();
    }
}
