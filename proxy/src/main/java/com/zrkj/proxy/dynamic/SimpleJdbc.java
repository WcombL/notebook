package com.zrkj.proxy.dynamic;

public class SimpleJdbc implements JdbcInterface {
    @Override
    public void getName() {
        System.out.println("Simple JDBC");
    }
}
