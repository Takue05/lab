package com.takue.lab.config;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.NoTypePermission;
import com.thoughtworks.xstream.security.PrimitiveTypePermission;
import org.axonframework.serialization.Serializer;
import org.axonframework.serialization.xml.XStreamSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AxonSerializationConfig {

    @Bean
    @Primary
    public Serializer defaultSerializer() {
        XStream xStream = new XStream();

        xStream.addPermission(NoTypePermission.NONE);
        xStream.addPermission(PrimitiveTypePermission.PRIMITIVES);

        xStream.allowTypesByWildcard(new String[] {
                "com.takue.lab.**",
                "org.axonframework.**",
                "java.lang.**",
                "java.util.**",
                "java.time.**"
        });

        return XStreamSerializer.builder()
                .xStream(xStream)
                .build();
    }
}
