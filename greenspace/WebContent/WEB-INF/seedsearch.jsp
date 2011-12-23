<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"><jsp:param name="title"
		value="Seeds" />
</jsp:include>
<div id="layout" align="center">
	<c:if test="${authenticatedUser !=null}">
		<div id="middle">
			<div class="options">
				<a href="CreateSeedServlet?page=createseed">Create
					New Seed</a>
			</div>
			<div class="search">
				<form action="ListSeedServlet" method="post">
					<table>
						<tr>
							<td style="color: #004216;">Enter Seed Code</td>
							<td><input type="text" name="seedid" id="seedid" />
							</td>
							<td><input type='submit' name="seedsearch"
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
						<td>Seed Quantity</td>
						<td>Seed Date</td>
						<td colspan="2">Operations</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><font color="#004216">${seed.id}.</font></td>
						<td><font color="#004216">${seed.seedQuantity}</font>
						</td>
						<td><font color="#004216">${seed.date}</font>
						</td>
						<td><a
							href="ListSeedServlet?page=deleteseed&&action=delete&&seedId=${seed.id}">Delete</a>
						</td>
						<td><a
							href="ListSeedServlet?page=editseed&&id=${seed.id}">Edit</a>
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