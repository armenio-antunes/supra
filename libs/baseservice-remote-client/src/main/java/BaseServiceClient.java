import com.mines.base.libs.dtos.exception.ServiceException;
import com.mines.base.libs.dtos.request.Request;
import com.mines.base.libs.dtos.response.Response;

public interface BaseServiceClient{

    Response submitRequest(Request request) throws ServiceException;

}
