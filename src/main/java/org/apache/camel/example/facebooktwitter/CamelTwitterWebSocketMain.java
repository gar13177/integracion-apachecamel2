
package org.apache.camel.example.facebooktwitter;

import org.apache.camel.main.Main;

/**
 * A main to start this example.
 */
public final class CamelTwitterWebSocketMain {

    //Twitter
    private static String consumerKey = "<>";
    private static String consumerSecret = "<>";
    private static String accessToken = "<>";
    private static String accessTokenSecret = "<>";
    
    //Facebook
    private static String OAuthAppId = "<>";
    private static String OAuthAppSecret = "<>";
    
    private CamelTwitterWebSocketMain() {
        // to pass checkstyle we have a private constructor
    }

    public static void main(String[] args) throws Exception {

        // create a new Camel Main so we can easily start Camel
        Main main = new Main();

        TwitterFacebookRoute route = new TwitterFacebookRoute();

        // setup twitter application authentication
        route.setAccessToken(accessToken);
        route.setAccessTokenSecret(accessTokenSecret);
        route.setConsumerKey(consumerKey);
        route.setConsumerSecret(consumerSecret);
        
        // setup facebook application authentication
        route.setOAuthAppId(OAuthAppId);
        route.setOAuthAppSecret(OAuthAppSecret);
        
        // add facebook pages
        route.addFacebookId("9gag");
        route.addFacebookId("fakeuselesspage");

        // add our routes to Camel
        main.addRouteBuilder(route);

        // and run, which keeps blocking until we terminate the JVM (or stop CamelContext)
        main.run();
    }

}
