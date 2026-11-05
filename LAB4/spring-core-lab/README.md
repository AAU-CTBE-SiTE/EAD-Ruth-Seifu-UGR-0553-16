# Spring Core IoC and Bean Management Lab

This project follows the final combined example in the supplied lab PDF, using annotation-based configuration:
- `AppConfig` is a `@Configuration` class with `@ComponentScan("com.craft")`; `App` loads it with `AnnotationConfigApplicationContext`
- `Student`, `Address`, and the two `Subject` beans are created by the Spring IoC container
- `Student` receives literals through `@Value`, an `Address` bean, and a `List<Subject>` collection through constructor injection
- The two `Subject` beans (`math` and `javaSubject`) are declared with `@Bean` methods, since two beans of the same class cannot both come from `@Component`

## Run in IntelliJ IDEA
1. Extract this folder.
2. Open the `spring-core-lab` folder in IntelliJ IDEA.
3. Reload Maven dependencies.
4. Set the project SDK and Maven importer JDK to Java 19.
5. Run `src/main/java/com/craft/App.java`.

Expected output includes the student details, Addis/Ethiopia address, and the two subjects.

## Bean scope check from the PDF
`@Component` beans are singleton-scoped by default, so two calls to `context.getBean(Student.class)` return the same reference.
To demonstrate prototype scope, add `@Scope("prototype")` to the `Student` class next to `@Component`.
