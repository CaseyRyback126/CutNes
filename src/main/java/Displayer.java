import javax.swing.*;
import java.awt.*;
import java.util.List;

public class Displayer {
    public void displayDetails() {
        JFrame frame = new JFrame();
        MaterialSheet sheet = new MaterialSheet(200, 300);
        int width = sheet.getWidth();
        int height = sheet.getHeight();
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                List<Detail> details = sheet.getDetails();
                for (Detail detail : details) {
                    g.drawRect(detail.getX(), detail.getY(), detail.getWidth(), detail.getHeight());
                }
            }
        };

        frame.add(panel);
        frame.setVisible(true);
    }
}
