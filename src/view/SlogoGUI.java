package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Point2D;
import java.io.File;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import model.SlogoModel;
import javax.swing.JButton;
import javax.swing.JSeparator;

import controller.Controller;

import util.Pixmap;

public class SlogoGUI extends JFrame {

	/**
	 * Constants
	 */
	public static final String TITLE = "SLOGO";
	private static final long serialVersionUID = 1L;
	private static final int NO_KEY_PRESSED = -1;
	private static final String NEW_LINE_CHARACTER = "\n";

	/**
	 * Instance variables
	 */
	private JPanel myContentPane;
	private JTextField myInputTextField;
	private JButton myEnter;
	private JList myCommandList;
	private DefaultListModel listContent;
	private ActionListener takeInputAfterClickingButton;
	private KeyListener enterKeyListener;
	private JSeparator mySeparator;
	private Canvas myCanvas;
	private SlogoModel myModel;
	private Controller myController;
	private int myLastKeyPressed;
	private boolean readInFromHistory = false;

	/**
	 * Create the View.
	 */
	public SlogoGUI(SlogoModel model, Controller control) {
		myModel = model;
		myModel.setCanvas(myCanvas);
		myController = control;
		myContentPane = (JPanel) getContentPane();

		myContentPane.setLayout(null);
		myContentPane.add(createInputTextFieldAndSetItsProperties());
		myContentPane.add(createEnterButtonAndSetItsProperties());
		myContentPane.add(createSeparator());
		myContentPane.add(createCanvas());
		myContentPane.add(createListForCommandHistory());
		setJMenuBar(createMenuBar());
		setBounds(100, 100, 900, 630);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	/**
	 * Create the Text Area to display command history
	 * 
	 * @return
	 */
	private JScrollPane createListForCommandHistory() {
		listContent = new DefaultListModel();
		myCommandList = new JList(listContent);
		myCommandList
				.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		myCommandList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		myCommandList.setVisibleRowCount(-1);
		myCommandList.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					readInFromHistory = true;
					myController.update();
				}
			}
		});
		JScrollPane listScroller = new JScrollPane(myCommandList);
		listScroller.setBounds(663, 5, 235, 525);
		listScroller.setAlignmentX(LEFT_ALIGNMENT);
		return listScroller;
	}

	/**
	 * Create Canvas: for drawing turtle and lines. Canvas is DIY, based on the
	 * Java Swing Canvas JComponent
	 * 
	 * @return
	 */
	private Canvas createCanvas() {
		myCanvas = new Canvas(myModel);
		return myCanvas;
	}

	public String getInputText() {
		if (readInFromHistory) {
			return (String) myCommandList.getSelectedValue();
		}
		return myInputTextField.getText().toString();
	}

	/**
	 * Create the Separator
	 * 
	 * @return
	 */
	private JSeparator createSeparator() {
		mySeparator = new JSeparator();
		mySeparator.setBounds(0, 536, 900, 12);
		return mySeparator;
	}

	/**
	 * Create the enter button and add action listener.
	 * 
	 * @return
	 */
	private JButton createEnterButtonAndSetItsProperties() {
		myEnter = new JButton("Enter");
		myEnter.setBounds(800, 544, 70, 30);
		createButtonActionListenerAndSetItsProperties();
		myEnter.addActionListener(takeInputAfterClickingButton);
		return myEnter;
	}

	/**
	 * Create the action listener for the enter button
	 */
	private void createButtonActionListenerAndSetItsProperties() {
		takeInputAfterClickingButton = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String commandHistory = myInputTextField.getText().toString();
				listContent.addElement(commandHistory);
				myController.update();
			}

		};
	}

	public void DisplayException() {
		myInputTextField
				.setText("Invalid Command input. Please provide a valid command!!");
	}

	public void DisplayReturn(int input) {
		myCanvas.repaint();
		myInputTextField.setText("");
		listContent.addElement(input);
	}

	/**
	 * Create the text field for command input and add the action Listener
	 * 
	 * @return
	 */
	private JTextField createInputTextFieldAndSetItsProperties() {
		myInputTextField = new JTextField();
		myInputTextField.setBounds(6, 545, 800, 27);
		myInputTextField.setColumns(10);
		createKeyEventListener();
		myInputTextField.addKeyListener(enterKeyListener);
		return myInputTextField;
	}

	/**
	 * Key listener: listen to "ENTER". For the text area
	 */
	private void createKeyEventListener() {
		enterKeyListener = new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				myLastKeyPressed = e.getKeyCode();
				if (myLastKeyPressed == KeyEvent.VK_ENTER) {
					String commandHistory = myInputTextField.getText()
							.toString();
					listContent.addElement(commandHistory);
					myController.update();
				}
			}

			@Override
			public void keyReleased(KeyEvent e) {
				myLastKeyPressed = NO_KEY_PRESSED;
			}
		};
	}

	/**
	 * Get the latest key pressed Convenience method
	 * 
	 * @return
	 */
	private int getMyLastKeyPressed() {
		return myLastKeyPressed;
	}

	/**
	 * Create the Menu bar
	 * 
	 * @return
	 */
	private JMenuBar createMenuBar() {
		JMenuBar myMenuBar;
		JMenu myMenu;

		myMenuBar = new JMenuBar();
		myMenu = createMainMenu();
		myMenuBar.add(myMenu);
		myMenu = createPenMenu();
		myMenuBar.add(myMenu);
		// Help Section
		myMenu = createHelpMenu();
		myMenuBar.add(myMenu);

		myMenu = createBackgroundMenu();
		myMenuBar.add(myMenu);

		myMenu = createTurtleMenu();
		myMenuBar.add(myMenu);

		return myMenuBar;
	}

	private ActionListener createTurtleImageButtons(final String name) {
		ActionListener a = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String newName = name + ".jpg";
				Pixmap newImage = new Pixmap(newName);
				myModel.getTurtle().setImage(newImage);
				myCanvas.repaint();
			}
		};
		return a;
	}

	private JMenu createTurtleMenu() {
		JMenuItem myMenuItem;
		ButtonGroup turtleImageGroup = new ButtonGroup();
		JMenu turtleMenu = new JMenu("Turtle");
		JMenu turtleImageMenu = new JMenu("Image");
		turtleMenu.add(turtleImageMenu);

		String name = "TurtleIcon";
		createTurtleImage(turtleImageGroup, turtleImageMenu, name);
		name = "Blastoise";
		createTurtleImage(turtleImageGroup, turtleImageMenu, name);
		name = "Cecil";
		createTurtleImage(turtleImageGroup, turtleImageMenu, name);
		name = "Squirtle";
		createTurtleImage(turtleImageGroup, turtleImageMenu, name);
		name = "Franklin";
		createTurtleImage(turtleImageGroup, turtleImageMenu, name);

		final JMenuItem highlight = new JCheckBoxMenuItem("Highlight");

		highlight.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (highlight.isSelected()) {
					myModel.getTurtle().turnOnHighlight();
					myCanvas.repaint();
				}
				if (!highlight.isSelected()) {
					myModel.getTurtle().turnOffHighlight();
					myCanvas.repaint();
				}
			}
		});

		turtleMenu.add(highlight);
		return turtleMenu;
	}

	private void createTurtleImage(ButtonGroup turtleImageGroup,
			JMenu turtleImageMenu, String name) {
		JMenuItem myMenuItem;
		myMenuItem = new JRadioButtonMenuItem(name);
		myMenuItem.addActionListener(createTurtleImageButtons(name));
		turtleImageMenu.add(myMenuItem);
		turtleImageGroup.add(myMenuItem);
	}

	private JMenu createBackgroundMenu() {
		JMenu myMenu, subMenu;
		JMenuItem myMenuItem;
		myMenu = new JMenu("Background");
		subMenu = new JMenu("Color");
		ButtonGroup colorGroup = new ButtonGroup();

		myMenuItem = new JRadioButtonMenuItem("White");
		myMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myCanvas.setColor(Color.WHITE);
				myCanvas.repaint();
			}

		});
		colorGroup.add(myMenuItem);
		subMenu.add(myMenuItem);
		myMenuItem = new JRadioButtonMenuItem("Red");
		myMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myCanvas.setColor(Color.RED);
				myCanvas.repaint();
			}

		});
		colorGroup.add(myMenuItem);
		subMenu.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Blue");
		myMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myCanvas.setColor(Color.BLUE);
				myCanvas.repaint();
			}

		});
		colorGroup.add(myMenuItem);
		subMenu.add(myMenuItem);
		myMenu.add(subMenu);

		return myMenu;
	}

	private JMenu createHelpMenu() {
		JMenu myMenu;
		JMenuItem myMenuItem;
		myMenu = new JMenu("Help");
		// Grid:
		final JCheckBoxMenuItem gridCheckBox = new JCheckBoxMenuItem("Grid");
		gridCheckBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (gridCheckBox.isSelected()) {
					myCanvas.turnOnGrid();
				}
				if (!gridCheckBox.isSelected()) {
					myCanvas.turnOffGrid();
					myCanvas.repaint();
				}
			}
		});
		myMenu.add(gridCheckBox);

		myMenuItem = new JMenuItem("Help Page");
		ActionListener helpPage = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				openHelpPage();
			}
		};
		myMenuItem.addActionListener(helpPage);
		myMenu.add(myMenuItem);
		return myMenu;
	}

	private JMenu createPenMenu() {
		JMenu myMenu;
		JMenu penStyle;
		JMenu penThickness;
		JMenuItem myMenuItem;
		myMenu = new JMenu("Pen");
		// Pen Up and Down
		ButtonGroup penStateGroup = new ButtonGroup();
		myMenuItem = new JRadioButtonMenuItem("Down");
		myMenuItem.setSelected(true);
		penStateGroup.add(myMenuItem);
		myMenu.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Up");
		penStateGroup.add(myMenuItem);
		myMenu.add(myMenuItem);

		// Pen Style
		ButtonGroup penStyleGroup = new ButtonGroup();
		penStyle = new JMenu("Line Style");

		myMenuItem = new JRadioButtonMenuItem("Solid");
		myMenuItem.setSelected(true);
		penStyleGroup.add(myMenuItem);
		penStyle.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Dashed");
		penStyleGroup.add(myMenuItem);
		penStyle.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Double Line");
		penStyleGroup.add(myMenuItem);
		penStyle.add(myMenuItem);
		myMenu.add(penStyle);

		// Thickness
		ButtonGroup penThicknessGroup = new ButtonGroup();
		penThickness = new JMenu("Thickness");

		myMenuItem = new JRadioButtonMenuItem("1.0");
		myMenuItem.setSelected(true);
		penThicknessGroup.add(myMenuItem);
		penThickness.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("2.0");
		penThicknessGroup.add(myMenuItem);
		penThickness.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("3.0");
		penThicknessGroup.add(myMenuItem);
		penThickness.add(myMenuItem);
		myMenu.add(penThickness);

		// Color
		ButtonGroup penColorGroup = new ButtonGroup();
		JMenu penColor = new JMenu("Color");

		myMenuItem = new JRadioButtonMenuItem("Black");
		myMenuItem.setSelected(true);
		penColorGroup.add(myMenuItem);
		penColor.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Red");
		penColorGroup.add(myMenuItem);
		penColor.add(myMenuItem);

		myMenuItem = new JRadioButtonMenuItem("Blue");
		penColorGroup.add(myMenuItem);
		penColor.add(myMenuItem);

		myMenu.add(penColor);
		return myMenu;
	}

	private JMenu createMainMenu() {
		JMenu myMenu;
		JMenuItem myMenuItem;
		myMenu = new JMenu("Main");
		myMenu.setMnemonic(KeyEvent.VK_M);
		myMenuItem = new JMenuItem("New WorkSpace");

		ActionListener newWindow = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SlogoModel model = new SlogoModel();
				SlogoGUI view = new SlogoGUI(model, myController);
			}
		};
		myMenuItem.addActionListener(newWindow);
		myMenu.add(myMenuItem);
		return myMenu;
	}

	public void openHelpPage() {
		String url = "http://www.cs.duke.edu/courses/cps108/current/assign/03_slogo/commands.php";
		try {
			java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
