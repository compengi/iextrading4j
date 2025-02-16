package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.Ohlc;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.entry;

class OhlcMarketRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<Map<String, Ohlc>> request = new OhlcMarketRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/{symbol}/ohlc");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<Map<String, Ohlc>>() {});
        assertThat(request.getPathParams()).containsExactly(entry("symbol", "market"));
        assertThat(request.getQueryParams()).isEmpty();
    }

}
