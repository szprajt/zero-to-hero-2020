package hu.zerotohero.verseny.httpstatus;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("http-status")
public class HTTPStatusController {

    @GetMapping("/getStatusDescription")
    public String getStatusDescription(@RequestParam(value = "statusCode", defaultValue = "500") Integer statusCode) throws NotFoundException {
        try {
            HttpStatus result = HttpStatus.valueOf(statusCode);
            return "Query: " + statusCode + " Response: " + result.getReasonPhrase();
        } catch (Exception e) {
            e.printStackTrace();
            throw new NotFoundException();
        }
    }
}
