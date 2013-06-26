package org.echinus.ui.panels;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.echinus.derby.DBInstance;
import org.echinus.utils.FileWalker;

public class WelcomePanel extends JPanel {
	
	JButton refreshButton = new JButton("Refresh Library");

	public WelcomePanel() {
		super();

		JLabel filler = new JLabel("Welcome here");
		filler.setHorizontalAlignment(JLabel.CENTER);
		this.setLayout(new GridLayout(2, 1));
		this.add(filler);
		
		refreshButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				System.out.println("would do a refresh");
				FileWalker fw = new FileWalker();
				fw.collectInfos(DBInstance.getInstance());
			}
		});
		this.add(refreshButton);
		
		
	}
	
	
	
	

}
