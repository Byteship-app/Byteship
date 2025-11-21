package com.hsu.byteship.client.view.lobby;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * 로비 화면에서 방 목록을 두 개의 컬럼으로 배치해 보여주는 패널입니다.
 * 왼쪽/오른쪽 컬럼에 {@link LobbyRoomCard}를 세로로 나열합니다.
 */
public class LobbyRoomPanel extends JPanel {

    private static final int MAX_PLAYERS_PER_ROOM = 2;

    private final JPanel leftColumn;
    private final JPanel rightColumn;

    /**
     * 기본 레이아웃과 컬럼 패널을 초기화하여 로비 방 목록 패널을 생성합니다.
     */
    public LobbyRoomPanel() {
        setLayout(new GridLayout(1, 2, 10, 0));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setOpaque(false);

        leftColumn = createColumnPanel();
        rightColumn = createColumnPanel();

        add(leftColumn);
        add(rightColumn);
    }

    // 열 생성
    private JPanel createColumnPanel() {
        JPanel column = new JPanel();
        column.setLayout(new BoxLayout(column, BoxLayout.Y_AXIS));
        column.setOpaque(false);
        return column;
    }

    // ===== UI 업데이트 =====

    /**
     * 컨트롤러에서 전달받은 방 목록으로 카드 리스트를 갱신합니다.
     * 방 카드는 좌우 컬럼에 번갈아가며 배치됩니다.
     *
     * @param rooms             로비에 표시할 방 요약 정보 목록
     * @param roomClickListener 방 카드 클릭 시 호출될 리스너
     */
//    public void updateRooms(List<RoomSummary> rooms, ActionListener roomClickListener) {
//        leftColumn.removeAll();
//        rightColumn.removeAll();
//
//        if (rooms == null || rooms.isEmpty()) {
//            leftColumn.add(new JLabel("표시할 방이 없습니다."));
//        } else {
//            for (int i = 0; i < rooms.size(); i++) {
//                RoomSummary room = rooms.get(i);
//
//                LobbyRoomCard roomCard = new LobbyRoomCard();
//                roomCard.setRoomInfo(
//                        room.getRoomId(),
//                        room.getRoomName(),
//                        room.getCurrentPlayers() + " / " + MAX_PLAYERS_PER_ROOM
//                );
//
//                roomCard.setMaximumSize(new Dimension(Integer.MAX_VALUE, 90));
//                roomCard.setAlignmentX(Component.CENTER_ALIGNMENT);
//
//                if (roomClickListener != null) {
//                    roomCard.addClickListener(roomClickListener);
//                }
//
//                JPanel targetColumn = (i % 2 == 0) ? leftColumn : rightColumn;
//                targetColumn.add(roomCard);
//                targetColumn.add(Box.createVerticalStrut(10));
//            }
//        }
//
//        revalidate();
//        repaint();
//    }
}
