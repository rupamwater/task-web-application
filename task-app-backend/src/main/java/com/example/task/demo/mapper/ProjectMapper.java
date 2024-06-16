package com.example.task.demo.mapper;

import com.example.task.demo.dto.ProjectDto;
import com.example.task.demo.entity.Project;


public class ProjectMapper {

    public static ProjectDto mapToProjectDto(Project project){

        System.out.println("MapToProjectDto : id "+ project.getId()+ " , name "+ project.getName() + " , description "+ project.getDescription() + " , type " + project.getType());
        return new ProjectDto(
                project.getId(),
                project.getName(),
                project.getDescription(),
                project.getType()
        );

    }

    public static Project mapToProject(ProjectDto projectDto ){
        System.out.println("MapToProjectDto : id "+ projectDto.getId()+ " , name "+ projectDto.getName() + " , description "+ projectDto.getDescription() + " , type " + projectDto.getType());

        return new Project(
                projectDto.getId(),
                projectDto.getName(),
                projectDto.getDescription(),
                projectDto.getType()

        );

    }

}
