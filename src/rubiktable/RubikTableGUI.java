package rubiktable;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class RubikTableGUI {
    private JFrame frame;
    private BoardGUI boardGUI;
    private DirectionButtonNorth directionButtonNorth;
    private DirectionButtonSouth directionButtonSouth;
    private DirectionButtonWest directionButtonWest;
    private DirectionButtonEast directionButtonEast;

    public RubikTableGUI() {
        frame = new JFrame("Rubik table");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        int INITIAL_BOARD_SIZE = 4;
        boardGUI = new BoardGUI(INITIAL_BOARD_SIZE);
        directionButtonNorth = new DirectionButtonNorth(INITIAL_BOARD_SIZE, boardGUI);
        directionButtonSouth = new DirectionButtonSouth(INITIAL_BOARD_SIZE, boardGUI);
        directionButtonWest = new DirectionButtonWest(INITIAL_BOARD_SIZE, boardGUI);
        directionButtonEast = new DirectionButtonEast(INITIAL_BOARD_SIZE, boardGUI);
        frame.getContentPane().add(boardGUI.getBoardPanel(), BorderLayout.CENTER);
        frame.getContentPane().add(directionButtonNorth.getButtonPanel(), BorderLayout.NORTH);
        frame.getContentPane().add(directionButtonSouth.getButtonPanel(), BorderLayout.SOUTH);
        frame.getContentPane().add(directionButtonWest.getButtonPanel(), BorderLayout.WEST);
        frame.getContentPane().add(directionButtonEast.getButtonPanel(), BorderLayout.EAST);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);
        JMenu gameMenu = new JMenu("Game");
        menuBar.add(gameMenu);
        JMenu newMenu = new JMenu("New");
        gameMenu.add(newMenu);
        int[] boardSizes = new int[]{2, 4, 6};
        for (int boardSize : boardSizes) {
            JMenuItem sizeMenuItem = new JMenuItem(boardSize + "x" + boardSize);
            newMenu.add(sizeMenuItem);
            sizeMenuItem.addActionListener(e -> {
                frame.getContentPane().remove(boardGUI.getBoardPanel());
                frame.getContentPane().remove(directionButtonNorth.getButtonPanel());
                frame.getContentPane().remove(directionButtonSouth.getButtonPanel());
                frame.getContentPane().remove(directionButtonWest.getButtonPanel());
                frame.getContentPane().remove(directionButtonEast.getButtonPanel());
                boardGUI = new BoardGUI(boardSize);
                directionButtonNorth = new DirectionButtonNorth(boardSize, boardGUI);
                directionButtonSouth = new DirectionButtonSouth(boardSize, boardGUI);
                directionButtonWest = new DirectionButtonWest(boardSize, boardGUI);
                directionButtonEast = new DirectionButtonEast(boardSize, boardGUI);
                frame.getContentPane().add(boardGUI.getBoardPanel(),BorderLayout.CENTER);
                frame.getContentPane().add(directionButtonNorth.getButtonPanel(), BorderLayout.NORTH);
                frame.getContentPane().add(directionButtonSouth.getButtonPanel(), BorderLayout.SOUTH);
                frame.getContentPane().add(directionButtonWest.getButtonPanel(), BorderLayout.WEST);
                frame.getContentPane().add(directionButtonEast.getButtonPanel(), BorderLayout.EAST);

                frame.pack();
            });
        }
        JMenuItem exitMenuItem = new JMenuItem("Exit");
        gameMenu.add(exitMenuItem);
        exitMenuItem.addActionListener(ae -> System.exit(0));

        frame.pack();
        frame.setVisible(true);
    }
}
