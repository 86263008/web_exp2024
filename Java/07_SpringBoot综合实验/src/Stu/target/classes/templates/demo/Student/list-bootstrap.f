<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>学生表管理</title>
  <!-- 引入Bootstrap 5和相关的JavaScript库 -->
  <link rel="stylesheet" href="/bootstrap-5.2.3-dist/css/bootstrap.min.css">
    <style>
    html,
    body {
      height: 100%;
    }

    .row {
      height: 100%;
    }

    .container-fluid {
      height: 100%;
    }
  </style>
</head>

<body>

  <h3>学生表信息管理</h3>
  <nav class="navbar navbar-expand-sm navbar-light bg-light">

    <div class="row g-3 align-items-center">
      <div class="input-group input-group-sm" style="width: 250px;">
        <span class="input-group-text" id="label-id">id</span>
        <input type="text" class="form-control" id="id" name="id" value="" placeholder="id" aria-label="id"
          aria-describedby="label-id" style="width: 150px;">
        <!--
        <button class="btn btn-outline-secondary" type="button" id="btn-label-no-clear">清除</button>
        -->
      </div>
      <div class="col-auto">
        <button id="buttonQuery" class="btn btn-primary btn-sm">查询</button>
      </div>
      <div class="col-auto">
        <button id="buttonAdd" class="btn btn-success btn-sm">添加</button>
      </div>
    </div>
  </nav>

  <!-- 学生表列表 -->
  <table class="table table-bordered table-striped">
    <thead>
      <tr>
        <th style="display:none;">Id</th>
        <th>学号</th>
        <th>姓名</th>
        <th>性别</th>
        <th>年龄</th>
        <th>所在系</th>
        <th>操作</th>
      </tr>
    </thead>
    <tbody id="objTableBody">
      <!-- 这里用JavaScript动态生成表格行 -->
    </tbody>

  </table>

  <nav class="navbar navbar-expand-sm navbar-light bg-light fixed-bottom bg-body-tertiary">
    <div class="row g-3 align-items-center">
      <div class="input-group input-group-sm" style="width: 150px;">
        <label class="input-group-text" for="pageSize">每页显示：</label>
        <select class="form-control" id="pageSize" name="pageSize" required>
          <option value="10" selected>10</option>
          <option value="30">30</option>
          <option value="100">100</option>
        </select>
      </div>
      <div class="input-group input-group-sm" style="width: 150px;">
        <label class="input-group-text" for="total">总页数：</label>
        <input type="number" min="1" class="form-control" id="total" value="0" disabled>
      </div>
      <div class="input-group input-group-sm" style="width: 150px;">
        <label class="input-group-text" for="pageSize">当前页码：</label>
        <input type="number" min="1" class="form-control" id="pageNum" value="0">
      </div>
      <div class="col-auto">
        <button id="buttonTo" class="btn btn-success btn-sm">跳转</button>
      </div>
    </div>
  </nav>

  <!-- 学生表信息对话框 -->
  <div class="modal fade" data-bs-backdrop="static" data-bs-keyboard="false" id="objModel" tabindex="-1"
    aria-labelledby="objModelTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="objModelTitle">修改学生表记录</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
          <form id="updateForm">
            <input type="hidden" id="update-id" name="id">
            <div class="mb-3">
              <label for="update-no" class="form-label">学号</label>
              <input type="text" class="form-control" id="update-no" name="no" required>
            </div>
            <div class="mb-3">
              <label for="update-name" class="form-label">姓名</label>
              <input type="text" class="form-control" id="update-name" name="name" required>
            </div>
            <div class="mb-3">
              <label for="update-gender" class="form-label">性别</label>
              <input type="text" class="form-control" id="update-gender" name="gender" required>
            </div>
            <div class="mb-3">
              <label for="update-age" class="form-label">年龄</label>
              <input type="text" class="form-control" id="update-age" name="age" required>
            </div>
            <div class="mb-3">
              <label for="update-dept" class="form-label">所在系</label>
              <input type="text" class="form-control" id="update-dept" name="dept" required>
            </div>
          </form>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">取消</button>
          <button type="button" class="btn btn-primary" id="updateSave">保存</button>
        </div>
      </div>
    </div>
  </div>

  <!-- 错误信息弹窗 -->
  <div class="modal fade" id="errorModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
    aria-labelledby="errorModalTitle" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <!--
        <div class="modal-header">
          <h5 class="modal-title" id="errorModalTitle">信息</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        -->
        <div class="modal-body" id="errorModalBody">
          <!-- 这里用JavaScript动态生成错误信息 -->
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">关闭</button>
        </div>
      </div>
    </div>
  </div>
  <script src="/bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
  <script src="/jquery/jquery-3.6.1.min.js"></script>
  <script>
    const idsUpdate = ["update-id","update-no","update-name","update-gender","update-age","update-dept"];

    $(document).ready(function () {
      $('#pageNum').val(1);
      getPage();

      //注册查询
      $('#buttonQuery').click(function () {
        $('#pageNum').val(1);
        getPage()
      });

      $('#buttonAdd').click(function () {
        showModel4Add();
      });

      $('#updateSave').click(function () {
        var obj = loadFromUI(idsUpdate);
        addObj(obj)
      });

      $('#buttonTo').click(function () {
        getPage();
      });

      //注册关闭错误信息
      $('#close').click(function () {
        $('#objModel').modal("hide");
      })
    });

    /**
     * 从修改对话框提取学生表信息
     */
    function loadFromUI(ids) {
      var res = {};
      ids.forEach((id) => {
        res[id.match(/-(\w+)/)[1]] = $("#" + id).val();
      });

      return res;
    }

    /**
     * 将学生表信息填充到有val属性的界面
     */
    function fill2Val(ids, obj) {
      ids.forEach((id) => {
        //id约定以成员名结束，如-id
        $("#" + id).val(obj[id.match(/-(\w+)$/)[1]]);
      });
    }
    /**
     * 将学生表信息填充到有text属性的界面
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
        "row-" + id + "-gender",
        "row-" + id + "-age",
        "row-" + id + "-dept"
      ];
    }
    /**
     * 显示修改学生表信息对话框
     */
    function update(id) {
      // 获取学生表信息
      $.ajax({
        url: '/demo/Student/getPage',
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
     * 学生表信息对话框用作修改
     */
    function showModel4Update(obj) {
      fill2Val(idsUpdate, obj);
      $('#updateTitle').text("修改学生表信息");
      $('#updateSave').text("修改");
      //注册修改
      $('#updateSave').off();
      $('#updateSave').click(function () {
        var obj = loadFromUI(idsUpdate);
        updateObj(obj)
      });
      $("#objModel").modal("show");
    }

    /**
     * 学生表信息对话框用作增加
     */
    function showModel4Add() {
      fill2Val(idsUpdate, {
        "id" : "",
        "no" : "",
        "name" : "",
        "gender" : "",
        "age" : "",
        "dept" : ""
      });
      $('#updateTitle').text("新建学生表信息");
      $('#updateSave').text("新建");
      //注册增加
      $('#updateSave').off();
      $('#updateSave').click(function () {
        var obj = loadFromUI(idsUpdate);
        addObj(obj)
      });
      $("#objModel").modal("show");
    }

    /**
     * 增加学生表信息
     */
    function addObj(obj) {
      // 获取学生表信息
      $.ajax({
        url: '/demo/Student/add',
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify({
          "id" : obj.id,
          "no" : obj.no,
          "name" : obj.name,
          "gender" : obj.gender,
          "age" : obj.age,
          "dept" : obj.dept
        }),
        success: function (response) {
          if (response.code == 0 && response.data != null) {
            const obj_new = response.data;
            appendRow(obj_new);
            fill2Text(buildRowIds(obj_new.id), obj_new);
            $("#objModel").modal("hide");
          }
          showError(response.message);
        },
        error: function (error) {
          showError(error.responseJSON.message);
        }
      });
    }

    /**
     * 修改学生表信息
     */
    function updateObj(obj) {
      // 获取学生表信息
      $.ajax({
        url: '/demo/Student/update',
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify({
          "id" : obj.id,
          "no" : obj.no,
          "name" : obj.name,
          "gender" : obj.gender,
          "age" : obj.age,
          "dept" : obj.dept
        }),
        success: function (response) {
          if (response.code == 0 && response.data > 0) {
            fill2Text(buildRowIds(obj.id), obj);
            $("#objModel").modal("hide");
          }
          showError(response.message);
        },
        error: function (error) {
          showError(error.responseJSON.message);
        }
      });
    }

    /**
     * 获取学生表信息
     */
    function getPage() {
      // 获取学生表信息
      const pageNum = $('#pageNum').val();
      const pageSize = $('#pageSize').val();
      $.ajax({
        url: '/demo/Student/getPage',
        type: 'POST',
        dataType: "json",
        contentType: 'application/json',
        data: JSON.stringify({
          "id": $('#id').val(),
          "pageNum": pageNum,
          "pageSize": pageSize
        }),
        success: function (response) {
          if (response.code == 0) {
            $('#objTableBody').empty();
            // 遍历学生表信息，生成表格
            $.each(response.data.data, function (index, obj) {
              appendRow(obj);
            });

            $('#pagination').empty();
            //更新分页
            var total = Math.ceil(response.data.total / parseInt(pageSize));
            $('#total').val(total);
            for (var i = 1; i <= total; i++) {
              var li = $("<li class='page-item'></li>");
              var a = $("<a class='page-link' href='#'>" + i + "</a>");
              a.click(function () {
                $('#pageNum').val($(this).text());
                getPage();
              });
              li.append(a);
              $("#pagination").append(li);
            }
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
     * 学生表列表中新增一行
     */
    function appendRow(obj) {
      var tr = $('<tr id="row-' + obj.id + '">');
      tr.append('<td style="display:none;" id="row-' + obj.id + '-id">' + obj.id + '</td>');
      tr.append('<td id="row-' + obj.id + '-no">' + obj.no + '</td>');
      tr.append('<td id="row-' + obj.id + '-name">' + obj.name + '</td>');
      tr.append('<td id="row-' + obj.id + '-gender">' + obj.gender + '</td>');
      tr.append('<td id="row-' + obj.id + '-age">' + obj.age + '</td>');
      tr.append('<td id="row-' + obj.id + '-dept">' + obj.dept + '</td>');
      tr.append('<td><button type="button" class="btn btn-outline-primary btn-sm" onclick="update(\'' + obj.id + '\')">编辑</button><button type="button" class="btn btn-outline-danger btn-sm" onclick="del(\'' + obj.id + '\')">删除</button></td>');
      $('#objTableBody').append(tr);
    }

    /*
     * 删除
     */
    function del(id) {
      $.ajax({
        url: "/demo/Student/delete",
        type: "POST",
        contentType: "application/json",
        data: JSON.stringify([id]),
        success: function (response) {
          showError(response.message);
          if (response.code == 0 && response.data > 0) {
            $("#row-" + id).remove();
          }
        },
        error: function (xhr, status, error) {
          showError(error.responseJSON.message);
        }
      });

    }

    function showError(message) {
      $('#errorModalBody').text(message);
      $('#errorModal').modal("show");
    }
  </script>
</body>

</html>
