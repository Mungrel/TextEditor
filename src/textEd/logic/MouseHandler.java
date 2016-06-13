package textEd.logic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import textEd.frames.FontFrame;

public class MouseHandler implements MouseListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		FontFrame.updateSampleTextFont();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		FontFrame.updateSampleTextFont();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		FontFrame.updateSampleTextFont();
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {FontFrame.updateSampleTextFont();}

	@Override
	public void mouseExited(MouseEvent e) {FontFrame.updateSampleTextFont();}

}
