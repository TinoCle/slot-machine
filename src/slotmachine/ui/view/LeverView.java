package slotmachine.ui.view;

import slotmachine.ui.handler.IInputHandler;
import slotmachine.ui.handler.IPlayHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class LeverView implements ILeverView, IInputHandler {
    private JButton button;
    private IPlayHandler playHandler;

    public LeverView() {
        button = new JButton();
        button.setText("Play");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (playHandler != null) {
                    playHandler.play();
                }
            }
        });
    }

    @Override
    public Component getComponent() {
        return button;
    }

    @Override
    public void setPlayHandler(IPlayHandler handler) {
        playHandler = handler;
    }

    @Override
    public void setEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }
}
