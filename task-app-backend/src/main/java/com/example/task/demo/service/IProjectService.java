package com.example.task.demo.service;


import com.example.task.demo.dto.ProjectDto;
import java.util.List;

public interface IProjectService  {

    public ProjectDto createProject(ProjectDto projectDto);

    public ProjectDto updateProject(ProjectDto projectDto);

    public ProjectDto getProject(Long projectId);

    public List<ProjectDto> getAllProjects();






}
