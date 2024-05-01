package exercise.dto.posts;

import java.util.List;
import java.util.Map;

import exercise.model.Post;
import io.javalin.validation.ValidationError;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

// BEGIN
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
@Getter
public class EditPostPage {
    private long id;
    private String name;
    private String body;
    /*@NonNull
    private Post post;*/
    private Map<String, List<ValidationError<Object>>> errors;
}
// END
