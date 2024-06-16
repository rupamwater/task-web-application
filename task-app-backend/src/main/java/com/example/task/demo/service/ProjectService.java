package com.example.task.demo.service;

import java.util.List;
import com.example.task.demo.dto.ProjectDto;
import com.example.task.demo.repository.ProjectRepository;
import com.example.task.demo.entity.Project;
import com.example.task.demo.mapper.ProjectMapper;

import com.example.task.demo.exception.ResourceNotFoundException;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProjectService implements IProjectService {

    @Autowired
    private ProjectRepository projectRepo;

    @Override
    public ProjectDto createProject(ProjectDto projectDto){
        Project project = ProjectMapper.mapToProject(projectDto);
        Project projectResult = projectRepo.save(project);
        return ProjectMapper.mapToProjectDto(projectResult);
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto){
        Project project = projectRepo.findById(projectDto.getId())
                .orElseThrow(() -> new ResourceNotFoundException(""));

        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        project.setType(projectDto.getType());

        Project projectResult = projectRepo.save(project);
        return ProjectMapper.mapToProjectDto(projectResult);
    }

    @Override
    public ProjectDto getProject(Long projectId){
        Project project = projectRepo.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException(""));


        return ProjectMapper.mapToProjectDto(project);

    }

    @Override
    public List<ProjectDto> getAllProjects(){
        List<Project> projects = projectRepo.findAll();

        return projects.stream().map((p) -> ProjectMapper.mapToProjectDto(p)).toList();

    }



}
