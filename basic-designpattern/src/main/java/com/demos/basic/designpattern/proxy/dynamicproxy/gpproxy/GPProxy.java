package com.demos.basic.designpattern.proxy.dynamicproxy.gpproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class GPProxy {

    private static final String ln = "\r\n";

    public static Object newProxyInstance(GPClassLoader loader,
                                          Class<?>[] interfaces,
                                          GPInvocationHandler h){
        try{
            //1、动态生成源代码
            String src = generateSrc(interfaces);
            System.out.println(src);

            //2、Java文件输出到磁盘
            String filePath = GPProxy.class.getResource("").getPath();
            filePath = filePath.replaceAll( "%20"," ");
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null,null,null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compiler.getTask(null ,manager, null, null, null,iterable);
            task.call();
            manager.close();

            Class proxyClass = loader.findClass("$Proxy0");
            Constructor c = proxyClass.getConstructor(GPInvocationHandler.class);
            return  c.newInstance(h);

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc(Class<?>[] interfaces) {
        //用代码写代码
        StringBuffer sb = new StringBuffer();
        sb.append("package com.demos.basic.designpattern.proxy.dynamicproxy.gpproxy;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);

        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);
        sb.append("GPInvocationHandler h;" + ln);
        sb.append("public $Proxy0(GPInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        for(Method m : interfaces[0].getMethods()){
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
                sb.append("try{" + ln);
                    sb.append("Method m = " + interfaces[0].getName() + ".class.getMethod(\"" + m.getName() +"\", new Class[]{});" + ln);
                    sb.append("this.h.invoke(this, m, null);" + ln);

                sb.append("}catch(Exception e){" + ln);
                    sb.append("e.printStackTrace();" + ln);
                sb.append("}" + ln);
            sb.append("}" + ln);
        }

        sb.append("}" + ln);
        return sb.toString();
    }
}
