package xust;

public class Result4GetPage<T> {
  private Integer total = 0;
  private T data;
  
  public Integer getTotal() {
    return total;
  }
  public void setTotal(Integer total) {
    this.total = total;
  }
  public T getData() {
    return data;
  }
  public void setData(T data) {
    this.data = data;
  }  
}
