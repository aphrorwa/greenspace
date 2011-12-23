<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp">
	<jsp:param value="Login" name="title" />
</jsp:include>
	<div id="layout" align="center">
	<div id="middle">
	<fieldset><legend>USER AUTHENTICATION FORM</legend>
		<form action="LoginServlet" method="post">
			<table>
				<tr bgcolor="gray">
					<td align="right"><b>Username</b>
					</td>
					<td align="left"><input type="text" size="10" maxlength="50"
						name="username" id="username" />
					</td>
				</tr>
				<tr bgcolor="gray">
					<td align="right"><b>Password</b>
					</td>
					<td align="left"><input type="password" size="10"
						maxlength="50" name="password" id="password" />
					</td>
				</tr>
				<tr bgcolor="gray">
					<td align="right">&nbsp;</td>
					<td align="left"><input type="submit" value="  Login  " />
					</td>
				</tr>
			</table>
		</form>
		</fieldset>
		</div>
	</div>
<%@ include file="footer.jsp"%>