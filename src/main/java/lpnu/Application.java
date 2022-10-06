package lpnu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


/*
 1.11 - дописати та потестити юзера

 8.11 - custom exception handler
 8.11 - spring validation

 8.11 - робота оператора
 8.11 - купівля палива

 15.11 - Lombok
 15.11 - оцінка часу та декомпозиція задач
 15.11 - збереження даних у файл
 15.11 - робота з пальним

 22.11 - основи Agile/Scrum/Kanban
 22.11 - custom validation annotation
 22.11 - email - надіслати туторіал
 22.11 - купівля товарів

 29.11 - base unit tests
 29.11 - base integration tests
 29.11

    доробити:   orderserviceimpl - get best item і юніт тести для того
                скинути туторіал по Hamcrest
                скинути "прибирання після int тестів"

 6.12 - консультація
 6.12 - паттерни
 6.12 - jMeter


 backlog:


  - base git commands
  - створення бібліотеки
  - замовлення палива
  - створення чеку
  - пропонування товарів
  - картки знижок (іт-клаб)
  - заповнити README.md
  - validate PathVariables and RequestParams
 */

/*
   + 1. Взаємодія між програмами
   + 2. Що таке сервер?
   + 3. Клієнт-сервер
   + 4. Мікросервіси
   + 5. HTTP
   + 6. REST
   + 7. JSON
   + 8. Maven
   + 9. Spring boot
   + 10. n-tier архітектура
   + 11. use case - діаграми

    in cmd -> netstat - покаже усі зайняті порти

    ubuntu:
        netstat -tulpn
        kill -9 process_id

   DTO
   finish with users
 */