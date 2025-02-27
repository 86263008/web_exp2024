<!DOCTYPE html>
<html>

<head>
  <meta charset="utf-8">
  <title>学生信息管理系统</title>
  <!-- 引入Bootstrap 5和相关的JavaScript库 -->
  <link rel="stylesheet" href="/bootstrap-5.2.3-dist/css/bootstrap.min.css">
  <style>
    html,
    body {
      height: 100%;
      /* overflow: hidden; */
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
  <nav class="navbar navbar-expand-lg navbar-light bg-light px-4">
    <a class="navbar-brand" href="#">学生信息管理系统</a>
  </nav>

  <hr class="m-0">

  <div class="container-fluid px-0">
    <div class="row d-flex">
      <nav class="col-md-3 col-lg-2 d-md-block bg-body-tertiary sidebar collapse bg-light">
        <div class="sidebar-sticky">
          <ul class="nav nav-pills flex-column mb-auto">
            <li class="nav-item">
              <a class="nav-link" id="_greeting" href="javascript:void(0);" onclick="go('/greeting')">首页</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="_demo_Student_list-bootstrap" href="javascript:void(0);"
                onclick="go('/demo/Student/list-bootstrap')">学生表管理</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="_demo_Course_list-bootstrap" href="javascript:void(0);"
                onclick="go('/demo/Course/list-bootstrap')">课程表管理</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" id="_demo_StuCourse_list-bootstrap" href="javascript:void(0);"
                onclick="go('/demo/StuCourse/list-bootstrap')">学生选课表管理</a>
            </li>
          </ul>
        </div>
      </nav>
      <main role="main" class="col-md-12 ml-sm-auto col-lg-10 px-0">
        <iframe id="content" src="" frameborder="0" width="100%" height="100%"></iframe>
      </main>
    </div>
  </div>

  <script src="/bootstrap-5.2.3-dist/js/bootstrap.bundle.min.js"></script>
  <script src="/jquery/jquery-3.6.1.min.js"></script>
  <script>
    $(document).ready(function () {

    });

    var last_url = "";
    function go(url) {
      if (last_url != url) {
        if (typeof last_url == "string" && last_url.length > 0) {
          $("#" + last_url.replaceAll("/", "_")).removeClass("active");
        }
        last_url = url;
        $("#" + url.replaceAll("/", "_")).addClass("active");
        $("#content").attr("src", url);
      }
    }
  </script>
</body>

</html>