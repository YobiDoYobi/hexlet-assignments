@import exercise.dto.users.UsersPage
@param UsersPage page


@template.layout.page(
content = @`
<%--<a href="/users/build">New User</a>--%>
    @if(page.getUsers().isEmpty())
        <p>Пока не добавлено ни одного пользователя</p>
    @else
        <table class="table table-hover">
            <thead>
            <tr>
                <th scope="col">Id</th>
                <th scope="col">Имя</th>
            </tr>
            </thead>
            <tbody>
            @for(var user : page.getUsers())
                <tr>
                    <th scope="row"><a href="/users/${user.getId()}">${user.getId()}</a></th>
                    <td>${user.getLastName()} ${user.getFirstName()}</td>
                </tr>
            @endfor
            </tbody>
        </table>
    @endif
`
)