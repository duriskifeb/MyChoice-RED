package NguliaH;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class mainan extends JFrame implements ActionListener, KeyListener {
    private Timer timer;
    private int ballX, ballY, ballXDir, ballYDir;
    private int paddleX, paddleY, paddleWidth, paddleHeight;
    private boolean[][] bricks;
    private int brickRows, brickCols;
    private int score;

    public mainan() {
        setTitle("Brick Breaker Game");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        timer = new Timer(5, this);
        ballX = 190;
        ballY = 350;
        ballXDir = 1;
        ballYDir = 2;

        paddleX = 150;
        paddleY = 330;
        paddleWidth = 60;
        paddleHeight = 10;

        brickRows = 5;
        brickCols = 10;
        bricks = new boolean[brickRows][brickCols];

        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                bricks[i][j] = true;
            }
        }

        score = 0;

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer.start();
    }

    public void actionPerformed(ActionEvent e) {
        moveBall();
        movePaddle();
        checkCollision();
        repaint();
    }

    public void moveBall() {
        ballX += ballXDir;
        ballY += ballYDir;

        if (ballX <= 0 || ballX >= 385) {
            ballXDir = -ballXDir;
        }

        if (ballY <= 0) {
            ballYDir = -ballYDir;
        }

        if (ballY >= 385) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over! Your Score: " + score);
            System.exit(0);
        }
    }

    public void movePaddle() {
        if (paddleX <= 0) {
            paddleX = 0;
        }

        if (paddleX >= 340) {
            paddleX = 340;
        }
    }

    public void checkCollision() {
        Rectangle ballRect = new Rectangle(ballX, ballY, 20, 20);
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);

        if (ballRect.intersects(paddleRect)) {
            ballYDir = -ballYDir;
        }

        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                if (bricks[i][j]) {
                    Rectangle brickRect = new Rectangle(j * 40, i * 20, 40, 20);
                    if (ballRect.intersects(brickRect)) {
                        bricks[i][j] = false;
                        ballYDir = -ballYDir;
                        score += 10;

                        if (score == brickRows * brickCols * 10) {
                            timer.stop();
                            JOptionPane.showMessageDialog(this, "Congratulations! You won!");
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.RED);
        g.fillOval(ballX, ballY, 20, 20);

        g.setColor(Color.BLUE);
        g.fillRect(paddleX, paddleY, paddleWidth, paddleHeight);

        for (int i = 0; i < brickRows; i++) {
            for (int j = 0; j < brickCols; j++) {
                if (bricks[i][j]) {
                    g.setColor(Color.GREEN);
                    g.fillRect(j * 40, i * 20, 40, 20);
                    g.setColor(Color.BLACK);
                    g.drawRect(j * 40, i * 20, 40, 20);
                }
            }
        }

        g.setColor(Color.BLACK);
        g.drawString("Score: " + score, 10, 15);

        Toolkit.getDefaultToolkit().sync();
    }

    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            paddleX -= 20;
        }
        if (key == KeyEvent.VK_RIGHT) {
            paddleX += 20;
        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new mainan().setVisible(true));
    }
}