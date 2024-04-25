<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<p>学生情報登録</p>
<from action="StudentCreate.action" method="post">
入学年度<input type="select" name="ent_year">
学生番号<input type="text" name="no">
氏名<input type="text" name="name">
クラス<input type="select" name="class_num">

<input type="button" value="登録して終了">
</from>

<%@include file="../footer.html" %>