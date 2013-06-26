package org.echinus.ui.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreferencePanel extends JPanel {

	public PreferencePanel() {
		super();

		JLabel filler = new JLabel("Preference Panel");
		filler.setHorizontalAlignment(JLabel.CENTER);
		this.setLayout(new GridLayout(1, 1));
		this.add(filler);
	}

}
