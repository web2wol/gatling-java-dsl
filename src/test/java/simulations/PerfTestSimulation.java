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
// mvn gatling:test -Dscn1Users=10 -Dscn2Users=2 -Dscn3Users=2 -DscnRampUp=5
    {
        try {
            setUp(
                    //Open model
                    BD.scnBlazeDemo("1 open").injectOpen(rampUsers(scn1Users).during(scnRampUp)),
                    BD.scnBlazeDemo("2 open").injectOpen(rampUsers(scn2Users).during(scnRampUp)),
                    //Closed model
                    BD.scnBlazeDemo("1 closed").injectClosed(constantConcurrentUsers(scn3Users).during(scnRampUp))

            )
                    .protocols(httpProtocolWithoutInferHtmlResources);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
