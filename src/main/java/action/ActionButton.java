package action;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;

public class ActionButton extends JButton {
    
    private boolean mousePress;
    
    public ActionButton() {
        setContentAreaFilled(false);
        addMouseListener(new MouseAdapter() {
            
            public void mousePress(MouseEvent me) {
                mousePress = true;
            }
            
            @Override
            public void mouseReleased(MouseEvent me) {
                mousePress = false;
            }
        });
    }
    
    protected void paintComponenent (Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int width = getWidth();
        int height = getHeight();
        int size = Math.min(width, height);
        int x = (width - size ) / 2;
        int y = (height - size) / 2;
        if (mousePress) {
            g2.setColor(new Color(158, 158, 158 ));
        } else {
            g2.setColor(new Color(199, 199, 199));
        }
    }
}
