package pl.zankowski.iextrading4j.client.rest.request.stocks;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.stocks.TodayEarnings;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

class TodayEarningsRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<TodayEarnings> request = new TodayEarningsRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/stock/market/today-earnings");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<TodayEarnings>() {});
        assertThat(request.getQueryParams()).isEmpty();
    }

}
