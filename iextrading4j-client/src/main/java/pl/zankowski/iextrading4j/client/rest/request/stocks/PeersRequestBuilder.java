package pl.zankowski.iextrading4j.client.rest.request.stocks;

import pl.zankowski.iextrading4j.client.rest.manager.RestRequest;
import pl.zankowski.iextrading4j.client.rest.manager.RestRequestBuilder;
import pl.zankowski.iextrading4j.client.rest.request.IEXCloudV1RestRequest;

import jakarta.ws.rs.core.GenericType;
import java.util.List;

public class PeersRequestBuilder extends AbstractStocksRequestBuilder<List<String>, PeersRequestBuilder>
        implements IEXCloudV1RestRequest<List<String>> {

    @Override
    public RestRequest<List<String>> build() {
        return RestRequestBuilder.<List<String>>builder()
                .withPath("/stock/{symbol}/peers")
                .addPathParam("symbol", getSymbol()).get()
                .withResponse(new GenericType<List<String>>() {})
                .build();
    }

}
