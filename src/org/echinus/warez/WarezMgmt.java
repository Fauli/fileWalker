package org.echinus.warez;

import javax.swing.JFrame;

import org.echinus.ui.ManagementGUI;

public class WarezMgmt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Started..");
		ManagementGUI mgmtGui = new ManagementGUI();
		mgmtGui.setTitle("Warez Mgmt Tool");
		mgmtGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mgmtGui.setVisible(true);

	}

}
