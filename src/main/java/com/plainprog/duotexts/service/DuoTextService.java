package com.plainprog.duotexts.service;

import com.plainprog.duotexts.model.DuoTextModel;
import com.plainprog.duotexts.model.MenuItemModel;
import com.plainprog.duotexts.model.SharedDuoTextModel;
import com.plainprog.duotexts.repository.DuoTextRepository;
import com.plainprog.duotexts.repository.SharedTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DuoTextService {
    @Autowired
    DuoTextRepository duoTextRepository;
    @Autowired
    SharedTextRepository sharedTextRepository;

    public DuoTextModel createText(DuoTextModel duoTextModel){
        duoTextModel.setId(null);
        return duoTextRepository.save(duoTextModel);
    }
    public SharedDuoTextModel createSharedText(SharedDuoTextModel sharedDuoTextModel){
        sharedDuoTextModel.setId(null);
        return sharedTextRepository.save(sharedDuoTextModel);
    }
    public boolean edit(DuoTextModel item){
        Optional<DuoTextModel> itemFromDb = duoTextRepository.findById(item.getId());
        if(!itemFromDb.isPresent())
            return false;
        duoTextRepository.save(item);
        return true;
    }
    public ArrayList<MenuItemModel> getForMenu(){
        ArrayList<MenuItemModel> result = new ArrayList<>();
        Iterable<DuoTextModel> texts = duoTextRepository.findAll();
        for(DuoTextModel text : texts){
            result.add(new MenuItemModel(text.getName()));
        }
        return result;
    }
    public DuoTextModel getDuoText(Integer id){
        Optional<DuoTextModel> itemOptional = duoTextRepository.findById(id);
        return itemOptional.orElse(null);
    }
    public boolean deleteText(Integer id){
        Optional<DuoTextModel> text = duoTextRepository.findById(id);
        if(!text.isPresent())
            return false;
        duoTextRepository.delete(text.get());
        return true;
    }
    public boolean deleteSharedText(Integer id){
        Optional<SharedDuoTextModel> text = sharedTextRepository.findById(id);
        if(!text.isPresent())
            return false;
        sharedTextRepository.delete(text.get());
        return true;
    }
    public boolean changePublicity(Integer itemId){
        Optional<DuoTextModel> text = duoTextRepository.findById(itemId);
        if(!text.isPresent())
            return false;
        text.get().setPublic(!text.get().getPublic());
        duoTextRepository.save(text.get());
        return true;
    }



}
