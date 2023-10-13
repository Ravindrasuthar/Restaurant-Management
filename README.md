# Project Name
Restaurant-Management

# Frameworks and Language Used
**Spring Boot** 3.1.4
**Java** 17
**Maven** 3.8.1

# Data Flow


_**Controller:**_ The controller has endpoints for signup and signin for user and admin, add foodItem, get foodItem, add order, get orders, get order by id. The @PostMapping annotation is used for the admin/signup, admin/login, user/signup, user/signin, admin/add/foodItem, user/place/order endpoint to handle HTTP POST requests with a JSON request body containing a Entity object. 
```
@PostMapping("admin/signup")
    public String AdminSignUp(@RequestBody Admin admin)
    {
        return adminService.AdminSignUp(admin);
    }

    @PostMapping("admin/signin")
    public String AdminSignIn(@RequestBody SignInInputDto signInInput)
    {
        return adminService.AdminSignIn(signInInput);
    }

    @PostMapping("admin/add/foodItem")
    public String AddFoodItem(@RequestBody FoodItemDto foodItemDto)
    {
        return foodItemService.AddFoodItem(foodItemDto.getSignInInputDto(),foodItemDto.getFoodItem());
    }
```
```
@PostMapping("user/signup")
    public String UserSignUp(@RequestBody User user)
    {
        return userService.UserSignUp(user);
    }

    @PostMapping("user/signin")
    public String UserSignIn(@RequestBody SignInInputDto signInInput)
    {
        return userService.UserSignIn(signInInput);
    }

    @PostMapping("user/place/order")
    public String UserOrder(@RequestBody OrderDto orderDto)
    {
        return userOrderService.UserOrder(orderDto.getSignInInputDto(),orderDto.getUserOrder());
    }
```

The @GetMapping annotation is used for the users, admin/food/items, orders, admin/order/{id}, user/food/items, user/order/{id} and visitor/food/items endpoints to handle HTTP GET requests with and without a path variable for the order id. The @PathVariable annotation is used to extract the order ID from the request URL and pass it to the required method.
```
 @GetMapping("users")
    public List<User> GetAllUsers()
    {
        return userService.GetAllUsers();
    }

    @GetMapping("admin/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }

    @GetMapping("orders")
    public List<UserOrder> GetAllOrders()
    {
        return userOrderService.GetAllOrders();
    }

    @GetMapping("admin/order/{id}")
    public UserOrder GetOrderById(@PathVariable Integer id)
    {
        return userOrderService.GetOrderById(id);
    }
```
```
 @GetMapping("user/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }

    @GetMapping("user/order/{id}")
    public UserOrder GetOrderById(@PathVariable Integer id)
    {
        return userOrderService.GetOrderById(id);
    }
```
```
 @GetMapping("visitor/food/items")
    public List<FoodItem> GetAllFoodItems()
    {
        return foodItemService.GetAllFoodItems();
    }
```

The controller class also has an autowired instance of the UserService, AdminService, FoodItemService, UserOrderService interface to handle business logic for the Restaurant-Management App.

This implementation demonstrates a basic setup for a REST API controller in Spring Boot, but it can be expanded upon and customized based on specific requirements for the Restaurant-Management App.

_**Services**:_ The services layer contains the business logic of the application. It receives requests from the controller, performs necessary computations or data manipulations, and interacts with the repository layer to access data.
```
@Service
public class AdminService {

    @Autowired
    IAdminRepo adminRepo;
```
```
@Service
public class FoodItemService {

    @Autowired
    IFoodItemRepo foodItemRepo;

    @Autowired
    IAdminRepo adminRepo;
```
```
@Service
public class UserService {

    @Autowired
    IUserRepo userRepo;
```
```
@Service
public class UserOrderService {

    @Autowired
    IUserOrderRepo userOrderRepo;

    @Autowired
    IUserRepo userRepo;
```

I have used PasswordEncryptor class to encrypt the password send by admin or user for security.
```
public class PasswordEncryptor {

    public static String encrypt(String unHashedPassword) throws NoSuchAlgorithmException {
        MessageDigest md5=MessageDigest.getInstance("MD5");

        md5.update(unHashedPassword.getBytes());
        byte[]digested=md5.digest();
        return DatatypeConverter.printHexBinary(digested);

    }
}
```

_**Repository:**_ The repository layer is responsible for interacting with the database. It uses Spring Data JPA to perform CRUD (create, read, update, delete) operations on entities.

In the application.properties all the text required for connection with MySQL database are written.
```
spring.datasource.url=jdbc:mysql://localhost:3306/Restaurant_App
spring.datasource.username=root
spring.datasource.password=Ravi.067456
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update

spring.jpa.properties.hibernate.show_sql=true
spring.jpa.properties.hibernate.use_sql_comments=true
spring.jpa.properties.hibernate.format_sql=true
```

# Database Structure Used
I have used MySQL as DataBase.

# Project Summary
In this project i have create different endpoints, created custom finders and used mappings between models like @OneToOne.
