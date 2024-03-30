package com.cydeo.config;

import com.cydeo.casefactory.Case;
import com.cydeo.casefactory.DellCase;
import com.cydeo.casefactory.Dimensions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PcConfig {

    @Bean
    public Dimensions dimensions(){
        return new Dimensions(50,10,10);
    }
    // you just create the bean Dimensions in the container,
    // and now this bean in the container
    // and Spring is provided by itself..
    // this is called wiring

    @Bean
    public Case caseDell(Dimensions dimensions){ // wiring automatically happen inside
        return new DellCase("220B","Dell","240",dimensions);
        // I have in the container and I have a Dimensions bean, let me provide.. it's wiring
    }
// we need to add parameter
    //you are creating new Object and one of the property of the Case object
    // is Dimensions, where you are going to bring this Dimension?
    // If you do not define inside the method or Constructor
    //you are going to bring from the outside. How you can bring something to your method from the outside?
    // with the parameter
    //Spring is gonna find that Object in the container ant it's gonna wire for your automatically
    //whenever you parameter, then wiring is completed.
    //this is called direct wiring
    // and also there is Dependency Injections,
    // because Spring container "injects" Dimensions Object into Case objects or dependencies
}
