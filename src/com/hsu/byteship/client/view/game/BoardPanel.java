package com.hsu.byteship.client.view.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * 배틀쉽 보드(10x10)를 렌더링하는 패널입니다.
 * 내 보드 / 상대 보드 모두 이 클래스를 사용하며,
 * clickable 여부로 클릭 가능 여부를 구분합니다.
 */
public class BoardPanel extends JPanel {

    private static final int BOARD_ROWS = 10;
    private static final int BOARD_COLS = 10;
    private static final int LABEL_SIZE = 24;

    private JButton[][] cells;
    private final boolean clickable;

    private JPanel gridPanel;

    /**
     * 보드 패널을 생성합니다.
     *
     * @param clickable true면 셀 클릭이 가능하고, false면 비활성화됩니다.
     */
    public BoardPanel(boolean clickable) {
        this.clickable = clickable;
        setLayout(new BorderLayout());
        buildBoard();
    }

    // == 보드 전체 구성 ==
    private void buildBoard() {
        createGridPanel();

        JPanel columnLabels = createColumnLabelsPanel();
        JPanel rowLabels = createRowLabelsPanel();

        JPanel topPanel = createTopPanel(columnLabels);

        add(topPanel, BorderLayout.NORTH);
        add(rowLabels, BorderLayout.WEST);
        add(gridPanel, BorderLayout.CENTER);
    }

    // 10x10 버튼 그리드 생성
    private void createGridPanel() {
        gridPanel = new JPanel(new GridLayout(BOARD_ROWS, BOARD_COLS));
        cells = new JButton[BOARD_ROWS][BOARD_COLS];

        for (int row = 0; row < BOARD_ROWS; row++) {
            for (int col = 0; col < BOARD_COLS; col++) {
                JButton cellButton = new JButton();
                cellButton.setBackground(new Color(207, 215, 225, 255));
                cellButton.setMargin(new Insets(0, 0, 0, 0));
                // 내부 좌표를 사람이 보기 좋은 "A1" 형태로 변환해서 actionCommand로 사용
                cellButton.setActionCommand(formatCoordinate(row, col));
                cellButton.setEnabled(clickable);

                cells[row][col] = cellButton;
                gridPanel.add(cellButton);
            }
        }
    }

    // 위쪽 알파벳 패널
    private JPanel createColumnLabelsPanel() {
        JPanel columnLabels = new JPanel(new GridLayout(1, BOARD_COLS));
        for (int col = 0; col < BOARD_COLS; col++) {
            char columnChar = (char) ('A' + col);
            JLabel label = new JLabel(String.valueOf(columnChar), SwingConstants.CENTER);
            columnLabels.add(label);
        }
        return columnLabels;
    }

    // 왼쪽 숫자 패널
    private JPanel createRowLabelsPanel() {
        JPanel rowLabels = new JPanel(new GridLayout(BOARD_ROWS, 1));
        for (int row = 0; row < BOARD_ROWS; row++) {
            JLabel label = new JLabel(String.valueOf(row + 1), SwingConstants.CENTER);
            rowLabels.add(label);
        }

        // 좌측 숫자 라벨 영역 크기 설정
        rowLabels.setPreferredSize(new Dimension(LABEL_SIZE, LABEL_SIZE * BOARD_ROWS));
        return rowLabels;
    }

    private JPanel createTopPanel(JPanel columnLabels) {
        JPanel corner = new JPanel();
        corner.setPreferredSize(new Dimension(LABEL_SIZE, LABEL_SIZE));

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(corner, BorderLayout.WEST);
        topPanel.add(columnLabels, BorderLayout.CENTER);

        return topPanel;
    }

    // 좌표 변환 helper: (row, col) -> "A1" 형태
    private String formatCoordinate(int row, int col) {
        char colChar = (char) ('A' + col);
        int rowNum = row + 1;
        return colChar + String.valueOf(rowNum); // 예: A1, C5
    }

    // ===== 리스너 붙이기 =====

    /**
     * 모든 셀에 동일한 액션 리스너를 등록합니다.
     * 셀 클릭 시 actionCommand로 "A1" 형태의 좌표가 전달됩니다.
     *
     * @param listener 셀 클릭 시 호출될 리스너
     */
    public void addClickListener(ActionListener listener) {
        for (int row = 0; row < BOARD_ROWS; row++) {
            for (int col = 0; col < BOARD_COLS; col++) {
                cells[row][col].addActionListener(listener);
            }
        }
    }

    /**
     * 특정 셀의 배경색을 변경합니다.
     *
     * @param row   0 기반 행 인덱스
     * @param col   0 기반 열 인덱스
     * @param color 적용할 색상
     */
    public void setCellBackground(int row, int col, Color color) {
        cells[row][col].setBackground(color);
    }
}
