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