package textEd.logic;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import textEd.frames.MainFrame;

public class DocumentHandler implements DocumentListener{

	@SuppressWarnings("static-access")
	@Override
	public void insertUpdate(DocumentEvent e) {
		MainFrame.mFrame.lblWords.setText("Words: "+Tools.getNumWords(MainFrame.mFrame.textArea.getText()));
	}

	@SuppressWarnings("static-access")
	@Override
	public void removeUpdate(DocumentEvent e) {
		MainFrame.mFrame.lblWords.setText("Words: "+Tools.getNumWords(MainFrame.mFrame.textArea.getText()));
	}

	@SuppressWarnings("static-access")
	@Override
	public void changedUpdate(DocumentEvent e) {
		MainFrame.mFrame.lblWords.setText("Words: "+Tools.getNumWords(MainFrame.mFrame.textArea.getText()));
	}

}
