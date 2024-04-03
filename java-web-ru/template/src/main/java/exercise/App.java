package exercise;

import exercise.dto.users.UsersPage;
import io.javalin.Javalin;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import io.javalin.http.NotFoundResponse;
import exercise.model.User;
import exercise.dto.users.UserPage;
import exercise.dto.users.UsersPage;

import static io.javalin.rendering.template.TemplateUtil.model;

import io.javalin.rendering.template.JavalinJte;

public final class App {

    // Каждый пользователь представлен объектом класса User
    private static final List<User> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.bundledPlugins.enableDevLogging();
            config.fileRenderer(new JavalinJte());
        });

        // BEGIN
        Map<Long, User> userMap = USERS.stream()
                .collect(Collectors.toMap(User::getId, Function.identity()));

        app.get("/users", ctx -> {
            UsersPage page = new UsersPage(USERS, "Список пользователей");
            ctx.render("users/index.jte", model("page", page));
        });

        app.get("users/{id}", ctx -> {
            //String id = ctx.pathParam("id");
            long id = Long.parseLong(ctx.pathParam("id"));
            if (!userMap.containsKey(id)) {
                throw new NotFoundResponse("User not found");
            }
            UserPage user = new UserPage(userMap.get(id));
            ctx.render("users/show.jte", model("user", user));

        });
        // END

        app.get("/", ctx -> {
            ctx.render("index.jte");
        });

        return app;
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
