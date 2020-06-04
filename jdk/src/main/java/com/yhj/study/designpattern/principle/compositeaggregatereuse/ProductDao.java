package com.yhj.study.designpattern.principle.compositeaggregatereuse;

/**
 * @date: 2019/05/06 14:13
 */
public class ProductDao {
    private DBConnection dbConnection;

    public void setDbConnection(DBConnection dbConnection){
        this.dbConnection = dbConnection;
    }

    public void addProduct(){
        String conn = dbConnection.getConnection();
        System.out.println("使用"+conn+"增加产品");
    }

}
