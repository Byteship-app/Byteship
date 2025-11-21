package com.hsu.byteship.client.view.common;

import javax.swing.*;
import java.awt.*;

/**
 * 클라이언트 공통 기본 프레임을 구성하는 상위 클래스입니다.
 * 공통 크기, 위치, 레이아웃 등을 설정합니다.
 */
public class BaseFrame extends JFrame {

    private static final int DEFAULT_WIDTH = 1000;
    private static final int DEFAULT_HEIGHT = 600;

    /**
     * 지정한 제목을 가진 기본 프레임을 생성합니다.
     *
     * @param title 프레임 제목
     */
    public BaseFrame(String title) {
        super(title);

        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());
    }
}
