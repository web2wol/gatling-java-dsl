package api;

import io.gatling.javaapi.core.ChainBuilder;

import static io.gatling.javaapi.core.CoreDsl.*;
import static io.gatling.javaapi.http.HttpDsl.http;


public class test {

    /**
     * Generate auth token API.
     *
     * @return
     */
    public ChainBuilder demoBlaze() {
        return exec(http("Hit Blaze Demo")
                        .get("https://blazedemo.com/")
                        .header("accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7")
//                .body(ElFileBody("/src/test/resources/bodies/AuthToken.json"))
                .check(regex("BlazeDemo").find().saveAs("BlazeDemo"))
        );
    }

}
