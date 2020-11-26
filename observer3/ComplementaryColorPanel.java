package observer3;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class ComplementaryColorPanel extends ColorPanel implements PropertyChangeListener {

    public ComplementaryColorPanel(float hue, float saturation, float brightness) {
        super(hue, saturation, brightness);
        DisplayColors.originalColorPanel.addPropertyChangeListener(this);
    }

    public void propertyChange(PropertyChangeEvent evt) {
        float originalHue = DisplayColors.originalColorPanel.getHue();
        float orginalSat = DisplayColors.originalColorPanel.getSaturation();
        float orginalBright = DisplayColors.originalColorPanel.getBrightness();

        float complementaryHue = originalHue - (float) .5;
        if (complementaryHue < 0){
            complementaryHue = complementaryHue + 1;
        }
        Color newCompColor = Color.getHSBColor(complementaryHue,orginalSat, orginalBright);
        this.setColor(newCompColor);
    }


}