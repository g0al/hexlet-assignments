@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
page = page,
content = @`
    <h1></h1><table class="table table-striped">
    @for(var post : page.getPosts())
        <tr>
            <td>
                ${post.getId()}
            </td>
            <td>
                <a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a>
            </td>
            <td>
                ${post.getBody()}
            </td>
        </tr>
    @endfor
</table>
`
)