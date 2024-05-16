<%@page contentType="text/html; charset=UTF-8" %> <!-- エンコードをUTF-8に指定 -->
<%@include file="../header.jsp" %> <!-- ヘッダーをインクルード -->
<%@include file="../navigation.jsp" %>


        <div class="top">
            <div class="box box-red">
                <a href="../gakuseikanri/StudentList.action">学生管理</a> <!-- リンクあり -->
            </div>

            <div class="box box-green">
                <div class="vertical-links"> <!-- 縦方向に配置 -->
                	<a>成績管理</a>
                    <a href="#">成績登録</a> <!-- リンクあり -->
                    <a href="#">成績参照</a> <!-- リンクあり -->
                </div>
            </div>

            <div class="box box-blue">
                <a href="../kamokukanri/SubjectList.action">科目管理</a> <!-- リンクあり -->
            </div>
        </div>

        <!-- Additional content section below the boxes -->
        <div class="additional-content">
            <h1>成績管理システムにようこそ！</h1> <!-- Welcome message -->
        </div>

<%@include file="../footer.jsp" %> <!-- フッターをインクルード -->
