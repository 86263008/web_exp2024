package xust;

public enum ErrEnum {
  SUCCESS(0, "操作成功！"),
  DB_CREATE_FAIL(1001, "创建失败！"),
  DB_DELETE_FAIL(1002, "删除失败！"),
  DB_UPDATE_FAIL(1003, "更新失败！"),
  DB_SIZE_FAIL(1004, "计数失败！"),
  DB_PAGE_FAIL(1005, "分页失败！"),
  DB_GET_FAIL(1006, "获取记录失败！"),
  EXPORT_EXCEL_FAIL(1100, "导出EXCEL失败！"),
  INPUT_FORMAT_ERROR(6000, "无效格式！"),
  INPUT_PARAM_INVALID(6001, "无效参数！"),
  
  PN8000_DISCONECTED(10000, "设备未连接！"),
  ;
  
  
  private Integer code;
  private String message;
  
  private ErrEnum(Integer code, String message) {
    this.code = code;
    this.message = message;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
  
  
}
