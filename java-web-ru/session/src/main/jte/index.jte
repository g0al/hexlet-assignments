@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@if(page.getName() != null)
    <p>${page.getName().toString()}</p>
    <form action="${NamedRoutes.logoutPath()}" method="post">
        Выйти
        <input type="submit"/>
    </form>
@else
    <a href="${NamedRoutes.buildSessionPath()}"><p>Войти</p></a>
@endif