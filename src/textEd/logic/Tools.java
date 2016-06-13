package textEd.logic;

import java.awt.Color;
import java.awt.GraphicsEnvironment;

import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class Tools {
	
	public static Style getNewStyle(String fontName, int pt, boolean isUnderlined, boolean isBold, boolean isItalic, Color textColor, Color highlight){
		
		Style myStyle = new StyleContext().getStyle(StyleContext.DEFAULT_STYLE);
		
		StyleConstants.setUnderline(myStyle, isUnderlined);
		StyleConstants.setBold(myStyle, isBold);
		StyleConstants.setItalic(myStyle, isItalic);
		StyleConstants.setFontSize(myStyle, pt);
		StyleConstants.setFontFamily(myStyle, fontName);
		StyleConstants.setForeground(myStyle, textColor);
		StyleConstants.setBackground(myStyle, highlight);
		
		return myStyle;
	}
	
	public static String[] getFontsList(){
		return GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
	}
	
	public static int getNumParagraphs(String s){
		System.out.println(s);
		if (s.isEmpty()){
			return 0;
		} else {
			s = s.replaceAll("\r", "\n");
		int lastIndex = 0;
		String findStr = "\n\n\n";
		int count = 1;
		while(lastIndex != -1){

		    lastIndex = s.indexOf(findStr,lastIndex);

		    if(lastIndex != -1){
		        count ++;
		        lastIndex += findStr.length();
		    }
		}
		return count;
	}}
	public static int getNumLines(String s){
		if (s.isEmpty()){
			return 0;
		} else {
		int count = 1;
		char[] ca = s.toCharArray();
		for (char c : ca){
			if (c == '\n'){
				count++;
			}
		}
		return count;
	}}
	
	public static int getNumChars(String s){
		return s.toCharArray().length;
	}
	public static int getNumWords(String s){
		s = s.trim();
	
		if (s.isEmpty()) {
	    	return 0;
	    }
	        
	    return s.split("\\s+").length;
	}

}
