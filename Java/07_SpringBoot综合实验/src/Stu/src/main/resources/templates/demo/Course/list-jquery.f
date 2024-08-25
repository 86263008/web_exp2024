<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>课程表表管理</title>
</head>

<body>
  <h3>课程表信息管理</h3>
  <div id="queryForm">
    <label for="id">id</label>
    <input type="text" id="id" name="id" value="">&nbsp;
    <button id="buttonQuery">查询</button>
    <button id="buttonAdd">添加</button>
  </div>

  <!-- 课程表列表 -->
  <table id="objTable">
    <thead>
      <tr>
        <th style="display:none;">Id</th>
        <th>编号</th>
        <th>课程名</th>
        <th>先修课</th>
        <th>学分</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody>
      <!-- 这里用jQuery动态生成表格行 -->
    </tbody>
  </table>
</body>

<div id="objModel">
  <div id="objModelContent">
    <span id="close">&times;</span>
    <h2 id="updateTitle">修改课程表记录</h2>
    <div id="updateForm">
      <input type="hidden" id="update-id" name="id">
      <div class="mb-3">
        <label for="update-no" class="form-label">编号</label>
        <input type="text" id="update-no" name="no" required>
      </div>
      <div class="mb-3">
        <label for="update-name" class="form-label">课程名</label>
        <input type="text" id="update-name" name="name" required>
      </div>
      <div class="mb-3">
        <label for="update-preNo" class="form-label">先修课</label>
        <input type="text" id="update-preNo" name="preNo" required>
      </div>
      <div class="mb-3">
        <label for="update-credit" class="form-label">学分</label>
        <input type="text" id="update-credit" name="credit" required>
      </div>
      <button id="updateSave">保存</button>
    </div>
  </div>
</div>

<!-- 弹出框 -->
<div id="popup">
  <div id="popupHeader">
    <h3 id="popupTitle">消息</h3>
    <button id="popupClose">X</button>
  </div>
  <div id="popupBody">
    <p>消息内容</p>
  </div>
</div>

