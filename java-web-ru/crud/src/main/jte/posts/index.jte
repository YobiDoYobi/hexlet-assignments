@import exercise.util.NamedRoutes
@import exercise.dto.posts.PostsPage
@param PostsPage page

@template.layout.page(
content = @`
    <div class="mx-auto p-4 py-md-5">
        <main>
            <h1>Все курсы</h1>
            @if(page.getPosts().isEmpty())
                <p>Пока не добавлено ни одного поста</p>
            @else
                @for(var post : page.getPosts())
                    <div>
                        <h4><a href="${NamedRoutes.postPath(post.getId())}">${post.getName()}</a></h4>
                    </div>
                @endfor
            @endif
        </main>

        <nav aria-label="...">
            <ul class="pagination">
                @if(page.getCurrPage() <= page.getListPage().get(0))
                    <li class="page-item disabled">
                        <a class="page-link">Previous</a>
                    </li>
                @else
                    <li class="page-item">
                        <a class="page-link"
                           href="${NamedRoutes.postsPath()}?page=${page.getCurrPage() - 1}">Previous</a>
                    </li>
                @endif
                @for(var navPageNum : page.getListPage())
                    <div>
                        @if(page.getCurrPage() == navPageNum)
                            <li class="page-item active"><a class="page-link"
                                                            href="${NamedRoutes.postsPath()}?page=${navPageNum}">${navPageNum}</a>
                            </li>
                        @else
                            <li class="page-item"><a class="page-link"
                                                     href="${NamedRoutes.postsPath()}?page=${navPageNum}">${navPageNum}</a>
                            </li>
                        @endif
                    </div>
                @endfor
                @if(page.getCurrPage() >= page.getListPage().get(page.getListPage().size()-1))
                    <li class="page-item disabled">
                        <a class="page-link">Next</a>
                    </li>
                @else
                    <li class="page-item">
                        <a class="page-link"
                           href="${NamedRoutes.postsPath()}?page=${page.getCurrPage() + 1}">Next</a>
                    </li>
                @endif
            </ul>
        </nav>
    </div>
`
)
