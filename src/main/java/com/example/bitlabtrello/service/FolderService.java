package com.example.bitlabtrello.service;

import com.example.bitlabtrello.model.Folders;
import com.example.bitlabtrello.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;
    public void addFolder(Folders folder){
        folderRepository.save(folder);
    }
    public List<Folders> getAllFolders(){
        return folderRepository.findAll();
    }
    public Folders getFolderById(Long id){
        return folderRepository.findById(id).orElse(null);
    }
}
