package slotmachine.ui.view;

import slotmachine.ui.handler.IInputHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MachineView {
    private JFrame machineFrame;
    private JPanel displayPanel;
    private JPanel reelPanel;
    private JPanel coinSlotPanel;
    private JPanel leverPanel;
    private JPanel playPanel;
    private JPanel gameModePanel;
    private JPanel payoutTrayPanel;
    private JPanel resetPanel;
    private JPanel recordPanel;

    public MachineView() {
        machineFrame = new JFrame();
        machineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        machineFrame.setResizable(false);
        machineFrame.setBounds(0, 0, 500, 600);
        machineFrame.setLocationRelativeTo(null);

        JPanel contentPanel = new JPanel(null);
        machineFrame.getContentPane().add(contentPanel);

        JPanel frontPanel = new JPanel(null);
        frontPanel.setBounds(0,0, 500, 600);
        contentPanel.add(frontPanel);

        JPanel insidePanel = new JPanel(null);
        insidePanel.setBounds(0,0, 500, 600);
        insidePanel.setVisible(false);
        contentPanel.add(insidePanel);

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.YELLOW);
        displayPanel.setBounds(20, 10, 450, 50);
        frontPanel.add(displayPanel);

        reelPanel = new JPanel(new BorderLayout());
        reelPanel.setBackground(Color.ORANGE);
        reelPanel.setBounds(20, 90, 350, 100);
        frontPanel.add(reelPanel);

        coinSlotPanel = new JPanel(new BorderLayout());
        coinSlotPanel.setBackground(Color.RED);
        coinSlotPanel.setBounds(225, 210, 150, 100);
        frontPanel.add(coinSlotPanel);

        playPanel = new JPanel(new BorderLayout());
        playPanel.setBackground(Color.GREEN);
        playPanel.setBounds(20, 210, 100, 80);
        frontPanel.add(playPanel);

        leverPanel = new JPanel(new BorderLayout());
        leverPanel.setBackground(Color.DARK_GRAY);
        leverPanel.setBounds(400, 80, 60, 180);
        frontPanel.add(leverPanel);

        payoutTrayPanel = new JPanel(new BorderLayout());
        payoutTrayPanel.setBackground(Color.CYAN);
        payoutTrayPanel.setBounds(60, 350, 150, 60);
        frontPanel.add(payoutTrayPanel);

        JButton openButton = new JButton();
        openButton.setText("Change Mode");
        openButton.setBounds(320, 350, 150, 40);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontPanel.setVisible(false);
                insidePanel.setVisible(true);
            }
        });
        frontPanel.add(openButton);

        resetPanel = new JPanel(new BorderLayout());
        resetPanel.setBackground(Color.GREEN);
        resetPanel.setBounds(320, 400, 150, 40);
        frontPanel.add(resetPanel);

        recordPanel = new JPanel(new BorderLayout());
        recordPanel.setBackground(Color.GREEN);
        recordPanel.setBounds(320, 450, 150, 40);
        frontPanel.add(recordPanel);

        gameModePanel = new JPanel(new BorderLayout());
        gameModePanel.setBackground(Color.GREEN);
        gameModePanel.setBounds(10, 10, 280, 80);
        insidePanel.add(gameModePanel);

        JButton closeButton = new JButton();
        closeButton.setText("Return");
        closeButton.setBounds(250, 330, 100, 40);
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontPanel.setVisible(true);
                insidePanel.setVisible(false);
            }
        });
        insidePanel.add(closeButton);
    }

    public void addDisplayView(IDisplayView view) {
        displayPanel.add(view.getComponent());
    }

    public void addReelView(IReelView view) {
        reelPanel.add(view.getComponent());
    }

    public void addCoinSlotView(ICoinSlotView view) {
        coinSlotPanel.add(view.getComponent());
    }

    public void addLeverView(ILeverView view) {
        leverPanel.add(view.getComponent());
    }

    public void addPlayView(IPlayView view) {
        playPanel.add(view.getComponent());
    }

    public void addGameModeView(IGameModeView view) {
        gameModePanel.add(view.getComponent());
    }

    public void addResetView(IResetView view) {
        resetPanel.add(view.getComponent());
    }

    public void addRecordView(IRecordView view) {
        recordPanel.add(view.getComponent());
    }

    public void addPayoutTrayView(IPayoutTrayView view) {
        payoutTrayPanel.add(view.getComponent());
    }

    public void show() {
        machineFrame.setVisible(true);
    }
}
