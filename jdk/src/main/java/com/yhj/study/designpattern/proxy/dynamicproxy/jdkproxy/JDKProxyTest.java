package com.yhj.study.designpattern.proxy.dynamicproxy.jdkproxy;

import com.yhj.study.designpattern.proxy.Person;

/**
 * Created by yhj on @date: 2019/05/08
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        try {
            Person obj = (Person) new JDKMeipo().getInstance(new Girl());
//            obj.findLove();
            obj.findHose();

//            byte[] bytes = ProxyGenerator.generateProxyClass("$Proxy0", new Class[]{Person.class});
//            FileOutputStream os = new FileOutputStream("E://$Proxy0.class");
//            os.write(bytes);
//            os.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
