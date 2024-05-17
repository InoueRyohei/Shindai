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
        
        .wrapper {
   		display: flex;
    	flex-direction: column;
    	min-height: 100vh;
		}
        
        .sidebar {
            width: 200px;
            background-color: #333;
            color: white;
            padding: 20px;
            box-sizing: border-box;
        }
        
        .main {
            flex-grow: 1;
            padding: 20px;
            background-color: white;
            box-sizing: border-box;
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
        
        .footer {
            width: 100%;
            height: 80px;
            background-color: #eaeaea; /* 背景色 */
            padding: 10px;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: center;
            text-align: center; /* 中央寄せ */
        }
        .footer-row {
            margin: 5px 0; /* 行の間隔 */
        }
         .container {
            display: flex; /* 横方向のレイアウト */
            flex: 1; /* 残りのスペースを占有 */
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

<div class="header">
    <h1>得点管理システム</h1> <!-- ヘッダータイトル -->

    <!-- 右下にアカウント情報とログアウトリンク -->
    <div class="account-info">
        <span>${teacher.name }様</span> <!-- ログイン中のアカウント名と「様」 -->
        <a href="../loginkanri/logout.jsp">ログアウト</a> <!-- ログアウトリンク -->
    </div>
</div>


