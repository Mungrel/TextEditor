package textEd.logic;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import textEd.frames.MainFrame;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by Nick p on 7/08/2015.
 */
public class SaveLoad {

	public static File lastDir = null;

	public void save(String fileContents) {
		JFileChooser jfc = getChooser();
		jfc.showSaveDialog(null);
		File chosenFile = jfc.getSelectedFile();
		if (chosenFile == null) {
			return;
		} else {
			lastDir = chosenFile.getParentFile();
			FileWriter fw;
			try {
				fw = new FileWriter(chosenFile + ".txt");

				fw.write(fileContents);
				fw.close();
			} catch (IOException e) {
				displayError("Error saving file");
			}
		}
	}

	public String load() {
		JFileChooser jfc = getChooser();
		jfc.showOpenDialog(null);
		File chosenFile = jfc.getSelectedFile();
		String content = "";
		if (chosenFile == null) {
			return null;
		}
		try {
			content = new Scanner(jfc.getSelectedFile()).useDelimiter("\\Z")
					.next();
			lastDir = jfc.getSelectedFile().getParentFile();
		} catch (Exception e3) {
			displayError("Error opening file\nTry again");
		}
		MainFrame.mFrame.setTitle("Nick's TextEd - "+chosenFile.getName());
		return content;
	}

	private static JFileChooser getChooser() {

		JFileChooser jfc = new JFileChooser();

		FileNameExtensionFilter ff = new FileNameExtensionFilter(
				"Text Documents (.txt)", "txt");
		jfc.setFileFilter(ff);
		jfc.setAcceptAllFileFilterUsed(false);

		if (lastDir != null) {
			jfc.setCurrentDirectory(lastDir);
		}

		return jfc;
	}

	public static void displayError(String msg) {
		JOptionPane.showMessageDialog(null, msg, "Error",
				JOptionPane.ERROR_MESSAGE);
	}
}
