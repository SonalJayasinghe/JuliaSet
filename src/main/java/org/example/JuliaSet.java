package org.example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JuliaSet extends JFrame implements ActionListener {
    private static final int MAX_ITERATION = 1000;
    private static final double RADIUS = 3;   //Radius(R)  Choose R > 0 such that R**2 - R >= sqrt(cx**2 + cy**2)
    private static final int WIDTH = 800;
    private static final int HEIGHT = 800;

    private final ComplexNumbers c = new ComplexNumbers(-0.75, 0.1); //Complex Number C

    private boolean initialState = true;

    public static void main(String[] args) {
        new JuliaSet();
    }

    public JuliaSet() {
        super("Julia Set");
        JButton button = new JButton("Create");
        setSize(WIDTH, HEIGHT);
        add(button);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button.setLayout(null);
        button.setLocation(10, 10);
        button.setSize(100, 25);
        button.addActionListener(this);
        setVisible(true);
    }


    public void paint(Graphics g) {
        super.paint(g);
        if (!initialState) {
            for (int y = 0; y < HEIGHT; y++) {
                for (int x = 0; x < WIDTH; x++) {
                    double zx = (x - WIDTH / 2.0) * 4.0 / WIDTH;    // scale to be between -R and R
                    double zy = (y - HEIGHT / 2.0) * 4.0 / HEIGHT;  // scale to be between -R and R
                    ComplexNumbers z = new ComplexNumbers(zx, zy);

                    int iteration = 0;
                    while (Math.pow(z.getReal(),2) + Math.pow(z.getImagine(),2) < RADIUS*RADIUS && iteration < MAX_ITERATION) {
                        z = z.multiply(z).add(c);
                        iteration++;
                    }

                    int changeColor = 0; // Change this to get visible output to the screen
                    if (iteration == MAX_ITERATION)
                        g.setColor(Color.BLACK);
                    else
                        g.setColor(new Color(iteration - changeColor));
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        initialState = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }
}