package org.echinus.utils;

import java.awt.List;
import java.io.File;
import java.util.ArrayList;

public class FileUtils {
	
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     */
    public static void listFilesAndFilesSubDirectories(String directoryName){
 
        File directory = new File(directoryName);
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                System.out.println(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
    }
    
    /**
     * List all files from a directory and its subdirectories
     * @param directoryName to be listed
     * 
     * TODO: Currently this returns an array but the recursive funtion does the same,
     * this means that only the parent dir values are returned and the child calles are lost.
     * Please fix.. Java 7 provides something calles the Files.walkFileTree.. try that.
     * SimpleFilevisitor visitFile
     */
    public static ArrayList<String> getFilesAndFilesSubDirectories(String directoryName){
 
        File directory = new File(directoryName);
        ArrayList<String> results = new ArrayList<String>();
 
        //get all the files from a directory
        File[] fList = directory.listFiles();
 
        for (File file : fList){
            if (file.isFile()){
                results.add(file.getAbsolutePath());
            } else if (file.isDirectory()){
                listFilesAndFilesSubDirectories(file.getAbsolutePath());
            }
        }
        
        return results;
    }

}
