package savogineros.Gestioneeventi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;

@SpringBootApplication
public class GestioneEventiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestioneEventiApplication.class, args);
		System.out.println(LocalDate.of(2012, 5, 23));
		System.out.println(LocalDate.now());
		System.out.println(LocalDate.parse("2022-05-11"));
	}

}
