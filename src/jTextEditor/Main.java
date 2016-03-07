package jTextEditor;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import java.awt.GridBagConstraints;
import javax.swing.JTextArea;
import java.awt.Insets;
import javax.swing.JInternalFrame;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.JToggleButton;
import javax.swing.DefaultComboBoxModel;

public class Main {

	private JFrame frmJtexteditor;
	private GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
	private String[] fonts = e.getAvailableFontFamilyNames();
	private static int[] fontSizes = null; //Find a way to populate font sizes combobox

	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmJtexteditor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		btnUndo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnUndo.setToolTipText("Undo");
		btnUndo.setIcon(new ImageIcon(Main.class.getResource("/icons/undo.png")));
		toolBar.add(btnUndo);
		
		JButton btnRedo = new JButton("");
		btnRedo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnRedo.setToolTipText("Redo");
		btnRedo.setIcon(new ImageIcon(Main.class.getResource("/icons/redo.png")));
		toolBar.add(btnRedo);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		toolBar.add(horizontalGlue);
		
		JComboBox comboBox = new JComboBox(fonts);
		toolBar.add(comboBox);
		comboBox.setToolTipText("Font");
		
		Component horizontalStrut = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut);

		JComboBox comboBox_1 = new JComboBox();
		toolBar.add(comboBox_1);
		comboBox_1.setToolTipText("Font Size");
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_1);
		
		JToggleButton tglbtnBold = new JToggleButton("");
		tglbtnBold.setToolTipText("Bold");
		tglbtnBold.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnBold.setIcon(new ImageIcon(Main.class.getResource("/icons/bold.png")));
		tglbtnBold.setFont(new Font("Tahoma", Font.BOLD, 14));
		toolBar.add(tglbtnBold);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_2);
		
		JToggleButton tglbtnItalics = new JToggleButton("");
		tglbtnItalics.setToolTipText("Italics");
		tglbtnItalics.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnItalics.setIcon(new ImageIcon(Main.class.getResource("/icons/italics.png")));
		tglbtnItalics.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		toolBar.add(tglbtnItalics);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_3);
		
		JToggleButton tglbtnWordWrap = new JToggleButton("");
		tglbtnWordWrap.setVerticalAlignment(SwingConstants.BOTTOM);
		tglbtnWordWrap.setToolTipText("Text Wrap");
		tglbtnWordWrap.setIcon(new ImageIcon(Main.class.getResource("/icons/wrap.png")));
		toolBar.add(tglbtnWordWrap);
		
		Component horizontalStrut_4 = Box.createHorizontalStrut(5);
		toolBar.add(horizontalStrut_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		frmJtexteditor.getContentPane().add(scrollPane, gbc_scrollPane);
		
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

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
