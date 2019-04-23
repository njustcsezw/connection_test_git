package com.njustz.utils;


import javax.sql.DataSource;
import java.sql.Connection;

/**
 * 连接的工具类
 * 用于从数据源中获取一个连接，并且实现和线程的绑定
 */

public class ConnectionUntils {

    private  ThreadLocal<Connection> tl = new ThreadLocal<Connection>();

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    //获取当前线程的连接
    public Connection getThreadConnection(){
        //先从ThreadLocal上获取
        Connection conn = tl.get();
            try {
                if(conn == null) {
                    //判断当前线程上是否有连接
                    //从数据源中获取一个连接，并存入ThreadLocal
                    conn = dataSource.getConnection();
                    tl.set(conn);
                }
                return conn;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

}
