@import exercise.dto.MainPage
@import exercise.util.NamedRoutes
@param MainPage page

@template.layout.page(
content = @`
    <main>
        <h1>Привет, Хекслет!</h1>
        @if(page.getName() != null)
            Добро пожаловать, ${page.getName()}.
            <%--<div class="mx-auto p-4 py-md-5">
                <a class="btn btn-primary" href="${NamedRoutes.logoutPath()}" role="button">Выйти</a>
            </div>--%>
            <form action="${NamedRoutes.logoutPath()}" method="post">
                <button type="submit" class="btn btn-primary">Выйти</button>
            </form>
        @else
            <div class="mx-auto p-4 py-md-5">
                <a class="btn btn-primary" href="${NamedRoutes.buildSessionPath()}" role="button">Войти</a>
            </div>
        @endif
    </main>
`
)