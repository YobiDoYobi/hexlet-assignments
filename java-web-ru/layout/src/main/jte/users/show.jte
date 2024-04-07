@import exercise.dto.users.UserPage
@param UserPage page


@template.layout.page(
content = @`
<%--<a href="/users/build">New User</a>--%>
    <div>${page.getUser().getFirstName()} ${page.getUser().getLastName()}</div>
    <div>${page.getUser().getEmail()}</div>
`
)