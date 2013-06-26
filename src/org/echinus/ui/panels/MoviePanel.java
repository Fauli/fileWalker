package org.echinus.ui.panels;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MoviePanel extends JPanel {

	public MoviePanel() {
		super();

		JLabel filler = new JLabel("Movie Panel");
		filler.setHorizontalAlignment(JLabel.CENTER);
		this.setLayout(new GridLayout(1, 1));
		this.add(filler);
	}

}
