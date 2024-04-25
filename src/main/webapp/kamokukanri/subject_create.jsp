<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html"%>

<p>科目情報登録</p>
<from action="insert" method="post">
科目コード<input type="select" name="cd">
科目名<input type="text" name="name">

<input type="button" value="登録">
</from>

<%@include file="../footer.html" %>