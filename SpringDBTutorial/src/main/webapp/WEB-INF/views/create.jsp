<!DOCTYPE html>
<html>
<head>
<title>This is document title</title>
<%@ page language="java" contentType="text/html" %>
<%@ page contentType="text/html" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="http://netdna.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<script src="http://code.jquery.com/jquery-1.12.1.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.11.2/moment.min.js"></script>
<script src="combodate.js"></script>

</head>
<body>
<h1>This is a heading</h1>
<p>Document content goes here.....</p>

	<form:form action="/intervest-crm/user/create" commandName="user" method="POST" >
	<label for="name">Username:</label>
 	<form:input path="userName"  cssClass="form-control input-sm" maxlength="30"/>
 	<input type="text" id="date" data-format="DD-MM-YYYY" data-template="D MMM YYYY" name="date" value="28-02-2016" class="form-control">
 	   <input type="submit" name="createCommand" value="Create User" class="loadAnchor"/>
 	</form:form>
	<script>
		$(function() {
			$('#date').combodate({
				customClass : 'form-control'
			});

		});
	</script>
</body>
</html>