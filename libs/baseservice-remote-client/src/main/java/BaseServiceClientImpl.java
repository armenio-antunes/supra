import com.mines.base.libs.dtos.exception.ServiceException;
import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;

public class BaseServiceClientImpl implements BaseServiceClient{
    private static final Logger logger = LoggerFactory.getLogger(BaseServiceClientImpl.class);
    private static final String SUBMIT_REQUEST = "/submit";
    private final RestTemplate restTemplate;
    private final URI baseUri;

    @Autowired
    public BaseServiceClientImpl(URI planStatusBaseUrl) {
        this(new RestTemplate(), planStatusBaseUrl);
    }

    protected BaseServiceClientImpl(RestTemplate restTemplate, URI planStatusBaseUrl) {
        this.restTemplate = restTemplate;
        this.baseUri = planStatusBaseUrl;
        this.restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                logger.error("ServiceResponse error: {} {}", response.getStatusCode(), response.getStatusText());
            }
        });
    }

    @Override
    public Response submitRequest(Request request) throws ServiceException{
        final HttpEntity<Request> httpEntity = new HttpEntity<>(request, getHttpHeaders());
        final ParameterizedTypeReference<Response> responseType = new ParameterizedTypeReference<Response>() {
        };
        final ResponseEntity<Response> response = this.restTemplate.exchange(baseUri + SUBMIT_REQUEST, HttpMethod.POST, httpEntity, responseType);
        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        }else{
            throw new ServiceException(response.getStatusCode().toString(),response.getBody().toString());
        }
    }

    private HttpHeaders getHttpHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

}
