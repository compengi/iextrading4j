package pl.zankowski.iextrading4j.api.stocks;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class QuoteTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final String companyName = fixture.create(String.class);
        final String primaryExchange = fixture.create(String.class);
        final String sector = fixture.create(String.class);
        final String calculationPrice = fixture.create(String.class);
        final BigDecimal open = fixture.create(BigDecimal.class);
        final Long openTime = fixture.create(Long.class);
        final String openSource = fixture.create(String.class);
        final BigDecimal close = fixture.create(BigDecimal.class);
        final Long closeTime = fixture.create(Long.class);
        final String closeSource = fixture.create(String.class);
        final BigDecimal high = fixture.create(BigDecimal.class);
        final Long highTime = fixture.create(Long.class);
        final String highSource = fixture.create(String.class);
        final BigDecimal low = fixture.create(BigDecimal.class);
        final Long lowTime = fixture.create(Long.class);
        final String lowSource = fixture.create(String.class);
        final BigDecimal volume = fixture.create(BigDecimal.class);
        final BigDecimal latestPrice = fixture.create(BigDecimal.class);
        final String latestSource = fixture.create(String.class);
        final String latestTime = fixture.create(String.class);
        final Long latestUpdate = fixture.create(Long.class);
        final BigDecimal latestVolume = fixture.create(BigDecimal.class);
        final BigDecimal iexRealtimePrice = fixture.create(BigDecimal.class);
        final BigDecimal iexRealtimeSize = fixture.create(BigDecimal.class);
        final Long iexLastUpdated = fixture.create(Long.class);
        final BigDecimal delayedPrice = fixture.create(BigDecimal.class);
        final Long delayedPriceTime = fixture.create(Long.class);
        final BigDecimal extendedPrice = fixture.create(BigDecimal.class);
        final BigDecimal extendedChange = fixture.create(BigDecimal.class);
        final BigDecimal extendedChangePercent = fixture.create(BigDecimal.class);
        final Long extendedPriceTime = fixture.create(Long.class);
        final BigDecimal previousClose = fixture.create(BigDecimal.class);
        final BigDecimal previousVolume = fixture.create(BigDecimal.class);
        final BigDecimal change = fixture.create(BigDecimal.class);
        final BigDecimal changePercent = fixture.create(BigDecimal.class);
        final BigDecimal iexMarketPercent = fixture.create(BigDecimal.class);
        final BigDecimal iexVolume = fixture.create(BigDecimal.class);
        final BigDecimal avgTotalVolume = fixture.create(BigDecimal.class);
        final BigDecimal iexBidPrice = fixture.create(BigDecimal.class);
        final BigDecimal iexBidSize = fixture.create(BigDecimal.class);
        final BigDecimal iexAskPrice = fixture.create(BigDecimal.class);
        final BigDecimal iexAskSize = fixture.create(BigDecimal.class);
        final BigDecimal marketCap = fixture.create(BigDecimal.class);
        final BigDecimal peRatio = fixture.create(BigDecimal.class);
        final BigDecimal week52High = fixture.create(BigDecimal.class);
        final BigDecimal week52Low = fixture.create(BigDecimal.class);
        final BigDecimal ytdChange = fixture.create(BigDecimal.class);
        final BigDecimal bidPrice = fixture.create(BigDecimal.class);
        final BigDecimal bidSize = fixture.create(BigDecimal.class);
        final BigDecimal askPrice = fixture.create(BigDecimal.class);
        final BigDecimal askSize = fixture.create(BigDecimal.class);
        final BigDecimal iexOpen = fixture.create(BigDecimal.class);
        final Long iexOpenTime = fixture.create(Long.class);
        final BigDecimal iexClose = fixture.create(BigDecimal.class);
        final Long iexCloseTime = fixture.create(Long.class);
        final Long lastTradeTime = fixture.create(Long.class);
        final Boolean isUSMarketOpen = fixture.create(Boolean.class);
        final BigDecimal oddLotDelayedPrice = fixture.create(BigDecimal.class);
        final Long oddLotDelayedPriceTime = fixture.create(Long.class);
        final String currency = fixture.create(String.class);

        final Quote quote = new Quote(symbol, companyName, primaryExchange, sector, calculationPrice, open,
                openTime, openSource, close, closeTime, closeSource, high, highTime, highSource, low, lowTime, lowSource,
                volume, latestPrice, latestSource, latestTime, latestUpdate,
                latestVolume, iexRealtimePrice, iexRealtimeSize, iexLastUpdated, delayedPrice, delayedPriceTime,
                extendedPrice, extendedChange, extendedChangePercent, extendedPriceTime, previousClose, previousVolume,
                change, changePercent, iexMarketPercent, iexVolume, avgTotalVolume, iexBidPrice, iexBidSize, iexAskPrice,
                iexAskSize, iexOpen, iexOpenTime, iexClose, iexCloseTime, marketCap, peRatio, week52High, week52Low,
                ytdChange, bidPrice, bidSize, askPrice, askSize, lastTradeTime, isUSMarketOpen, oddLotDelayedPrice,
                oddLotDelayedPriceTime, currency);

        assertThat(quote.getSymbol()).isEqualTo(symbol);
        assertThat(quote.getCompanyName()).isEqualTo(companyName);
        assertThat(quote.getPrimaryExchange()).isEqualTo(primaryExchange);
        assertThat(quote.getSector()).isEqualTo(sector);
        assertThat(quote.getCalculationPrice()).isEqualTo(calculationPrice);
        assertThat(quote.getOpen()).isEqualTo(open);
        assertThat(quote.getOpenTime()).isEqualTo(openTime);
        assertThat(quote.getOpenSource()).isEqualTo(openSource);
        assertThat(quote.getClose()).isEqualTo(close);
        assertThat(quote.getCloseTime()).isEqualTo(closeTime);
        assertThat(quote.getCloseSource()).isEqualTo(closeSource);
        assertThat(quote.getHigh()).isEqualTo(high);
        assertThat(quote.getLow()).isEqualTo(low);
        assertThat(quote.getVolume()).isEqualTo(volume);
        assertThat(quote.getLatestPrice()).isEqualTo(latestPrice);
        assertThat(quote.getLatestSource()).isEqualTo(latestSource);
        assertThat(quote.getLatestTime()).isEqualTo(latestTime);
        assertThat(quote.getLatestUpdate()).isEqualTo(latestUpdate);
        assertThat(quote.getLatestVolume()).isEqualTo(latestVolume);
        assertThat(quote.getIexRealtimePrice()).isEqualTo(iexRealtimePrice);
        assertThat(quote.getIexRealtimeSize()).isEqualTo(iexRealtimeSize);
        assertThat(quote.getIexLastUpdated()).isEqualTo(iexLastUpdated);
        assertThat(quote.getDelayedPrice()).isEqualTo(delayedPrice);
        assertThat(quote.getDelayedPriceTime()).isEqualTo(delayedPriceTime);
        assertThat(quote.getExtendedPrice()).isEqualTo(extendedPrice);
        assertThat(quote.getExtendedChange()).isEqualTo(extendedChange);
        assertThat(quote.getExtendedChangePercent()).isEqualTo(extendedChangePercent);
        assertThat(quote.getExtendedPriceTime()).isEqualTo(extendedPriceTime);
        assertThat(quote.getPreviousClose()).isEqualTo(previousClose);
        assertThat(quote.getPreviousVolume()).isEqualTo(previousVolume);
        assertThat(quote.getChange()).isEqualTo(change);
        assertThat(quote.getChangePercent()).isEqualTo(changePercent);
        assertThat(quote.getIexMarketPercent()).isEqualTo(iexMarketPercent);
        assertThat(quote.getIexVolume()).isEqualTo(iexVolume);
        assertThat(quote.getAvgTotalVolume()).isEqualTo(avgTotalVolume);
        assertThat(quote.getIexBidPrice()).isEqualTo(iexBidPrice);
        assertThat(quote.getIexBidSize()).isEqualTo(iexBidSize);
        assertThat(quote.getIexAskPrice()).isEqualTo(iexAskPrice);
        assertThat(quote.getIexAskSize()).isEqualTo(iexAskSize);
        assertThat(quote.getIexOpen()).isEqualTo(iexOpen);
        assertThat(quote.getIexOpenTime()).isEqualTo(iexOpenTime);
        assertThat(quote.getIexClose()).isEqualTo(iexClose);
        assertThat(quote.getIexCloseTime()).isEqualTo(iexCloseTime);
        assertThat(quote.getMarketCap()).isEqualTo(marketCap);
        assertThat(quote.getPeRatio()).isEqualTo(peRatio);
        assertThat(quote.getWeek52High()).isEqualTo(week52High);
        assertThat(quote.getWeek52Low()).isEqualTo(week52Low);
        assertThat(quote.getYtdChange()).isEqualTo(ytdChange);
        assertThat(quote.getBidSize()).isEqualTo(bidSize);
        assertThat(quote.getBidPrice()).isEqualTo(bidPrice);
        assertThat(quote.getAskSize()).isEqualTo(askSize);
        assertThat(quote.getAskPrice()).isEqualTo(askPrice);
        assertThat(quote.getLastTradeTime()).isEqualTo(lastTradeTime);
        assertThat(quote.isUSMarketOpen()).isEqualTo(isUSMarketOpen);
        assertThat(quote.getOddLotDelayedPrice()).isEqualTo(oddLotDelayedPrice);
        assertThat(quote.getOddLotDelayedPriceTime()).isEqualTo(oddLotDelayedPriceTime);
        assertThat(quote.getCurrency()).isEqualTo(currency);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Quote.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(Quote.class))
                .verify();
    }

}
