package org.echinus.ui;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.ScrollPaneConstants;

import org.echinus.derby.DBInstance;
import org.echinus.ui.panels.MoviePanel;
import org.echinus.ui.panels.MusicPanel;
import org.echinus.ui.panels.PreferencePanel;
import org.echinus.ui.panels.WelcomePanel;
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
		tabbedPane.setSize(600,400);
		ImageIcon icon = createImageIcon("/images/middle.png");

		JPanel welcomePanel = new WelcomePanel();
		JScrollPane jScrolWelcome = new JScrollPane(welcomePanel);
		tabbedPane.addTab("Welcome", icon, jScrolWelcome, "Welcome");
		tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

		JPanel musicPanel = new MusicPanel();
		JScrollPane jScrolMusic = new JScrollPane(musicPanel);
		jScrolMusic.setPreferredSize(new Dimension(600, 400));
		jScrolMusic.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tabbedPane.addTab("Music", icon, jScrolMusic, "Music");
		tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

		JComponent moviePanel = new MoviePanel();
		JScrollPane jScrolMovie = new JScrollPane(moviePanel);
		tabbedPane.addTab("Movies", icon, jScrolMovie, "Movies");
		tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

		JComponent panel4 = new PreferencePanel();
		panel4.setPreferredSize(new Dimension(600, 400));
		tabbedPane.addTab("Preferences", icon, panel4, "Does nothing at all");
		tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);

		this.add(tabbedPane);
		this.pack();
		this.add(panel);
//		FileUtils.listFilesAndFilesSubDirectories("C:\\Windows\\Temp");
//		DBInstance dbi = DBInstance.getInstance();

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
