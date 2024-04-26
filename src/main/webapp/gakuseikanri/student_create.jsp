<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html"%>
<!-- menu.jspを読み込む -->
<%@include file="../index/menu.jsp" %>


<form action="StudentCreateExecute.action" method="post">
	入学年度<select name="ent_year">
        <% for(int i=2000; i<=2025; i++) { %>
			<option value="<%= i %>"><%= i %></option>
		<% } %>
    </select><br>
    学生番号<input type="text" name="no"><br>
    氏名　　<input type="text" name="name"><br>
    クラス　<select name="class_num">
		<c:forEach var="class_num" items="${class_list }">
    		<option value="${class_num.class_num}">${class_num.class_num}</option>
		</c:forEach>

    </select><br>
    <input type="submit" value="登録して終了">
</form>

<%@include file="../footer.html" %>