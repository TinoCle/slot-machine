package slotmachine.ui.view;

import slotmachine.ui.handler.IInputHandler;
import slotmachine.ui.handler.IPlayHandler;
import slotmachine.ui.handler.IResetHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class ResetView implements IResetView, IInputHandler {
    private JButton button;
    private IResetHandler resetHandler;

    public ResetView() {
        button = new JButton();
        button.setBounds(10,400,200,100);
        button.setText("Reset");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (resetHandler != null) {
                    resetHandler.reset();
                }
            }
        });
    }

    @Override
    public Component getComponent() {
        return button;
    }

    @Override
    public void setResetHandler(IResetHandler handler){
        resetHandler = handler;
    }

    @Override
    public void setEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }
}
