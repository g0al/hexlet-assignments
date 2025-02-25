@import gg.jte.Content
@param Content content

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>Header/Footer Javalin Example</title>
</head>
<body>
<div class="header">
    <a href="/">Главная страница</a>
    <a href="/users">Все пользователи</a>
</div>
<div class="main">
    ${content}
</div>
<div class="footer">
    <p>Повторяющийся футер</p>
</div>
</body>
</html>