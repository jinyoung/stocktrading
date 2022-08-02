package stock.trading.common;

import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import stock.trading.AssetsApplication;

@CucumberContextConfiguration
@SpringBootTest(classes = { AssetsApplication.class })
public class CucumberSpingConfiguration {}
