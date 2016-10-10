<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>图书编辑</title>
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
	        <li  class="active"><a href="index.jsp">搜索<span class="sr-only">(current)</span></a></li>
	        <li><a href="InsertBook.jsp">添加</a></li>
	      </ul>
	    </div>
	  </div>
	</nav>

<div class="row">
	<div class="col-md-4 column"></div>
	<div class="col-md-4 column">
	<form action="editBook">
		<div class="form-group">
		  <label class="control-label" for="author.Name">作者姓名</label>
		  <input type="text" class="form-control" id="author.Name" type="text"  placeholder="请输入作者姓名" name="author.Name">
		</div>
		
		<div class="form-group">
		  <label class="control-label" for="book.Publisher">出版商</label>
		  <input type="text" class="form-control" id="book.Publisher" type="text" placeholder="请输入出版商" name="book.Publisher">
		</div>
		
		<div class="form-group">
		  <label class="control-label" for="book.PublishDate">出版日期</label>
		  <input type="text" class="form-control" id="book.PublishDate" type="text" placeholder="请输入出版日期（如:xxxx-xx-xx)" name="book.PublishDate">
		</div>
		
		<div class="form-group">
		  <label class="control-label" for="book.Price">价格</label>
		  <input type="text" class="form-control" id="book.Price" type="text" placeholder="请输入价格" name="book.Price">
		</div>
		<input type="hidden" name="book.ISBN" value="${name}" >
		<input type="hidden" name="name" value="${ttitle}">
		<button type="submit" class="btn btn-primary">提交</button>
	</form>
	</div>
</div>

</body>
</html>