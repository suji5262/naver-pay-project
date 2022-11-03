package org.toyproject.DB;

import java.sql.*;

public class JDBCPaymentsMgr {
    private JDBCPaymentsMgr() {}
    public static Connection getConnection() {
        Connection conn = null;

        try {
            DriverManager.registerDriver(new org.h2.Driver());
            conn = DriverManager.getConnection("jdbc:h2:tcp://localhost/c:/Users/user/IdeaProjects/naver-pay-project/NaverPayments", "sa", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return conn;
    }

    // PreparedStatement: PreCompiled SQL 저장 객체
    // Connection: DB 커넥션 객체
    public static void close(PreparedStatement stmt, Connection conn) {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ResultSet: SQL 실행결과 저장 객체
    // PreparedStatement: PreCompiled SQL 저장 객체
    // Connection: DB 커넥션 객체
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) {
        try {
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        close(stmt, conn);

    }
}