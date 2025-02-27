@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@if(page.getErrors() != null)
    <ul>
        @for(var validator : page.getErrors().values())
            @for(var error : validator)
                <li>${error.getMessage()}</li>
            @endfor
        @endfor
    </ul>
@endif

<form action="/articles" method="post">
    <div>
        <label>
            Название
            <input type="text" required name="title" value="${page.getTitle()}" />
        </label>
    </div>
    <div>
        <label>
            Содержание
            <input type="textarea" required name="content" value="${page.getContent()}" />
        </label>
    </div>
    <input type="submit" value="Опубликовать" />
</form>