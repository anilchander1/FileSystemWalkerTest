/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemwalkertest;

import java.nio.file.attribute.BasicFileAttributes;

/**
 *
 * @author anilcha
 */
public class CheckCreatedLastModifiedTime {
    
    public void check(BasicFileAttributes bfa){
        System.out.println("***************************************************************************************************************************");
        System.out.println("created time = "+bfa.creationTime()+" ; modified time = "+bfa.lastModifiedTime()+" ; Last accessed time = "+bfa.lastAccessTime());        
    }
    
}
