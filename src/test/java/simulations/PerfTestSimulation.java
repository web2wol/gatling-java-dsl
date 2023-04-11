package simulations;

import static config.baseHelpers.httpProtocolWithoutInferHtmlResources;
import static io.gatling.javaapi.core.CoreDsl.*;
//import config.baseHelpers;
import scenarios.BlazeDemo;
import io.gatling.javaapi.core.Simulation;




/**
 * This sample is based on our official tutorials:
 * <ul>
 *   <li><a href="https://gatling.io/docs/gatling/tutorials/quickstart">Gatling quickstart tutorial</a>
 *   <li><a href="https://gatling.io/docs/gatling/tutorials/advanced">Gatling advanced tutorial</a>
 * </ul>
 */
public class PerfTestSimulation extends Simulation {

//    config.baseHelpers helpers = new baseHelpers();
    scenarios.BlazeDemo BD = new BlazeDemo();

    {
        try {


            this.setUp(BD.scnBlazeDemo().injectOpen(rampUsers(1).during(1)))
                    .protocols(httpProtocolWithoutInferHtmlResources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
