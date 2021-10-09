package pl.zankowski.iextrading4j.client.socket.request.market;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.market.MarketVolume;
import pl.zankowski.iextrading4j.client.socket.manager.SocketRequest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MarketAsyncRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateAsyncRequest() {
        final SocketRequest<List<MarketVolume>> request = new MarketAsyncRequestBuilder().build();

        assertThat(request.getPath()).isEqualTo("/market");
        assertThat(request.getParam()).isNull();
    }

}
