package com.yk.example;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.*;
import java.io.IOException;
import java.net.HttpURLConnection;

import static org.junit.Assert.assertEquals;

/**
 * Created by yk on 15/12/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@ActiveProfiles("test")
public class ApplicationTest {

    @Value("${local.server.port}")
    private int port;

    @Autowired
    private ApplicationContext context;


    @BeforeClass
    public static void setUp() {

        try {
            // setup ssl context to ignore certificate errors
            SSLContext ctx = SSLContext.getInstance("TLS");
            X509TrustManager tm = new X509TrustManager() {

                @Override
                public void checkClientTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws java.security.cert.CertificateException {
                }

                @Override
                public void checkServerTrusted(java.security.cert.X509Certificate[] chain,
                                               String authType) throws java.security.cert.CertificateException {
                }

                @Override
                public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                    return null;
                }
            };
            ctx.init(null, new TrustManager[] { tm }, null);
            SSLContext.setDefault(ctx);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

    }





    /**
     * Http Request Factory for ignoring SSL hostname errors. Not for production use!
     */
    class MySimpleClientHttpRequestFactory extends SimpleClientHttpRequestFactory {

        private final HostnameVerifier verifier;

        public MySimpleClientHttpRequestFactory(final HostnameVerifier verifier) {
            this.verifier = verifier;
        }

        @Override
        protected void prepareConnection(final HttpURLConnection connection,
                                         final String httpMethod) throws IOException {
            if (connection instanceof HttpsURLConnection) {
                ((HttpsURLConnection) connection).setHostnameVerifier(this.verifier);
            }
            super.prepareConnection(connection, httpMethod);
        }
    }


    @Test
    public void testHello() throws Exception {
        RestTemplate template = new RestTemplate();
        final MySimpleClientHttpRequestFactory factory = new MySimpleClientHttpRequestFactory(
                new HostnameVerifier() {

                    @Override
                    public boolean verify(final String hostname,
                                          final SSLSession session) {
                        return true; // these guys are alright by me...
                    }
                });
        template.setRequestFactory(factory);

        ResponseEntity<String> entity = template.getForEntity(
                "http://localhost:" + this.context.getBean("port") + "/user/hello",
                String.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("hello", entity.getBody());

        ResponseEntity<String> httpsEntity = template
                .getForEntity("https://localhost:" + this.port + "/user/hello", String.class);
        assertEquals(HttpStatus.OK, httpsEntity.getStatusCode());
        assertEquals("hello", httpsEntity.getBody());

    }

}
