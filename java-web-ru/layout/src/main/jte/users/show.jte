@import exercise.dto.users.UserPage
@param UserPage page


@template.layout.page(
content = @`
    <table class="table table-hover">
        <tbody>
        <tr>
            <td>First Name</td>
            <td>${page.getUser().getFirstName()}</td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td>${page.getUser().getLastName()}</td>
        </tr>
        <tr>
            <td>Email</td>
            <td>${page.getUser().getEmail()}</td>
        </tr>
        </tbody>
    </table>
`
)