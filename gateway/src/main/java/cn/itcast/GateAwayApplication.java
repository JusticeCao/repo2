package cn.itcast;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class GateAwayApplication {

    public static void main(String[] args) {

        SpringApplication.run(GateAwayApplication.class);

    }


}
   /* class Demo extends ZuulFilter {


        @Override
        public String filterType() {   //过滤器类型
            return null;
        }

        @Override
        public int filterOrder() {  //过滤器顺序(优先级)
            return 0;
        }

        @Override
        public boolean shouldFilter() {
            return false;  // 来自ZuulFilter,要不要过滤
        }

        @Override
        public Object run() throws ZuulException {
            return null;   // 过滤逻辑
        }
    }*/
