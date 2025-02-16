package pl.zankowski.iextrading4j.client.rest.manager;

import com.google.common.collect.ImmutableMap;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.exception.IEXTradingException;



import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class RestManagerTest {

    private RestClient restClientMock;
    private RestManager restManager;

    @BeforeEach
    public void setUp() {
        restClientMock = mock(RestClient.class);
        restManager = new RestManager(restClientMock);
    }

    @Test
    void shouldSuccessfullyExecuteGetRequest() {
        // Arrange
        final String reasonPhrase = "reason";
        final Response.StatusType statusTypeMock = mock(Response.StatusType.class);
        when(statusTypeMock.getReasonPhrase()).thenReturn(reasonPhrase);

        final Response responseMock = mock(Response.class);
        when(responseMock.getStatusInfo()).thenReturn(statusTypeMock);
        when(responseMock.getStatus()).thenReturn(200);

        final Invocation.Builder builderMock = mock(Invocation.Builder.class);
        when(builderMock.get()).thenReturn(responseMock);

        final WebTarget webTargetMock = mock(WebTarget.class);
        when(webTargetMock.request(anyString())).thenReturn(builderMock);

        final Client clientMock = mock(Client.class);
        when(clientMock.target(anyString())).thenReturn(webTargetMock);

        final RestRequest restRequestMock = mock(RestRequest.class);
        when(restClientMock.getClient()).thenReturn(clientMock);

        final RestClientMetadata metadataMock = mock(RestClientMetadata.class);
        when(restClientMock.getRestClientMetadata()).thenReturn(metadataMock);

        when(restRequestMock.getMethodType()).thenReturn(MethodType.GET);
        when(restRequestMock.getPath()).thenReturn("/test/{test}");
        when(restRequestMock.getPathParams()).thenReturn(ImmutableMap.builder()
                .put("test", "works")
                .build());
        when(restRequestMock.getQueryParams()).thenReturn(ImmutableMap.builder()
                .put("query", "test")
                .build());
        when(metadataMock.getUrl()).thenReturn("http://localhost:8080");

        // Act
        final RestResponse response = restManager.executeRequest(restRequestMock);

        // Assert
        assertThat(response.getMessage()).isEqualTo(reasonPhrase);

        verify(responseMock).close();
        verify(clientMock).target("http://localhost:8080/test/works?query=test");
    }

    @Test
    void shouldThrowAnExceptionForNotSuccessfulResponse() {
        // Arrange
        final String reasonPhrase = "reason";
        final Response.StatusType statusTypeMock = mock(Response.StatusType.class);
        when(statusTypeMock.getReasonPhrase()).thenReturn(reasonPhrase);

        final Response responseMock = mock(Response.class);
        when(responseMock.getStatusInfo()).thenReturn(statusTypeMock);
        when(responseMock.getStatus()).thenReturn(500);

        final Invocation.Builder builderMock = mock(Invocation.Builder.class);
        when(builderMock.get()).thenReturn(responseMock);

        final WebTarget webTargetMock = mock(WebTarget.class);
        when(webTargetMock.request(anyString())).thenReturn(builderMock);

        final Client clientMock = mock(Client.class);
        when(clientMock.target(anyString())).thenReturn(webTargetMock);

        final RestRequest restRequestMock = mock(RestRequest.class);
        when(restClientMock.getClient()).thenReturn(clientMock);

        final RestClientMetadata metadataMock = mock(RestClientMetadata.class);
        when(restClientMock.getRestClientMetadata()).thenReturn(metadataMock);

        when(restRequestMock.getMethodType()).thenReturn(MethodType.GET);
        when(restRequestMock.getPath()).thenReturn("/test/{test}");
        when(restRequestMock.getPathParams()).thenReturn(ImmutableMap.builder()
                .put("test", "works")
                .build());
        when(restRequestMock.getQueryParams()).thenReturn(ImmutableMap.builder()
                .put("query", "test")
                .build());
        when(metadataMock.getUrl()).thenReturn("http://localhost:8080");

        // Act
        assertThrows(IEXTradingException.class, () -> restManager.executeRequest(restRequestMock));
    }

    @Test
    void shouldThrowAnExceptionIfMethodTypeIsNotSupported() {
        final RestClientMetadata metadataMock = mock(RestClientMetadata.class);
        final RestRequest restRequestMock = mock(RestRequest.class);
        final Client clientMock = mock(Client.class);
        final WebTarget webTargetMock = mock(WebTarget.class);
        final Invocation.Builder builderMock = mock(Invocation.Builder.class);

        when(webTargetMock.request(anyString())).thenReturn(builderMock);
        when(clientMock.target(anyString())).thenReturn(webTargetMock);
        when(restClientMock.getClient()).thenReturn(clientMock);
        when(restClientMock.getRestClientMetadata()).thenReturn(metadataMock);

        when(restRequestMock.getMethodType()).thenReturn(MethodType.PUT);
        when(restRequestMock.getPath()).thenReturn("/test");
        when(metadataMock.getUrl()).thenReturn("http://localhost:8080");

        assertThrows(IllegalStateException.class, () -> restManager.executeRequest(restRequestMock));
    }
}