<script src="/jquery/jquery-3.6.1.min.js"></script>
<script>
  const idsUpdate = ["update-id","update-no","update-name","update-preNo","update-credit"];

  $(document).ready(function () {
    getPage();

    //注册查询
    $('#buttonQuery').click(function () {
      getPage()
    });

    $('#buttonAdd').click(function () {
      showModel4Add();
    });

    //注册关闭错误信息
    $('#popupClose').click(function () {
      $('#popup').hide();
    })
    //注册关闭错误信息
    $('#close').click(function () {
      $('#objModel').hide();
    })
  });

  /**
   * 从修改对话框提取课程表信息
   */
  function loadFromUI(ids) {
    var res = {};
    ids.forEach((id) => {
      res[id.match(/-(\w+)/)[1]] = $("#" + id).val();
    });

    return res;
  }

  /**
   * 将课程表信息填充到有val属性的界面
   */
  function fill2Val(ids, obj) {
    ids.forEach((id) => {
      //id约定以成员名结束，如-id
      $("#" + id).val(obj[id.match(/-(\w+)$/)[1]]);
    });
  }
  /**
   * 将课程表信息填充到有text属性的界面
   */
  function fill2Text(ids, obj) {
    ids.forEach((id) => {
      //id约定以成员名结束，如-id
      $("#" + id).text(obj[id.match(/-(\w+)$/)[1]]);
      //console.log(id + ":" + id.match(/-(\w+)$/)[1] + "=" + obj[id.match(/-(\w+)$/)[1]]);
    });
  }

  function buildRowIds(id) {
    return [
        "row-" + id + "-id",
        "row-" + id + "-no",
        "row-" + id + "-name",
        "row-" + id + "-preNo",
        "row-" + id + "-credit"
    ];
  }

  /**
   * 显示修改课程表信息对话框
   */
  function update(id) {
    // 获取课程表信息
    $.ajax({
      url: '/demo/Course/getPage',
      type: 'POST',
      dataType: "json",
      contentType: 'application/json',
      data: JSON.stringify({
        "id": id,
        "pageNum": 1,
        "pageSize": 1
      }),
      success: function (response) {
        if (response.code == 0) {
          $.each(response.data.data, function (index, obj) {
            showModel4Update(obj);
          });
        } else {
          showError(response.message);
        }
      },
      error: function (error) {
        showError(error.responseJSON.message);
      }
    });
  }

  /**
   * 课程表信息对话框用作修改
   */
  function showModel4Update(obj) {
    fill2Val(idsUpdate, obj);
    $('#updateTitle').text("修改课程表信息");
    $('#updateSave').text("修改");
    //注册修改
    $('#updateSave').off();
    $('#updateSave').click(function () {
      var obj = loadFromUI(idsUpdate);
      updateObj(obj)
    });
    $("#objModel").show();
  }

  /**
   * 课程表信息对话框用作增加
   */
  function showModel4Add() {
    fill2Val(idsUpdate, {
      "id": "",
      "no": "",
      "name": "",
      "gender": "",
      "age": "",
      "dept": ""
    });
    $('#updateTitle').text("新建课程表信息");
    $('#updateSave').text("新建");
    //注册增加
    $('#updateSave').off();
    $('#updateSave').click(function () {
      var obj = loadFromUI(idsUpdate);
      addObj(obj)
    });
    $("#objModel").show();
  }

  /**
   * 增加课程表信息
   */
  function addObj(obj) {
    // 获取课程表信息
    $.ajax({
      url: '/demo/Course/add',
      type: 'POST',
      dataType: "json",
      contentType: 'application/json',
      data: JSON.stringify({
        "id" : obj.id,
        "no" : obj.no,
        "name" : obj.name,
        "preNo" : obj.preNo,
        "credit" : obj.credit
      }),
      success: function (response) {
        if (response.code == 0) {
          const obj_new = response.data;
          appendRow(obj_new);
          fill2Text(buildRowIds(obj_new.id), obj_new);
          $("#objModel").hide();
        }
        showError(response.message);
      },
      error: function (error) {
        showError(error.responseJSON.message);
      }
    });
  }

  /**
   * 修改课程表信息
   */
  function updateObj(obj) {
    // 获取课程表信息
    $.ajax({
      url: '/demo/Course/update',
      type: 'POST',
      dataType: "json",
      contentType: 'application/json',
      data: JSON.stringify({
        "id" : obj.id,
        "no" : obj.no,
        "name" : obj.name,
        "preNo" : obj.preNo,
        "credit" : obj.credit
      }),
      success: function (response) {
        if (response.code == 0) {
          fill2Text(buildRowIds(obj.id), obj);
          $("#objModel").hide();
        }
        showError(response.message);
      },
      error: function (error) {
        showError(error.responseJSON.message);
      }
    });
  }

  /**
   * 获取课程表信息
   */
  function getPage() {
    // 获取课程表信息
    $.ajax({
      url: '/demo/Course/getPage',
      type: 'POST',
      dataType: "json",
      contentType: 'application/json',
      data: JSON.stringify({
        "id": $('#id').val(),
        "pageNum": 1,
        "pageSize": 1
      }),
      success: function (response) {
        if (response.code == 0) {
          $('#objTable tbody').empty();
          // 遍历课程表信息，生成表格行
          $.each(response.data.data, function (index, obj) {
            appendRow(obj);
          });
        } else {
          showError(response.message);
        }

      },
      error: function (error) {
        showError(error.responseJSON.message);
      }
    });
  }

  /**
   * 课程表列表中新增一行
   */
  function appendRow(obj) {
    var tr = $('<tr id="row-' + obj.id + '">');
    tr.append('<td style="display:none;" id="row-' + obj.id + '-id">' + obj.id + '</td>');
    tr.append('<td id="row-' + obj.id + '-no">' + obj.no + '</td>');
    tr.append('<td id="row-' + obj.id + '-name">' + obj.name + '</td>');
    tr.append('<td id="row-' + obj.id + '-preNo">' + obj.preNo + '</td>');
    tr.append('<td id="row-' + obj.id + '-credit">' + obj.credit + '</td>');
    tr.append('<td><button onclick="update(\'' + obj.id + '\')">编辑</button><button onclick="del(\'' + obj.id + '\')">删除</button></td>');
    $('#objTable tbody').append(tr);
  }

  /*
   * 删除
   */
  function del(id) {
    $.ajax({
      url: "/demo/Course/delete",
      type: "POST",
      contentType: "application/json",
      data: JSON.stringify([id]),
      success: function (response) {
        showError(response.message);
        $("#row-" + id).remove();
      },
      error: function (xhr, status, error) {
        showError(error.responseJSON.message);
      }
    });

  }

  function showError(message) {
    $('#popupBody').text(message);
    $('#popup').show();
  }
</script>

<!-- 课程表列表 -->
<style>
  #objTable {
    border-collapse: collapse;
    width: 100%;
  }

  #objTable th,
  #objTable td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: center;
  }

  #objTable th {
    background-color: #f2f2f2;
  }
</style>

<!-- 课程表信息框 -->
<style>
  /* 模式对话框样式 */
  #objModel {
    display: none;
    position: fixed;
    top: 50%;
    left: 50%;
    z-index: 666;
    overflow: auto;
    background-color: #fff;
    border: 1px solid #ccc;
    padding: 10px;
  }

  #modalContent {
    background-color: #fff;
    margin: 10% auto;
    padding: 20px;
    border: 1px solid #888;
    width: 50%;
  }

  #close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }

  #close:hover,
  #close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
</style>
<!-- 错误消息框 -->
<style>
  #popup {
    position: fixed;
    top: 50%;
    left: 50%;
    transform: translate(-50%, -50%);
    background-color: #fff;
    border: 1px solid #ccc;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.5);
    z-index: 9999;
    display: none;
  }

  #popupHeader {
    padding: 10px;
    background-color: #f5f5f5;
    border-bottom: 1px solid #ccc;
    position: relative;
  }

  #popupTitle {
    margin: 0;
  }

  #popupClose {
    position: absolute;
    top: 5px;
    right: 5px;
    border: none;
    background-color: transparent;
    font-size: 20px;
    cursor: pointer;
  }

  #popupBody {
    padding: 10px;
  }
</style>

</html>
