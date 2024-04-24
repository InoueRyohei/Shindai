<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>

学生管理一覧

<p>検索キーワードを入力してください。</p>
<form action="" method="post">
<input type="text" name="keyword">
<input type="submit" value="検索">
</form>
<hr>

<table style="border-collapse:separate;border-spacing:10px;">
<c:forEach var="student" items="${list}">
	<tr>
	<td>${student.no}</td>
	<td>${student.name }</td>
	<td>${student.ent_year }</td>
	<td>${student.class_num }</td>
	<td>${student.is_attend }</td>
	<td><a href="">変更</a></td>
	</tr>
</c:forEach>
</table>

<%@include file="../footer.html" %>