<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WooGenome</title>
<style type="text/css">
	body{
		font-family: "Comic Sans MS";
	}
</style>
</head>
<body>
<h2>WooGenome</h2>

<div style="text-align: right;">
	<a href="logout">Logout</a>
</div>

API:
<br/>
<a href="api?apiName=/user" target="apiContent">/user</a><br/>
<a href="api?apiName=/names" target="apiContent">/names</a><br/>
...<br/>
<br/>

<iframe name="apiContent" width="100%" >
	<noframes>
		Your browser does not support iframe !
	</noframes>
</iframe>

<div style="padding-top: 50px;text-align: center;">
	Copyright &copy; 2014 nodexy
</div>
</body>
</html>