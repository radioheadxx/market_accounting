package com.kata.market_accounting.services;

import com.kata.market_accounting.models.Contractor;
import com.kata.market_accounting.models.ContractorStatus;
import com.kata.market_accounting.repositories.ContractorRepository;
import com.kata.market_accounting.repositories.ContractorStatusRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ContractorServiceTests {
    @Mock
    private ContractorRepository contractorRepository;

    @Mock
    private ContractorStatusRepository statusRepository;

    @InjectMocks
    private ContractorServiceImpl service;

    private Contractor contractor;

    @BeforeEach
    public void setup() {
        contractorRepository = Mockito.mock(ContractorRepository.class);
        statusRepository = Mockito.mock(ContractorStatusRepository.class);
        service = new ContractorServiceImpl(contractorRepository, statusRepository);
        contractor = new Contractor();
        ContractorStatus status = new ContractorStatus();
        contractor.setId(1L);
        contractor.setName("Contractor test");
        contractor.setStatus(status);
    }

    @DisplayName("JUnit test for create method")
    @Test
    public void givenContractorObject_whenSaveContractor_thenReturnContractorObject() {
        given(contractorRepository.save(contractor)).willReturn(contractor);
        System.out.println(contractorRepository);
        System.out.println(service);

        Contractor savedContractor = service.create(contractor);

        System.out.println(savedContractor);

        assertThat(savedContractor).isNotNull();
    }

    @DisplayName("JUnit test for getAll method")
    @Test
    public void givenContractorList_whenGetAllContractors_thenReturnContractorsList() {
        contractorRepository = Mockito.mock(ContractorRepository.class);
        statusRepository = Mockito.mock(ContractorStatusRepository.class);
        service = new ContractorServiceImpl(contractorRepository, statusRepository);
        Contractor contractor2 = new Contractor();
        ContractorStatus status2 = new ContractorStatus();
        contractor2.setId(2L);
        contractor2.setName("Contractor test 2");
        contractor2.setStatus(status2);

        given(contractorRepository.findAll()).willReturn(List.of(contractor, contractor2));

        List<Contractor> contractorList = service.getAll();

        assertThat(contractorList).isNotNull();
        assertThat(contractorList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getOneById method")
    @Test
    public void givenContractorById_whenGetOneById_thenReturnContractorObject() {
        given(contractorRepository.findById(1L)).willReturn(Optional.of(contractor));

        Contractor savedContractor = service.getOneById(contractor.getId());

        assertThat(savedContractor).isNotNull();
    }

    @DisplayName("JUnit test for update method")
    @Test
    public void givenContractorObject_whenUpdateContractor_thenReturnUpdatedContractor() {
        given(contractorRepository.save(contractor)).willReturn(contractor);
        contractor.setName("Updated contractor");
        Contractor updatedContractor = service.update(contractor);
        assertThat(updatedContractor.getName()).isEqualTo("Updated contractor");
    }

    @DisplayName("JUnit test for delete method")
    @Test
    public void givenContractorId_whenDeleteContractor_thenNothing() {
        long contractorId = 1L;

        willDoNothing().given(contractorRepository).deleteById(contractorId);
        when(contractorRepository.findById(contractorId)).thenReturn(Optional.of(contractor));
        service.delete(contractorId);

        verify(contractorRepository, times(1)).deleteById(contractorId);
    }
}