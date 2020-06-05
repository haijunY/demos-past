package com.demos.basic.designpattern.proxy.dynamicproxy.gpproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class GPClassLoader extends ClassLoader{

    private File classPathFile;

    public GPClassLoader(){
        String classPath = GPClassLoader.class.getResource("").getPath();
        classPath = classPath.replaceAll( "%20"," ");

        this.classPathFile = new File(classPath);

    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if(classPathFile != null){
            String fName = name.replaceAll("\\.","/") + ".class";
            File classFile = new File(classPathFile, fName);
            if(classFile.exists()){
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try {
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1){
                        out.write(buff,0,len);
                    }
                    return defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e){
                   e.printStackTrace();
                }
            }
        }
        return null;
    }
}
