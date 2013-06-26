package org.echinus.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.echinus.utils.FileUtils;

public class ManagementGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panel = new JPanel();
	JLabel label = new JLabel("Test");

	/**
	 * @param args
	 */
	public ManagementGUI() {

		JTabbedPane tabbedPane = new JTabbedPane();
		ImageIcon icon = createImageIcon("images/middle.gif");

		JComponent panel1 = makeTextPanel("Panel #1");
		tabbedPane.addTab("Tab 1", icon, panel1, "Does nothing");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JComponent panel2 = makeTextPanel("Panel #2");
		tabbedPane.addTab("Tab 2", icon, panel2, "Does twice as much nothing");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent panel3 = makeTextPanel("Panel #3");
		tabbedPane.addTab("Tab 3", icon, panel3, "Still does nothing");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = makeTextPanel("Panel #4 (has a preferred size of 410 x 50).");
		panel4.setPreferredSize(new Dimension(410, 50));
		tabbedPane.addTab("Tab 4", icon, panel4, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		panel.add(label);
		this.add(tabbedPane);
		this.pack();
		this.add(panel);
		FileUtils.listFilesAndFilesSubDirectories("C:\\Windows\\Temp");

	}
	
	protected JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }
	
	/** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = ManagementGUI.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

}
