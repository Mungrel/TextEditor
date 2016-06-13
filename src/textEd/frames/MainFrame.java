package textEd.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.StyledDocument;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextPane;

import textEd.logic.DocumentHandler;
import textEd.logic.SaveLoad;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {

	private JPanel contentPane;
	private SaveLoad sl = new SaveLoad();
	public static MainFrame mFrame = new MainFrame();
	public JLabel lblWords;
	public static JTextPane textArea;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setTitle("Nick's TextEd");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 438, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMinimumSize(new Dimension(getWidth(), menuBar.getHeight()));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmNew = new JMenuItem("New");
		mntmNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "New" button clicked
				textArea.setText("");
			}
		});
		mnFile.add(mntmNew);
		
		JMenuItem mntmOpen = new JMenuItem("Open");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "Load" button clicked
				String s = sl.load();
				if (s != null) {
					textArea.setText(s);
				}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmSaveAs = new JMenuItem("Save As...");
		mntmSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// "Save" button clicked
				sl.save(textArea.getText());
			}
		});
		mnFile.add(mntmSaveAs);
		
		JMenuItem mntmClose = new JMenuItem("Close");
		mntmClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mFrame.dispose();
			}
		});
		
		mnFile.add(mntmClose);
		
		JMenu mnFormat = new JMenu("Format");
		menuBar.add(mnFormat);
		
		JMenuItem mntmFont = new JMenuItem("Font...");
		mntmFont.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FontFrame.fFrame.setLocationRelativeTo(mFrame);
				FontFrame.fFrame.setVisible(true);
			}
		});
		mnFormat.add(mntmFont);

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textArea = new JTextPane();
		textArea.getDocument().addDocumentListener(new DocumentHandler());
		scrollPane.setViewportView(textArea);;
		
		JPanel statusPanel = new JPanel();
		contentPane.add(statusPanel, BorderLayout.SOUTH);
		statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.X_AXIS));
		
		lblWords = new JLabel("Words: 0");
		lblWords.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				TextStatsFrame.tsFrame.setLocationRelativeTo(mFrame);
				TextStatsFrame.updateLabels();
				TextStatsFrame.tsFrame.setVisible(true);
			}
		});
		statusPanel.add(lblWords);
		
	}
	
	public static StyledDocument getDocumentStyle(){
		return textArea.getStyledDocument();
	}
}
