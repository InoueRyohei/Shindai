<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.jsp" %>
<%@include file="../navigation.jsp" %>

<h2>ログイン</h2>

<div class="main">

<%-- エラーメッセージがあれば表示 --%>
<% String errorMessage = (String)request.getAttribute("errorMessage"); %>
<% if(errorMessage != null && !errorMessage.isEmpty()) { %>
    <p><%= errorMessage %></p>
<% } %>

<%
    // ログインに失敗した場合に入力されたIDを取得
    String inputId = request.getParameter("id");
    if(inputId == null) {
        inputId = "";
    }
    
    // ログインに失敗した場合に入力されたPWを取得
    String inputPassword = request.getParameter("password");
    if(inputPassword == null) {
        inputPassword = "";
    }
%>

<form action="Login.action" method="post">
<p>ID　　　　<input type="text" name="id" value="<%= inputId %>">
<%-- IDが未入力の場合にメッセージを表示 --%>
    <% if(inputId.isEmpty() && errorMessage == "IDまたはパスワードを入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
</p>
<p>パスワード<input type="password" name="password" value="<%= inputPassword %>">
<%-- パスワードが未入力の場合にメッセージを表示 --%>
    <% if(inputPassword.isEmpty()  && errorMessage == "IDまたはパスワードを入力してください") { %>
        <span style="color: red;">このフィールドを入力してください</span>
    <% } %>
</p>
<p><input type="submit" value="ログイン"></p>
</form>

</div>

<%@include file="../footer.jsp" %>
