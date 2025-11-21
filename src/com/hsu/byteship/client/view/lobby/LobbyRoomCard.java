package com.hsu.byteship.client.view.lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 로비 화면에서 방 정보를 카드 형태로 표시하는 버튼 컴포넌트입니다.
 * 방 이름과 인원 정보를 보여주며, 클릭 시 해당 방 선택 이벤트를 발생시킵니다.
 */
public class LobbyRoomCard extends JButton {

    private JLabel roomNameLabel;
    private JLabel roomSeatLabel;
    private long roomId;

    /**
     * 기본 스타일과 레이아웃을 초기화한 로비 방 카드 버튼을 생성합니다.
     */
    public LobbyRoomCard() {
        buildGui();
    }

    private void buildGui() {
        initComponents();
        configureLayout();
    }

    private void initComponents() {
        setLayout(new BorderLayout());
        setOpaque(true);
        setBackground(new Color(207, 215, 225));
        setPreferredSize(new Dimension(220, 90));
        setFocusable(false);

        roomNameLabel = new JLabel("Room Name");
        roomNameLabel.setFont(roomNameLabel.getFont().deriveFont(Font.BOLD, 18f));

        roomSeatLabel = new JLabel("0 / 2", SwingConstants.RIGHT);
        roomSeatLabel.setFont(roomSeatLabel.getFont().deriveFont(14f));
    }

    private void configureLayout() {
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setOpaque(false);
        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        centerPanel.add(roomNameLabel, BorderLayout.WEST);
        centerPanel.add(roomSeatLabel, BorderLayout.EAST);

        add(centerPanel, BorderLayout.CENTER);
    }

    // ===== 컨트롤러 =====

    /**
     * 서버/컨트롤러에서 받은 방 정보를 카드 내용에 반영합니다.
     *
     * @param roomId   방 ID
     * @param roomName 방 이름
     * @param seatText 인원 표시 텍스트 (예: "1 / 2")
     */
    public void setRoomInfo(long roomId, String roomName, String seatText) {
        this.roomId = roomId;
        roomNameLabel.setText(roomName);
        roomSeatLabel.setText(seatText);
    }

    /**
     * 이 카드에 연결된 방 ID를 반환합니다.
     *
     * @return 방 ID
     */
    public long getRoomId() {
        return roomId;
    }

    // ===== 컨트롤러 이벤트 등록 =====

    /**
     * 카드 클릭 시 호출될 액션 리스너를 등록합니다.
     * 로비 View → 로비 패널 → 로비 룸 카드에서 사용됩니다.
     *
     * @param listener 카드 클릭 시 호출될 리스너
     */
    public void addClickListener(ActionListener listener) {
        addActionListener(listener);
    }
}
