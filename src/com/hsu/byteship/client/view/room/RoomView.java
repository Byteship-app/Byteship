package com.hsu.byteship.client.view.room;

import com.hsu.byteship.client.view.common.BaseFrame;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

/**
 * 게임 방(1:1 매칭) 정보를 표시하고 Ready/Leave 조작을 제공하는 뷰입니다.
 */
public class RoomView extends BaseFrame {

    private static final int ROOM_WIDTH = 800;
    private static final int ROOM_HEIGHT = 600;

    private JLabel roomNameLabel;
    private JLabel roomStatusLabel;
    private JLabel player1Label;
    private JLabel player2Label;

    private JButton leaveButton;
    private JButton readyButton;

    /**
     * 게임 방 화면을 초기화하고 표시합니다.
     */
    public RoomView() {
        super("Battle Ship Client - Game Room");
        setSize(ROOM_WIDTH, ROOM_HEIGHT);
        buildGui();
        setVisible(true);
    }

    private void buildGui() {
        setContentPane(createBackgroundPanel());
        createMenuBar();
        add(createCenterPanel(), BorderLayout.CENTER);
    }

    private JPanel createBackgroundPanel() {
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("../images/gameroom.png"));
        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        return backgroundPanel;
    }

    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        roomNameLabel = new JLabel("Room 1");
        roomNameLabel.setFont(roomNameLabel.getFont().deriveFont(Font.BOLD, 18f));

        roomStatusLabel = new JLabel("대기 중");
        roomStatusLabel.setFont(roomStatusLabel.getFont().deriveFont(Font.BOLD, 18f));
        roomStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        readyButton = new JButton("준비");
        leaveButton = new JButton("나가기");

        Font buttonFont = readyButton.getFont().deriveFont(Font.BOLD, 14f);
        readyButton.setFont(buttonFont);
        leaveButton.setFont(buttonFont);

        readyButton.setFocusable(false);
        leaveButton.setFocusable(false);

        menuBar.add(roomNameLabel);
        menuBar.add(Box.createHorizontalStrut(20));
        menuBar.add(roomStatusLabel);
        menuBar.add(Box.createHorizontalGlue());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 5, 0));
        buttonPanel.setOpaque(false);
        buttonPanel.add(readyButton);
        buttonPanel.add(leaveButton);
        menuBar.add(buttonPanel);

        setJMenuBar(menuBar);
    }

    // 중앙 패널을 담당하는 메서드입니다.
    private JPanel createCenterPanel() {
        JPanel wrapper = new JPanel(new BorderLayout());
        wrapper.setOpaque(false);
        wrapper.setBorder(BorderFactory.createEmptyBorder(40, 80, 60, 80));

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new javax.swing.BoxLayout(centerPanel, javax.swing.BoxLayout.Y_AXIS));
        centerPanel.setOpaque(true);
        centerPanel.setBackground(new Color(245, 248, 255));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        player1Label = new JLabel("Player 1");
        player2Label = new JLabel("Player 2");

        Font nameFont = player1Label.getFont().deriveFont(Font.BOLD, 24f);
        player1Label.setFont(nameFont);
        player2Label.setFont(nameFont);

        JPanel player1Panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        player1Panel.setOpaque(false);
        player1Panel.add(player1Label);

        JPanel player2Panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
        player2Panel.setOpaque(false);
        player2Panel.add(player2Label);

        JPanel vsPanel = new JPanel(new GridBagLayout());
        vsPanel.setOpaque(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        gbc.insets = new Insets(0, 5, 0, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.weightx = 1.0;
        vsPanel.add(new JSeparator(), gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.0;
        JLabel vsLabel = new JLabel("VS");
        vsLabel.setFont(vsLabel.getFont().deriveFont(Font.BOLD, 18f));
        vsPanel.add(vsLabel, gbc);

        gbc.gridx = 2;
        gbc.weightx = 1.0;
        vsPanel.add(new JSeparator(), gbc);

        centerPanel.add(player1Panel);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(vsPanel);
        centerPanel.add(Box.createVerticalStrut(15));
        centerPanel.add(player2Panel);

        wrapper.add(centerPanel, BorderLayout.CENTER);

        return wrapper;
    }

    // ===== 컨트롤러용 메서드들 =====

    /**
     * 상단 메뉴 바의 방 이름을 설정합니다.
     *
     * @param name 방 이름
     */
    public void setRoomName(String name) {
        roomNameLabel.setText(name);
    }

    /**
     * 상단 상태 텍스트를 설정합니다.
     *
     * @param status 상태 문자열 (예: "대기 중")
     */
    public void setStatusText(String status) {
        roomStatusLabel.setText(status);
    }

    /**
     * 플레이어 이름을 설정합니다.
     *
     * @param player1Name 플레이어 1 이름
     * @param player2Name 플레이어 2 이름
     */
    public void setPlayerNames(String player1Name, String player2Name) {
        player1Label.setText(player1Name);
        player2Label.setText(player2Name);
    }

    /**
     * Ready 버튼의 텍스트를 설정합니다. (예: "준비", "준비 해제")
     *
     * @param text 버튼에 표시할 텍스트
     */
    public void setReadyButtonText(String text) {
        readyButton.setText(text);
    }

    /**
     * 나가기 버튼 클릭 리스너를 등록합니다.
     *
     * @param listener 나가기 처리 리스너
     */
    public void addLeaveListener(ActionListener listener) {
        leaveButton.addActionListener(listener);
    }

    /**
     * 준비 버튼 클릭 리스너를 등록합니다.
     *
     * @param listener 준비/준비 해제 처리 리스너
     */
    public void addReadyListener(ActionListener listener) {
        readyButton.addActionListener(listener);
    }
}
