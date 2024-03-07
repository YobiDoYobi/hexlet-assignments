package exercise;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class App {

    private static final List<Map<String, String>> USERS = Data.getUsers();

    public static Javalin getApp() {

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });

        // BEGIN
        app.get("/users", ctx -> {
            String page = ctx.queryParam("page");
            String per = ctx.queryParam("per");
            if (page == null) {
                ctx.json(USERS.subList(0, 5));
            } else {
                int pageInt = Integer.parseInt(page) - 1;
                if (per == null) {
                    int perInt = 5;
                    ctx.json(USERS.subList(perInt * pageInt, pageInt * perInt + perInt));
                } else {
                    int perInt = Integer.parseInt(per);
                    ctx.json(USERS.subList(perInt * pageInt, pageInt * perInt + perInt));
                }
            }
        });
        // END

        return app;

    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
