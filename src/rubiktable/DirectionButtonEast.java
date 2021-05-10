package rubiktable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectionButtonEast {
    private JPanel buttonPanel;
    private Board board;
    private BoardGUI boardGUI;

    public DirectionButtonEast(int boardSizes, BoardGUI boardGUI) {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(boardSizes, 1));
        for(int i =0;i<boardSizes;i++){
            JButton button = new JButton(">");
            this.boardGUI = boardGUI;
            this.board = boardGUI.getBoard();
            button.addActionListener(new ButtonListener(i));
            buttonPanel.add(button);
        }
    }

    public void slideEast(int x){
        Field tempField = board.getBoard()[x][board.getBoardSize()-1];
        for(int i = board.getBoardSize()-1; i > 0; i--){
            board.getBoard()[x][i] = board.getBoard()[x][i-1];
        }
        board.getBoard()[x][0] = tempField;
    }

    class ButtonListener implements ActionListener {

        private int x;

        public ButtonListener(int x) {
            this.x = x;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            slideEast(x);
            boardGUI.refresh();
        }
    }

    public JPanel getButtonPanel(){
        return buttonPanel;
    }
}
