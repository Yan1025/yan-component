package example;

import component.FactoryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Yan
 * @Description
 * @Date 2020/6/11 9:23 下午
 */
@RestController
public class RouterController {
    @Autowired
    private FactoryList<Integer, RouterService> factoryList;

    @GetMapping("routertest")
    public void routertest() {
        RouterService routerService = factoryList.getBean(2);
        System.out.println(routerService);
    }
}
