package slotmachine.ui.view;

import slotmachine.ui.handler.IRecordHandler;
import slotmachine.ui.handler.IInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecordView implements IRecordView, IInputHandler {
    private JButton button;
    private IRecordHandler recordHandler;

    public RecordView() {
        button = new JButton();
        button.setText("Record");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (recordHandler != null) {
                    recordHandler.showRecords();
                }
            }
        });
    }

    @Override
    public Component getComponent() {
        return button;
    }

    @Override
    public void setRecordHandler(IRecordHandler handler){
        recordHandler = handler;
    }

    @Override
    public void setEnabled(boolean enabled) {
        button.setEnabled(enabled);
    }
}
