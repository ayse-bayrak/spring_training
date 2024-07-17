package com.cydeo.service.impl;

import com.cydeo.dto.TaskDTO;
import com.cydeo.entity.Task;
import com.cydeo.mapper.TaskMapper;
import com.cydeo.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.BDDMockito.*;

@ExtendWith(MockitoExtension.class)
class TaskServiceImplTest {
// we want to test findById() method
    /* public TaskDTO findById(Long id) {
        Optional<Task> task = taskRepository.findById(id);
        if(task.isPresent()){
            return taskMapper.convertToDto(task.get());
        }
        return null;
    } */
    @Mock
    TaskRepository taskRepository;

    @Mock
    TaskMapper taskMapper;

    @InjectMocks
    TaskServiceImpl taskServiceImpl;

    @ParameterizedTest
    @ValueSource(longs = {1L, 2L, 3L})
    void findById_Test(long id) {

        // we need to define behaviour-->stab
        // Given (Preparation)
        Task task = new Task();

        when(taskRepository.findById(id)).thenReturn(Optional.of(task));   //Optional.of method--> Optional<Task> since findById is coming from crud repository and work with Optional
        when(taskMapper.convertToDto(task)).thenReturn(new TaskDTO());

        // When (Action is happening)
        taskServiceImpl.findById(id);// We are not defining this will be the method I want to test.

        // Then (Assertion and verification checks)
        verify(taskRepository).findById(id);
        verify(taskMapper).convertToDto(task);

    }

    @Test
    void findById_BDD_Test() {   // This is not something used a lot.

        // Given
        Task task = new Task();
        given(taskRepository.findById(anyLong())).willReturn(Optional.of(task)); // given() is coming from BDD Mockito import static org.mockito.BDDMockito.*;
        given(taskMapper.convertToDto(task)).willReturn(new TaskDTO());

        // When
        taskServiceImpl.findById(anyLong());

        // Then
        then(taskRepository).should().findById(anyLong());
        then(taskMapper).should(atLeastOnce()).convertToDto(task);

    }

}