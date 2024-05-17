<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp"%>
<%@include file="../navigation.jsp" %>

<%-- エラーメッセージがあれば表示 --%>
<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
<% if(errorMessage != null && !errorMessage.isEmpty()) { %>
    <p><%= errorMessage %></p>
<% } %>

<%
    // 失敗した場合に入力されたnameを取得
    String inputSubject_name = request.getParameter("subject_name");
    if(inputSubject_name == null) {
        inputSubject_name = "";
    }
    
    // 失敗した場合に入力されたnoを取得
    String inputSubject_cd = request.getParameter("subject_cd");
    if(inputSubject_cd == null) {
        inputSubject_cd = "";
    }
%>

<h2>科目情報登録</h2>
<form action="SubjectCreateExecute.action" method="post">

	科目コード<br>
	<input type="text" name="subject_cd" vallue="inputSubject_cd">
	<% if(inputSubject_cd.isEmpty() && errorMessage == "科目コードまたは科目名を入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
	<br>

	科目名<br>
	<input type="text" name="subject_name" vallue="inputSubject_name">
	<% if(inputSubject_name.isEmpty() && errorMessage == "科目コードまたは科目名を入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
	<br>

	<input type="submit" value="登録">
</form>

<a href="SubjectList.action">戻る</a>

<%@include file="../footer.jsp" %>