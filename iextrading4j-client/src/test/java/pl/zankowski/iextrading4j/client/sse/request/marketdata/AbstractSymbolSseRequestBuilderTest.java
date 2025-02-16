package pl.zankowski.iextrading4j.client.sse.request.marketdata;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.marketdata.LastTrade;
import pl.zankowski.iextrading4j.client.sse.manager.SseRequest;

import jakarta.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class AbstractSymbolSseRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateSseRequestWithMultipleSymbols() {
        final String ibmSymbol = "ibm";
        final String aaplSymbol = "aapl";

        final SseRequest<List<LastTrade>> request = new LastSseRequestBuilder()
                .withSymbols(ibmSymbol, aaplSymbol)
                .build();

        assertThat(request.getPath()).isEqualTo("/last");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<LastTrade>>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).contains(entry("nosnapshot", "false"));

        final String value = request.getQueryParams().get("symbols");
        assertThat(value).containsSequence(ibmSymbol).containsSequence(aaplSymbol);
    }

}
