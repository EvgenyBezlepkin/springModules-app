package jugru.custom_scope.base;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

@Component
@Scope("periodical")
public class ColorFrame extends JFrame {

    @Autowired
    private Color color;

    public ColorFrame() throws HeadlessException {
        setSize(200, 180);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @PreDestroy
    public void destroy() {
        setVisible(false);
    }

    public void showOnRandomPlace() {
        Random random = new Random();
        setLocation(random.nextInt(1000), random.nextInt(700));
        getContentPane().setBackground(color);
        repaint();
    }
}
