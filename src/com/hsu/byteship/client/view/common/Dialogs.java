package com.hsu.byteship.client.view.common;

import javax.swing.*;
import java.awt.*;

/**
 * 클라이언트 전역에서 공통으로 사용하는 다이얼로그 유틸리티 클래스입니다.
 * 정보, 에러, 확인 메시지를 간단한 정적 메서드로 제공합니다.
 */
public final class Dialogs {

    /**
     * 인스턴스 생성을 방지하기 위한 private 생성자입니다.
     */
    private Dialogs() {}

    /**
     * 정보 메시지 다이얼로그를 표시합니다.
     *
     * @param parent  부모 컴포넌트 (null 가능)
     * @param message 표시할 메시지
     */
    public static void info(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * 에러 메시지 다이얼로그를 표시합니다.
     *
     * @param parent  부모 컴포넌트 (null 가능)
     * @param message 표시할 에러 메시지
     */
    public static void error(Component parent, String message) {
        JOptionPane.showMessageDialog(parent, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * 확인(Yes/No) 다이얼로그를 표시하고 사용자의 선택을 반환합니다.
     *
     * @param parent  부모 컴포넌트 (null 가능)
     * @param message 확인 메시지
     * @return 사용자가 "Yes"를 선택하면 true, 그렇지 않으면 false
     */
    public static boolean confirm(Component parent, String message) {
        int result = JOptionPane.showConfirmDialog(
                parent,
                message,
                "Confirmation",
                JOptionPane.YES_NO_OPTION
        );
        return result == JOptionPane.YES_OPTION;
    }
}
