package com.avicsafety.webapp.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.approval.ApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenApprovalStore;
import org.springframework.security.oauth2.provider.approval.TokenStoreUserApprovalHandler;
import org.springframework.security.oauth2.provider.approval.UserApprovalHandler;
import org.springframework.security.oauth2.provider.request.DefaultOAuth2RequestFactory;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

@Configuration
@EnableAuthorizationServer
public class SecurityOauth2Config extends AuthorizationServerConfigurerAdapter {

	private static String REALM = "MY_OAUTH_REALM";

	@Autowired
	private UserApprovalHandler userApprovalHandler;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private TokenStore tokenStore;

	@Autowired
	private UserDetailsService userService;

	@Autowired
	private ClientDetailsService clientDetailsService;

	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		
		// 客户端详情服务
		clients.inMemory().withClient("13890999")
				.authorizedGrantTypes("password", "authorization_code", "refresh_token", "implicit")
				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT").scopes("read", "write", "trust").secret("secret_oas1QAZ")
				.accessTokenValiditySeconds(10).// Access token is only valid for 2 minutes.
				refreshTokenValiditySeconds(600);// Refresh token is only valid for 10 minutes.

		// curl https://localhost:8080/oauth/token -k -d client_id=13890999 -d
		// client_secret=secret -d grant_type=password -d username=shili -d
		// password=zzz123
		// C:\curl75\AMD64>curl http://localhost:8080/oauth/token -d client_id=13890999
		// -d client_secret=secret -d grant_type=password -d username=shili -d
		// password=zzz123
		// http://localhost:8433/oauth/authorize?client_id=13890999&response_type=code&redirect_uri=http://localhost:8433
		// C:\curl75\AMD64>curl "http://localhost:8080/oauth/token" -d
		// "client_id=13890999&client_secret=secret&grant_type=authorization_code&code=KYrtyE&redirect_uri=http://localhost:8080"
		// C:\curl75\AMD64>curl "http://localhost:8080/sayhello" -d
		// "access_token=b6223ba2-a9cf-48ab-bd12-6604d4052624"
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(tokenStore).userApprovalHandler(userApprovalHandler)
				.authenticationManager(authenticationManager).userDetailsService(userService);
	}

	@Bean
	public TokenStore tokenStore() {
		return new InMemoryTokenStore();
	}

	@Bean
	@Autowired
	public TokenStoreUserApprovalHandler userApprovalHandler(TokenStore tokenStore) {
		TokenStoreUserApprovalHandler handler = new TokenStoreUserApprovalHandler();
		handler.setTokenStore(tokenStore);
		handler.setRequestFactory(new DefaultOAuth2RequestFactory(clientDetailsService));
		handler.setClientDetailsService(clientDetailsService);
		return handler;
	}

	@Bean
	@Autowired
	public ApprovalStore approvalStore(TokenStore tokenStore) throws Exception {
		TokenApprovalStore store = new TokenApprovalStore();
		store.setTokenStore(tokenStore);
		return store;
	}

}
