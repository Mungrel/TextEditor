package textEd.frames;

import java.awt.Component;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Style;
import javax.swing.JColorChooser;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import textEd.logic.MouseHandler;
import textEd.logic.Tools;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

@SuppressWarnings("serial")
public class FontFrame extends JFrame {

	private JPanel contentPane;
	public static FontFrame fFrame = new FontFrame();
	private JSpinner spinner;
	private JRadioButton boldBtn;
	private JRadioButton undrlnBtn;
	@SuppressWarnings("rawtypes")
	private JList list;
	private JRadioButton italicBtn;
	protected JTextPane txtArea;
	private Color textColor = Color.black;
	private Color highlightColor = Color.white;
	private JButton btnHighlight;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FontFrame() {
		setResizable(false);
		setTitle("Font");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 317, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 176, 165);
		contentPane.add(scrollPane);
		
		list = new JList(Tools.getFontsList());
		list.setSelectedIndex(0);
		list.addMouseListener(new MouseHandler());
		scrollPane.setViewportView(list);
		
		JLabel lblFont = new JLabel("Font Name");
		lblFont.setBounds(10, 11, 122, 14);
		contentPane.add(lblFont);
		
		JLabel lblFontSize = new JLabel("Font Size");
		lblFontSize.setBounds(193, 11, 101, 14);
		contentPane.add(lblFontSize);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Integer(12), new Integer(1), null, new Integer(1)));
		spinner.setBounds(203, 35, 46, 20);
		//Adding mouse listeners to all subcomponents of JSpinner
		for (Component c : spinner.getComponents()){
			c.addMouseListener(new MouseHandler());
		}
		contentPane.add(spinner);
		
		boldBtn = new JRadioButton("Bold");
		boldBtn.setBounds(196, 62, 109, 23);
		boldBtn.addMouseListener(new MouseHandler());
		contentPane.add(boldBtn);
		
		undrlnBtn = new JRadioButton("Underlined");
		undrlnBtn.setBounds(196, 88, 109, 23);
		undrlnBtn.addMouseListener(new MouseHandler());
		contentPane.add(undrlnBtn);
		
		italicBtn = new JRadioButton("Italic");
		italicBtn.setBounds(196, 114, 109, 23);
		italicBtn.addMouseListener(new MouseHandler());
		contentPane.add(italicBtn);
		
		txtArea = new JTextPane();
		txtArea.setEditable(false);
		txtArea.setText("Sample Text");
		txtArea.setBounds(10, 212, 284, 65);
		contentPane.add(txtArea);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBackground(Color.WHITE);
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fFrame.setVisible(false);
			}
		});
		btnCancel.setBounds(205, 288, 89, 23);
		contentPane.add(btnCancel);
		
		JButton btnOk = new JButton("OK");
		btnOk.setBackground(Color.WHITE);
		btnOk.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				
				MainFrame.mFrame.textArea.setLogicalStyle(fFrame.txtArea.getLogicalStyle());
				
				fFrame.setVisible(false);
			}
		});
		btnOk.setBounds(106, 288, 89, 23);
		contentPane.add(btnOk);
		
		JButton btnFontColour = new JButton("Colour");
		btnFontColour.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				//Colour button clicked
				JColorChooser jcc = new JColorChooser();
				Color newColour = jcc.showDialog(fFrame, "Colour", textColor);
				if (newColour != null){
					fFrame.textColor = newColour;
				}
				updateSampleTextFont();
			}
		});
		btnFontColour.setBackground(Color.WHITE);
		btnFontColour.setBounds(196, 144, 89, 23);
		contentPane.add(btnFontColour);
		
		btnHighlight = new JButton("Highlight");
		btnHighlight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Color chosenColor = JColorChooser.showDialog(fFrame, "Highlight Colour", fFrame.highlightColor);
				if (chosenColor != null){
					fFrame.highlightColor = chosenColor;
				}
				updateSampleTextFont();
			}
		});
		btnHighlight.setBackground(Color.WHITE);
		btnHighlight.setBounds(196, 178, 89, 23);
		contentPane.add(btnHighlight);
		
	}
	
	public static void updateSampleTextFont(){
		
		String fontName = (String)fFrame.list.getSelectedValue();
		int pt = (Integer)fFrame.spinner.getValue();
		boolean underline = fFrame.undrlnBtn.isSelected();
		boolean bold = fFrame.boldBtn.isSelected();
		boolean italic = fFrame.italicBtn.isSelected();
		
		Style s = Tools.getNewStyle(fontName, pt, underline, bold, italic, fFrame.textColor, fFrame.highlightColor);
		fFrame.txtArea.setLogicalStyle(s);
		fFrame.txtArea.repaint();
		}
}
