package observer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Observer extends JFrame {


    private boolean leftOpen = true;
    private boolean rightOpen = true;
    private boolean isSmile = true;

    public Observer() throws IOException {
        super("Test frame");
        createGUI();
    }

    public void createGUI() throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(null);

        BufferedImage myPicture = ImageIO.read(new File("src/observer/base.jpg"));
        BufferedImage leftEyeOpen = ImageIO.read(new File("src/observer/left_open.png"));
        BufferedImage leftEyeClose = ImageIO.read(new File("src/observer/left_close.png"));
        BufferedImage rightEyeOpen = ImageIO.read(new File("src/observer/right_open.png"));
        BufferedImage rightEyeClose = ImageIO.read(new File("src/observer/right_close.png"));
        BufferedImage smileImage = ImageIO.read(new File("src/observer/smile.png"));
        BufferedImage smileImageClose = ImageIO.read(new File("src/observer/not_smile.png"));

        JLabel base = new JLabel(new ImageIcon(myPicture));
        base.setBounds(0, 0, 800, 800);
        JLabel left = new JLabel(new ImageIcon(leftEyeOpen));
        left.setBounds(150, 150, 163, 152);
        left.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                left.setIcon(new ImageIcon(leftOpen ? leftEyeClose : leftEyeOpen));
                leftOpen = !leftOpen;
            }
        });

        JLabel right = new JLabel(new ImageIcon(rightEyeClose));
        right.setBounds(510, 125, 192, 197);
        right.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                right.setIcon(new ImageIcon(rightOpen ? rightEyeClose : rightEyeOpen));
                rightOpen = !rightOpen;
            }
        });

        JLabel smile = new JLabel(new ImageIcon(smileImage));
        smile.setBounds(250, 336, 312, 384);
        smile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                smile.setIcon(new ImageIcon(isSmile ? smileImage : smileImageClose));
                isSmile = !isSmile;
            }
        });

        panel.add(right);
        panel.add(smile);
        panel.add(left);
        panel.add(base);


        getContentPane().add(panel);
        setPreferredSize(new Dimension(800, 800));
    }

    public static void main(String[] args) throws IOException {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                Observer frame = null;
                try {
                    frame = new Observer();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}