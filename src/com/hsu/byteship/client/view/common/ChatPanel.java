package com.hsu.byteship.client.view.common;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 클라이언트에서 공통으로 사용하는 채팅 UI 패널입니다.
 * 채팅 메시지 출력 영역과 입력 필드, 전송 버튼으로 구성됩니다.
 */
public class ChatPanel extends JPanel {

    private JButton sendButton;
    private JTextArea chatArea;
    private JTextField inputField;

    /**
     * 기본 레이아웃과 컴포넌트를 초기화하여 채팅 패널을 생성합니다.
     */
    public ChatPanel() {
        setLayout(new BorderLayout());
        buildGui();
    }

    private void buildGui() {
        add(createChatScrollPane(), BorderLayout.CENTER);
        add(createInputPanel(), BorderLayout.SOUTH);
    }

    private JScrollPane createChatScrollPane() {
        chatArea = new JTextArea();
        chatArea.setEditable(false);
        chatArea.setFocusable(false);
        chatArea.setLineWrap(true);
        chatArea.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(
                chatArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER
        );
        return scrollPane;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new BorderLayout());

        inputField = new JTextField(20);
        sendButton = new JButton("전송");

        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        return inputPanel;
    }

    // ===== 컨트롤러 리스너 연결 =====

    /**
     * 전송 버튼에 전달된 액션 리스너를 등록합니다.
     *
     * @param listener 전송 버튼 클릭 시 호출될 리스너
     */
    public void addSendListener(ActionListener listener) {
        sendButton.addActionListener(listener);
    }

    /**
     * 입력 필드에 전달된 액션 리스너를 등록합니다.
     * Enter 키 입력 시 호출됩니다.
     *
     * @param listener 입력 필드 액션 발생 시 호출될 리스너
     */
    public void addInputListener(ActionListener listener) {
        inputField.addActionListener(listener);
    }

    // ==== 컨트롤러에게 텍스트 데이터 주기 =====

    /**
     * 입력 필드에 작성된 텍스트를 반환합니다.
     *
     * @return 현재 입력 필드의 텍스트
     */
    public String getInput() {
        return inputField.getText();
    }

    // ===== UI 업데이트 메서드 =====

    /**
     * 채팅 영역에 전달된 메시지를 한 줄 추가하고,
     * 스크롤을 최신 위치로 이동합니다.
     *
     * @param message 출력할 채팅 메시지
     */
    public void appendMessage(String message) {
        chatArea.append(message + "\n");
        chatArea.setCaretPosition(chatArea.getDocument().getLength());
    }

    /**
     * 입력 필드의 텍스트를 모두 지웁니다.
     */
    public void clearInput() {
        inputField.setText("");
    }

    /**
     * 입력 필드에 포커스를 요청합니다.
     * 메시지 전송 후, 커서를 텍스트 필드로 옮깁니다.
     */
    public void focusInput() {
        inputField.requestFocusInWindow();
    }
}
