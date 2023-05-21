# CaptoleConsulting
Captole Consulting exercise

# How to run it
1. Make sure that you have Java 17 ```$ sdk use java 17.0.7-tem```
2. Build ```$ ./mvnw clean install```
3. Run ```$ ./mvnw spring-boot:run```

# Explicación
A continuación una breve explicación sobre la resolución del ejercicio

## Base de datos H2 y Flyway
La idea del ejercicio era utilizar una base de datos H2, asi que se agrega esto en el archivo ```pom.xml``` para luego 
agregar sus estructuras y datos en ```data.sql```. Si fuera el caso que la estructura de la base de datos es mas 
grande, se podria dividir un archivo para la estructura y otro para la ingesta de datos. Al ser un ejemplo simple, 
lo agregué todo junto. 

Definí tres tablas llamadas ```Brand```, ```Product``` y ```Price``` para dividir mejor las entidades. Todas poseen 
su ```FK``` para referenciarse. Si esto fuera una base de datos productiva, desde ya que habría que agregar índices 
para realizar las consultas productivas. En este caso, no los agregué ya que son pocos registros. 

## Repositorios y servicios
Cada entidad tiene su definición en ```Entities``` donde se levanta cada dato utilizando anotaciones como ```@Id``` 
o ```@Column``` para referirse a la tabla. Luego, para no escribir getters y setters inecesarios, agregé la libreria 
```Lombok``` que te permite tenerlos sin ensuciar el código. También para referenciarse a las otras entidades, utilizo 
```@OneToOne```.

Para referirnos y levantar cada dato, utilizamos ```Repository``` de cada uno ya que es la forma más fácil para 
acceder a un dato y permite generar búsquedas dinámicas como la agregada en ```Price``` llamada 
```findByBrandAndProduct```. También poseemos un ```Service``` que nos permite utilizar métodos para interactuar con 
cada entidad. Por ejemplo, ```PriceService``` posee el método ```getPriceAtThisMoment``` que nos va a poder premitir 
responder las consultas del problema. Todos se cargan utilizando ```@Autowired```, o sea injección de dependencias.

Para responder las consultas de problema, se creó el método nombrado anteriormente  
```PriceService.getPriceAtThisMoment``` que toma como parámetro ```brand_id``` y ```product_id```. Primero busca 
estos dos utilizando sus respectivos repositories. Luego, se utiliza el método en ```Price``` buscando por estos dos 
(```findByBrandAndProduct```). Este puede no estar presente, es por eso que devuelve un Optional. Para filtrar por 
fechas, utilizamos ```stream()``` y ```filter()``` preguntando que este entre start_date y end_date. Y para terminar,
tomamos el precio que tenga mayor priority. En este código, se usan varias funciones nuevas de Java.

## PriceController
En esta clase, definimos el endpoint que se va a utilizar para realizar las consultas. Este transforma los datos de 
parámetros y consulta a ```priceService.getPriceAtThisMoment```. Devolvemos un ```ObjectNode``` ya que es un objeto 
flexible para devolver JSON. 

## ControllerAdvicer
Puede ser que querramos mostrar un mensaje de error en ciertas excepciones. Es por eso que se agregó un 
ControllerAdvicer en ```RestResponseEntityExceptionHandler```.

## Tests unitarios y de integración
El ejercicio pedía realizar tests al endpoint creado, es por esto que se agregaron tests en 
```CaptoleConsultingApplicationTests``` donde se agregaron los tests pedidos chequeando sus resultados. Al tener 
todos los tests una misma estructura, se encapsuló el método principal en un método privado. 

Estos tests levantan el controller y le realizan un pedido a la API, para luego chequear su valor. Se podría hacer 
los tests más liviano solamente chequeando este método y levantando solo su Bean, pero no estariamos chequenado la 
parte del Controller. 
