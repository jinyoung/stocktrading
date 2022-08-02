package stock.trading.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stock.trading.PricingApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { PricingApplication.class })
public class CucumberSpingConfiguration {}
