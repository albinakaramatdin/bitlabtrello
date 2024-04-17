package com.example.bitlabtrello.controller;

import com.example.bitlabtrello.model.Folders;
import com.example.bitlabtrello.model.TaskCategories;
import com.example.bitlabtrello.model.Tasks;
import com.example.bitlabtrello.service.FolderService;
import com.example.bitlabtrello.service.TaskCategoriesService;
import com.example.bitlabtrello.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
public class HomeController {
    //Аннотация @Autowired используется для внедрения зависимостей.
    // Зависимости FolderService, TaskService и TaskCategoriesService
    // внедряются в этот контроллер.
    @Autowired
    private FolderService folderService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskCategoriesService taskCategoriesService;

    @GetMapping(value = "/folders")
    public String foldersPage(Model model){
        model.addAttribute("allfolders", folderService.getAllFolders());
        return "index";
    }

    @PostMapping(value = "/addFolder")
    public String addFolder(@RequestParam(value = "folderName") String folderName){
        Folders folder = new Folders();
        folder.setName(folderName);
        folderService.addFolder(folder);
        return "redirect:/";
    }

    @GetMapping(value = "/folders/details/{id}")
    public String detailsFolder(@PathVariable(value = "id") Long id,
                                Model model){
        Folders folder = folderService.getFolderById(id);
        model.addAttribute("detailsFolder", folder);
        // Я тут не вытаскиваю весь список таска, я вытаскиваю только определенного таска по folder у
        List<Tasks> tasksByFolder = taskService.getAllTasksByFolder(id);
        model.addAttribute("allTaskByFolder", tasksByFolder);

        List<TaskCategories> taskCategories = taskCategoriesService.getAllTaskCategories();
        model.addAttribute("allTaskCat", taskCategories);
        return "detailsFolder";
    }
    @PostMapping(value = "/addTask/{folderId}")
    public String addTask(@RequestParam(value = "taskName") String taskName,
                          @RequestParam(value = "taskDesc") String taskDesc,
                          @PathVariable(value = "folderId") Long folderId){
        Folders folder = folderService.getFolderById(folderId);
        Tasks task = new Tasks();
        task.setTitle(taskName);
        task.setDescription(taskDesc);
        task.setFolder(folder);
        task.setStatus(0);
        taskService.addTask(task);
        return "redirect:/folders/details/"+folderId; // Указываем обратный корректный путь
    }
    @GetMapping(value = "/folders/detailsFolder/detailsTask/{taskId}")
    public String detailsTask(@PathVariable(value = "taskId") Long taskId,
                              Model model){
        Tasks task = taskService.getTaskById(taskId); //Детальный просмотр таска
        model.addAttribute("taskByFolder",task);
        return "detailsTask";
    }
}
