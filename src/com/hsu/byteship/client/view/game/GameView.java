package com.hsu.byteship.client.view.game;

import com.hsu.byteship.client.view.common.BaseFrame;
import com.hsu.byteship.client.view.common.ChatPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 배틀쉽 게임 진행 화면을 담당하는 메인 뷰입니다.
 * 내 보드 / 상대 보드 / 히트 로그 / 좌표 입력 / 채팅 패널로 구성됩니다.
 */
public class GameView extends BaseFrame {

    private JButton coordinateSendButton;
    private JTextField coordinateInputField;
    private JTextArea hitLogArea;

    private ChatPanel chatPanel;

    private BoardPanel myBoardPanel;
    private BoardPanel enemyBoardPanel;

    /**
     * 배틀쉽 게임 화면을 초기화하고 표시합니다.
     */
    public GameView() {
        super("Battle Ship Client - BATTLE");
        buildGui();
        setVisible(true);
    }

    private void buildGui() {
        JPanel leftPanel = new JPanel(new BorderLayout());
        leftPanel.add(createMainPanel(), BorderLayout.CENTER);
        leftPanel.add(createCoordinatePanel(), BorderLayout.SOUTH);

        chatPanel = new ChatPanel();

        add(leftPanel, BorderLayout.CENTER);
        add(chatPanel, BorderLayout.EAST);
    }

    private JPanel createMainPanel() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new java.awt.GridLayout(1, 2));

        myBoardPanel = new BoardPanel(false);
        enemyBoardPanel = new BoardPanel(true);

        mainPanel.add(myBoardPanel);
        mainPanel.add(enemyBoardPanel);

        return mainPanel;
    }

    // 히트 로그 + 좌표 보내기 패널 생성
    private JPanel createCoordinatePanel() {
        JPanel coordinatePanel = new JPanel(new BorderLayout());

        hitLogArea = new JTextArea(5, 20);
        hitLogArea.setEditable(false);
        hitLogArea.setFocusable(false);
        JScrollPane logScroll = new JScrollPane(
                hitLogArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );

        JPanel controlPanel = new JPanel(new BorderLayout());
        coordinateInputField = new JTextField();
        coordinateInputField.setEditable(false); // 버튼/보드 선택으로만 입력
        coordinateSendButton = new JButton("좌표 입력");

        controlPanel.add(coordinateSendButton, BorderLayout.WEST);
        controlPanel.add(coordinateInputField, BorderLayout.CENTER);

        coordinatePanel.add(logScroll, BorderLayout.CENTER);
        coordinatePanel.add(controlPanel, BorderLayout.SOUTH);

        return coordinatePanel;
    }

    // ===== 컨트롤러용 메서드 =====

    // 채팅 패널 관련
    /**
     * 채팅 전송 버튼에 리스너를 등록합니다.
     */
    public void addChatSendListener(ActionListener listener) {
        chatPanel.addSendListener(listener);
    }

    /**
     * 채팅 입력 필드(엔터)에 리스너를 등록합니다.
     */
    public void addChatInputListener(ActionListener listener) {
        chatPanel.addInputListener(listener);
    }

    /**
     * 채팅 입력 필드의 현재 텍스트를 반환합니다.
     */
    public String getChatInput() {
        return chatPanel.getInput();
    }

    /**
     * 채팅 메시지를 채팅 영역에 추가합니다.
     */
    public void appendChat(String message) {
        chatPanel.appendMessage(message);
    }

    // ==== 보드 클릭 시 이벤트 처리 ====

    /**
     * 상대 보드 셀 클릭(공격 좌표 선택) 리스너를 등록합니다.
     */
    public void addBoardClickListener(ActionListener listener) {
        enemyBoardPanel.addClickListener(listener);
    }

    /**
     * 좌표 입력 버튼 클릭 리스너를 등록합니다.
     */
    public void addCoordinateSendListener(ActionListener listener) {
        coordinateSendButton.addActionListener(listener);
    }

    /**
     * 좌표 입력 필드를 비웁니다.
     */
    public void clearCoordinateInput() {
        coordinateInputField.setText("");
    }

    /**
     * 선택된 공격 좌표 텍스트를 좌표 입력 필드에 표시합니다.
     *
     * @param coord 예: "B4", "A5"
     */
    public void setCoordinateInput(String coord) {
        coordinateInputField.setText(coord);
    }

    /**
     * 히트 로그에 한 줄을 추가하고 스크롤을 최신 위치로 이동합니다.
     */
    public void appendHitLog(String line) {
        hitLogArea.append(line + "\n");
        hitLogArea.setCaretPosition(hitLogArea.getDocument().getLength());
    }

    /**
     * 좌표 입력 필드의 텍스트를 반환합니다.
     */
    public String getCoordinateInput() {
        return coordinateInputField.getText();
    }

    // ==== 보드 상태 업데이트 ====

    /**
     * 내 보드의 특정 셀 배경색을 변경합니다.
     */
    public void setMyCellBackground(int row, int col, Color color) {
        myBoardPanel.setCellBackground(row, col, color);
    }

    /**
     * 상대 보드의 특정 셀 배경색을 변경합니다.
     */
    public void setEnemyCellBackground(int row, int col, Color color) {
        enemyBoardPanel.setCellBackground(row, col, color);
    }
}
