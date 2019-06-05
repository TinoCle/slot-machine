package slotmachine.ui.view;

import slotmachine.ui.handler.IGameModeHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class GameModeView implements IGameModeView {
    private JButton button;
    private IGameModeHandler gameModeHandler;

    public GameModeView() {
        button = new JButton();
        button.setText("Mode");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gameModeHandler != null) {
                    button.setText(gameModeHandler.change());
                }
            }
        });
    }

    @Override
    public Component getComponent() {
        return button;
    }

    @Override
    public void setGameModeHandler(IGameModeHandler handler) {
        gameModeHandler = handler;
    }
}
