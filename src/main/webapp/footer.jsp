<%@page contentType="text/html; charset=UTF-8" %> <!-- JSP ページのエンコードを設定 -->

<!DOCTYPE html>
<html lang="jp"> <!-- 言語設定 -->
<head>
    <meta charset="UTF-8"> <!-- HTML エンコード -->
    <title>Vertical Footer Example</title>
    <style>
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
    </style>
</head>
<body>

<div class="footer">
    <div class="footer-row">© 2023 TIC</div>
    <div class="footer-row">大原学園</div>
</div>

</body>
</html>
