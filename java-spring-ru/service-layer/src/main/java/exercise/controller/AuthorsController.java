package exercise.controller;

import exercise.dto.AuthorDTO;
import exercise.dto.AuthorCreateDTO;
import exercise.dto.AuthorUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.AuthorMapper;
import exercise.repository.AuthorRepository;
import exercise.service.AuthorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @Autowired
    private AuthorService authorService;

    // BEGIN
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuthorDTO> getAuthors() {
        return authorService.getAllAuthors();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AuthorDTO createAuthor(@Valid @RequestBody AuthorCreateDTO authorCreateDTO) {
        return authorService.createAuthor(authorCreateDTO);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AuthorDTO updateAuthor(@PathVariable Long id, @RequestBody AuthorUpdateDTO authorUpdateDTO) {
        return authorService.updateAuthor(id, authorUpdateDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthor(@PathVariable Long id) {
        authorService.deleteAuthor(id);
    }
    // END
}
