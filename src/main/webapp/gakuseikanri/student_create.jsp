<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html"%>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>

<%-- エラーメッセージがあれば表示 --%>
<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
<% if(errorMessage != null && !errorMessage.isEmpty()) { %>
    <p><%= errorMessage %></p>
<% } %>

<%
    // ログインに失敗した場合に入力されたnameを取得
    String inputName = request.getParameter("name");
    if(inputName == null) {
        inputName = "";
    }
    
    // ログインに失敗した場合に入力されたnoを取得
    String inputNo = request.getParameter("no");
    if(inputNo == null) {
        inputNo = "";
    }
%>


<form action="StudentCreateExcecute.action" method="post">
	<p>入学年度<select name="ent_year">
		<option value="0">選択してください</option>
        <% for(int i=2000; i<=2025; i++) { %>
			<option value="<%= i %>"><%= i %></option>
		<% } %>
    </select>
    <% if(errorMessage == "入学年度を選択してください") { %>
        <span style="color: red;">このフィールドを選択してください</span>
    <% } %>
    </p>
    <br>
	<p> 学生番号<input type="text" name="no" value="<%= inputNo %>">
	<% if(inputNo.isEmpty() && errorMessage == "学生番号または氏名を入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
 	</p>
 	<br>
 	<p> 氏名　　<input type="text" name="name" value="<%= inputName %>">
 	<% if(inputName.isEmpty() && errorMessage == "学生番号または氏名を入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
 	</p>
 	<br>
 	<p>クラス　<select name="class_num">
		<c:forEach var="class_num" items="${class_list }">
    		<option value="${class_num.class_num}">${class_num.class_num}</option>
		</c:forEach></select>
 	</p>
	<br>
    <input type="submit" value="登録して終了">
</form>

<%@include file="../footer.html" %>