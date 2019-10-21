package example.camel.spring.restapi.route;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//Make sure to always declare as component
@Component
public class RESTServer extends RouteBuilder {
    @Override
    public void configure() {

        //Configure the REST server. Utilizing spark-rest as server component due to ease of use
        //with straightforward REST API
        restConfiguration().component("spark-rest").port(8080);

        rest().get("playerscore/{playerID}")
                //Declares that this endpoint from here on is treated as a route vs REST endpoint
                .route()
                //Has to be of type Expression when setting body. Using simple expression
                .setBody(simple("You requested information on ${header.playerID}"))
                .log(LoggingLevel.INFO,"The user requested to know the score for user ${header.playerID}");

        rest().post("/submitnewscore")
                //Declares that this endpoint from here on is treated as a route vs REST endpoint
                .route()
                .log(LoggingLevel.INFO, "You sent me the payload of ${body}")
                .setBody(simple("You sent me the payload of ${body}"));
    }
}
