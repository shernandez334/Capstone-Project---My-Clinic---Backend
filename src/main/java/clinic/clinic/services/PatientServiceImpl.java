package clinic.clinic.services;

import clinic.clinic.models.Patient;
import clinic.clinic.repositories.PatientRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Patient addPatient(Patient patient) {
        String encryptedPassword = passwordEncoder.encode(patient.getPassword());
        patient.setPassword(encryptedPassword);
        return patientRepo.save(patient);
    }
}
