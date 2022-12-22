package models;

import java.io.Serializable;

/**
 *
 * @author USER
 */
public class ServerObject implements Serializable {

  private Integer oper;
  private Boolean returnValue;
  private Object object;

  public Integer getOper() {
    return oper;
  }

  public void setOper(Integer oper) {
    this.oper = oper;
  }

  public Boolean getReturnValue() {
    return returnValue;
  }

  public void setReturnValue(Boolean returnValue) {
    this.returnValue = returnValue;
  }

  public Object getObject() {
    return object;
  }

  public void setObject(Object object) {
    this.object = object;
  }

}
