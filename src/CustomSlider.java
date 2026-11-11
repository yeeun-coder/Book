
import javax.swing.*;
import javax.swing.plaf.basic.BasicSliderUI;
import java.awt.*;

public class CustomSlider extends BasicSliderUI {

    public CustomSlider(JSlider slider) {
        super(slider);
    }

    @Override
    public void paintThumb(Graphics g) {
        g.setColor(new Color(0,0,0)); // thumb 색
        g.fillOval(thumbRect.x, thumbRect.y, thumbRect.width, thumbRect.height);
    }

    @Override
    public void paintTrack(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(200, 200, 200)); // 트랙 배경
        g2.fillRoundRect(trackRect.x, trackRect.y + 6, trackRect.width, 6, 6, 6);

        g2.setColor(new Color(0, 0, 0)); // 진행된 구간
        int filledWidth = (int) ((slider.getValue() / 100.0) * trackRect.width);
        g2.fillRoundRect(trackRect.x, trackRect.y + 6, filledWidth, 6, 6, 6);
    }
}
