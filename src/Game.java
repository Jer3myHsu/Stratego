import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.renderable.RenderableImageOp;
import java.io.IOException;
import java.awt.SplashScreen;

import javax.swing.BorderFactory;
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
    final static boolean player1Turn = true, player2Turn = false;
    static boolean turn = true;
    static int gamePhase = 0;
    static String name = "";
    public static void  main(String[] args)
	{
		SynthLookAndFeel synth = new SynthLookAndFeel();
		try {
			synth.load(Game.class.getResourceAsStream("design.xml"), Game.class);
			//UIManager.setLookAndFeel(synth);
		} catch (Exception e) {
			e.printStackTrace();
		}
		SplashScreen();
	}
	public static void SplashScreen() {
		JProgressBar progressBar = new JProgressBar();
		JWindow win = new JWindow();
		JPanel panel = new JPanel();
        Container container = win.getContentPane();
        JLabel label = new JLabel(new ImageIcon(Game.class.getResource("Title.png")));
        container.setLayout(null);
        panel.setBounds(0,0, 750, 200);//size of the title image
        container.add(panel);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        panel.add(label);
        panel.setOpaque(false);
        progressBar.setMaximum(100);
        progressBar.setBounds(162, 176, 428, 5);//This is hard to track, try using photoshop or etc to get values
        progressBar.setBackground(Color.decode("#580F19"));//Illusion that it is invisable
        progressBar.setForeground(Color.orange);
        progressBar.setBorder(null);
        progressBar.setBorderPainted(false);
        progressBar.setAlignmentX(Component.CENTER_ALIGNMENT);
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
				frame.setVisible(true);
				frame.setResizable(true);
				frame.pack();
				frame.setSize(frame.getSize());
				frame.setLocationRelativeTo(null);
			}
		};
		timer1 = new Timer(25, al);
		timer1.start();
	}
	public static void addComponentsToFrame(JFrame frame)
	{
		//Declare Variables
		Container container = frame.getContentPane();//Contains every panel
		JPanel horizontalPanel = new JPanel();//Centers all Panels
		JPanel buttonPanel = new JPanel();//Contains Map buttons
		JPanel mapPanel = new JPanel();//Contains buttonPanel and the map
		JPanel statPanel = new JPanel();//Contains the stats
		JPanel rightPanel = new JPanel();//Contains all the right side panels
		JMenuBar menuBar = new JMenuBar();
		JMenu gameMenu = new JMenu("Game");
		JMenu mapMenu = new JMenu("Map");
		JMenu helpMenu = new JMenu("Help");
		JRadioButtonMenuItem grassMap = new JRadioButtonMenuItem("Grassland", true);
		JRadioButtonMenuItem caveMap = new JRadioButtonMenuItem("Cave", false);
		ButtonGroup mapsItem = new ButtonGroup();
		JMenuItem restartItem = new JMenuItem("Restart");
		MapButton mapButton[][] = new MapButton[10][10];
		JButton sideButton[] = new JButton[12];
		JLabel backgroundImage = new JLabel(new ImageIcon(Game.class.getResource("Maps\\grassland.png")));
		JLabel title = new JLabel("It is your turn...");
		ImageIcon blankImage = new ImageIcon(Game.class.getResource("blank.png"));
		Font font = new Font("Minecraft", Font.BOLD, 32);
		String names[] = {"Ender Dragon", "Tnt", "Flag", "Ghast", "Golem", "Herobrine",
				"Miner", "Skeleton", "Enderman", "Witch", "Wither", "Zombie"};
		ActionListener mapSelectActions = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButtonMenuItem thisButton = (JRadioButtonMenuItem) e.getSource();
				System.out.println("hey");
				if (thisButton.isSelected()) {
					backgroundImage.setIcon(new ImageIcon(Game.class.getResource(
							"Maps\\" + thisButton.getText().toLowerCase() + ".png")));
				}
			}
		};
		ActionListener mapActions = new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton thisButton = (JButton) e.getSource();
				if (gamePhase == startPhase) {
					switch (name) {
					case "Ender Dragon": thisButton.setIcon(new ImageIcon(Game.class.getResource("test.png")));
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
				//disableAll(mapButton);
				if (gamePhase == startPhase) {
					if (turn == player1Turn) {
						for (int i = mapButton.length - 1; i >= mapButton.length - 4; i--) {
							for (int j = 0; j < mapButton[i].length; j++) {
								mapButton[i][j].setMapEnabled(true);
							}
						}
					} else {
						for (int i = 0; i < 4; i++) {
							for (int j = 0; j < mapButton[i].length; j++) {
								mapButton[i][j].setMapEnabled(true);
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
		statPanel.setLayout(new GridLayout(0,3, 10, 10));
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		
		backgroundImage.setAlignmentX(Component.CENTER_ALIGNMENT);
		mapsItem.add(grassMap);
		mapsItem.add(caveMap);
		grassMap.addActionListener(mapSelectActions);
		caveMap.addActionListener(mapSelectActions);
		frame.setJMenuBar(menuBar);
		menuBar.add(gameMenu);
		menuBar.add(mapMenu);
		menuBar.add(helpMenu);
		gameMenu.add(restartItem);
		mapMenu.add(grassMap);
		mapMenu.add(caveMap);
		
		for (int i = 0; i < mapButton.length; i++)
		{
			for (int j = 0; j < mapButton[i].length; j++)
			{
				mapButton[i][j] = new MapButton(blankImage, blankImage);
				//mapButton[i][j].setMapEnabled(false);
				mapButton[i][j].addActionListener(mapActions);
				buttonPanel.add(mapButton[i][j]);
			}
		}
		buttonPanel.setOpaque(false);
		mapPanel.add(buttonPanel);
		mapPanel.add(backgroundImage);
		mapPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
		horizontalPanel.add(mapPanel);
		rightPanel.setBorder(BorderFactory.createMatteBorder(
                28, 28, 28, 28, new ImageIcon(Game.class.getResource("texture\\border.png"))));
		rightPanel.setBackground(Color.gray);
		title.setFont(font);
		title.setAlignmentX(Component.CENTER_ALIGNMENT);
		rightPanel.add(title);
		for (int i = 0; i < sideButton.length; i++)
		{
			sideButton[i] = new JButton(names[i]);
			sideButton[i].setName("sideButton");
			sideButton[i].setAlignmentX(Component.CENTER_ALIGNMENT);
			sideButton[i].addActionListener(sideAction);
			statPanel.add(sideButton[i]);
		}
		statPanel.setOpaque(false);
		rightPanel.add(statPanel);
		horizontalPanel.add(rightPanel);
		container.add(horizontalPanel);
	}
	public static void disableAll(MapButton[][] button) {
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[i].length; j++) {
				button[i][j].setMapEnabled(false);
			}
		}
	}
}
