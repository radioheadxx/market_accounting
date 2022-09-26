package com.kata.market_accounting;

import com.kata.market_accounting.models.Currency;
import com.kata.market_accounting.repositories.CurrencyRepository;
import com.kata.market_accounting.services.CurrencyServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CurrencyServiceTests {
    @Mock
    private CurrencyRepository currencyRepository;

    @InjectMocks
    private CurrencyServiceImpl currencyService;

    private Currency currency;
    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");


    @BeforeEach
    public void setup() {
        currencyRepository = Mockito.mock(CurrencyRepository.class);
        currencyService = new CurrencyServiceImpl(currencyRepository);
        currency = new Currency("test.cur1", "Test Currency One", "TST1");
        currency.setId(1L);
    }

    @DisplayName("JUnit test for add currency method")
    @Test
    public void givenCurrencyObject_whenSaveCurrency_thenReturnCurrencyObject() {

        given(currencyRepository.save(currency)).willReturn(currency);

        System.out.println(currencyRepository);
        System.out.println(currencyService);

        Currency savedCurrency = currencyService.create(currency);

        System.out.println(savedCurrency);

        assertThat(savedCurrency).isNotNull();
    }

    @DisplayName("JUnit test for getAll method")
    @Test
    public void givenCurrencyList_whenGetAllCurrencies_thenReturnCurrenciesList() {
        Currency currency1 = new Currency("test.cur2", "Test Currency Two", "TST2");

        given(currencyRepository.findAll()).willReturn(List.of(currency, currency1));

        List<Currency> currencyList = currencyService.getAll();

        assertThat(currencyList).isNotNull();
        assertThat(currencyList.size()).isEqualTo(2);
    }

    @DisplayName("JUnit test for getOneById method")
    @Test
    public void givenCurrencyId_whenGetOneById_thenReturnCurrencyObject() {
        given(currencyRepository.findById(1L)).willReturn(Optional.of(currency));

        Currency savedCurrency = currencyService.getOneById(currency.getId());

        assertThat(savedCurrency).isNotNull();
    }

    @DisplayName("JUnit test for update method")
    @Test
    public void givenCurrencyObject_whenUpdateCurrency_thenReturnUpdatedCurrency() {
        given(currencyRepository.save(currency)).willReturn(currency);
        currency.setShortName("updated test");

        Currency updatedCurrency = currencyService.update(currency);

        assertThat(updatedCurrency.getShortName()).isEqualTo("updated test");
    }

    @DisplayName("JUnit test for delete method")
    @Test
    public void givenCurrencyId_whenDeleteCurrency_ThenNothing() {
        long currencyId = 1L;

        willDoNothing().given(currencyRepository).deleteById(currencyId);

        currencyService.delete(currencyId);

        verify(currencyRepository, times(1)).deleteById(currencyId);
    }
}