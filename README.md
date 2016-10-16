Gemfire peer to peer distributed cache example

What is this about?
--
This repository contains a demo of how to use Gemfire as a peer-to-peer distributed cache. It is typically used in usecases where you want the cache to scale out with the number of application instances. The peer-to-peer distributed cache lives within the memory allocated to the application - so logically - the more app instances you have bigger the cache.

How does it work?
--
The app uses Spring Data Gemfire to interact with the Gemfire caches. The app fakes the backing datasource by creating an in-memory map on startup. The Gemfire cache's use a multicast address to discover each other. **Please note that this is NOT a recommended deployment - It is recommended to use a locator** http://gemfire.docs.pivotal.io/docs-gemfire/configuring/running/running_the_locator.html.

**It might not even work in the network you are on because of how the network you are on is configured. So using locators is the right way to do it.**

What does it demo?
--
One you run both the apps, when you lookup a key from the dropdown the API makes a call to the cache via Spring Data Gemfire. If the value (for the key) is in the cache, it is returned from the cache. If not in the cache, it will go ahead retrieve it (get) from the cache and puts (put) it in the cache.

Next time, the same key is looked up any app instance it does not hit the backing data source and is fetched from the distributed cache.

How to run the demo?
--
Clone the repository
--
    git clone https://github.com/amithn/gemfire-peer-to-peer-cache-example.git

Start the first app instance on port 8080
--
    ./gradlew bootRepackage; java -Dserver.port=8888 -jar build/libs/gemfire-peer-to-peer-cache-example-0.1.0.jar

Start the second app instance on port 9090
--
    ./gradlew bootRepackage; java -Dserver.port=9090 -jar build/libs/gemfire-peer-to-peer-cache-example-0.1.0.jar

--
Start looking up the keys from the dropdown from each of the app instances see the cache hits and misses in action.

--
Screen recording here
--
<a href="https://www.youtube.com/watch?v=qFBNMcMa07M
" target="_blank"><img src="https://i.ytimg.com/vi/qFBNMcMa07M/1.jpg?time=1476625530052" 
alt="Video here" width="240" height="180" border="10" /></a>


