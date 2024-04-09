@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
    <form action="/users" method="get">
        <input type="search" required name="term" value="${page.getTerm()}">
        <input type="submit" value="Искать">
    </form>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        <table>
            <tr>
                <td>Id</td>
                <td>Фамилия</td>
                <td>Имя</td>
            </tr>
            @for(var user : page.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                </tr>
            @endfor
        </table>
    @endif
`
)