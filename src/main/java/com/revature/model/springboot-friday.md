#Spring boot 
 - focus on all that is different

 spring starter proj
 
 start.spring.io in service url
 
 com.revature
 spring-web
 Demo proj for spring
 package com.revature
 
 proj dependencies
 
 	web
 	validation hit finish
 	
 new class
 
 public class Movies {
 	private String title;
 	private String genre
 	private double rating;
 	
 	// geter and setter
 	
 	// and Constructor and super class
 }
 
 package com.revature.controller;
 
 import stereotype.Controller;
 
 @Controller
 @RequestMapping("/movies")
 public class MovieController {
 
 	@RequestMapping(value="/hello", method=RequestMethod.GET)
 	public String helloWorld() {
 		return "Hello, World!";
 	}									//can run as java app or spring boot
 	
 	//return a response entity
 	@RequestMapping(value="/hello", method=RequestMethod.GET)
 	public ResponseEntity(String> helloWorld() {
 		return ResponseEntity.ok("Hello, World!");
 	}									//can run as java app or spring boot
 	@GetMapping("/{id}")
 	public ResponseEntity<Movie> returnMovie(@PathVariable("id") int id) {
 		return ResposeEntity.ok(new Movie(ud, "Jaws"
 	}
 	
 	@GetMapping("/index")
 	public String getIndex() {
 		return "index.html";  // make a new file in static folder index.html then changeit to 
 	}
 }
 
 
 // proper rest control
 packagee com.revature.controller;
 
 @RestController
 public call MovieRestController {
 
 }
 
 
 
 controller - business logic
 view - represent the data
 model - the different components
 
 
 package com.revature;
 
 import org.springframework.boot.SpringBootApplication;
 
 @SpringBootApplication
 public class SpringwebApplication {
 	public static void main(String [] args) {
 	
 	}
 }
 
 restcontroller is the goto guy
 @GetMapping
 @ResponseBody
 
 in postman do a get request get get the same json in raw or pretty
 
 
 
 @PostMapping("'api/post")
 public Movie createMovie(@RequestBody Movie m) {
 	return m;  // should return movie obj  in the rest api the json obj posted as request and you back an obj
 }
 
 
 how to validate info on web page (ie this field is for password )
 
 validate at every step
 
 
 JSR  Java community process - request for new patch
 
 jsr 303 - bean validation base on annotation
 
 let's try in title
 
 @NotBlank
 @Pattern(regexp="[a-z-A-Z]*")
 private String tite;
 
 @Min(alue=6)
 @Max(value=10)
 private double rating;
 
 
 for html index,html put in templates folder  
 
 
 @GetMapping("/index")
 public Stringindex() 
 	return "index";  // leave this alone
 }
 
 
 com.revature.config  -> doing it the hard way by doing a configuration
 
 @Configuration
 public class WebConfig extends Web {
 	@overrride
 	public void addViewControllers(ViewControllerRegistry registry) {
 		registry.addViewController("/movies/index").setViewName("index")
 	}
 	
 	
 how to put error page - map exception to http err page in Spring
 
 in the Controller
 
 @ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Movies does not exist
 public class MovieNotFoundException extends RunTimeException 
 
 
 
 in Movie controller add
 
 @GetMapping("/ex")
 public MovieexMovie
 	Movie movie = null;
 	if (movie == null)
 		throw new MovieNotFoundException();
 	else
 	   return new Movie();
 	   
 	   
 	   
in movie controller try 

@ResponseStatus(value=HttpStatus.CONFLICT)
@ExceptionHandler(IOException.class)
public ResponseEntity<String> conflict() {
	return ResponseEntity.ok("uh oh, Spagheti-os");  //make our own exception class or a method to handle error
}

in our ex let's throw IOException();


make a global error handler

in controller

import webbind,annotation

@ControllerAdvice
public class GlobalExceptionHandler {
	@ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
	@ExceptionHandler(MovieNotFoundException.class)
	public void handleNoMovie() {
	
	}
	
	
}


forwarding in controller

@GetMaooing("api/{id}")
public String redirect(@PathVariable("id") String
	return "redirect:/movie
	
	
	
now let's start BAck end

new Spring starter proj

add web 

in sql add jpa  (example of spring data)

package com.revature.model;

@Entity
@Table(name="Animals")
public class Animal {
	private int id;
	private String name 
	private int age;
	provate int legs;
	
	@Id
	@Column(name="ID")
	public int getId() {
		return id;
		}
	
	
in repo

@Repository
public interface AnimalDao extends JpaRepository<Animal, Integer> {

}



create a class controller

in controller

@RestController
public class AnimalController {


	@Autowired
	AnimalDao dao;
	
	@GetMapping("/animals")
	public List<Animals> getAll() {
		List<Animal> animals = dao.findAll();
		return animals;		
}
	
	in pom in dependency add oracle driver
	
	com.oracle.jdbc
	
in AnimalDao

spring.datasource.username=zoo
spring.datasource.password=password02
spring.datasource.url=jdbc...
psring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver
spring.jpa.database-platform=org.hibernate.dialect.Oracle10Dialect


in AnimalDao
	Animal finByName(String name);
	
in controller

	public Animal getByNAme(@PathVariabe("name") String name)
	
in AnimalDao

	List<Animal> findAeBetween
	
@GetMaopping("/animals/18-24")
public List<Animal> getBetween1824() {
   return dao.findByAgeBetween(18,24);
   
   
make it transction

@Transaction
List<Animal> finByAgeBetween(Integer min, Int max)


Take a look at spring.io


maven proj

spring-hibernate

in pom 
set up compiler in properties and dependencies oracle jdbc

next spring dependencies

org.springframework

commons-dbcp
commons-dbcp
1.4

org.hibernate
hibernate-entitymanager
4.3.9.Final


new class

pkg com.revature.config;

import org.springframework.transaction.annotation

@Configuration
@ComponentScan("com.revature")
@EnableTransactionManagement
@PropertySource("claspath:application.properties")
public class HibernateConfig
public class HibernateConfig {

	@Autowired
	private Environment env;
	
	@Bean
	public DataSource myDataSource   // import 
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName(driverClassName(env.getProperty("jdbc.driverClassName"));
		dataSource setUrl(env.getPropertyt("jdbc.url");
		
	@Bean
	public LocalSessionFactory sessionFactory() {
		LocalSessionFactoryBean sf = new LocalSessionFacotyBean();
		sf.setDatasource(myDataSource);
		sf.setPackagesToScan(newString[] {"com.revature"});
		Properties hb = new Properties();
		hb.setProperty("hibernate,dialect", env.getProperty("hibernate.dialect"));
		sf.setHibernateproperties(hb);
		
		return sf;
	}
	
	@Bean
	public HibernateTransactionManager transactionManager(sessionFactory sf) {
		
	}
	
	//next make a bean dao
	@Bean
	public AnimalDao animalDao(SessionFactory sf) {
	
	}
}
new file application.property

jdbc.driverClassName=oracle.jdbc.driver.OracleDriver
jdbc.url=jdbc:oracl...
jdbc.username
hibernate


in repo
@Repository
public class AnimalDao {
	private SessionFactory sessionFactory;
	
	private void setSessionFactory(SessionFactory sf) {
		this.sessionFactory = sessionFactory;
	}
	
	@Transaction
	public List<
	
}


create Animal class

in model

@entity
@Table(name="ANIMALS")
public class Animal {
	@Id
	private int id
}


make a driver

public class Driver {

	public static void main(String [] args) {
		AbstractApplicationContext context = newAnnotationConfigApplication
		animalDao dao = context.getBean("animalDao", AnimalDao.class);
		
		System.out.println(dao.getAnimals());
		context.close();
	}
}