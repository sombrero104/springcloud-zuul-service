<br/>

# API Gateway
<br/>

## Zuul Service 설정 

~~~
@SpringBootApplication
@EnableZuulProxy
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
~~~

~~~
server:
  port: 8000

spring:
  application:
    name: my-zuul-service

zuul:
  routes:
    first-service:
      path: /first-service/**       # 이 경로로 요청이 들어오면 아래 url로 포워딩. 
      url: http://localhost:8081
    second-service:
      path: /second-service/**      # 이 경로로 요청이 들어오면 아래 url로 포워딩. 
      url: http://localhost:8082
~~~

<br/><br/><br/><br/>