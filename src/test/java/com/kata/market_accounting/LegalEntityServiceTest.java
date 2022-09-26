package com.kata.market_accounting;

import com.kata.market_accounting.exception.LegalEntityException;
import com.kata.market_accounting.mappers.LegalEntityMapper;
import com.kata.market_accounting.models.LegalEntity;
import com.kata.market_accounting.models.dto.LegalEntityDTO;
import com.kata.market_accounting.repositories.LegalEntityRepository;
import com.kata.market_accounting.services.LegalEntityServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class LegalEntityServiceTest {

    @Mock
    private LegalEntityRepository legalEntityRepository;
    @Mock
    private LegalEntityMapper legalEntityMapper;
    @InjectMocks
    private LegalEntityServiceImpl legalEntityService;

    private LegalEntity legalEntity;
    private static LegalEntityDTO legalEntityDTO;
    @BeforeEach
    void prepare() {
        this.legalEntityRepository = Mockito.mock(LegalEntityRepository.class);
        this.legalEntityMapper = Mockito.mock(LegalEntityMapper.class);
        this.legalEntityService = new LegalEntityServiceImpl(legalEntityRepository, legalEntityMapper);

        legalEntity = new LegalEntity(1L, "Nick", 101L, "8-999-999-99-99",
                "nickname@gmail.com", null, null, true);
        legalEntityDTO = new LegalEntityDTO(1L, "Nick", 101L, "8-999-999-99-99",
                "nickname@gmail.com", null, null, true);
    }

    @Test
    void shouldGetAllLegalEntities() {
        LegalEntity legalEntity2 = new LegalEntity(2L, "Test", 102L, null,
                "test@gmail.com", "test", null, false);
        LegalEntityDTO legalEntityDTO2 = new LegalEntityDTO(2L, "Test", 102L, null,
                "test@gmail.com", "test", null, false);

        Mockito.when(legalEntityRepository.findAll()).thenReturn(List.of(legalEntity, legalEntity2));
        Mockito.when(legalEntityMapper.domainsToListDTO(any(List.class)))
                .thenReturn(List.of(legalEntityDTO, legalEntityDTO2));

        List<LegalEntityDTO> legalEntityDTO = legalEntityService.getAllLegalEntities();

        assertThat(legalEntityDTO.size()).isEqualTo(2);
    }

    @Test
    void shouldGetLegalEntityById() {
        Mockito.when(legalEntityRepository.findById(1L)).thenReturn(Optional.of(legalEntity));
        Mockito.when(legalEntityMapper.domainToDTO(any(LegalEntity.class))).thenReturn(legalEntityDTO);

        LegalEntityDTO legalEntityDTOFromDB = legalEntityService.getLegalEntityById(legalEntity.getId());

        assertThat(legalEntityDTOFromDB).isEqualTo(legalEntityDTO);
    }

    @Test()
    void shouldThrowAnExceptionIfTheLegalEntityIsNotFoundById() {
        Mockito.when(legalEntityRepository.findById(1L))
                .thenThrow(new LegalEntityException("Not found legal entity with ID: 1"));

        LegalEntityException thrown = Assertions.assertThrows(LegalEntityException.class, () -> {
            legalEntityRepository.findById(1L);
        }, "LegalEntityException was expected");

        assertThat(thrown.getMessage()).isEqualTo("Not found legal entity with ID: 1");
    }

    @Test
    void shouldCreateLegalEntity() {
        Mockito.when(legalEntityRepository.save(legalEntity)).thenReturn(legalEntity);
        Mockito.when(legalEntityMapper.DTOToDomain(any(LegalEntityDTO.class))).thenReturn(legalEntity);

        boolean isCreatedLegalEntity = legalEntityService.createLegalEntity(legalEntityDTO);

        assertThat(isCreatedLegalEntity).isEqualTo(true);
    }

    @Test
    void shouldThrowAnExceptionWhenSavingTheInvalidLegalEntity() {
        Mockito.when(legalEntityRepository.save(legalEntity))
                .thenThrow(new LegalEntityException("Field 'short_name', 'email' or 'public_access' is not filled!"));
        Mockito.when(legalEntityMapper.DTOToDomain(any(LegalEntityDTO.class))).thenReturn(legalEntity);

        LegalEntityException thrown = Assertions.assertThrows(LegalEntityException.class, () -> {
            legalEntityService.createLegalEntity(legalEntityDTO);
        }, "LegalEntityException was expected");

        assertThat(thrown.getMessage())
                .isEqualTo("Field 'short_name', 'email' or 'public_access' is not filled!");
    }

    @Test
    void shouldDeleteLegalEntityById() {
        Mockito.doNothing().when(legalEntityRepository).deleteById(1L);
        Mockito.when(legalEntityRepository.findById(1L)).thenReturn(Optional.of(legalEntity));

        legalEntityService.deleteLegalEntityById(legalEntity.getId());

        Mockito.verify(legalEntityRepository).deleteById(legalEntity.getId());
    }
}