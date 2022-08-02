package stock.trading.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stock.trading.BidApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { BidApplication.class })
public class CucumberSpingConfiguration {}
