package calculator;

/*
 * File Name:       CalculatorViewController.java
 * Author:          Mayank Khera
 * Student ID:		040912734
 * Course:          CST8221 - JavaApplicationProgramming
 * Lab Section: 	311
 * Assignment:      1, Part 2
 * Date:            November 2, 2019
 * Professor:       Daniel Cormier
 * Purpose:         This class is responsible for building and operating a GUI.
 * Class list:      Calculator                 
 */

import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.BorderFactory;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is responsible for launching frame to the screen.
 * 
 * @author Mayank Khera
 * @version 2
 * @see calculator
 * @since 1.8.0_121

 */
public class CalculatorViewController extends JPanel {
	
	/**Auto generated serialVersionUID to get rid of warning*/
	private static final long serialVersionUID = 564629511007450471L;
	private JTextField display1;// the calculator display1 field reference
	private JTextField display2;// the calculator display2 field reference
	private JLabel error;// the mode/error display label reference
	private JButton dotButton;// the decimal point (dot) button reference
	private JButton[] hexs;//to activate them separately when hex mode is on

	/** hex checkbox instance created*/
	JCheckBox checkBox = new JCheckBox("Hex");
	/**Radio button for single zero float-point precision*/
	JRadioButton singleZeroButton = new JRadioButton(".0", false);
	/**Radio button for double zero float-point precision*/
	JRadioButton doubleZeroButton = new JRadioButton(".00", true);
	/**Radio button for sci*/
	JRadioButton sciButton = new JRadioButton("Sci", false);
	/**Button group created so that all the radio buttons aren't enabled at once*/
	ButtonGroup group = new ButtonGroup();
	
	private static final String[] nums = { "A", "B", "C", "D", "E", "F", "7", "8", "9", "*", "4", "5", "6", "/", "1",
			"2", "3", "+", ".", "0", "\u00B1", "-" };

