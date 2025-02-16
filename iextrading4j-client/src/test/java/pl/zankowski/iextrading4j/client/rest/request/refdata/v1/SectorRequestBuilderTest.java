package pl.zankowski.iextrading4j.client.rest.request.refdata.v1;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.refdata.v1.Sector;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SectorRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateSectorRequest() {
        final RestRequest<List<Sector>> request = new SectorRequestBuilder().build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/ref-data/sectors");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<List<Sector>>() {
        });
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
