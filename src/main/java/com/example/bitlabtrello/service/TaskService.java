package com.example.bitlabtrello.service;

import com.example.bitlabtrello.model.Tasks;
import com.example.bitlabtrello.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;
    //тут вытаскиваем весь список таска
    public List<Tasks> getAllTasks(){
        return taskRepository.findAll();
    }
    // это детальный просмотр таска
    public Tasks getTaskById(Long id){
        return taskRepository.findById(id).orElse(null);
        // в другом случае возвращает null если он не найдет объект по айдишке
    }
    // метод который ничего не возвращает но будет прнимать только объект таска
    public void addTask(Tasks task){
        taskRepository.save(task); // передаём объект, метод save сам схраняет в базы данных
    }
    // Вытаскивает список определенную список по folder
    public List<Tasks> getAllTasksByFolder(Long folderId){
        return taskRepository.findAllByFolderId(folderId);
    }
}