	public CalculatorViewController() {
		/**CalculatorModel object to get calculations from the class*/
		CalculatorModel model = new CalculatorModel();
		
		/**Controller object to access it*/
		Controller ctrl = new Controller(model);
		
		hexs = new JButton[6];

		JPanel keypad = new JPanel();
		JPanel keys = new JPanel();
		/**Jpanel created to store equal button*/
		JPanel equals = new JPanel();
		/**JPanel created to store Clear button*/
		JPanel clear = new JPanel();
		/**Jpanels creatd to organize the display and store buttons in different locations*/
		JPanel underDisplay = new JPanel();
		JPanel west = new JPanel();
		JPanel east = new JPanel();
		JPanel north = new JPanel();
		JPanel display = new JPanel();
		/**backspace button */
		JButton backspace = new JButton();
		/**backspace button being setup acording to the project*/
		backspace.setPreferredSize(new Dimension(52, 55));
		backspace.setBackground(Color.YELLOW);
		backspace.setOpaque(true);
		backspace.setBorder(BorderFactory.createMatteBorder(0, 5, 0, 1, Color.BLACK));
		backspace.setText("\u21da");
		backspace.setFont(new Font(backspace.getFont().getName(), Font.BOLD, 20));
		backspace.setToolTipText("Alt-B(Backspace)");
		backspace.setMnemonic('b');
		backspace.setActionCommand("\u21da");
		backspace.addActionListener(ctrl);
	
		/**JPanel created to store radio buttons*/
		JPanel radios = new JPanel();
		/**JPanel created to store radio buttons and checkbox*/
		JPanel box = new JPanel();

		/**setting layout for the window*/
		setLayout(new BorderLayout());
		/**setting border for the window*/
		setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.BLACK));
		
		/**setting border for north JPanel*/
		north.setLayout(new BorderLayout());

		error = new JLabel("F");
		error.setPreferredSize(new Dimension(52, 55));
		error.setOpaque(true);
		error.setBackground(Color.YELLOW);
		error.setBorder(BorderFactory.createMatteBorder(0, 1, 0, 5, Color.BLACK));
		error.setHorizontalAlignment(JLabel.CENTER);
		error.setFont(new Font(error.getFont().getName(), error.getFont().getStyle(), 20));

		display.setLayout(new GridLayout(2, 0));
		display.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
		display1 = new JTextField();
		display1.setPreferredSize(new Dimension(14, 30));
		display1.setBackground(Color.WHITE);
		display1.setEditable(false);
		display1.setHorizontalAlignment(JTextField.RIGHT);
		display1.setBorder(BorderFactory.createEmptyBorder());

		display2 = new JTextField();
		display2.setPreferredSize(new Dimension(14, 30));
		display2.setBackground(Color.WHITE);
		display2.setEditable(false);
		display2.setHorizontalAlignment(JTextField.RIGHT);
		display2.setText("0.0");
		display2.setBorder(BorderFactory.createEmptyBorder());

		display.add(display1);
		display.add(display2);

		north.add(error, BorderLayout.WEST);
		north.add(display, BorderLayout.CENTER);
		north.add(backspace, BorderLayout.EAST);

		//mode.setLayout(new FlowLayout());
		
		checkBox.setBackground(Color.GREEN);
		checkBox.addActionListener(ctrl);
		singleZeroButton.setBackground(Color.YELLOW);
		singleZeroButton.addActionListener(ctrl);
		doubleZeroButton.setBackground(Color.YELLOW);
		doubleZeroButton.addActionListener(ctrl);
		sciButton.setBackground(Color.YELLOW);
		sciButton.addActionListener(ctrl);
		checkBox.setActionCommand("Hex");
		singleZeroButton.setActionCommand(".0");
		doubleZeroButton.setActionCommand(".00");

		radios.setLayout(new GridLayout(1, 1, 5, 5));
		radios.setBackground(Color.YELLOW);
		radios.add(singleZeroButton);
		radios.add(doubleZeroButton);
		radios.add(sciButton);
		group.add(singleZeroButton);
		group.add(doubleZeroButton);
		group.add(sciButton);

		box.setLayout(new BorderLayout());
		box.setBackground(Color.BLACK);
		//box.setBackground(Color.BLACK);
		box.setBorder(BorderFactory.createMatteBorder(5, 1, 5, 1, Color.BLACK));
		//box.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		box.add(checkBox, BorderLayout.WEST);
		box.add(radios, BorderLayout.EAST);

		


		
		north.add(box, BorderLayout.SOUTH);

		underDisplay.setLayout(new BorderLayout());
		keypad.setLayout(new BorderLayout());
		

		// keys.setLayout(new GridLayout(6,1));
		keys.setBorder(BorderFactory.createMatteBorder(3, 3, 3, 3, Color.BLACK));
		keys.setLayout(new GridLayout(6, 3, 3, 3));
		keys.setBackground(Color.WHITE);
		west.setLayout(new GridLayout(2,1 , 3, 3));
		west.setBackground(Color.BLACK);
		west.setBorder(BorderFactory.createEmptyBorder(0, 0, 3, 3));

		east.setLayout(new GridLayout(2, 1,3,3));
		east.setBackground(Color.BLACK);
		east.setBorder(BorderFactory.createEmptyBorder(0, 3, 3, 0));

		clear.setBackground(Color.BLACK);
		equals.setBackground(Color.BLACK);

		equals.setLayout(new GridLayout(1, 1));
		equals.setBorder(BorderFactory.createMatteBorder(0, 3, 5, 3, Color.BLACK));
		clear.setLayout(new GridLayout(1, 1));
		clear.setBorder(BorderFactory.createMatteBorder(0, 3, 0, 3, Color.BLACK));
		
		/**this loop adds all the buttons on the keypad, using the method called createButton()*/
		for (int i = 0; i < nums.length; i++) {
			if (nums[i].equals(".")) {
				dotButton = createButton(".", ".", Color.BLACK, Color.MAGENTA,ctrl);
				keys.add(dotButton);
			} else if (nums[i].equals("\u00B1")) {
				keys.add(createButton("\u00B1", "\u00B1", Color.BLACK, Color.MAGENTA,ctrl));
			} else if (nums[i].equals("+") || nums[i].equals("-")) {
				east.add(createButton(nums[i], nums[i], Color.BLACK, Color.CYAN,ctrl))
						.setPreferredSize(new Dimension(48, 55));
				;
			} else if (nums[i].equals("*") || nums[i].equals("/")) {
				west.add(createButton(nums[i], nums[i], Color.BLACK, Color.CYAN,ctrl))
						.setPreferredSize(new Dimension(48, 55));
			} else if (nums[i].equals("A") || nums[i].equals("B") || nums[i].equals("C") || nums[i].equals("D")
					|| nums[i].equals("E") || nums[i].equals("F")) {
				hexs[i] = createButton(nums[i], nums[i], Color.GRAY, Color.BLUE,ctrl);
				keys.add(hexs[i]);
				hexs[i].setEnabled(false);
			} else {
				keys.add(createButton(nums[i], nums[i], Color.BLACK, Color.BLUE,ctrl));
			}
		}
		
		/**adding the rest of the button to the keypad*/
		clear.add(createButton("C", "c", Color.BLACK, Color.RED,ctrl));
		equals.add(createButton("=", "=", Color.BLACK, Color.YELLOW,ctrl));

		keypad.add(clear, BorderLayout.NORTH);
		keypad.add(keys, BorderLayout.CENTER);
		keypad.add(equals, BorderLayout.SOUTH);

		add(north, BorderLayout.NORTH);

		underDisplay.setBackground(Color.BLACK);
		underDisplay.add(west, BorderLayout.WEST);
		underDisplay.add(keypad, BorderLayout.CENTER);
		underDisplay.add(east, BorderLayout.EAST);

		add(underDisplay, BorderLayout.CENTER);

	}

	/**
	 * Purpose: Creates and returns a button using the passed parameters
	 * @param text
	 * @param ac
	 * @param fg
	 * @param bg
	 * @param handler
	 * @return JButton
	 */
	private JButton createButton(String text, String ac, Color fg, Color bg, ActionListener handler) {

		JButton retKey = new JButton(text);// create a button with text passed into the parameter

		retKey.setForeground(fg);// sets foreground color to fg
		retKey.setBackground(bg);// sets background color to bg

		if (ac != null)// if ac is null command need not be set
			retKey.setActionCommand(ac);// sets Action command to the passed parameter

		Font nFont = new Font(retKey.getName(), Font.PLAIN, 20);
		retKey.setFont(nFont);// sets the font to nFont(has font size 20 and doesn;t change the style or font)

		retKey.addActionListener(handler);// Registers the handler as an Action event listner for the button

		return retKey;// returns a reference to the created button
	}

	/**
	 * This class is responsible for handling all the events generated by the GUI
	 * 
	 * @author Mayank Khera
	 * @version 2
	 * @see calculator
	 * @since 1.8.0_121
	 */
	private class Controller implements ActionListener {
		/**Calculator model class object gets calculations through the parameter*/
		private CalculatorModel calcModel;
		/**String to store events*/
		private String ac;
		/**instance created to use the same function multiple times by hitting enter*/
		private int equals;
		
		public Controller(CalculatorModel calcModel) {
			this.calcModel = calcModel;
			equals = 0;
		}
		
		/**
		 * takes event as a parameter and performs actions accordingly
		 * @param event
		 */
		public void actionPerformed(ActionEvent event) {
			
			ac = event.getActionCommand();
			
			switch(ac) {
			
			case "\u21da":
				if(!calcModel.getEState()) {
					if(display2.getText().length() > 0) {
						if(display2.getText().length() == 1 && display2.getText().contains("-")) {
							display1.setText("line315");
							display2.setText("line316");
						}
						display2.setText(display2.getText().substring(0, display2.getText().length() - 1));
					}else {
						display1.setText("");
						display2.setText("0.0");
					}
				}
				break;
				
			case "Hex":
				
				if(checkBox.isSelected()) {
					equals = 0;
					error.setText("H");
					error.setBackground(Color.GREEN);
					display1.setText("");
					display2.setText("0");
					group.clearSelection();
					for(int i=0; i < hexs.length; i++) {
						hexs[i].setEnabled(true);
						hexs[i].setForeground(Color.BLACK);
					}
					dotButton.setEnabled(false);
					calcModel.setEState(false);
					calcModel.setOMode(ac);
				}else {
					doubleZeroButton.doClick();
				}
				break;
				
			case ".0":
			case ".00":
			case "Sci":
				equals = 0;
				error.setText("F");
				error.setBackground(Color.YELLOW);
				display1.setText("");
				display2.setText("0.0");
				checkBox.setSelected(false);
				
				for(int i = 0; i < hexs.length; i++) {
					hexs[i].setEnabled(false);
					hexs[i].setForeground(Color.GRAY);
				}
				dotButton.setEnabled(true);
				calcModel.setFpp(ac);
				calcModel.setEState(false);
				calcModel.setOMode("Float");
				break;
				
			case "c":
				equals = 0;
				calcModel.setEState(false);
				if(!checkBox.isSelected()) {
					error.setText("F");
					error.setBackground(Color.YELLOW);
					display1.setText("");
					display2.setText("0.0");
				}else {
					error.setText("H");
					error.setBackground(Color.GREEN);
					display1.setText("");
					display2.setText("0");
				}
				break;
				
			case "A":
			case "B":
			case "C":
			case "D":
			case "E":
			case "F":
			case "1":
			case "2":
			case "3":
			case "4":
			case "5":
			case "6":
			case "7":
			case "8":
			case "9":
			case "0":
			case ".":
				if(!calcModel.getEState()) {
					if(display2.getText().contentEquals("0.0") || display2.getText().contentEquals("0.0"))
						display2.setText(ac);
					else
						display2.replaceSelection(ac);
					if(display2.getText().length() == 14) {
						display2.setText("Exceeding digit limit");
						calcModel.setEState(true);
					}
				}
				break;
				
			case "+":
			case "-":
			case "*":
			case "/":
				if(!calcModel.getEState()) {
					calcModel.setAOperation(ac);
					if(display2.getText() != "") {
						calcModel.setOperand1(display2.getText());
						calcModel.setOperand2(display2.getText());
					}
					display1.setText(display2.getText() + " " + ac);
					display2.setText("");
				}
				break;
				
			case "\u00B1":
				if(!calcModel.getEState()) {
					if(display2.getText().startsWith("-")) 
						display2.setText(display2.getText().substring(1));
					else
						display2.setText("-".concat(display2.getText()));
				}
				break;
				
			case "=":
				if(!calcModel.getEState()) {
					if(!display2.getText().equals("") && equals == 0)
						calcModel.setOperand2(display2.getText());
					if(equals > 0)
						calcModel.setOperand1(display2.getText());
					//display1.replaceSelection(" "+display2.getText() + " " + ac);
					display1.setText("");
					display2.setText(calcModel.getResult());
					equals++;
				}
				break;
			}
			if(calcModel.getEState()) {
				error.setText("E");
				error.setBackground(Color.RED);
			}
			
		}
	}
}
