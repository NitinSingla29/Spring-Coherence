# [Spring-Coherence](https://github.com/NitinSingla29/Spring-Coherence#spring-coherence)

It's a spring based API to integrate Coherence cache with existing application based on Spring 4.1.6

## Steps
    - Import Coherence Configuration via com.spring.coherence.configuration.CoherenceConfiguration 
    - Add sample application-cache.xml and tangosol-coherence-override.xml in in classpath (For maven project, add in resource folder)
    - Both xml files must precede coherence.jar in classpath
## tangosol-coherence-override.xml 
    - It specify the configuration of coherence cluster configuration.
## application-cache.xml 
    - It specifty the configuration of caches required for application


## References
    - https://docs.oracle.com/middleware/1212/wls/CLUST/coherence.htm#CLUST629
