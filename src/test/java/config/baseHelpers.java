package config;

import io.gatling.javaapi.http.HttpDsl;
import io.gatling.javaapi.http.HttpProtocolBuilder;

public class baseHelpers {
    public static final String PROJECT_BASE_DIRECTORY = System.getProperty("user.dir", "");
    public static final String PROJECT_CONFIG_PATH;
    public static final int MIN_THINK_TIME;
    public static final int MAX_THINK_TIME;
    public static HttpProtocolBuilder httpProtocolWithoutInferHtmlResources;
    public static HttpProtocolBuilder httpProtocolWithInferHtmlResources;


    static {
        PROJECT_CONFIG_PATH = PROJECT_BASE_DIRECTORY + "/src/test/scala/config/";
        MIN_THINK_TIME = Integer.parseInt(System.getProperty("MinThinkTime", "2"));
        MAX_THINK_TIME = Integer.parseInt(System.getProperty("MaxThinkTime", "5"));
        httpProtocolWithoutInferHtmlResources = HttpDsl.http.acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3").acceptEncodingHeader("gzip, deflate").acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8").upgradeInsecureRequestsHeader("1").userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
        httpProtocolWithInferHtmlResources = HttpDsl.http.inferHtmlResources().acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3").acceptEncodingHeader("gzip, deflate").acceptLanguageHeader("en-GB,en-US;q=0.9,en;q=0.8").upgradeInsecureRequestsHeader("1").userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36");
    }

    public static final Integer scn1Users = Integer.parseInt(System.getProperty("scn1Users", "1"));
    public static final Integer scn2Users = Integer.parseInt(System.getProperty("scn2Users", "1"));
    public static final Integer scn3Users = Integer.parseInt(System.getProperty("scn3Users", "1"));
    public static final Integer scnRampUp = Integer.parseInt(System.getProperty("scnRampUp", "1"));


}
