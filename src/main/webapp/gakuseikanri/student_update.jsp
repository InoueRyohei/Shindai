<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.jsp"%>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>

<h2>学生変更</h2>

<%-- エラーメッセージがあれば表示 --%>
<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
<% if(errorMessage != null && !errorMessage.isEmpty()) { %>
    <p><%= errorMessage %></p>
<% } %>

<%
    // 失敗した場合に入力されたnameを取得
    String inputName = request.getParameter("name");
    if(inputName == null) {
        inputName = "";
    }
    
%>

	<form action="StudentUpdateExecute.action" method="post">
		<input type="hidden" name="update_no" value="${student.no}">
		
        <label for="ent_year">入学年度：</label>
        <select id="ent_year" name="ent_year" onchange="${student.ent_year}">
        	<option selected=>${student.ent_year}</option>
        	<% for(int i=2000; i<=2025; i++) { %>
				<option value="<%= i %>"><%= i %></option>
			<% } %>
        </select>
        <br>
        
        <label for="no">学生番号：</label>
        <input type="text" id="no" name="no" value="${student.no}">
        <br>
        
        <label for="name">氏名　　：</label>
        <input type="text" id="name" name="name" value="${student.name}">
        <% if(inputName.isEmpty() && errorMessage == "氏名を入力してください") { %>
        	<span style="color: red;">このフィールドを入力してください</span>
		<% } %>
        <br>
        
        <label for="class_num">クラス　：</label>
        <select id="class_num" name="class_num" onchange="${student.class_num}">
        	<option selected=>${student.class_num }</option>
        	<c:forEach var="class_num" items="${class_list }">
    			<option value="${class_num.class_num}">${class_num.class_num}</option>
			</c:forEach>
        </select>
        <br>
        
        <label for="is_attend">在学中　：</label>
        <input type="checkbox" id="is_attend" name="is_attend" <c:if test="${student.is_attend}">checked</c:if>>
        <br>
        
        <input type="submit" value="変更">
    </form>
    
    <a href="StudentList.action">戻る</a>

<%@include file="../footer.jsp" %>