package com.spring.cyclists.config;


import com.spring.cyclists.model.RankDAO;
import com.spring.cyclists.model.RankDAOImpl;
import com.spring.cyclists.service.RankService;
import com.spring.cyclists.service.RankServiceImpl;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

// @Configuration - žymi konfigūracijos komponentą
// viduje leidžia kurti bean per metodus su @Bean
@Configuration
public class SpringConfig {

	// Bean- tai objektai, kurie sudaro Spring aplikacijos pagrindą.
	// Paprastai tai Java klasė, realizuojanti tam tikrą interfeisą ir JavaBean specifikaciją.
	// Bean atitinka Singleton šabloną - programinės įrangos projektavimo schema,
	// kuri riboja klasės įvykdymą vienu „vieninteliu“ egzemplioriumi.
	// Tai naudinga, kai reikia tiksliai vieno objekto, norint koordinuoti veiksmus visoje sistemoje.
	@Bean

	// @Qualifier anotacija kartu su @Autowired patikslina su kuriuo konkrečiai bean susieti priklausomybę.
	// Jeigu @Configuration klasėje yra daugiau negu vienas bean, @Qualifier anotacija yra privaloma,
	// kitu atveju metama klaida:
	// 'Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans,
	// or using @Qualifier to identify the bean that should be consumed'
	@Qualifier("RankDAOImpl")
	public RankDAO getRankDAO() {
		return new RankDAOImpl();
	}

	@Bean
	@Primary
	@Qualifier("RankServiceImpl")
	public RankService getRankService() {
		return new RankServiceImpl();
	}

}
