package com.avicsafety.webapp.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.avicsafety.webapp.entity.Article;
import com.avicsafety.webapp.entity.Building;
import com.avicsafety.webapp.entity.BuildingUser;
import com.avicsafety.webapp.entity.Community;
import com.avicsafety.webapp.entity.Dictionary;
import com.avicsafety.webapp.entity.Member;
import com.avicsafety.webapp.entity.MemberLevel;
import com.avicsafety.webapp.entity.MemberPrize;
import com.avicsafety.webapp.entity.Menu;
import com.avicsafety.webapp.entity.MenuCate;
import com.avicsafety.webapp.entity.Order;
import com.avicsafety.webapp.entity.Role;
import com.avicsafety.webapp.entity.SafetyArticle;
import com.avicsafety.webapp.entity.SmartTips;
import com.avicsafety.webapp.entity.User;
import com.avicsafety.webapp.entity.WebAttachments;

@Configuration  
public class WebConfig {
	private CorsConfiguration buildConfig() {  
        CorsConfiguration corsConfiguration = new CorsConfiguration();  
        corsConfiguration.addAllowedOrigin("*"); // 1  
        corsConfiguration.addAllowedHeader("*"); // 2  
        corsConfiguration.addAllowedMethod("*"); // 3  
        return corsConfiguration;  
    }  
	
	@Bean  
    public CorsFilter corsFilter() {  
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
        source.registerCorsConfiguration("/**", buildConfig()); // 4  
        return new CorsFilter(source);  
    }  
	
	/**
	 * 为了解决Spring Data Rest不暴露ID字段的问题。
	 * 参考：http://tommyziegler.com/how-to-expose-the-resourceid-with-spring-data-rest/
	 * Created by Dante on 2016/8/18.
	 */
	@Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {

        return new RepositoryRestConfigurerAdapter() {
            @Override
            public void configureRepositoryRestConfiguration(
                    RepositoryRestConfiguration config) {
	                config.exposeIdsFor(User.class);
	                config.exposeIdsFor(Role.class);
	                config.exposeIdsFor(Menu.class);
	                config.exposeIdsFor(MenuCate.class);
	                config.exposeIdsFor(Dictionary.class);
	                config.exposeIdsFor(Order.class);
	                config.exposeIdsFor(Community.class);
	                config.exposeIdsFor(Building.class);
	                config.exposeIdsFor(BuildingUser.class);
	                config.exposeIdsFor(Member.class);
	                config.exposeIdsFor(MemberLevel.class);
	                config.exposeIdsFor(MemberPrize.class);
	                config.exposeIdsFor(Article.class);
	                config.exposeIdsFor(SmartTips.class);
	                config.exposeIdsFor(SafetyArticle.class);
	                config.exposeIdsFor(WebAttachments.class);
            }
        };
    }

	
}
