<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:include page="header.jsp"><jsp:param name="title"
		value="Create TreePlanted" />
</jsp:include>
<div id="layout" align="center">
	<div id="middle">
		<c:if test="${authenticatedUser !=null}">
			<b>Create Tree Planted</b>
			<form action="ListTreePlantedServlet?page=treeplantededitconfirm"
				method="post">
				<table>
					<tr>
						<td align="right"><b>Id</b>
						</td>
						<td align="left"><input type="text" size="10" maxlength="50"
							name="id" id="id" value="${curTreePlanted.id}" readonly="readonly" />
						</td>
					</tr>
					<tr>
						<td align="right"><b>Date</b>
						</td>
							<td align="left"><input type="text" name="date"
							onClick="ds_sh(this);" readonly="readonly" style="cursor: text"
							size="20" onFocus="this.select();" value="${curTreePlanted.date}" />
						</td>
					</tr>
					<tr>
						<td align="right"><b>Tree Planted Quantity</b>
						</td>
						<td align="left"><input type="text" size="10" maxlength="50"
							name="treeplantedquantity" id="treeplantedquantity" value="${curTreePlanted.treeQuantity}"/></td>
					</tr>
					<tr>
						<td align="right">&nbsp;</td>
						<td align="left"><input type="submit"
							name="saveTreePlantedChanges" value="Save Changes" />
						</td>
					</tr>
				</table>
			</form>
		</c:if>
		<c:if test="${authenticatedUser ==null}">
			<div id="middle">
				<fieldset>
					<legend>USER AUTHENTICATION FORM</legend>
					<form action="LoginServlet" method="post">
						<table>
							<tr bgcolor="gray">
								<td align="right"><b>Username</b></td>
								<td align="left"><input type="text" size="10"
									maxlength="50" name="username" id="username" /></td>
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
</div>
<%@ include file="footer.jsp"%>