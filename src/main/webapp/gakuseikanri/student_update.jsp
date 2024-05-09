<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html"%>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>

<h2>学生変更</h2>

	<form action="StudentUpdateExecute.action" method="post">
        <input type="hidden" name="no" value="${student.no}">
        <label for="name">氏名　　：</label>
        <input type="text" id="name" name="name" value="${student.name}">
        <br>
        <label for="ent_year">入学年度：</label>
        <input type="text" id="ent_year" name="ent_year" value="${student.ent_year}">
        <br>
        <label for="class_num">クラス　：</label>
        <input type="text" id="class_num" name="class_num" value="${student.class_num}">
        <br>
        <label for="is_attend">在学中　：</label>
        <input type="checkbox" id="is_attend" name="is_attend" <c:if test="${student.is_attend}">checked</c:if>>
        <br>
        <input type="submit" value="変更">
    </form>

<%@include file="../footer.html" %>