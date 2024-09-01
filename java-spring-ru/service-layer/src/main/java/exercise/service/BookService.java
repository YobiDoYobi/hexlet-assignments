package exercise.service;

import exercise.dto.BookCreateDTO;
import exercise.dto.BookDTO;
import exercise.dto.BookUpdateDTO;
import exercise.exception.ResourceNotFoundException;
import exercise.mapper.BookMapper;
import exercise.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    // BEGIN
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookMapper bookMapper;

    public List<BookDTO> findAll() {
        var authors = bookRepository.findAll();
        return authors.stream()
                .map(bookMapper::map)
                .toList();
    }

    public BookDTO findById(Long id) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Author: " + id));
        return bookMapper.map(book);
    }

    public BookDTO create(BookCreateDTO dto) {
        var book = bookMapper.map(dto);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public BookDTO update(Long id, BookUpdateDTO dto) {
        var book = bookRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Not Found Author: " + id));
        bookMapper.update(dto, book);
        bookRepository.save(book);
        return bookMapper.map(book);
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }
    // END
}
