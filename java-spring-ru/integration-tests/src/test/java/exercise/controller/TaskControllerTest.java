package exercise.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class ApplicationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Faker faker;

    @Autowired
    private ObjectMapper om;

    @Autowired
    private TaskRepository taskRepository;


    @Test
    public void testWelcomePage() throws Exception {
        var result = mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Welcome to Spring!");
    }

    @Test
    public void testIndex() throws Exception {
        var result = mockMvc.perform(get("/tasks"))
                .andExpect(status().isOk())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThatJson(body).isArray();
    }


    // BEGIN
    private Task testTask;

    @BeforeEach
    public void setUp() {
        testTask = new Task();
        testTask.setDescription(faker.lorem().paragraph());
        testTask.setTitle(faker.lorem().word());
        taskRepository.save(testTask);
    }

    @Test
    public void testShow() throws Exception {
        mockMvc.perform(get("/tasks/{id}", testTask.getId()))
                .andExpect(status().isOk())
                .andExpect(content().json(om.writeValueAsString(testTask)));
    }

    @Test
    public void testShowNegative() throws Exception {
        var result = mockMvc.perform(get("/tasks/{id}", 100))
                .andExpect(status().isNotFound())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Task with id 100 not found");
    }

    @Test
    public void testCreate() throws Exception {
        Task testTaskCreate1 = new Task();
        testTaskCreate1.setDescription(faker.lorem().paragraph());
        testTaskCreate1.setTitle(faker.lorem().word());

        var request1 = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(testTaskCreate1));

        mockMvc.perform(request1)
                .andExpect(status().isCreated());

        var testTaskCreate2 = new Task();
        testTaskCreate2.setDescription(faker.lorem().paragraph());
        testTaskCreate2.setTitle(faker.lorem().word());

        var request2 = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(testTaskCreate2));

        mockMvc.perform(request2)
                .andExpect(status().isCreated());
        var result1 = taskRepository.findByTitle(testTaskCreate1.getTitle()).get();
        assertThat(result1.getDescription()).isEqualTo(testTaskCreate1.getDescription());
    }

    @Test
    public void testUpdate() throws Exception {
        var testTaskUpdate = new Task();
        testTaskUpdate.setTitle(faker.lorem().word());
        testTaskUpdate.setDescription(faker.lorem().paragraph());

        var request = put("/tasks/{id}", testTask.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(testTaskUpdate));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        var actualTask = taskRepository.findById(testTask.getId()).get();

        assertThat(actualTask.getTitle()).isEqualTo(testTaskUpdate.getTitle());
        assertThat(actualTask.getDescription()).isEqualTo(testTaskUpdate.getDescription());
    }

    @Test
    public void testUpdateNegative() throws Exception {
        var testTaskUpdate = new Task();
        testTaskUpdate.setTitle(faker.lorem().word());
        testTaskUpdate.setDescription(faker.lorem().paragraph());

        var request = put("/tasks/{id}", 100)
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(testTaskUpdate));

        var result = mockMvc.perform(request)
                .andExpect(status().isNotFound())
                .andReturn();

        var body = result.getResponse().getContentAsString();
        assertThat(body).contains("Task with id 100 not found");
    }

    @Test
    public void testDelete() throws Exception {
        var id = testTask.getId();

        mockMvc.perform(delete("/tasks/{id}", testTask.getId()))
                .andExpect(status().isOk());

        assertThat(taskRepository.findById(id)).isEmpty();
    }
    // END
}
