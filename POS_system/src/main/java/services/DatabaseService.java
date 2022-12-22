/*
 * Copyright (c) 2020 Self-Order Kiosk
 */
package services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseService {

  private final String url = "jdbc:mysql://127.0.0.1:3306/POS_system";
  private final String username = "root";
  private final String password = "";
  public Connection conn;

  DatabaseService() {
  }

  public void connect() {
    try {
      conn = DriverManager.getConnection(url, username, password);
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

  public void disconnect() {
    try {
      conn.close();
    } catch (SQLException e) {
      System.out.println(e);
    }
  }

}
