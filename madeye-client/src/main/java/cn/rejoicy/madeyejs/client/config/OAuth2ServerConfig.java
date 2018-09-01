//package cn.rejoicy.madeyejs.client.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//public class OAuth2ServerConfig {
//
//    private static final String DEMO_RESOURCE_ID = "order";
//
//    @Configuration
//    @EnableResourceServer
//    protected static class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
//
//        @Override
//        public void configure(ResourceServerSecurityConfigurer resources) {
//            resources.resourceId(DEMO_RESOURCE_ID).stateless(true);
//        }
//
//        @Override
//        public void configure(HttpSecurity http) throws Exception {
//            // @formatter:off
//            http
//                    // Since we want the protected resources to be accessible in the UI as well we need
//                    // session creation to be allowed (it's disabled by default in 2.0.6)
//                    .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
//                    .and()
//                    .requestMatchers().anyRequest()
//                    .and()
//
//                    .anonymous()
//                    .and()
//                    .authorizeRequests()
//                    .antMatchers("/api/**").authenticated();
//            // @formatter:on
//        }
//    }
//
//
//    @Configuration
//    @EnableAuthorizationServer
//    protected static class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//        @Autowired
//        AuthenticationManager authenticationManager;
//
//        @Autowired
//        RedisConnectionFactory redisConnectionFactory;
//
//        @Override
//        public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//            //配置两个客户端,一个用于password认证一个用于client认证
//            clients.inMemory().withClient("client_1")
//                    .resourceIds(DEMO_RESOURCE_ID)
//                    .authorizedGrantTypes("client_credentials", "refresh_token")
//                    .scopes("select")
//                    .authorities("client")
//                    .secret("123456")
//                    .and().withClient("client_2")
//                    .resourceIds(DEMO_RESOURCE_ID)
//                    .authorizedGrantTypes("password", "refresh_token")
//                    .scopes("select")
//                    .authorities("client")
//                    .secret("123456");
//        }
//
//        @Override
//        public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//            endpoints
//                    .tokenStore(new RedisTokenStore(redisConnectionFactory))
//                    .authenticationManager(authenticationManager);
//        }
//
//        @Override
//        public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//            //允许表单认证
//            oauthServer.allowFormAuthenticationForClients();
//        }
//
//    }
//
//}