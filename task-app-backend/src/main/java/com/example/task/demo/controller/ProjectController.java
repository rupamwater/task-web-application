package com.example.task.demo.controller;

import com.example.task.demo.dto.ProjectDto;
import com.example.task.demo.entity.Project;
import com.example.task.demo.mapper.ProjectMapper;
import com.example.task.demo.service.ProjectService;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.CrossOrigin;


import lombok.AllArgsConstructor;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/project")
@AllArgsConstructor
public class ProjectController {

    private ProjectService projectService;


   @GetMapping("/{id}")
   public ResponseEntity<ProjectDto> getProjectById(@PathVariable("id") Long projectId){
       ProjectDto projectDto = projectService.getProject(projectId);
       return ResponseEntity.ok(projectDto);


   }

    @GetMapping
    public ResponseEntity<List<ProjectDto>> getAllProjects(){
        List<ProjectDto> projectsDto = projectService.getAllProjects();
        return ResponseEntity.ok(projectsDto);


    }

    @PostMapping
    public ResponseEntity<ProjectDto> createProject(@RequestBody ProjectDto projectDto){
          ProjectDto projectDtoRes = projectService.createProject(projectDto);

          return new ResponseEntity<>( projectDtoRes , HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<ProjectDto> updateProject(@RequestBody ProjectDto projectDto){
        ProjectDto projectDtoRes = projectService.updateProject(projectDto);

        return ResponseEntity.ok( projectDtoRes );
    }


}
