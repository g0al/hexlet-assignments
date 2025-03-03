@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

<h1>Список Курсов</h1>
@if(page.getPosts().isEmpty())
    <p>Пока не добавлено ни одного курса</p>
@else
    @for(var post : page.getPosts())
        <div>
            <h2><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h2>
            <p>${post.getBody()}</p>
        </div>
    @endfor
    <div>
    @if(page.getPage() != 1)
        <p><a href="${NamedRoutes.postsPath()}?page=${page.getPage() - 1}">Previous page: ${page.getPage() - 1}</a></p>
    @endif
        <p>Current page: ${page.getPage()}</p>
    @if(((page.getPage() * page.getPostsByPage()) / page.getPostsLength()) != 1)
        <p><a href="${NamedRoutes.postsPath()}?page=${page.getPage() + 1}">Next page: ${page.getPage() + 1}</a></p>
    @endif
        </div>
@endif