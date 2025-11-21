package com.hsu.byteship.client.view.login;

import com.hsu.byteship.client.view.common.BaseFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 클라이언트 로그인 화면을 담당하는 뷰입니다.
 * 닉네임 입력 필드와 로그인/종료 버튼을 제공합니다.
 */
public class LoginView extends BaseFrame {

    private JTextField usernameField;
    private JButton loginButton;
    private JButton exitButton;

    /**
     * 로그인 화면을 초기화하고 표시합니다.
     */
    public LoginView() {
        super("Battle Ship Client - Login");
        buildGui();
        setVisible(true);
    }

    private void buildGui() {
        setContentPane(createMainPanel());
    }

    private JPanel createMainPanel() {
        JPanel backgroundPanel = createBackgroundPanel();
        backgroundPanel.setLayout(new BorderLayout());
        backgroundPanel.add(createLowerDeckPanel(), BorderLayout.SOUTH);
        return backgroundPanel;
    }

    private JPanel createBackgroundPanel() {
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("../images/title.png"));

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics graphics) {
                super.paintComponent(graphics);
                graphics.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), this);
            }
        };
        return panel;
    }

    private JPanel createLowerDeckPanel() {
        JPanel panel = new JPanel(new GridLayout(2, 1));

        JPanel inputPanel = createInputPanel();
        JPanel controlPanel = createControlPanel();

        panel.add(inputPanel);
        panel.add(controlPanel);

        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
        panel.setOpaque(false);

        return panel;
    }

    private JPanel createInputPanel() {
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        usernameField = new JTextField(20);

        inputPanel.add(usernameField);
        inputPanel.setOpaque(false);
        return inputPanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        loginButton = new JButton("로그인");
        exitButton = new JButton("종료");

        controlPanel.add(loginButton);
        controlPanel.add(exitButton);

        controlPanel.setOpaque(false);
        return controlPanel;
    }

    // ===== 컨트롤러 리스너 부분 =====

    /**
     * 로그인 버튼 및 엔터 입력에 대한 리스너를 등록합니다.
     *
     * @param listener 로그인 시 호출될 리스너
     */
    public void addLoginListener(ActionListener listener) {
        loginButton.addActionListener(listener);
        usernameField.addActionListener(listener);
    }

    /**
     * 종료 버튼에 대한 리스너를 등록합니다.
     *
     * @param listener 종료 시 호출될 리스너
     */
    public void addExitListener(ActionListener listener) {
        exitButton.addActionListener(listener);
    }

    // ===== 컨트롤러로 보낼 데이터 부분 =====

    /**
     * 입력된 유저 이름(닉네임)을 반환합니다.
     *
     * @return 공백을 제거한 유저 이름 문자열
     */
    public String getUsername() {
        return usernameField.getText().strip();
    }
}
