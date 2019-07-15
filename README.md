# springboot-thymeleaf
springboot整合thymeleaf的demo

下面是几个需要注意的地方:
* 如果希望方法返回值是String时是跳转到指定页面(xxx.html),Controller层应该使用@Controller注解,而不是@RestController
* springboot默认的目录是/resources/static,所以在使用具体的目录时只需要以staic的下一个子目录开始即可。如:/resources/static/jquery/jquery-1.7.2.js,在使用Thymeleaf表示路径地址时的格式: th:src="@{/jquery/jquery-1.7.2.js}"
* 如果直接通过url就可以访问到index.html,只需要把index.html放在static目录下即可,即:/static/index.html




