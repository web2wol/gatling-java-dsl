package scenarios;

import api.test;
import io.gatling.javaapi.core.ScenarioBuilder;

import static io.gatling.javaapi.core.CoreDsl.exec;
import static io.gatling.javaapi.core.CoreDsl.scenario;
import static io.gatling.javaapi.http.HttpDsl.flushCookieJar;
import static io.gatling.javaapi.http.HttpDsl.flushHttpCache;

public class BlazeDemo {

//    baseHelpers helpers = new baseHelpers();
    test t = new test();

    public ScenarioBuilder scnBlazeDemo(String scnName) {
        return scenario("Blaze Demo Site " + scnName)
                .exec(flushHttpCache())
                .exec(flushCookieJar())
                /**
                 * If any of the requests gets failed then user will exist at the failure step and/ or reiterates from the beginning.
                 */
                .exitBlockOnFail(
                        /**
                         * In case of API, it is not required to group individual API into a parent transaction name.
                         * We can directly call APIs as given below.
                         */
                        exec(t.demoBlaze())
                );
    }

}
