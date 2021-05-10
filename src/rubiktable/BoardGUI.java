package rubiktable;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.*;

public class BoardGUI {

    private JButton[][] buttons;
    private Board board;
    private JPanel boardPanel;
    private int clickNum = 0;
    private Color[][] colorsMatrix;

//    BoardGUI konstruktora
    public BoardGUI(int boardSize) {
        board = new Board(boardSize);
        boardPanel = new JPanel();
        boardPanel.setLayout(new GridLayout(board.getBoardSize(), board.getBoardSize()));
        buttons = new JButton[board.getBoardSize()][board.getBoardSize()];
        shuffleColors(boardSize);
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                JButton button = new JButton();
                Field field = board.get(i,j);
                field.setColor(colorsMatrix[i][j]);
                button.setPreferredSize(new Dimension(80, 80));
                button.setBackground(field.getColor());
                buttons[i][j] = button;
                boardPanel.add(button);
            }
        }
    }

//    Lekéri az aktuális tábla minden egyes elemét, majd kirajzolja a GUI-ra, eközben ellenőrzi, hogy nem lett-e vége a játéknak.
//    Ha vége lett, akkor lefrissíti a táblát
    public void refresh() {
        for (int i = 0; i < board.getBoardSize(); ++i) {
            for (int j = 0; j < board.getBoardSize(); ++j) {
                Field field = board.get(i, j);
                JButton button = buttons[i][j];
                button.setBackground(field.getColor());
            }
        }
        clickNum++;
        if(board.isOverHorizontal() || board.isOverVertical()){
            JOptionPane.showMessageDialog(boardPanel, "Nyertél "  + clickNum + " kattintással!", "Gratulálok!", JOptionPane.PLAIN_MESSAGE);
            shuffleColors(board.getBoardSize());
            for (int i = 0; i < board.getBoardSize(); ++i) {
                for (int j = 0; j < board.getBoardSize(); ++j) {
                    JButton button = buttons[i][j];
                    Field field = board.get(i,j);
                    field.setColor(colorsMatrix[i][j]);
                    button.setBackground(field.getColor());
                }
            }
            clickNum=0;
        }

    }

    public Board getBoard(){
        return board;
    }

    public void shuffleColors(int boardSize){
        ArrayList<Color> colors = new ArrayList<>();
        Color[][] colorsMatrix = new Color[boardSize][boardSize];
        int colorNum = 0;
        Color red = new Color(255,0,0);
        Color blue = new Color(0,0,255);
        Color green = new Color(0,255,0);
        Color pink = new Color(255,0,255);
        Color yellow = new Color(255,255,0);
        Color black = new Color(0,0,0);
        for(int i = 0; i< boardSize*boardSize;i++) {
            switch (boardSize) {
                case 2:
                    if (colorNum < 2) {
                        colors.add(red);
                        colorNum++;
                    } else {
                        colors.add(blue);
                    }
                    break;
                case 4:
                    if (colorNum < 4) {
                        colors.add(red);
                        colorNum++;
                    } else {
                        if (colorNum < 8) {
                            colors.add(blue);
                            colorNum++;
                        } else {
                            if (colorNum < 12) {
                                colors.add(yellow);
                                colorNum++;
                            } else {
                                colors.add(green);
                            }
                        }
                    }
                    break;
                case 6:
                    if (colorNum < 6) {
                        colors.add(red);
                        colorNum++;
                    } else {
                        if (colorNum < 12) {
                            colors.add(blue);
                            colorNum++;
                        } else {
                            if (colorNum < 18) {
                                colors.add(yellow);
                                colorNum++;
                            } else {
                                if (colorNum < 24) {
                                    colors.add(green);
                                    colorNum++;
                                } else {
                                    if (colorNum < 30) {
                                        colors.add(black);
                                        colorNum++;
                                    } else {
                                        colors.add(pink);
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
        }
        Collections.shuffle(colors);
        int num = 0;
        for(int i = 0;i<boardSize;i++){
            for(int j = 0;j<boardSize;j++) {
                colorsMatrix[i][j] = colors.get(num);
                num++;
            }
        }
        this.colorsMatrix = colorsMatrix;
    }

    public JPanel getBoardPanel() {
        return boardPanel;
    }

}