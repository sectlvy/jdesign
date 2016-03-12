package com.dahuang.swing; 

/** 
 * <p>Title: </p> 
 * 
 * <p>Description: </p> 
 * 
 * <p>Copyright: Copyright (c) 2007</p> 
 * 
 * <p>Company: </p> 
 * 
 * @author not attributable 
 * @version 1.0 
 */ 
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.ResultSetMetaData; 
import java.util.Vector; 

import javax.swing.JFrame; 
import javax.swing.JScrollPane; 
import javax.swing.JTable; 
import javax.swing.table.DefaultTableModel; 

public class jTable extends JFrame { 
    JTable table = new JTable(); 
    Connection con = null; 
    PreparedStatement pstmt = null; 
    ResultSet rs = null; 

    public jTable() { 
        try { 
            Class.forName("oracle.jdbc.driver.OracleDriver"); //驱动申明 
            con = DriverManager.getConnection( 
                    "jdbc:oracle:thin:@cdfn01:1521:cdfn01", "erpcn", "erpcn"); //建立链接 
            String sql = "select * from emp"; //查询语句 
            pstmt = con.prepareStatement(sql); 
            rs = pstmt.executeQuery(); 
        } catch (Exception e) { 
            System.out.println(e.toString()); 
        } 
        ((DefaultTableModel) table.getModel()).setDataVector(getdata(), 
                gettitle()); 
        JScrollPane jsp = new JScrollPane(table); 
        getContentPane().add(jsp); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        pack(); 
        setVisible(true); 
    } 

    private Vector gettitle() { 
        try { 
            ResultSetMetaData rsm = rs.getMetaData(); 
            Vector title = new Vector(); 
            for (int i = 1; i <= rsm.getColumnCount(); i++) { 
                title.add(rsm.getColumnName(i)); 
            } 
            return title; 
        } catch (Exception e) { 
            System.out.println(e.toString()); 
        } 
        return new Vector(); 
    } 

    private Vector getdata() { 
        try { 
            ResultSetMetaData rsm = rs.getMetaData(); 
            Vector data = new Vector(); 
            while (rs.next()) { 
                Vector row = new Vector(); 
                for (int i = 1; i <= rsm.getColumnCount(); i++) { 
                    row.add(rs.getObject(i)); 
                } 
                data.add(row); 
            } 
            return data; 
        } catch (Exception e) { 
            System.out.println(e.toString()); 
        } 
        return new Vector(); 
    } 

    public static void main(String args[]) { 
        new jTable(); 
    } 
} 

