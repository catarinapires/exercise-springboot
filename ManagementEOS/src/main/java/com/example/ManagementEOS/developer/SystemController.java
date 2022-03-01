package com.example.ManagementEOS.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dev/")
public class SystemController {

    private final SystemService systemService;

    @Autowired
    public SystemController(SystemService systemService) {
        this.systemService = systemService;
    }

    @GetMapping // get from server, list<developer>
    public List<Developer> getDevelopers(){
        return systemService.getDevelopers();
    }

    @PostMapping
    public void registerNewDeveloper(@RequestBody Developer dev) {
        systemService.addNewDeveloper(dev);
    }

    @DeleteMapping(path = "{developerId}")
    public void deleteStudent(
            @PathVariable("developerId") Integer developerId){
        systemService.deleteDeveloper(developerId);
    }

    @PutMapping(path = "{developerId}")
    public void updateDeveloper(
            @PathVariable("developerId") Integer developerId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String jobDescription,
            @RequestParam(required = false) String email
            ) {
        systemService.updateDeveloper(developerId,name,jobDescription,email);
    }

}
