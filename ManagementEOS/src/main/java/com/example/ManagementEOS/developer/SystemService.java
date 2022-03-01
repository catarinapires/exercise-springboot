package com.example.ManagementEOS.developer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class SystemService {

    private final SystemRepository systemRepository;

    @Autowired
    public SystemService(SystemRepository systemRepository) {
        this.systemRepository = systemRepository;
    }

    public List<Developer> getDevelopers(){
        return systemRepository.findAll();
    }

    public void addNewDeveloper(Developer dev) {
        systemRepository.save(dev);
    }

    public void deleteDeveloper(Integer developerId) {
        boolean exists = systemRepository.existsById(developerId);
        if (!exists){
            throw new IllegalStateException(
                    "developer with id " + developerId + " does not exist :(");

        }
        systemRepository.deleteById(developerId);
    }

    @Transactional
    public void updateDeveloper(Integer developerId, String name, String jobDescription, String email) {
        Developer developer = systemRepository.findById(developerId)
                .orElseThrow(() -> new IllegalStateException(
                        "developer with id "+ developerId+ " does not exist :("));

        if (name != null && name.length()>0 &&
                !Objects.equals(developer.getName(), name)){
            developer.setName(name);
        }

        if (email != null && email.length()>0 &&
                !Objects.equals(developer.getEmail(), email)){

            if (email.contains("@")) {
                developer.setEmail(email);
            }
        }


        if (jobDescription != null && developer.typesDeveloper.contains(jobDescription)){
            developer.setJobDescription(jobDescription);
        }

    }
}
