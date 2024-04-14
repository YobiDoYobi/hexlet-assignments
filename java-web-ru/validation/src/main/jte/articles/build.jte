@import exercise.dto.articles.BuildArticlePage
@param BuildArticlePage page

@template.layout.page(
content = @`
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
        <div class="mb-3">
            <label for="title" class="form-label">Название</label>
            <input type="text" class="form-control" id="title" placeholder="Название" value="${page.getTitle()}"
                   name="title">
        </div>
        <div class="mb-3">
            <label for="content" class="form-label">Текст</label>
            <textarea class="form-control" id="content" rows="10" content="${page.getContent()}"
                      name="content">${page.getContent()}</textarea>
        </div>
        <input type="submit" value="Добавить"/>
    </form>
`
)
