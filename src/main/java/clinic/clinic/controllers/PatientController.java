package clinic.clinic.controllers;

import clinic.clinic.models.Patient;
import clinic.clinic.services.PatientServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PatientController {

    @Autowired
    private PatientServiceImpl service;

    @PostMapping("/add")
    public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient){
        Patient savedPatient = service.addPatient(patient);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
    }
}
