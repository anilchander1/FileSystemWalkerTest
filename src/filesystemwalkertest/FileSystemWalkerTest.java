/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemwalkertest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author anilcha
 */
public class FileSystemWalkerTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        Path start=Paths.get("D:\\PROJECT\\GIT\\ADF-master");
        Files.walkFileTree(start, new FileSystemVisitor());
        
    }
    
}
