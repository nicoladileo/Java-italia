<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="./bootstrap-italia/css/bootstrap-italia.min.css"/>    
    <link rel="stylesheet" href="./bootstrap-italia/css/style.css"/>       
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-6">
				<h1>Todo list</h1>
			</div>
		</div>
		<div class="row">
			
				<div class="col-lg-4">
					<div class="form-group">
	    				<input form="formtodo"  type="text" class="form-control" id="authorText" name="author">
	    				<label for="exampleInputText">Author</label>
	  				</div>
	  			</div>
	  			<div class="col-lg-4">
					<div class="form-group">
	    				<input form="formtodo" type="text" class="form-control" id="taskText" name="task">
	    				<label for="exampleInputText">Task</label>
	  				</div>
	  			</div>
	  			<div class="col-lg-4">
	  				<form id="formtodo" action="/javaitalia/todoservlet" method="post">
	  					<button type="submit" class="btn btn-primary">Save</button>
	  				</form>
	  			</div>
  			
		</div>
		<div class="row">
			<div class="col-lg-12">
				<table class="table table-striped">
			    	<thead>
			        	<tr>
			            	<td>#</td>
			            	<td>Author</td>
			            	<td>Task</td>
			            	<td>Status</td>
			        	</tr>
			    	</thead>
					<c:forEach var="todo" items="${todos}">
			        	<tr>
			            	<td>${todo.id}</td>
			               	<td>${todo.author}</td>
			                <td>${todo.name}</td>   
			                <td>
			               		<div>
									<div class="form-check">
									    <input id="${todo.id}" type="checkbox">
									    <label for="${todo.id}">Done</label>
								  	</div>
								</div>
			                </td>              
			            </tr>
					</c:forEach>               
				</table>  
			</div>
		</div>
	</div>	
	
	<script src="./bootstrap-italia/js/bootstrap-italia.bundle.min.js"></script>
</body>
</html>