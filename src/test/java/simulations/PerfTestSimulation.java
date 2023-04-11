package simulations;

import static config.baseHelpers.*;
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


            this.setUp(BD.scnBlazeDemo().injectOpen(rampUsers(scn1Users).during(scnRampUp)))
                    .protocols(httpProtocolWithoutInferHtmlResources);
            this.setUp(BD.scnBlazeDemo().injectOpen(rampUsers(scn2Users).during(scnRampUp)))
                    .protocols(httpProtocolWithoutInferHtmlResources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
