package jTextEditor;

import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.undo.UndoManager;

import java.awt.Color;

public class WindowInit {

	
	public JFrame frmJtexteditor;
	public String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	public String fontSizes[] = new String[]{"5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
	public JTextArea textBody;
	public JToggleButton tglbtnBold = new JToggleButton("");
	public JToggleButton tglbtnItalics = new JToggleButton("");
	public JToggleButton tglbtnWordWrap = new JToggleButton("");
	
	public Settings settings = new Settings();
	public String newFont;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox fontsComboBox = new JComboBox(fonts);
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public JComboBox sizesComboBox = new JComboBox(fontSizes);
	
	protected UndoManager undoManager = new UndoManager();
	
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void init() {

		frmJtexteditor = new JFrame();
		frmJtexteditor.setTitle("jTextEditor");
		frmJtexteditor.setBounds(100, 100, 629, 513);
		frmJtexteditor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frmJtexteditor.getContentPane().setLayout(gridBagLayout);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.fill = GridBagConstraints.BOTH;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		frmJtexteditor.getContentPane().add(toolBar, gbc_toolBar);
		
		JButton btnOpen = new JButton("");
		btnOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnOpen.setVerticalAlignment(SwingConstants.BOTTOM);
		btnOpen.setToolTipText("Open");
		btnOpen.setSelectedIcon(new ImageIcon(Main.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		btnOpen.setIcon(new ImageIcon(Main.class.getResource("/icons/open.png")));
		toolBar.add(btnOpen);
		
		JButton btnSave = new JButton("");
		btnSave.setVerticalAlignment(SwingConstants.BOTTOM);
		btnSave.setToolTipText("Save");
		btnSave.setIcon(new ImageIcon(Main.class.getResource("/icons/save.png")));
		toolBar.add(btnSave);
		
		JButton btnUndo = new JButton("");
		btnUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(undoManager.canUndo()){
					undoManager.undo();
				}
				
			}
		});
		btnUndo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnUndo.setToolTipText("Undo");
		btnUndo.setIcon(new ImageIcon(Main.class.getResource("/icons/undo.png")));
		toolBar.add(btnUndo);
		
		JButton btnRedo = new JButton("");
		btnRedo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(undoManager.canRedo()){
					undoManager.redo();
				}
				
			}
		});
		btnRedo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon(Main.class.getResource("/icons/redo.png")));
		toolBar.add(btnRedo);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		Component horizontalStrut_5 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_5);
		fontsComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		toolBar.add(fontsComboBox);
		fontsComboBox.setToolTipText("Font");
		fontsComboBox.setSelectedItem(getDefault("Font"));
	
		Component horizontalStrut = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut);
		sizesComboBox.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		sizesComboBox.setSelectedItem(getDefault("FontSize"));
		sizesComboBox.setToolTipText("Font Size");
		toolBar.add(sizesComboBox);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_1);
		tglbtnBold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnItalics.setSelected(false);
			}
		});
			
		tglbtnBold.setToolTipText("Bold");
		tglbtnBold.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnBold.setIcon(new ImageIcon(Main.class.getResource("/icons/bold.png")));
		tglbtnBold.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(tglbtnBold);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_2);
		tglbtnItalics.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tglbtnBold.setSelected(false);
			}
		});
		
		tglbtnItalics.setToolTipText("Italics");
		tglbtnItalics.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnItalics.setIcon(new ImageIcon(Main.class.getResource("/icons/italics.png")));
		tglbtnItalics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		toolBar.add(tglbtnItalics);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_3);
		
		tglbtnWordWrap.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnWordWrap.setToolTipText("Text Wrap");
		tglbtnWordWrap.setIcon(new ImageIcon(Main.class.getResource("/icons/wrap.png")));
		toolBar.add(tglbtnWordWrap);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_4);
		
		JButton btnApplyButton = new JButton("Apply");
		btnApplyButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnApplyButton.setIcon(new ImageIcon(WindowInit.class.getResource("/icons/apply.png")));
		btnApplyButton.setForeground(Color.BLACK);
		btnApplyButton.setVerticalAlignment(SwingConstants.BOTTOM);
		btnApplyButton.setToolTipText("Apply Font Changes");
		btnApplyButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String font = (String) fontsComboBox.getSelectedItem();
				String fontSize = (String) sizesComboBox.getSelectedItem();
				settings.setValue("Font", font);
				settings.setValue("FontSize", fontSize);
				
				changeTextBodyFont();
				
				if(tglbtnWordWrap.isSelected()){
					textBody.setLineWrap(true);
				}
				else{
					textBody.setLineWrap(false);
				}
			}
		});
		toolBar.add(btnApplyButton);

		textBody = new JTextArea();
//		textBody.setFont(new Font("Monospaced", Font.PLAIN, 11));
		changeTextBodyFont();
		textBody.getDocument().addUndoableEditListener(undoManager);
		
		JScrollPane textBodyScrollPane = new JScrollPane(textBody);
		GridBagConstraints gbc_textBodyScrollPane = new GridBagConstraints();
		gbc_textBodyScrollPane.fill = GridBagConstraints.BOTH;
		gbc_textBodyScrollPane.gridx = 0;
		gbc_textBodyScrollPane.gridy = 1;
		frmJtexteditor.getContentPane().add(textBodyScrollPane, gbc_textBodyScrollPane);
		
		JMenuBar menuBar = new JMenuBar();
		frmJtexteditor.setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("File");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mnNewMenu.add(mntmNew);
		
		JSeparator separator = new JSeparator();
		mnNewMenu.add(separator);
		
		JMenuItem mntmOpen = new JMenuItem("Open...");
		mnNewMenu.add(mntmOpen);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mnNewMenu.add(mntmClose);
		
		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnNewMenu.add(separator_1);
		mnNewMenu.add(mntmSave);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save as...");
		mnNewMenu.add(mntmSaveAs);
		
		JMenu mnAbout = new JMenu("Help");
		menuBar.add(mnAbout);
		
		JMenuItem mntmAboutJtexteditor = new JMenuItem("About jTextEditor");
		mnAbout.add(mntmAboutJtexteditor);
	}
//------------------------------End of init()---------------------------------//
	
	public void changeTextBodyFont(){
		
		String newFontName = (String) fontsComboBox.getSelectedItem();
		int newFontSize = Integer.parseInt((String) sizesComboBox.getSelectedItem());
		Font newFont = null;
		
		if(tglbtnBold.isSelected()){
			newFont = new Font(newFontName, Font.BOLD, newFontSize);
		}
		else if(tglbtnItalics.isSelected()){
			newFont = new Font(newFontName, Font.ITALIC, newFontSize);
		}
		else if(!(tglbtnBold.isSelected() || tglbtnItalics.isSelected())){
			newFont = new Font(newFontName, Font.PLAIN, newFontSize);
		}

		textBody.setFont(newFont);
		settings.setValue("Font", newFontName);
	}
	

	
	public String getDefault(String var){
		
		String value = settings.getValue(var);
		return value;
	}
	
	
	
}
