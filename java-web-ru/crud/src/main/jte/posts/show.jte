@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostPage
@param PostPage page

<h1>About course</h1>

<div>
    <h2>${page.getPost().getName()}</h2>
    <p>${page.getPost().getBody()}</p>
    <p><a href="${NamedRoutes.postsPath()}">Назад к списку постов</a></p>
</div>
