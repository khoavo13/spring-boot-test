package com.likelion.rest.service.impl;

import com.likelion.rest.entity.Tutorial;
import com.likelion.rest.repository.TutorialRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TutorialServiceImplTest {
    @Mock
    private TutorialRepository tutorialRepository;
    @InjectMocks
    private TutorialServiceImpl tutorialService;

    @Test
    void findAll() {
        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1l, "Title1", "Desc1", true));
        tutorials.add(new Tutorial(2l, "Title2", "Desc2", false));
        tutorials.add(new Tutorial(3l, "Title3", "Desc3", true));
        tutorials.add(new Tutorial(4l, "Title3-b", "Desc3-b", true));

        // Thiết lập hành vi cho mock repository
        when(tutorialRepository.findAll()).thenReturn(tutorials);

        // Gọi hàm findAll() của service và lưu kết quả vào một danh sách khác
        List<Tutorial> actualTutorials = tutorialService.findAll();

        // So sánh danh sách kết quả trả về từ service với danh sách mong đợi
        assertEquals(tutorials, actualTutorials);
    }

    @Test
    void deleteAll() {
        tutorialService.deleteAll();
        verify(tutorialRepository, times(1)).deleteAll();
    }

    @Test
    void saveTutorial() {
        // Tạo đối tượng Tutorial mới
        Tutorial tutorial = new Tutorial(5l, "title5", "des5", false);

        // Khi gọi hàm save trên repository, trả về đối tượng Tutorial đã tạo
        when(tutorialRepository.save(tutorial)).thenReturn(tutorial);

        // Gọi hàm saveTutorial của service
        Tutorial savedTutorial = tutorialService.saveTutorial(tutorial);

        // Kiểm tra kết quả
        assertEquals(tutorial, savedTutorial);
    }
}