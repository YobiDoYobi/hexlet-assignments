@import exercise.dto.posts.PostPage
@param PostPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <h1>${page.getPost().getName()}</h1>
        <p>${page.getPost().getBody()}</p>
    </div>
`
)