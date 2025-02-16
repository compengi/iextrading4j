package pl.zankowski.iextrading4j.client.rest.request.system;

import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.system.SystemStatus;
import pl.zankowski.iextrading4j.client.rest.manager.MethodType;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;

import jakarta.ws.rs.core.GenericType;

import static org.assertj.core.api.Assertions.assertThat;

class SystemStatusRequestBuilderTest {

    @Test
    void shouldSuccessfullyCreateRequest() {
        final RestRequest<SystemStatus> request = new SystemStatusRequestBuilder()
                .build();

        assertThat(request.getMethodType()).isEqualTo(MethodType.GET);
        assertThat(request.getPath()).isEqualTo("/status");
        assertThat(request.getResponseType()).isEqualTo(new GenericType<SystemStatus>() {});
        assertThat(request.getPathParams()).isEmpty();
        assertThat(request.getQueryParams()).isEmpty();
    }

}
