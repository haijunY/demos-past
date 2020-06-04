package com.yhj.study.concurrency.rpc.provider;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @date: 2019/06/06 11:19
 */
public class RpcRequest implements Serializable {

    private String className;

    private String methodName;

    private Object[] parameters;

    private String version;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameters=" + Arrays.toString(parameters) +
                ", version='" + version + '\'' +
                '}';
    }
}
