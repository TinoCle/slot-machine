package slotmachine.ui.view;

import slotmachine.ui.handler.IReelHandler;
import slotmachine.ui.handler.IReelsHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ReelView implements IReelView, IReelsHandler {
    private JPanel panel;
    private List<IReelHandler> reels;

    public ReelView(int qty){
        panel= new JPanel(new GridLayout(1,qty));
        reels = new ArrayList<>();

        for (int i = 0; i < qty; i++) {
            JLabel label = new JLabel();
            IReelHandler handler = text -> {
                //label.setText(text);
                ImageIcon imageIcon = new ImageIcon(new ImageIcon(System.getProperty("user.dir") + "/Resources/"+text+".png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
                label.setIcon(imageIcon);
            };

            //label.setIcon(new ImageIcon(System.getProperty("user.dir") + "/Resources/"+label.getText()+".png"));
            panel.add(label);
            reels.add(handler);
        }
    }

    @Override
    public Component getComponent() {
        return panel;
    }

    @Override
    public List<IReelHandler> getReelsHandler() {
        return reels;
    }
}
