/*
 * Copyright (c) 2020 Self-Order Kiosk
 */
package models;

import java.io.Serializable;

public class Category implements Serializable{

  private int id;
  private String name;

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
