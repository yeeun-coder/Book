package dbConnect;


import java.sql.*;
import java.io.*;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author LG
 */
public class DB {


    String strDriver = "com.mysql.cj.jdbc.Driver";
    
    
    //내 서버 접속정보
    String strUser = "java-proj-book";
    String strURL = "jdbc:mysql://lcsvictory.cloud:9666/java_proj_book_db?characterEncoding=UTF-8&serverTimezone=UTC";
    String strPWD = "251125";
  
    
    public Connection dbCon;
    public Statement dbStmt;
    public ResultSet dbRs;
    
    public void dbOpen() throws IOException {
        HG_ErrorMessage();
//        System.out.println(System.getProperty("java.version"));
//        System.out.println("DBOpen 실행중 ...");
        
        try {
            Class.forName(strDriver);
            dbCon = DriverManager.getConnection(strURL, strUser, strPWD);
            dbStmt = dbCon.createStatement();
        } catch (Exception e) {
            System.out.println("SQLException : " + e.getMessage());
            System.out.println("SQLException : " + e.toString());
            e.printStackTrace();
        }
    }
    
    public void dbClose() throws IOException {
        try {
            dbStmt.close();
            dbCon.close();
        } catch (SQLException e) {
            System.out.println("SQLExeception : " + e.getMessage());
        }
    }
    
    public void HG_ErrorMessage() throws UnsupportedEncodingException {
        try {
            System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));
        } catch (java.io.UnsupportedEncodingException ex) {
            ex.printStackTrace();
        }
    }
    
}
