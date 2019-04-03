package net.jayanth.springbootistiogke;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringbootIstioGkeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootIstioGkeApplication.class, args);
	}

	@Bean
	ApplicationRunner init(CardRepository repository) {
		//Dummy Card Numbers
		Object[][] data = {
				{"1", "5555555555554444", "MasterCard", "Jayanth"},
				{"1", "4111111111111111", "Visa", "Pradeep"},
				{"1", "378282246310005", "American Express", "Karthik"},
				{"1", "30569309025904", "Diners Club", "Guruprasad"}
		};

		return args ->
		repository
		.deleteAll()
		.thenMany(
			Flux
					.just(data)
					.map(array -> {
						return new Card((String) array[0], (String) array[1], (String) array[2], (String) array[3]);
					})
					.flatMap(repository::save)
		)
		.thenMany(repository.findAll())
		.subscribe(kayak -> System.out.println("saving " + kayak.toString()));
	}
}
