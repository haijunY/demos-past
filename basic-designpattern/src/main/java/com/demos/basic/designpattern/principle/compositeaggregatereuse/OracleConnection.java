package com.demos.basic.designpattern.principle.compositeaggregatereuse;

/**
 * @date: 2019/05/06 14:17
 */
public class OracleConnection extends DBConnection {
    @Override
    public String getConnection() {
        return "Oracle 数据库链接";
    }
}
