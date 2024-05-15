<%@page contentType="text/html; charset=UTF-8" %> <!-- エンコードをUTF-8に指定 -->
<%-- ログイン中のユーザー名を取得 --%>
<%
String accountName = (String) session.getAttribute("accountName");
if (accountName == null) {
    accountName = "Guest"; /* デフォルトの名前 */
}
%>

<!DOCTYPE html>
<html lang="ja"> <!-- 言語設定 -->
<head>
    <meta charset="UTF-8"> <!-- HTMLエンコード -->
    <title>Servlet/JSP Samples</title> <!-- タイトル -->
    <style>
        .header {
            width: 100%; /* ヘッダーの幅 */
            height: 70px; /* ヘッダーの高さ */
            background-color: #f5f5f5; /* 背景色 */
            padding-left: 15px; /* 左側のパディング */
            padding-right: 15px; /* 右側のパディングを減らす */
            display: flex; /* フレックスボックス */
            justify-content: space-between; /* 左右に要素を配置 */
            align-items: center; /* 垂直中央寄せ */
        }

        .account-info {
            display: flex; /* フレックスボックス */
            align-items: center; /* 垂直中央寄せ */
            justify-content: flex-end; /* 右寄せ */
            margin-right: 10px; /* 右側のマージン */
        }

        .account-info a {
            text-decoration: none; /* アンダーラインを削除 */
            color: #333; /* リンクのテキスト色 */
            margin-left: 5px; /* リンク間のスペースを減らす */
        }
    </style>
</head>
<body>

<div class="header">
    <h1>得点管理システム</h1> <!-- ヘッダータイトル -->

    <!-- 右下にアカウント情報とログアウトリンク -->
    <div class="account-info">
        <span><%= accountName %>様</span> <!-- ログイン中のアカウント名と「様」 -->
        <a href="../loginkanri/logout.jsp">ログアウト</a> <!-- ログアウトリンク -->
    </div>
</div>

</body>
</html>
