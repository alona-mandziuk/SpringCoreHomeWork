package task2;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Random;
import java.util.UUID;

@Controller
@RequestMapping("/")
public class AppController {

    @GetMapping(value = "/uuid", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getRandomUUID() {
        return UUID.randomUUID().toString();

    }

    @GetMapping(value = "/exchange", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getRandomExchangeRate() {
        double exchangeRate = Math.random() * 100;
        return String.format("%.2f", exchangeRate);
    }

    @GetMapping(value = "/exchange/{currency}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getExchangeRateForCurrency(@PathVariable String currency) {
        double randomRate = new Random().nextDouble() * 100;
        return String.format("%.2f", randomRate);
    }
}
