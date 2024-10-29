package com.tecsup.petclinic.services;

import static org.junit.jupiter.api.Assertions.*;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.tecsup.petclinic.entities.Vet;

@SpringBootTest
@Slf4j
@Transactional
public class VetServiceTest {

    @Autowired
    private VetService vetService;

    @Test
    public void testCreateVet() {
        Vet vet = new Vet();
        vet.setNombre("Carlos");
        vet.setApellido("Gonzalez");
        vet.setNumeroLicencia("LIC12345");
        vet.setEspecialidad("Cirugía");

        Vet savedVet = vetService.save(vet);

        assertNotNull(savedVet.getId());
        assertEquals("Carlos", savedVet.getNombre());
        assertEquals("Gonzalez", savedVet.getApellido());
        assertEquals("LIC12345", savedVet.getNumeroLicencia());
        assertEquals("Cirugía", savedVet.getEspecialidad());

        log.info("Test de creación de veterinario pasado correctamente.");
    }
}
