package pl.zankowski.iextrading4j.client.socket.manager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flextrade.jfixture.JFixture;
import com.google.common.collect.Lists;
import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.util.ToStringVerifier;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class SocketRequestTest {

    private final JFixture fixture = new JFixture();

    @Test
    void constructor() {
        final TypeReference<String> responseType = new TypeReference<String>() {
        };
        final String path = fixture.create(String.class);
        final List<String> params = Lists.newArrayList();

        final SocketRequest<String> request = new SocketRequest<>(responseType, path, params);

        assertThat(request.getPath()).isEqualTo(path);
        assertThat(request.getResponseType()).isEqualTo(responseType);
        assertThat(request.getParam()).isEqualTo(params);
    }

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(SocketRequest.class)
                .usingGetClass()
                .verify();
    }

    @Test
    void toStringVerification() {
        ToStringVerifier.forObject(new SocketRequest<>(null, null, null))
                .verify();
    }

}
