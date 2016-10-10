<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>作者查询</title>
<link rel="stylesheet"
	href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://maxcdn.bootstrapcdn.com/bootswatch/3.3.7/readable/bootstrap.min.css" rel="stylesheet" integrity="sha384-Li5uVfY2bSkD3WQyiHX8tJd0aMF91rMrQP5aAewFkHkVSTT2TmD2PehZeMmm7aiL" crossorigin="anonymous">
<script
	src="http://cdn.static.runoob.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script
	src="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-default">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="index.jsp">首页</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav">
        <li class="active"><a href="index.jsp">搜索<span class="sr-only">(current)</span></a></li>
        <li action="add"><a href="InsertBook.jsp">添加</a></li>
      </ul>
    </div>
  </div>
</nav>

<p class="text-center" ><em>图书管理</em></p>
	<div style="padding: 200px 300px 10px;">
		<form action="searchAuthor">
			<div class="input-group">
				<div class="input-group-btn">
					<button type="button"
						class="btn btn-default 
                        dropdown-toggle"
						data-toggle="dropdown">
						搜索作者姓名<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="index.jsp">搜索图书标题</a></li>
						
					</ul>
				</div>
					<input type="text" class="form-control" name="name" placeholder="请输入姓名"> 
					<div class="input-group-btn">
						<button type="submit" class="btn btn-default">搜索</button>
					</div>
			</div>
		</form>
	</div>
</body>
</html>