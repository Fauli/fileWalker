package org.echinus.warez;

import javax.swing.JFrame;

import org.echinus.derby.DBInstance;
import org.echinus.ui.ManagementGUI;
import org.echinus.utils.FileUtils;
import org.echinus.utils.FileWalker;

public class WarezMgmt {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// DEBUG:
		
		DBInstance dbi = DBInstance.getInstance();
		dbi.clearDB();
		System.out.println("Debug active");
		
		// TODO Auto-generated method stub
		System.out.println("Collecting files..");
		FileWalker fw = new FileWalker();
		fw.collectInfos(dbi);
		
		System.out.println("Started..");
		ManagementGUI mgmtGui = new ManagementGUI();
		mgmtGui.setTitle("Warez Mgmt Tool");
		mgmtGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mgmtGui.setLocationRelativeTo(null);
		mgmtGui.setVisible(true);


	}

}
