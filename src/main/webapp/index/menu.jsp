<%@page contentType="text/html; charset=UTF-8" %> <!-- エンコードをUTF-8に設定 -->

<!DOCTYPE html>
<html lang="ja"> <!-- 言語設定 -->
<head>
    <title>Navigation Example</title>
    <style>
        .container {
            display: flex; /* 横方向に配置 */
            height: 100vh; /* ビューポート全体の高さ */
        }

        .nav {
            flex: 0 0 20%; /* ナビゲーションの固定幅 */
            background-color: #f0f0f0; /* ナビゲーションの背景色 */
            padding: 10px; /* パディング */
            display: flex;
            flex-direction: column; /* 縦方向にリンクを配置 */
            align-items: flex-start; /* 左寄せ */
        }

        .nav a {
            text-decoration: none; /* アンダーラインを削除 */
            color: #333; /* リンクのテキスト色 */
            margin-bottom: 10px; /* リンク間のスペース */
            font-size: 16px; /* フォントサイズ */
            transition: color 0.3s; /* ホバー時のカラートランジション */
        }

        .nav a:hover {
            color: #007acc; /* ホバー時のリンク色 */
        }

        .right-space {
            flex: 1; /* 残りのスペースをメインコンテンツに */
            background-color: #ffffff; /* 白い背景 */
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Navigation section on the left -->
    <div class="nav">
        <a href="../loginkanri/login-in.jsp">ログイン</a>
        <a href="../gakuseikanri/studentList.action">学生管理</a>
        <span>成績管理</span> <!-- リンクなしのテキスト -->
        <a href="#">成績参照</a>
        <a href="#">成績検索</a>
        <a href="#">科目管理</a>
    </div>

    <!-- Empty space on the right -->
    <div class="right-space"></div>
</div>

</body>
</html>
