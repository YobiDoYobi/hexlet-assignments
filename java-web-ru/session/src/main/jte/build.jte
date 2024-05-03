@import exercise.dto.LoginPage
@import exercise.util.NamedRoutes
@param LoginPage page

@template.layout.page(
content = @`
    @if(page.getError() != null)
        <div class="mb-3">
            <ul>
                <li>${page.getError()}</li>
            </ul>
        </div>
    @endif


    <form action="${NamedRoutes.loginPath()}" method="post">
        <div class="row mb-3">
            <label for="inputEmail3" class="col-sm-2 col-form-label">Nickname</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="inputEmail3" placeholder="Nickname" name="name">
            </div>
        </div>
        <div class="row mb-3">
            <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
            <div class="col-sm-10">
                <input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="password">
            </div>
        </div>
        <button type="submit" class="btn btn-primary">Войти</button>
    </form>
`
)
