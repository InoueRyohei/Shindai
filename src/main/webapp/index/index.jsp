<%@page contentType="text/html; charset=UTF-8" %> <!-- エンコードをUTF-8に指定 -->
<%@include file="../header.jsp" %> <!-- ヘッダーをインクルード -->

<!DOCTYPE html>
<html lang="ja"> <!-- 言語設定 -->
<head>
    <meta charset="UTF-8"> <!-- HTMLエンコード -->
    <title>Navigation and Layout Example</title> <!-- タイトル -->
    <style>
        .container {
            display: flex; /* 横方向のレイアウト */
            height: 100vh; /* ビューポート全体の高さ */
        }

        .nav {
            flex: 0 0 20%; /* ナビゲーションの固定幅 */
            background-color: #f0f0f0; /* ナビゲーションの背景色 */
            padding: 10px; /* パディング */
            display: flex; /* フレックスボックス */
            flex-direction: column; /* 縦方向にリンクを配置 */
            align-items: flex-start; /* 左寄せ */
        }

        .nav a {
            text-decoration: none; /* アンダーラインを削除 */
            color: #333; /* リンクのテキスト色 */
            margin-bottom: 10px; /* リンク間のスペース */
            font-size: 16px; /* フォントサイズ */
            transition: color 0.3s; /* ホバー効果 */
        }

        .main {
            flex: 1; /* 残りのスペースをメインコンテンツに */
            padding: 10px; /* パディング */
            display: flex; /* フレックスボックス */
            flex-direction: column; /* 縦方向に配置 */
        }

        .top {
            display: flex; /* 横方向のレイアウト */
            justify-content: space-between; /* 各ボックスを等間隔に配置 */
            align-items: flex-start; /* 上寄せ */
            height: 100px; /* ボックスの高さを揃える */
        }

        .box {
            flex: 1; /* 各ボックスが均等な幅 */
            text-align: center; /* 中央寄せ */
            padding: 10px; /* パディング */
            height: 80px; /* ボックスの高さ */
            border-radius: 8px; /* 角の丸み */
        }

        .box-red {
            background-color: #ffaaaa; /* ライトレッド */
        }

        .box-green {
            background-color: #aaffaa; /* ライトグリーン */
        }

        .box-blue {
            background-color: #aaaaff; /* ライトブルー */
        }

        .box-green .vertical-links {
            display: flex; /* 縦方向に配置 */
            flex-direction: column; /* 縦に並べる */
            align-items: center; /* 中央寄せ */
        }

        .additional-content {
            padding: 20px; /* パディング */
            border-radius: 8px; /* 角の丸み */
            text-align: center; /* テキストを中央寄せ */
        }
    </style>
</head>
<body>

<div class="container">
    <!-- Navigation section on the left -->
    <div class="nav">
        <a href="../loginkanri/login-in.jsp">ログイン</a>
        <a href="../gakuseikanri/studentList.action">学生管理</a>
        <a>成績管理</a>
        <a href="#">　成績登録</a>
        <a href="#">　成績参照</a>
        <a href="#">科目管理</a>
    </div>

    <!-- Main content area -->
    <div class="main">
        <div class="top">
            <div class="box box-red">
                <a href="../gakuseikanri/studentList.action">学生管理</a> <!-- リンクあり -->
            </div>

            <div class="box box-green">
                <div class="vertical-links"> <!-- 縦方向に配置 -->
                	<a>成績管理</a>
                    <a href="#">成績登録</a> <!-- リンクあり -->
                    <a href="#">成績参照</a> <!-- リンクあり -->
                </div>
            </div>

            <div class="box box-blue">
                <a href="#">科目管理</a> <!-- リンクあり -->
            </div>
        </div>

        <!-- Additional content section below the boxes -->
        <div class="additional-content">
            <h1>成績管理システムにようこそ！</h1> <!-- Welcome message -->
        </div>
    </div>
</div>

<%@include file="../footer.jsp" %> <!-- フッターをインクルード -->

</body>
</html>
