@template.layout.page(
content = @`
    <form action="/users" method="post">
        <div class="row mb-3">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Имя</label>
            <div class="col-auto">
                <input type="text" class="form-control" id="firstName" placeholder="Имя" name="firstName">
            </div>
        </div>
        <div class="row mb-3">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Фамилия</label>
            <div class="col-auto">
                <input type="text" class="form-control" id="lastName" placeholder="Фамилия" name="lastName">
            </div>
        </div>
        <div class="row mb-3">
            <label for="colFormLabel" class="col-sm-2 col-form-label">Email</label>
            <div class="col-auto">
                <input type="email" class="form-control" id="email" placeholder="name@example.com" name="email">
            </div>
        </div>
        <div class="row mb-3">
            <label for="password" class="col-sm-2 col-form-label">Пароль</label>
            <div class="col-auto">
                <input type="password" id="password" class="form-control" aria-describedby="passwordHelpInline"
                       name="password">
            </div>
            <div class="col-auto">
    <span id="passwordHelpInline" class="form-text">
      Must be 8-20 characters long.
    </span>
            </div>
        </div>
        <input type="submit" value="Зарегистрировать"/>
    </form>
`
)


