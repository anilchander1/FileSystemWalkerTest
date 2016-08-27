/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemwalkertest;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import static java.nio.file.FileVisitResult.CONTINUE;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author anilcha
 */
public class FileSystemVisitor extends SimpleFileVisitor<Path> {

    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attr) {
        JarReader jr = new JarReader();        
        if (file.getFileName().toString().endsWith(".jar")) {
            System.out.println(file.getFileName());
            jr.check(file.toFile().getAbsolutePath(),attr);
            
        }
        return CONTINUE;
    }

    // Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir,
            IOException exc) {
        //System.out.format("Searching Directory: %s%n", dir);
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file,
            IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }

}
