package exercise.controller.users;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

import exercise.model.Post;
import exercise.Data;

// BEGIN
@RequestMapping("/api")
@RestController
public class PostsController {

    private List<Post> posts = Data.getPosts();

    @GetMapping("/users/{id}/posts")
    public List<Post> show(@PathVariable int id) {
        return posts.stream()
                .filter(p -> p.getUserId() == id)
                .toList();
    }

    @PostMapping("/users/{id}/posts")
    @ResponseStatus(HttpStatus.CREATED)
    public Post create(@RequestBody Post post,
                           //String slug, String title, String body,
                       @PathVariable int id) {
        var newPost = new Post();
        newPost.setUserId(id);
        newPost.setSlug(post.getSlug());
        newPost.setTitle(post.getTitle());
        newPost.setBody(post.getBody());
        posts.add(newPost);
        return newPost;
    }
}
// END
