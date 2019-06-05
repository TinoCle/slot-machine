package slotmachine.ui.view;

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

    public MachineView() {
        machineFrame = new JFrame();
        machineFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        machineFrame.setResizable(false);
        machineFrame.setBounds(0, 0, 300, 400);

        JPanel contentPanel = new JPanel(null);
        machineFrame.getContentPane().add(contentPanel);

        JPanel frontPanel = new JPanel(null);
        frontPanel.setBounds(0,0, 300, 400);
        contentPanel.add(frontPanel);

        JPanel insidePanel = new JPanel(null);
        insidePanel.setBounds(0,0, 300, 400);
        insidePanel.setVisible(false);
        contentPanel.add(insidePanel);

        displayPanel = new JPanel(new BorderLayout());
        displayPanel.setBackground(Color.YELLOW);
        displayPanel.setBounds(10, 10, 210, 60);
        frontPanel.add(displayPanel);

        reelPanel = new JPanel(new BorderLayout());
        reelPanel.setBackground(Color.ORANGE);
        reelPanel.setBounds(10, 90, 210, 100);
        frontPanel.add(reelPanel);

        coinSlotPanel = new JPanel(new BorderLayout());
        coinSlotPanel.setBackground(Color.RED);
        coinSlotPanel.setBounds(190, 200, 100, 100);
        frontPanel.add(coinSlotPanel);

        playPanel = new JPanel(new BorderLayout());
        playPanel.setBackground(Color.GREEN);
        playPanel.setBounds(10, 210, 100, 80);
        frontPanel.add(playPanel);

        leverPanel = new JPanel(new BorderLayout());
        leverPanel.setBackground(Color.DARK_GRAY);
        leverPanel.setBounds(230, 10, 60, 180);
        frontPanel.add(leverPanel);

        payoutTrayPanel = new JPanel(new BorderLayout());
        payoutTrayPanel.setBackground(Color.CYAN);
        payoutTrayPanel.setBounds(60, 300, 100, 60);
        frontPanel.add(payoutTrayPanel);


        JButton openButton = new JButton();
        openButton.setText("O");
        openButton.setBounds(250, 330, 40, 40);
        openButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frontPanel.setVisible(false);
                insidePanel.setVisible(true);
            }
        });
        frontPanel.add(openButton);

        gameModePanel = new JPanel(new BorderLayout());
        gameModePanel.setBackground(Color.GREEN);
        gameModePanel.setBounds(10, 10, 280, 80);
        insidePanel.add(gameModePanel);

        JButton closeButton = new JButton();
        closeButton.setText("C");
        closeButton.setBounds(250, 330, 40, 40);
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

    public void addPayoutTrayView(IPayoutTrayView view) {
        payoutTrayPanel.add(view.getComponent());
    }

    public void show() {
        machineFrame.setVisible(true);
    }
}
