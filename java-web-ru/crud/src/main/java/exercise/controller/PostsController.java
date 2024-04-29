package exercise.controller;

import static io.javalin.rendering.template.TemplateUtil.model;

import java.util.List;
import java.util.ArrayList;

import exercise.dto.posts.PostsPage;
import exercise.dto.posts.PostPage;
import exercise.model.Post;
import exercise.repository.PostRepository;

import io.javalin.http.Context;
import io.javalin.http.NotFoundResponse;

public class PostsController {

    // BEGIN
    public static void index(Context ctx) {
        int per = 5;
        var posts = PostRepository.getEntities();
        int pageCount = (int) Math.ceil(posts.size() / 5);
        List<Integer> pageList = new ArrayList<>(posts.size() / 5);
        for (int i = 0; i < pageCount; i++) {
            pageList.add(i);
        }
        PostsPage page;
        String pageNumberStr = ctx.queryParam("page");



        if (pageNumberStr == null) {
            page = new PostsPage(posts.subList(0, 5), 0);
        } else {
            int pageNumber = Integer.parseInt(pageNumberStr);
            page = new PostsPage(posts.subList(per * pageNumber, pageNumber * per + per), pageNumber);
        }
        //var page = new PostsPage(posts);
        ctx.render("posts/index.jte", model("page", page, "nav", pageList));
    }

    public static void show(Context ctx) {
        long id = ctx.pathParamAsClass("id", Long.class).get();
        //long idNumber = Long.parseLong(id);
        var post = PostRepository.find(id)
                .orElseThrow(() -> new NotFoundResponse("Entity with id = " + id + " not found"));
        var page = new PostPage(post);
        ctx.render("posts/show.jte", model("page", page));
    }
    // END
}
