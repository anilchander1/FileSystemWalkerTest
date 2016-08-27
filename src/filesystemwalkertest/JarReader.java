/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filesystemwalkertest;

import java.io.File;
import java.lang.reflect.Method;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author anilcha
 */
public class JarReader {

    public void check(String jarLocation,BasicFileAttributes bfa) {
        File file = new File(jarLocation);
        JarFile jarFile = null;
        JarClassLoader jcl = null;
        Method[] methods = null;
        CheckCreatedLastModifiedTime tc=new CheckCreatedLastModifiedTime();
        try {
            tc.check(bfa);
            jcl = new JarClassLoader(file.toURI().toURL());
            System.out.println(jcl.getMainClassName());
            jarFile = new JarFile(file);
        } catch (Exception e) {
            System.out.println(e.getClass().getSimpleName() + "==>" + e.getMessage());
        }
        Enumeration jarenum = jarFile.entries();

        while (jarenum.hasMoreElements()) {
            String filename = process(jarenum.nextElement());
            if (filename.endsWith(".class")) {
                String classname = filename.replace("/", ".").replace(".class", "");
                System.out.println(classname);
                try {
                    methods = jcl.getMethods(classname);
                    System.out.println("Number of methods = " + methods.length);
                } catch (Throwable e1) {
                    System.err.println(e1.getClass().getName() + "==>" + e1.getMessage());
                    continue;
                }

                if (methods == null) {
                    System.out.println("null");
                } else {
                    System.out.println(methods.length);
                }

            } else {
                continue;
            }
        }
    }

    private String process(Object obj) {
        JarEntry entry = (JarEntry) obj;
        String name = entry.getName();//.replace("/", ".");
        return name;
    }

}
