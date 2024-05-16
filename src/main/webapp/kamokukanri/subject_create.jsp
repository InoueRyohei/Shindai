<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp"%>
<%@include file="../navigation.jsp" %>

<h2>科目情報登録</h2>
<form action="SubjectCreateExecute.action" method="post">

	科目コード<br>
	<input type="text" name="subject_cd" vallue="">
	<br>

	科目名<br>
	<input type="text" name="subject_name" vallue="">
	<br>

	<input type="submit" value="登録">
</form>

<a href="SubjectList.action">戻る</a>

<%@include file="../footer.jsp" %>