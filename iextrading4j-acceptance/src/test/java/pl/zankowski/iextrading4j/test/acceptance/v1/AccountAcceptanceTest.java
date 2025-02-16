package pl.zankowski.iextrading4j.test.acceptance.v1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zankowski.iextrading4j.api.account.Metadata;
import pl.zankowski.iextrading4j.api.account.Usage;
import pl.zankowski.iextrading4j.client.IEXCloudClient;
import pl.zankowski.iextrading4j.client.IEXCloudTokenBuilder;
import pl.zankowski.iextrading4j.client.IEXTradingApiVersion;
import pl.zankowski.iextrading4j.client.IEXTradingClient;
import pl.zankowski.iextrading4j.client.rest.request.account.MetadataRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.account.UsageType;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AccountAcceptanceTest {

    protected IEXCloudClient cloudClient;

    @BeforeEach
    public void setUp() {
        cloudClient = IEXTradingClient.create(IEXTradingApiVersion.IEX_CLOUD_V1_SANDBOX, new IEXCloudTokenBuilder()
                .withPublishableToken("Tpk_18dfe6cebb4f41ffb219b9680f9acaf2")
                .withSecretToken("Tsk_3eedff6f5c284e1a8b9bc16c54dd1af3")
                .build());
    }

    @AfterEach
    public void tearDown() {
        cloudClient = null;
    }

    @Test
    void metadataTest() {
        final Metadata metadata = cloudClient.executeRequest(new MetadataRequestBuilder()
                .build());
        assertThat(metadata).isNotNull();
    }

    @Test
    void messageUsageTest() {
        final List<Usage> usage = cloudClient.executeRequest(new UsageRequestBuilder()
                .withUsageType(UsageType.MESSAGES)
                .build());
        System.out.println(usage);
        assertThat(usage).isNotNull();
    }

    @Test
    void rulesUsageTest() {
        final List<Usage> usage = cloudClient.executeRequest(new UsageRequestBuilder()
                .withUsageType(UsageType.RULES)
                .build());
        System.out.println(usage);
        assertThat(usage).isNotNull();
    }

    @Test
    void usageTest() {
        final Map<String, List<Usage>> result = cloudClient.executeRequest(new UsageRequestBuilder().build());
        System.out.println(result);
        assertThat(result).isNotNull();
    }

}
