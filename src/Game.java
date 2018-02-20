import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.renderable.RenderableImageOp;
import java.io.IOException;
import java.awt.SplashScreen;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.GroupLayout.Group;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JWindow;
import javax.swing.OverlayLayout;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.plaf.basic.BasicBorders.RadioButtonBorder;
import javax.swing.plaf.synth.SynthLookAndFeel;

import Pieces.*;

/* Jeremy Hsu, Vince, Vincent, Edward
 * 
 */
public class Game
{
	static int count;
	static Timer timer1;
	final static int startPhase = 0, battlePhase = 1, gameOverPhase = 2;
	final static boolean p1Turn = true, p2Turn = false;
	static boolean turn = true;
	static int gamePhase = 0;
	static String name = "";
	static ImageIcon blankImage = new ImageIcon(Game.class.getResource("blank.png"));
	public static void  main(String[] args)
	{
		SynthLookAndFeel synth = new SynthLookAndFeel();
		try {
			synth.load(Game.class.getResourceAsStream("design.xml"), Game.class);
			UIManager.setLookAndFeel(synth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Use "java -splash:splashTitle.gif Game" in cmd while in bin folder to run with splash
		final SplashScreen splash = SplashScreen.getSplashScreen();
		//SplashScreen();
		JFrame.setDefaultLookAndFeelDecorated(false);
		JFrame frame = new JFrame("Stratego");
		//frame.setIconImage(<ICON>.getImage());
		addComponentsToFrame(frame);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.pack();
		frame.setSize(frame.getSize());
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	public static void SplashScreen() {
		JProgressBar progressBar = new JProgressBar();
		JWindow win = new JWindow();
		JPanel panel = new JPanel();
		Container container = win.getContentPane();
		JLabel label = new JLabel(new ImageIcon(Game.class.getResource("Title.png")));
		JLabel loading = new JLabel(new ImageIcon(Game.class.getResource("loading.gif")));
		container.setLayout(null);
		panel.setBounds(0,0, 750, 300);//size of the title image
		container.add(panel);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		loading.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel.add(label);
		panel.add(loading);
		panel.setOpaque(false);
		progressBar.setMaximum(100);
		progressBar.setBounds(162, 176, 428, 5);//This is hard to track, try using photoshop or etc to get values
		//progressBar.setBackground(Color.decode("#580F19"));//Illusion that it is invisable
		//progressBar.setForeground(Color.orange);
		//progressBar.setBorder(null);
		//progressBar.setBorderPainted(false);
		progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
		progressBar.setVisible(true);
		container.add(progressBar);
		container.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		loadProgressBar(progressBar, win);
		win.setSize(750, 300);
		win.setBackground(new Color(0,0,0,0));//This to set Opaque false
		win.setLocationRelativeTo(null);
		win.setVisible(true);
	}
	private static void loadProgressBar(JProgressBar progressBar, JWindow win) {
		//this is the loading bar
		ActionListener al = new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) 
			{
				count++;
				progressBar.setValue(count);
				if (count == 100) {
					createFrame();
					win.setVisible(false);//swapped this around with timer1.stop()
					timer1.stop();
				}
			}
			private void createFrame() 
			{
				//this opens when the splashscreen is done
				JFrame.setDefaultLookAndFeelDecorated(false);
				JFrame frame = new JFrame("Stratego");
				//frame.setIconImage(<ICON>.getImage());
				addComponentsToFrame(frame);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setResizable(true);
				frame.pack();
				frame.setSize(frame.getSize());
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
			}
		};
		timer1 = new Timer(25, al);
		timer1.start();
	}
	public static void addComponentsToFrame(JFrame frame)
	{
		//Declare Variables
		Piece p1Piece = new Piece(p1Turn);
		Piece p2Piece = new Piece(p2Turn);

		Container container = frame.getContentPane();//Contains every panel
		JPanel horizontalPanel = new JPanel();//Centers all Panels
		JPanel buttonPanel = new JPanel();//Contains Map buttons
		JPanel mapPanel = new JPanel();//Contains buttonPanel and the map
		JPanel placePiecePanel = new JPanel();//Contains the buttons to place pieces
		JPanel rightPanel = new JPanel();//Contains all the right side panels
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenu mapMenu = new JMenu("Map");
		JMenu helpMenu = new JMenu("Help");
		JRadioButtonMenuItem grassMap = new JRadioButtonMenuItem("Grassland", true);
		JRadioButtonMenuItem caveMap = new JRadioButtonMenuItem("Cave", false);
		JRadioButtonMenuItem netherMap = new JRadioButtonMenuItem("Nether", false);
		JRadioButtonMenuItem endMap = new JRadioButtonMenuItem("End", false);
		ButtonGroup mapsGroup = new ButtonGroup();
		JMenuItem restartItem = new JMenuItem("Restart");
		MapButton mapButton[][] = new MapButton[10][10];
		JButton sideButton[] = new JButton[12];
		JButton endTurnButton = new JButton("End Turn");
		JLabel backgroundImage = new JLabel(new ImageIcon(Game.class.getResource("Maps\\grassland.png")));
		JLabel title = new JLabel("Player 1's turn...");
		Font font = new Font("Minecraft", Font.BOLD, 32);
		String names[] = {"Ender Dragon", "Tnt", "Flag", "Ghast", "Golem", "Herobrine",
				"Miner", "Skeleton", "Enderman", "Witch", "Wither", "Zombie"};
		ActionListener mapSelectActions = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
				if (thisButton.isSelected()) {
					backgroundImage.setIcon(new ImageIcon(Game.class.getResource(
							"Maps\\" + thisButton.getText().toLowerCase() + ".png")));
				}
			}
		};
		ActionListener nextPlayerAction = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				if (gamePhase == startPhase) {
					if (turn == p1Turn) {
						disableAll(mapButton, p1Piece);
						endTurnButton.setEnabled(false);
						turn = p2Turn;
					} else {
						disableAll(mapButton, p2Piece);
						turn = p1Turn;
						gamePhase = battlePhase;
					}
				}
			}
		};
		ActionListener mapActions = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton thisButton = (JButton) e.getSource();
				Piece piece;
				if (turn == p1Turn) {
					piece = p1Piece;
					title.setText("Player 1's turn...");
				} else {
					piece = p2Piece;
					title.setText("Player 2's turn...");
				}
				if (gamePhase == startPhase) {
					if (thisButton.getIcon() != blankImage) {
						return;
					} else if (piece.isAmountValid(name)) {
						piece.usePiece(name);
						piece.setButton(name, thisButton);
						if (piece.isAmountValid(name)) {
							//sideButton[].setEnabled(false);//Thing Jeremy is working on
						}
					}
					if (piece.isAllPiecesOnBoard()) {
						endTurnButton.setEnabled(true);
					} else {
						endTurnButton.setEnabled(false);
					}
				} else if (gamePhase == battlePhase) {

				} else {

				}
			}
		};
		ActionListener sideAction = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton thisButton = (JButton) e.getSource();
				name = thisButton.getText();
				if (gamePhase == startPhase) {
					if (turn == p1Turn) {
						disableAll(mapButton, p1Piece);
						for (int i = 0; i < 4; i++) {
							for (int j = 0; j < mapButton[i].length; j++) {
								mapButton[i][j].setEnabled(true);
							}
						}
					} else {
						disableAll(mapButton, p2Piece);
						for (int i = mapButton.length - 1; i >= mapButton.length - 4; i--) {
							for (int j = 0; j < mapButton[i].length; j++) {
								mapButton[i][j].setEnabled(true);
							}
						}
					}
				} else if (gamePhase == battlePhase) {

				} else {

				}
			}
		};

		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		mapPanel.setLayout(new OverlayLayout(mapPanel));
		buttonPanel.setLayout(new GridLayout(10, 10));
		buttonPanel.setMaximumSize(new Dimension(620, 620));
		horizontalPanel.setLayout(new BoxLayout(horizontalPanel, BoxLayout.X_AXIS));
		placePiecePanel.setLayout(new GridLayout(0,3, 10, 10));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		rightPanel.setName("sidePanel");

		backgroundImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		mapsGroup.add(grassMap);
		mapsGroup.add(caveMap);
		mapsGroup.add(netherMap);
		mapsGroup.add(endMap);
		grassMap.addActionListener(mapSelectActions);
		caveMap.addActionListener(mapSelectActions);
		netherMap.addActionListener(mapSelectActions);
		endMap.addActionListener(mapSelectActions);
		frame.setJMenuBar(menuBar);
		menuBar.add(gameMenu);
		menuBar.add(mapMenu);
		menuBar.add(helpMenu);
		gameMenu.add(restartItem);
		mapMenu.add(grassMap);
		mapMenu.add(caveMap);
		mapMenu.add(netherMap);
		mapMenu.add(endMap);

		for (int i = mapButton.length - 1; i >= 0; i--)
		{
			for (int j = 0; j < mapButton[i].length; j++)
			{
				mapButton[i][j] = new MapButton(blankImage);
				mapButton[i][j].setEnabled(false);
				mapButton[i][j].setName("mapButton");
				mapButton[i][j].setCoordinate(j, i);
				if (i == 3 && j == 0) {
					mapButton[i][j].setEnabled(true);
				}
				mapButton[i][j].addActionListener(mapActions);
				buttonPanel.add(mapButton[i][j]);
			}
		}
		buttonPanel.setOpaque(false);
		mapPanel.add(buttonPanel);
		mapPanel.add(backgroundImage);
		mapPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalPanel.add(mapPanel);
		rightPanel.setBackground(Color.gray);
		title.setFont(font);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(title);
		for (int i = 0; i < sideButton.length; i++)
		{
			sideButton[i] = new JButton(names[i]);
			sideButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			sideButton[i].addActionListener(sideAction);
			placePiecePanel.add(sideButton[i]);
		}
		placePiecePanel.setOpaque(false);
		rightPanel.add(placePiecePanel);
		rightPanel.add(Box.createRigidArea(new Dimension(0, 10)));
		endTurnButton.addActionListener(nextPlayerAction);
		endTurnButton.setEnabled(false);
		endTurnButton.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
		endTurnButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(endTurnButton);
		horizontalPanel.add(rightPanel);
		container.add(horizontalPanel);
	}
	public static void disableAll(JButton[][] button, Piece piece) {
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				if (turn == piece.getTeam() && button[i][j].getIcon() != blankImage) {
					button[i][j].setDisabledIcon(new ImageIcon(Game.class.getResource("Pieces\\hidden.png")));
				} else if (turn != piece.getTeam()){
					button[i][j].setDisabledIcon(button[i][j].getIcon());
				}
				button[i][j].setToolTipText(null);
				button[i][j].setEnabled(false);
			}
		}
	}
}//end class
