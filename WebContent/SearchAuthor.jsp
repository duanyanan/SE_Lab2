<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<title>图书查询</title>
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
<div  class="col-md-3 column"></div> 
	<div  class="col-md-6 column">
	<table class="table table-striped table-hover ">
	  <thead>
	    <tr>
	    	<th>作者ID</th>
			<th>姓名</th>
	    </tr>
	  </thead>
	  <tbody>
	    	<s:iterator value="resultAuthor" id='s'> 
		
			<s:if test="#s.AuthorID!=null">
				<tr>
					<td><s:property value="#s.AuthorID"/></td>
					<td><s:property value="#s.Name"/></td>
					
				</tr>
			</s:if>
			</s:iterator>
	
	  </tbody>
	</table> 
</div>
<div  class="col-md-3 column"></div>
</div>

<div class="row">
<div  class="col-md-3 column"></div> 
<div  class="col-md-6 column">
	<table class="table table-striped table-hover ">
	  <thead>
	    <tr>
			<th>ISBN</th>
			<th>标题</th>
	    </tr>
	  </thead>
	  <tbody>
	    	<s:iterator value="resultBook" var='string'> 
			<tr>
				<td><s:property value="#string.ISBN"/></td>
				<td><s:property value="#string.Title"/></td>
				<td>
			<div class="input-group">
			<div class="input-group-btn">
			<a id="modal-533768" href="#modal-container-533768" role="button"  data-toggle="modal">
			<button type="button" class="btn btn-primary">更多</button></a>
			</div>
			</div>
			<div class="modal fade" id="modal-container-533768" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							 <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">
								详细信息
							</h4>
						</div>
						<div class="modal-body">
							<table class="table table-striped table-hover ">
							  <thead>
							    <tr>
									<th>ISBN</th>
									<th>标题</th>
									<th>作者ID</th>
									<th>出版商</th>
									<th>出版日期</th>
									<th>价格</th>
							    </tr>
							  </thead>
							  <tbody>
									<tr>
										<td><s:property value="#string.ISBN"/></td>
										<td><s:property value="#string.Title"/></td>
										<td><s:property value="#string.AuthorID"/></td>
										<td><s:property value="#string.Publisher"/></td>
										<td><s:property value="#string.PublishDate"/></td>
										<td><s:property value="#string.Price"/></td>
									</tr>
							  </tbody>
							  </table>	
							  <table class="table table-striped table-hover ">
							  <thead>
							    <tr>
							    	<th>作者ID</th>
									<th>姓名</th>
									<th>年龄</th>
									<th>国籍</th>
							    </tr>
							  </thead>
							  <tbody>
							    	<s:iterator value="resultAuthor" id='s'> 
								
									<s:if test="#s.AuthorID==#string.AuthorID">
										<tr>
											<td><s:property value="#s.AuthorID"/></td>
											<td><s:property value="#s.Name"/></td>
											<td><s:property value="#s.Age"/></td>
											<td><s:property value="#s.Country"/></td>
										</tr>
									</s:if>
									</s:iterator>
							
							  </tbody>
							</table> 
						</div>
						<div class="modal-footer">
							 <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button> 
						</div>
					</div>
				</div>
			</div>

		</td>

				<td>
				<div class="input-group">
					<div class="input-group-btn">
						<form action="delete">
							<button type="submit" class="btn btn-primary">删除</button>
							<input type="hidden" name="book.ISBN" value=<s:property value="#string.ISBN"/>>
							<input type="hidden" name="name" value=<s:property value="#string.Title"/>>
						</form>
					</div>
				</div>
				</td>
				<td>
				<div class="input-group">
					<div class="input-group-btn">
						<form action="edit">	
							<input type="hidden" name="name" value=<s:property value="#string.ISBN"/>>		
							<input type="hidden" name="ttitle" value=<s:property value="#string.Title"/>>
							<button type="submit" class="btn btn-primary">更新</button>
						</form>
					</div>
				</div>
				</td>
			</tr>
			
		</s:iterator>
	
	  </tbody>
	</table> 
</div>

<div  class="col-md-3 column"></div> 
</div>

</body>
</html>