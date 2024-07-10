package com.example.certificatesapp.service;

import com.example.certificatesapp.model.Certificate;
import com.example.certificatesapp.repository.CertificateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CertificateServiceTest {

    @Mock
    private CertificateRepository certificateRepository;

    @InjectMocks
    private CertificateService certificateService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateCertificate() {
        Certificate certificate = new Certificate();
        certificate.setName("Test Certificate");

        when(certificateRepository.save(certificate)).thenReturn(certificate);

        Certificate created = certificateService.createCertificate(certificate);

        assertNotNull(created);
        assertEquals("Test Certificate", created.getName());
        verify(certificateRepository, times(1)).save(certificate);
    }

    @Test
    public void testGetCertificateById() {
        Long id = 1L;
        Certificate certificate = new Certificate();
        certificate.setId(id);
        certificate.setName("Test Certificate");

        when(certificateRepository.findById(id)).thenReturn(Optional.of(certificate));

        Optional<Certificate> found = certificateService.getCertificateById(id);

        assertTrue(found.isPresent());
        assertEquals("Test Certificate", found.get().getName());
        verify(certificateRepository, times(1)).findById(id);
    }

    @Test
    public void testUpdateCertificate() {
        Long id = 1L;
        Certificate existingCertificate = new Certificate();
        existingCertificate.setId(id);
        existingCertificate.setName("Old Name");

        Certificate newCertificate = new Certificate();
        newCertificate.setName("New Name");

        when(certificateRepository.findById(id)).thenReturn(Optional.of(existingCertificate));
        when(certificateRepository.save(existingCertificate)).thenReturn(existingCertificate);

        Certificate updatedCertificate = certificateService.updateCertificate(id, newCertificate);

        assertNotNull(updatedCertificate);
        assertEquals("New Name", updatedCertificate.getName());
        verify(certificateRepository, times(1)).findById(id);
        verify(certificateRepository, times(1)).save(existingCertificate);
    }

    @Test
    public void testDeleteCertificate() {
        Long id = 1L;
        Certificate certificate = new Certificate();
        certificate.setId(id);
        certificate.setName("Test Certificate");

        when(certificateRepository.findById(id)).thenReturn(Optional.of(certificate));
        doNothing().when(certificateRepository).deleteById(id);

        boolean isDeleted = certificateService.deleteCertificate(id);

        assertTrue(isDeleted);
        verify(certificateRepository, times(1)).findById(id);
        verify(certificateRepository, times(1)).deleteById(id);
    }
}
