package pl.zankowski.iextrading4j.api.stocks.v1;

import com.flextrade.jfixture.JFixture;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CashFlowsTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final List<CashFlow> cashFlow = Lists.newArrayList(fixture.collections().createCollection(CashFlow.class));
        final String symbol = fixture.create(String.class);

        final CashFlows cashFlows = new CashFlows(symbol, cashFlow);

        assertThat(cashFlows.getCashFlow()).isEqualTo(cashFlow);
        assertThat(cashFlows.getSymbol()).isEqualTo(symbol);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(CashFlows.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(fixture.create(CashFlows.class))
                .verify();
    }

}
