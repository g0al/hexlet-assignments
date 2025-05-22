package exercise.controller;

import org.junit.jupiter.api.Test;
import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;
import org.instancio.Instancio;
import org.instancio.Select;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import java.util.HashMap;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.datafaker.Faker;
import exercise.repository.TaskRepository;
import exercise.model.Task;

// BEGIN
@SpringBootTest
@AutoConfigureMockMvc
// END
class TaskControllerTest {

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
    @Test
    public void testGet() throws Exception {
        var task = createTask();
        taskRepository.save(task);

        var sampleTask = taskRepository.findById(1L).get();
        var result = mockMvc.perform(get("/tasks/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        Task retrievedTask = om.readValue(jsonResponse, Task.class);
        assertThat(retrievedTask.getId()).isEqualTo(sampleTask.getId());
        assertThat(retrievedTask.getTitle()).isEqualTo(sampleTask.getTitle());
        assertThat(retrievedTask.getDescription()).isEqualTo(sampleTask.getDescription());
    }

    public Task createTask() {
        return Instancio.of(Task.class)
                .ignore(Select.field(Task::getId))
                .supply(Select.field(Task::getTitle), () -> faker.lorem().word())
                .supply(Select.field(Task::getDescription), () -> faker.lorem().sentence(5))
                .create();
    }

    @Test
    public void testUpdate() throws Exception {
        var task = createTask();
        taskRepository.save(task);

        var data = new HashMap<>();
        data.put("title", "Mike Dirt");

        var request = put("/tasks/" + task.getId())
                .contentType(MediaType.APPLICATION_JSON)
                // ObjectMapper конвертирует Map в JSON
                .content(om.writeValueAsString(data));

        mockMvc.perform(request)
                .andExpect(status().isOk());

        task = taskRepository.findById(task.getId()).get();
        assertThat(task.getTitle()).isEqualTo(("Mike Dirt"));
    }

    @Test
    public void testCreate() throws Exception {
        var data = new HashMap<>();
        data.put("id", 1L);
        data.put("title", "Mike Dirt 2");
        data.put("description", "Mike Dirt 2 gggggggggggg");
        data.put("createdAt", "2025-05-22");
        data.put("updatedAt", "2025-05-22");
        var request = post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(om.writeValueAsString(data));

        var result = mockMvc.perform(request)
                .andExpect(status().isCreated()).andReturn();

        String jsonResponse = result.getResponse().getContentAsString();
        //assertThatJson(jsonResponse).isEqualTo("{\"id\":1,\"title\":\"Mike Dirt 2\",\"description\":\"Mike Dirt 2 gggggggggggg\"}");
        assertThatJson(jsonResponse).and(
                a -> a.node("id").isEqualTo(1),
                a -> a.node("title").isEqualTo("Mike Dirt 2"),
                a -> a.node("description").isEqualTo("Mike Dirt 2 gggggggggggg")
        );
    }

    @Test
    public void testDelete() throws Exception {
        var task = createTask();
        taskRepository.save(task);

        var id = task.getId();

        var request = delete("/tasks/" + task.getId());

        mockMvc.perform(request)
            .andExpect(status().isOk());

        assertThat(taskRepository.findById(id)).isNotPresent();
    }
    // END
}
