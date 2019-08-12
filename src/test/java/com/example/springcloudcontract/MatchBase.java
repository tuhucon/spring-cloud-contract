package com.example.springcloudcontract;

import com.github.tomakehurst.wiremock.client.MappingBuilder;
import static com.github.tomakehurst.wiremock.client.WireMock.*;
import com.github.tomakehurst.wiremock.common.ClasspathFileSource;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.junit.WireMockClassRule;
import com.github.tomakehurst.wiremock.standalone.JsonFileMappingsSource;
import com.github.tomakehurst.wiremock.standalone.MappingsSource;
import com.github.tomakehurst.wiremock.stubbing.InMemoryStubMappings;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.FilteredClassLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.cloud.contract.wiremock.WireMockSpring;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.UUID;

@SpringBootTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@AutoConfigureStubRunner
public abstract class MatchBase {

    @Autowired
    WebApplicationContext webApplicationContext;

    @ClassRule
    public static WireMockClassRule imageWireMock = new WireMockClassRule(WireMockSpring.options()
            .port(8081)
//            .mappingSource(new JsonFileMappingsSource(new ClasspathFileSource("mappings/imageService")))
    );

    @ClassRule
    public static WireMockClassRule textWireMock = new WireMockClassRule(WireMockSpring.options()
            .port(8082)
//            .mappingSource(new JsonFileMappingsSource(new ClasspathFileSource("mappings/textService")))
    );

    @Before
    public void setup() {
//        ClasspathFileSource fileSource = new ClasspathFileSource("mappings/imageService");
//        JsonFileMappingsSource source = new JsonFileMappingsSource(fileSource);
//        InMemoryStubMappings stubMappings = new InMemoryStubMappings();
//        source.loadMappingsInto(stubMappings);
//        List<StubMapping> allMappings = stubMappings.getAll();
        RestAssuredMockMvc.webAppContextSetup(webApplicationContext);
    }
}
