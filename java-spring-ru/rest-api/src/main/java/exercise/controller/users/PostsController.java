package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RestController
@RequestMapping("/api")
public class PostsController {
    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts") // Список страниц
    public List<Post> userPosts(@PathVariable String id) {
        return posts.stream()
                .filter(p -> p.getUserId() == Integer.parseInt(id))
                .toList();
    }

    @PostMapping("users/{id}/posts") // Создание страницы
    public ResponseEntity<Post> create(@RequestBody Post post, @PathVariable String id) {
        post.setUserId(Integer.parseInt(id));
        posts.add(post);
        return ResponseEntity.status(201)
                .body(post);
    }
}
// END
