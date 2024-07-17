package com.cydeo.service.impl;

import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {
// I want to test getByProjectCode(String code) method

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test(){
        // anyString() comes Mockito
        //Given
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); // Stubbing--> I am defining the behaviour and the return
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO()); // Stubbing--> we are creating the behavior

        //Mocks are the objects,
        //Stables are the behaviours of these methods.

        //When
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString()); // real action, I want to test getByProjectCode(String code) method inside the ProjectServiceImpl

        //Then
        InOrder inOrder = inOrder(projectRepository, projectMapper); // I want to check the order of these 2 Mocks
        inOrder.verify(projectRepository).findByProjectCode(anyString()); // we are providing in which order these 2 Mocks
        inOrder.verify(projectMapper).convertToDto(any(Project.class));
        assertNotNull(projectDTO);
    }

    @Test
    void getByProjectCode_ExceptionTest() {

        when(projectRepository.findByProjectCode("")).thenThrow(new NoSuchElementException("Project Not Found"));

        Throwable throwable = assertThrows(NoSuchElementException.class, () -> projectService.getByProjectCode(""));

        verify(projectRepository).findByProjectCode("");

        verify(projectMapper, never()).convertToDto(any(Project.class));

        assertEquals("Project Not Found", throwable.getMessage());

    }



}