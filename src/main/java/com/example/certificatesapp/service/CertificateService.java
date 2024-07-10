package com.example.certificatesapp.service;

import com.example.certificatesapp.model.Certificate;
import com.example.certificatesapp.repository.CertificateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CertificateService {

    @Autowired
    private CertificateRepository certificateRepository;

    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Optional<Certificate> getCertificateById(Long id) {
        return certificateRepository.findById(id);
    }

    public Certificate updateCertificate(Long id, Certificate certificateDetails) {
        Optional<Certificate> optionalCertificate = certificateRepository.findById(id);

        if (optionalCertificate.isPresent()) {
            Certificate certificate = optionalCertificate.get();
            certificate.setName(certificateDetails.getName());
            // Aggiorna altri campi necessari
            return certificateRepository.save(certificate);
        } else {
            throw new RuntimeException("Certificate not found");
        }
    }

    public boolean deleteCertificate(Long id) {
        Optional<Certificate> optionalCertificate = certificateRepository.findById(id);
        if (optionalCertificate.isPresent()) {
            certificateRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
