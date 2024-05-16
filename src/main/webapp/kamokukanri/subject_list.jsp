<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp" %>
<%@include file="../navigation.jsp" %>


<h2>科目管理一覧</h2>

<a href="">新規登録</a>

<table style="border-collapse:separate;border-spacing:10px;">
	<tr>
	<td>科目コード</td>
	<td>科目名</td>
	<td></td>
	<td></td>
	</tr>
	
	<c:forEach var="subject" items="${list2 }">
		<tr>
		<td>${subject.subject_cd }</td>
		<td>${subject.subject_name }</td>
		<td><a href="">変更</a></td>
		<td><a href="">削除</a></td>
		</tr>
	</c:forEach>
</table>

<%@include file="../footer.jsp" %>