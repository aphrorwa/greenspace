<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"><jsp:param name="title"
		value="Locations" />
</jsp:include>
<div id="layout" align="center">
	<c:if test="${authenticatedUser !=null}">
		<div id="middle">
			<div class="options">
				<a href="CreateLocationServlet?page=createlocation">Create
					New Location</a>
			</div>
			<div class="search">
				<form action="ListLocationServlet" method="post">
					<table>
						<tr>
							<td style="color: #004216;">Enter Location Code</td>
							<td><input type="text" name="locationcode" id="locationcode" />
							</td>
							<td><input type='submit' name="locationsearch"
								value='search' />
							</td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<hr />
		<div id="middle">
			<table>
				<thead>
					<tr>
						<td>ID</td>
						<td>Location Code</td>
						<td>Location Name</td>
						<td>Location Description</td>
						<td colspan="2">Operations</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><font color="#004216">${location.id}.</font></td>
						<td><font color="#004216">${location.locationCode}</font>
						</td>
						<td><font color="#004216">${location.locationName}</font>
						</td>
						<td><font color="#004216">${location.locationDescription}</font>
						</td>
						<td><a
							href="ListLocationServlet?page=deletelocation&&action=delete&&locationId=${location.id}">Delete</a>
						</td>
						<td><a
							href="ListLocationServlet?page=editlocation&&id=${location.id}">Edit</a>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</c:if>
	<c:if test="${authenticatedUser ==null}">
		<div id="middle">
			<fieldset>
				<legend>USER AUTHENTICATION FORM</legend>
				<form action="LoginServlet" method="post">
					<table>
						<tr bgcolor="gray">
							<td align="right"><b>Username</b></td>
							<td align="left"><input type="text" size="10" maxlength="50"
								name="username" id="username" /></td>
						</tr>
						<tr bgcolor="gray">
							<td align="right"><b>Password</b></td>
							<td align="left"><input type="password" size="10"
								maxlength="50" name="password" id="password" /></td>
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
	</c:if>
</div>
<%@ include file="footer.jsp"%>