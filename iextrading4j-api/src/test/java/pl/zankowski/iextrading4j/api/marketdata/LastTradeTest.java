package pl.zankowski.iextrading4j.api.marketdata;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class LastTradeTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final String symbol = fixture.create(String.class);
        final BigDecimal price = fixture.create(BigDecimal.class);
        final BigDecimal size = fixture.create(BigDecimal.class);
        final Long time = fixture.create(Long.class);

        final LastTrade lastTrade = new LastTrade(symbol, price, size, time);

        assertThat(lastTrade.getSymbol()).isEqualTo(symbol);
        assertThat(lastTrade.getPrice()).isEqualTo(price);
        assertThat(lastTrade.getSize()).isEqualTo(size);
        assertThat(lastTrade.getTime()).isEqualTo(time);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(LastTrade.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(LastTrade.class))
                .verify();
    }

}
