@import exercise.util.NamedRoutes

@import exercise.dto.LoginPage
@import java.util.Objects
@param LoginPage page

@if(!Objects.isNull(page.getError()))
    <p>${page.getError()}</p>
@endif

<form action="${NamedRoutes.loginPath()}" method="post">
    <input type="text" placeholder="Name" name="name"/>
    <input type="password" placeholder="Password" name="password"/>
    <input type="submit"/>
</form>