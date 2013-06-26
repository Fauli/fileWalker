package org.echinus.utils;

import java.util.ArrayList;

import org.echinus.derby.DBInstance;

public class FileWalker {
	
	ArrayList<String> result;
	
	public void collectInfos(DBInstance dbi){
		
		result = FileUtils.getFilesAndFilesSubDirectories("C:\\Windows\\TEMP");
		
		for (String path : result) {
			
			dbi.insertFile(path);
			
		}
		
	}

}
