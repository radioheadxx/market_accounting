package com.kata.market_accounting.services;

import com.kata.market_accounting.models.ContractorStatus;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ContractorStatusServiceTests {

    @Mock
    private ContractorStatusRepository statusRepository;

    @InjectMocks
    private ContractorStatusServiceImpl service;

    private ContractorStatus status;

    @BeforeEach
    public void setup() {
        statusRepository = Mockito.mock(ContractorStatusRepository.class);
        service = new ContractorStatusServiceImpl(statusRepository);
        status = new ContractorStatus();
        status.setId(1L);
        status.setDescription("Test status 1");
        status.setDefinition(ContractorStatus.StatusDefinitions.USUAL.getDef());
        status.setColor(ContractorStatus.Colors.RED);
    }

    @DisplayName("JUnit test for add new status method")
    @Test
    public void givenContractorStatusObject_whenSaveContractorStatus_thenReturnContractorStatusObject() {
        given(statusRepository.save(status)).willReturn(status);

        System.out.println(statusRepository);
        System.out.println(service);

        ContractorStatus savedContractorStatus = service.create(status);

        System.out.println(savedContractorStatus);

        assertThat(savedContractorStatus).isNotNull();
    }

    @DisplayName("JUnit test for getAll method")
    @Test
    public void givenContractorStatusList_whenGetAllContractorsStatuses_thenReturnStatusesList() {
        statusRepository = Mockito.mock(ContractorStatusRepository.class);
        service = new ContractorStatusServiceImpl(statusRepository);
        ContractorStatus status2 = new ContractorStatus();
        status2.setId(2L);
        status2.setDescription("Test status 2");
        status2.setDefinition(ContractorStatus.StatusDefinitions.FINAL_POSITIVE.getDef());
        status2.setColor(ContractorStatus.Colors.GREEN);

        given(statusRepository.findAll()).willReturn(List.of(status, status2));

        List<ContractorStatus> currencyList = service.getAll();

        assertThat(currencyList).isNotNull();
        assertThat(currencyList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getOneById method")
    @Test
    public void givenContractorById_whenGetOneById_thenReturnContractorObject() {
        given(statusRepository.findById(1L)).willReturn(Optional.of(status));

        ContractorStatus savedStatus = service.getOneById(status.getId());

        assertThat(savedStatus).isNotNull();
    }

    @DisplayName("JUnit test for update method")
    @Test
    public void givenContractorStatusObject_whenUpdateContractorStatus_thenReturnUpdatedContractorStatus() {
        given(statusRepository.save(status)).willReturn(status);
        status.setDescription("Updated test");

        ContractorStatus updatedStatus = service.update(status);

        assertThat(updatedStatus.getDescription()).isEqualTo("Updated test");
    }

    @DisplayName("JUnit test for delete method")
    @Test
    public void givenContractorStatusId_whenDeleteContractorStatus_ThenNothing() {
        long contractorId = 1L;

        willDoNothing().given(statusRepository).deleteById(contractorId);

        service.delete(contractorId);

        verify(statusRepository, times(1)).deleteById(contractorId);
    }
}
