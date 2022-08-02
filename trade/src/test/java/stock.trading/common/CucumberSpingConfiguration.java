package stock.trading.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stock.trading.TradeApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { TradeApplication.class })
public class CucumberSpingConfiguration {}
