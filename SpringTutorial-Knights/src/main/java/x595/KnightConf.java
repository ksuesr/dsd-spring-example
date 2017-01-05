package x595;

import org.springframework.context.annotation.*;

@Configuration public class KnightConf {

	@Bean public Knight getKnight() {
		return new BraveKnight(quest());
	}
	
	@Bean public Quest quest() {
		return new SlayDragonQuest(System.out);
	}
}
