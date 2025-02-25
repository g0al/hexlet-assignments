@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    @for(var user : page.getUsers())
        <p><a href="/users/${user.getId()}">${user.getId()}</a></p>
        <p>${user.getFirstName()}</p>
        <p>${user.getLastName()}</p>
        <p>${user.getEmail()}</p>
        <br>
    @endfor
`
)