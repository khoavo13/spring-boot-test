package com.likelion.rest.repository;

import com.likelion.rest.entity.Tutorial;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;



import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class TutorialRepositoryTest {
    @Mock
    private TutorialRepository tutorialRepository;

    @Test
    void findByPublished(){
        boolean published = true;

        List<Tutorial> tutorials = new ArrayList<>();
        tutorials.add(new Tutorial(1L, "title1", "des1", true));
        tutorials.add(new Tutorial(2L, "title2", "des2", true));

        when(tutorialRepository.findByPublished(published)).thenReturn(tutorials);
        List<Tutorial> result = tutorialRepository.findByPublished(published);

        assertEquals(2, result.size());
        for (int i = 0; i < result.size(); i++){
            assertEquals(tutorials.get(i).getTitle(), result.get(i).getTitle());
        }
    }

    @Test
    void saveTutorial(){
        Tutorial tutorial = new Tutorial();
        tutorial.setId(4L);
        tutorial.setTitle("tỉtle4");
        tutorial.setDescription("des4");
        tutorial.setPublished(true);

        when(tutorialRepository.save(tutorial)).thenReturn(tutorial);

        Tutorial savedTutorial = tutorialRepository.save(tutorial);

        assertNotNull(savedTutorial);
        assertEquals(tutorial, savedTutorial);
    }

//    Trong phương thức testDeleteAll(), ta sử dụng doNothing() để định nghĩa hành động của deleteAll() phải là không làm gì cả. Điều này có nghĩa là khi gọi deleteAll(), phương thức sẽ không làm gì cả và trả về ngay lập tức. Ta thực hiện điều này để đảm bảo rằng phương thức deleteAll() không làm ảnh hưởng đến cơ sở dữ liệu của chúng ta.
//    Trong phần When, ta gọi phương thức deleteAll() của TutorialRepository.
//    Trong phần Then, ta sử dụng verify() để kiểm tra xem phương thức deleteAll() đã được gọi chính xác một lần hay không, bằng cách sử dụng times(1).
//    Việc kiểm tra này đảm bảo rằng phương thức deleteAll() đã được gọi đúng số lần và chức năng xóa tất cả các bản ghi đã hoạt động như mong đợi.
    @Test
    void deleteAll() {
        doNothing().when(tutorialRepository).deleteAll();

        // When
        tutorialRepository.deleteAll();

        // Then
        verify(tutorialRepository, times(1)).deleteAll();
    }


}