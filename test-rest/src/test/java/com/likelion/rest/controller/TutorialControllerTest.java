package com.likelion.rest.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.likelion.rest.entity.Tutorial;
import com.likelion.rest.service.impl.TutorialServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@AutoConfigureJsonTesters
@WebMvcTest(TutorialController.class)
class TutorialControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TutorialServiceImpl tutorialService;


    @Test
    void getAllTutorials() throws Exception {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "title1", "des1", true));
        tutorials.add(new Tutorial(2l, "title2", "des2", true));
        tutorials.add(new Tutorial(3l, "title3", "des3", false));

        when(tutorialService.findAll()).thenReturn(tutorials);

        // Perform GET request to /api/tutorials endpoint
        mockMvc.perform(get("/api/tutorials"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[0].title").value("title1"))
                .andExpect(jsonPath("$[0].description").value("des1"))
                .andExpect(jsonPath("$[1].title").value("title2"))
                .andExpect(jsonPath("$[1].description").value("des2"))
                .andExpect(jsonPath("$[2].title").value("title3"))
                .andExpect(jsonPath("$[2].description").value("des3"));
    }

    @Test
    void getTutorialById() throws Exception {
        // Tạo đối tượng Tutorial và mock dữ liệu trả về từ service
        long id = 1l;
        Tutorial tutorial = new Tutorial();
        tutorial.setId(1L);
        tutorial.setTitle("title1");
        tutorial.setDescription("des1");
        tutorial.setPublished(true);

        when(tutorialService.findById(1L)).thenReturn(tutorial);

        // Gửi yêu cầu GET /tutorials/1 và kiểm tra phản hồi
        mockMvc.perform(get("/api/tutorials/{id}", id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value("title1"))
                .andExpect(jsonPath("$.description").value("des1"));
    }

    @Test
    void findByPublished() throws Exception {
        // given
        boolean published = true;
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l,"title1","des1", true));
        tutorials.add(new Tutorial(2l,"title2","des2", true));

        // when
        when(tutorialService.findByPublished(published)).thenReturn(tutorials);

        mockMvc.perform(get("/api/tutorials/published")
                        .contentType(MediaType.APPLICATION_JSON)
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("title1"))
                .andExpect(jsonPath("$[0].description").value("des1"))
                .andExpect(jsonPath("$[1].title").value("title2"))
                .andExpect(jsonPath("$[1].description").value("des2"));
    }

    @Test
    void createTutorial() throws Exception {
        // given
        long id = 5l;
        Tutorial tutorial = new Tutorial(id, "title5", "des5", false);

        when(tutorialService.saveTutorial(any(Tutorial.class))).thenReturn(tutorial);

        mockMvc.perform(post("/api/tutorials")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(tutorial))
                )
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(id))
                .andExpect(jsonPath("$.title").value("title5"))
                .andExpect(jsonPath("$.description").value("des5"))
                .andExpect(jsonPath("$.published").value(false));
    }

    @Test
    void updateTutorial() throws Exception {
        // given
        long id = 1l;
        Tutorial oldTutorial = new Tutorial(1L, "tite1", "des1", true);
        Tutorial updateTutorial = new Tutorial(1L, "title1-update", "des1-update", false);
        when(tutorialService.findById(1l)).thenReturn(oldTutorial);
        when(tutorialService.saveTutorial(updateTutorial)).thenReturn(updateTutorial);

        mockMvc.perform(put("/api/tutorials/{id}", id)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(updateTutorial)))
                .andExpect(status().isOk());
    }

    @Test
    void deleteTutorial() throws Exception{
        long id = 1l;
        doNothing().when(tutorialService).deleteById(id);

        mockMvc.perform(delete("/api/tutorials/{id}", id))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteAllTutorials() throws Exception{
        doNothing().when(tutorialService).deleteAll();

        mockMvc.perform(delete("/api/tutorials/"))
                .andExpect(status().isNoContent());
    }


}