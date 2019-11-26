package com.plainprog.duotexts.controller;

import com.plainprog.duotexts.Constants;
import com.plainprog.duotexts.model.DuoTextModel;
import com.plainprog.duotexts.service.DuoTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/DuoText")
public class DuoTextsController {
    @Autowired
    DuoTextService service;
    @RequestMapping(value = "/CreateText",method = RequestMethod.POST)
    public ResponseEntity createText(@RequestBody DuoTextModel duoText)  {
        service.createText(duoText);
        return new ResponseEntity<>(Constants.MESSAGE200,HttpStatus.OK);
    }
    @RequestMapping(value = "/CreateShared",method = RequestMethod.POST)
    public ResponseEntity createShared(@RequestBody DuoTextModel duoText)  {
        service.createText(duoText);
        return new ResponseEntity<>(Constants.MESSAGE200,HttpStatus.OK);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/Edit")
    public ResponseEntity edit(@RequestBody DuoTextModel duoText){
        if(service.edit(duoText))
            return new ResponseEntity<>(Constants.MESSAGE200,HttpStatus.OK);
        return new ResponseEntity<>(Constants.MESSAGE304, HttpStatus.NOT_MODIFIED);
    }
    /*@RequestMapping(method = RequestMethod.GET, value = "/GetMenuItem")
    public ResponseEntity getForMenu(@RequestBody DuoTextModel duoText){
        return new ResponseEntity(service.getForMenu(),)
        if(service.edit(duoText))
            return new ResponseEntity<>(Constants.MESSAGE200,HttpStatus.OK);
        return new ResponseEntity<>(Constants.MESSAGE304, HttpStatus.NOT_MODIFIED);
    }*/
}
