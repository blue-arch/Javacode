package snakeGame;
/*在Java  swing中的button无法设置圆角按钮，为了一定程度上完善游戏界面，故而设置了圆角按钮。
 * 定义圆角按钮；
 */
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;

public class RButton extends JButton {
    private static final long serialVersionUID = 39082560987930759L;
    public static final Color BUTTON_COLOR1 = new Color(205, 255, 205);     //设置按钮的第一种颜色
    public static final Color BUTTON_COLOR2 = new Color(51, 55, 47);        //设置按钮的第二种颜色
    // public static final Color BUTTON_COLOR1 = new Color(125, 161, 237);
    // public static final Color BUTTON_COLOR2 = new Color(91, 118, 173);
    public static final Color BUTTON_FOREGROUND_COLOR = Color.WHITE;
    private boolean hover;

    public RButton(String name) {
        this.setText(name);   //添加名字
        setFont(new Font("system", Font.PLAIN, 12)); //设置字体
        setBorderPainted(false);               //设置边界可见否
          setForeground(BUTTON_COLOR2);           //设置前景色
         setFocusPainted(false);                   
          setContentAreaFilled(false);  
          //定义鼠标事件，即当鼠标进入到按钮界面时，按钮颜色会发生变化，鼠标离开按钮区域时也会发生变化
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setForeground(BUTTON_FOREGROUND_COLOR);
                hover = true;
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setForeground(BUTTON_COLOR2);
                hover = false;
                repaint();
            }
        });
    }
   //设置按钮圆角
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        int h = getHeight();
        int w = getWidth();
        float tran = 1F;
        if (!hover) {
            tran = 0.3F;
        }

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint p1;
        GradientPaint p2;
        //当点击按钮之后，按钮颜色和字体会发生变化
        if (getModel().isPressed()) {
            p1 = new GradientPaint(0, 0, new Color(0, 0, 0), 0, h - 1,
                    new Color(100, 100, 100));
            p2 = new GradientPaint(0, 1, new Color(0, 0, 0, 50), 0, h - 3,
                    new Color(255, 255, 255, 100));
        } else {
            p1 = new GradientPaint(0, 0, new Color(100, 100, 100), 0, h - 1,
                    new Color(0, 0, 0));
            p2 = new GradientPaint(0, 1, new Color(255, 255, 255, 100), 0,
                    h - 3, new Color(0, 0, 0, 50));
        }
        
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
                tran));
        RoundRectangle2D.Float r2d = new RoundRectangle2D.Float(0, 0, w - 1,
                h - 1, 20, 20);
        Shape clip = g2d.getClip();
        g2d.clip(r2d);
        GradientPaint gp = new GradientPaint(0.0F, 0.0F, BUTTON_COLOR1, 0.0F,
                h, BUTTON_COLOR2, true);
     
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, w, h);
        g2d.setClip(clip);
        g2d.setPaint(p1);
        g2d.drawRoundRect(0, 0, w - 1, h - 1, 20, 20);
        g2d.setPaint(p2);
        g2d.drawRoundRect(1, 1, w - 3, h - 3, 18, 18);
        g2d.dispose();
        super.paintComponent(g);
    }
}

