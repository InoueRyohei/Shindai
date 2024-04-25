<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>

<h2>学生管理</h2>

<label>入学年度</label>
<label>クラス</label>
<br>
<select name=f1>
	<% for(int i=2000; i<=2025; i++) { %>
		<option value="<%= i %>"><%= i %></option>
	<% } %>
</select>
<select name=f2>
	<c:forEach var="student" items="${list }">
		${sudent.class_num }
	</c:forEach>
</select>

<table style="border-collapse:separate;border-spacing:10px;">
	<tr>
	<td>入学年度</td>
	<td>学生番号</td>
	<td>氏名</td>
	<td>クラス</td>
	<td>在学中</td>
	<td></td>
	</tr>


<c:forEach var="student" items="${list}">
	<tr>
	<td>${student.ent_year }</td>
	<td>${student.no }</td>
	<td>${student.name }</td>
	<td>${student.class_num }</td>
	<td>
    <c:if test="${student.is_attend}">
        ○
    </c:if>
    <c:if test="${not student.is_attend}">
        ×
    </c:if>
	</td>
	<td><a href="">変更</a></td>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>