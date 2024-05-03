package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;
import exercise.dto.MainPage;
import exercise.dto.LoginPage;
import exercise.repository.UsersRepository;
import static exercise.util.Security.encrypt;

import exercise.util.NamedRoutes;
import io.javalin.http.Context;

public class SessionsController {

    // BEGIN
    public static void build(Context ctx) {
        var page = new LoginPage(null, null);
        ctx.render("build.jte", model("page", page));
    }

    public static void create(Context ctx) {
        var nickname = ctx.formParam("name");
        var password = ctx.formParam("password");
        var passwordEncrypt = encrypt(password);
        var user = UsersRepository.findByName(nickname);
        if (user == null) {
            var page = new LoginPage("", "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        } else if (passwordEncrypt.equals(user.getPassword())) {
            ctx.sessionAttribute("currentUser", nickname);
            ctx.redirect(NamedRoutes.rootPath());
        } else {
            var page = new LoginPage(nickname, "Wrong username or password");
            ctx.render("build.jte", model("page", page));
        }
    }

    public static void destroy(Context ctx) {
        ctx.sessionAttribute("currentUser", null);
        ctx.redirect(NamedRoutes.rootPath());
    }

    public static void index(Context ctx) {
        var page = new MainPage(ctx.sessionAttribute("currentUser"));
        ctx.render("index.jte", model("page", page));
    }
    // END
}
