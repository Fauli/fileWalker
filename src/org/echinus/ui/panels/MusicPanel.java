package org.echinus.ui.panels;

import java.awt.GridLayout;
import java.awt.Label;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.echinus.derby.DBInstance;

public class MusicPanel extends JPanel {

	public MusicPanel() {
		super();

		JLabel filler = new JLabel("Music Panel");
		filler.setHorizontalAlignment(JLabel.CENTER);
		this.setLayout(new GridLayout(25, 1));
		this.add(filler);
		
		JPanel contentPanel = new JPanel();
		
//		ArrayList<String> fileList = FileUtils.getFilesAndFilesSubDirectories("C:\\Windows\\TEMP");
		ArrayList<String> fileList = DBInstance.getInstance().getAllFiles();
		
		
		for (String file : fileList) {
			this.add(new Label(file));
		}
		
			
		
	}

}
