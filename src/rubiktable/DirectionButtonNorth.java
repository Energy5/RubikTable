package rubiktable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DirectionButtonNorth {
    private JPanel buttonPanel;
    private Board board;
    private BoardGUI boardGUI;

    public DirectionButtonNorth(int boardSizes, BoardGUI boardGUI) {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, boardSizes));
        for(int i =0;i<boardSizes;i++){
            JButton button = new JButton("^");
            this.boardGUI = boardGUI;
            this.board = boardGUI.getBoard();
            button.addActionListener(new ButtonListener(i));
            buttonPanel.add(button);
        }
    }

    public void slideNorth(int x){
        Field tempField = board.getBoard()[0][x];
        for(int i = 0; i < board.getBoardSize()-1; i++){
            board.getBoard()[i][x] = board.getBoard()[i+1][x];
        }
        board.getBoard()[board.getBoardSize()-1][x] = tempField;
    }

    class ButtonListener implements ActionListener {

        private int x;

        public ButtonListener(int x) {
            this.x = x;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            slideNorth(x);
            boardGUI.refresh();

        }
    }

    public JPanel getButtonPanel(){
        return buttonPanel;
    }
}
