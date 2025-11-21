package com.hsu.byteship.client.view.lobby;

import com.hsu.byteship.client.view.common.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 로비 화면의 전체 레이아웃을 담당하는 뷰 클래스입니다.
 * 방 목록 패널과 상단 메뉴 바, 배경 이미지를 포함합니다.
 */
public class LobbyView extends BaseFrame {

    private JButton createButton;
    private JButton leaveButton;
    private JMenuBar lobbyMenuBar;
    private LobbyRoomPanel lobbyRoomPanel;

    /**
     * 로비 화면을 초기화하고 표시합니다.
     */
    public LobbyView() {
        super("Battle Ship Client - Lobby");
        setLayout(new BorderLayout());
        buildGui();
        setVisible(true);
    }

    private void buildGui() {
        setContentPane(createBackgroundPanel());

        createMenuBar();
        add(createLobbyPanel(), BorderLayout.CENTER);
        add(createLowerPanel(), BorderLayout.SOUTH);
    }

    private JPanel createBackgroundPanel() {
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("../images/title.png"));
        JPanel backgroundPanel = new JPanel(new BorderLayout()) {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        return backgroundPanel;
    }

    private JPanel createLobbyPanel() {
        lobbyRoomPanel = new LobbyRoomPanel();

        JScrollPane scrollPane = new JScrollPane(lobbyRoomPanel);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);

        JPanel centerWrapper = new JPanel(new BorderLayout());
        centerWrapper.setBorder(BorderFactory.createEmptyBorder(30, 20, 0, 15));
        centerWrapper.add(scrollPane, BorderLayout.CENTER);
        centerWrapper.setOpaque(false);

        return centerWrapper;
    }

    private JPanel createLowerPanel() {
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(0, 100));
        panel.setOpaque(false);
        return panel;
    }

    private void createMenuBar() {
        lobbyMenuBar = new JMenuBar();

        createButton = new JButton("방 생성");
        leaveButton = new JButton("나가기");

        Font buttonFont = createButton.getFont().deriveFont(Font.BOLD, 17f);
        createButton.setFont(buttonFont);
        leaveButton.setFont(buttonFont);

        createButton.setFocusable(false);
        leaveButton.setFocusable(false);

        int buttonHeight = 40;
        int buttonWidth = 200;
        createButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));
        leaveButton.setPreferredSize(new Dimension(buttonWidth, buttonHeight));

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 0));
        buttonPanel.add(createButton);
        buttonPanel.add(leaveButton);

        lobbyMenuBar.add(Box.createHorizontalGlue());
        lobbyMenuBar.add(buttonPanel);
        lobbyMenuBar.add(Box.createHorizontalGlue());

        lobbyMenuBar.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

        setJMenuBar(lobbyMenuBar);
    }

    // ==== 컨트롤러 메서드 =====

    /**
     * 방 생성 버튼 클릭 리스너를 등록합니다.
     *
     * @param listener 방 생성 요청 처리 리스너
     */
    public void addCreateListener(ActionListener listener) {
        createButton.addActionListener(listener);
    }

    /**
     * 로비 나가기 버튼 클릭 리스너를 등록합니다.
     *
     * @param listener 나가기 요청 처리 리스너
     */
    public void addLeaveListener(ActionListener listener) {
        leaveButton.addActionListener(listener);
    }

    /**
     * 서버/컨트롤러에서 전달된 방 목록으로 로비 방 리스트를 갱신합니다.
     *
     * @param rooms             방 요약 정보 목록
     * @param roomClickListener 방 카드 클릭 시 호출될 리스너
     */
//    public void updateRooms(List<RoomSummary> rooms, ActionListener roomClickListener) {
//        lobbyRoomPanel.updateRooms(rooms, roomClickListener);
//    }
}
