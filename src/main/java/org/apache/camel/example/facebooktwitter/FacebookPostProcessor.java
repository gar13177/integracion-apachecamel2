/*
 * Copyright 2016 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.example.facebooktwitter;

import facebook4j.Post;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 *
 * @author PabloJavier
 */
public class FacebookPostProcessor implements Processor{

            @Override
            public void process(Exchange exchange) throws Exception {
                Post message;
                System.out.println(exchange.getIn().getBody(String.class));
                message = exchange.getIn().getBody(Post.class);
                
                if(message != null)
                {
                    exchange.getOut().setHeader("isNull", "no");
                    if (message.getMessage() != null && message.getMessage().length() < 140) {
                        exchange.getOut().setHeader("post", "yes");
                        if (message.getMessage().contains("http")) {
                            exchange.getOut().setHeader("timeline", "yes");
                        } else {
                            exchange.getOut().setHeader("timeline", "no");
                        }

                    } else {
                        exchange.getOut().setHeader("post", "no");
                    }
                    exchange.getOut().setBody(message.getMessage());
                    
                }
                else
                {
                    exchange.getOut().setHeader("isNull", "yes");
                    exchange.getOut().setBody("NOPE");
                }
                
            }    
}
