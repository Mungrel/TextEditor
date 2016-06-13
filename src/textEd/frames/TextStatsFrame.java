package textEd.frames;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import textEd.logic.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class TextStatsFrame extends JFrame {

	private JPanel contentPane;
	public static TextStatsFrame tsFrame = new TextStatsFrame();
	private JLabel lblParagraphs;
	private JLabel lblLines;
	private JLabel lblCharacters;
	private JLabel lblWords;

	public TextStatsFrame() {
		setResizable(false);
		setTitle("Statistics");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 258, 136);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblWords = new JLabel("Words: 0");
		lblWords.setBounds(10, 11, 89, 14);
		contentPane.add(lblWords);
		
		lblCharacters = new JLabel("Characters: 0");
		lblCharacters.setBounds(10, 36, 111, 14);
		contentPane.add(lblCharacters);
		
		lblLines = new JLabel("Lines: 0");
		lblLines.setBounds(124, 11, 46, 14);
		contentPane.add(lblLines);
		
		lblParagraphs = new JLabel("Paragraphs: 0");
		lblParagraphs.setBounds(124, 36, 111, 14);
		contentPane.add(lblParagraphs);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.WHITE);
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tsFrame.setVisible(false);
			}
		});
		btnOk.setBounds(146, 61, 89, 23);
		contentPane.add(btnOk);
	}
	@SuppressWarnings("static-access")
	public static void updateLabels(){
		String s = MainFrame.mFrame.textArea.getText();
		tsFrame.lblWords.setText("Words: "+Tools.getNumWords(s));
		tsFrame.lblCharacters.setText("Characters: "+Tools.getNumChars(s));
		tsFrame.lblLines.setText("Lines: "+Tools.getNumLines(s));
		tsFrame.lblParagraphs.setText("Paragraphs: "+Tools.getNumParagraphs(s));
	}
}
