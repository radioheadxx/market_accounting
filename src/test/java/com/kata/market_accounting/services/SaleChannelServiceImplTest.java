package com.kata.market_accounting.services;

import com.kata.market_accounting.models.SaleChannel;
import com.kata.market_accounting.repositories.SaleChannelRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class SaleChannelServiceImplTest {

    @Mock
    private SaleChannelRepository repository;

    @InjectMocks
    private SaleChannelServiceImpl underTest;
    private SaleChannel saleChannel;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy kk:mm");

    @BeforeEach
    void setup() {
        saleChannel = new SaleChannel();
        saleChannel.setId(1L);
        saleChannel.setName("Yandex");
        saleChannel.setType("Post service");
        saleChannel.setDescription("Description");
        saleChannel.setOwnerDepartment("Основной");
        saleChannel.setDateAndTime(LocalDateTime.now().format(formatter));
    }


    @Test
    void listSaleChannelsShouldInvokeRepositoryFindAll() {
        underTest.listSaleChannels();
        verify(repository).findAll();
    }


    @Test
    void getSaleChannelShouldInvokeRepositoryFindById() {
        given(repository.findById(1L)).willReturn(Optional.of(saleChannel));

        SaleChannel savedSaleChannel = underTest.getSaleChannel(saleChannel.getId());

        assertThat(savedSaleChannel).isNotNull();
        assertThat(savedSaleChannel).isEqualTo(saleChannel);
    }

    @Test
    void createSaleChannelShouldInvokeRepositorySaveWithAppropriateParameters() {
        SaleChannel saleChannel = new SaleChannel();
        saleChannel.setName("VKontakte");
        saleChannel.setType("Social net");
        saleChannel.setDescription("Description");
        saleChannel.setOwnerDepartment("Основной");
        saleChannel.setDateAndTime(LocalDateTime.now().format(formatter));

        underTest.createSaleChannel(saleChannel);

        ArgumentCaptor<SaleChannel> argumentCaptor =
                ArgumentCaptor.forClass(SaleChannel.class);

        verify(repository).save(argumentCaptor.capture());
    }

    @Test
    void updateSaleChannel() {
        saleChannel.setDescription("updated description");

        SaleChannel updatedSaleChannel = underTest.updateSaleChannel(saleChannel);

        Assertions.assertThat(updatedSaleChannel.getDescription()).isEqualTo("updated description");
    }

    @Test
    void deleteSaleChannelShouldInvokeRepositoryDeleteByIdMethodWithParameter() {
        long saleChannelId = 1L;
        underTest.deleteSaleChannel(saleChannelId);
        verify(repository).deleteById(saleChannelId);
    }
}