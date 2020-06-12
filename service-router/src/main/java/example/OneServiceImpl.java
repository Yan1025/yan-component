package example;

import org.springframework.stereotype.Service;

/**
 * @Author Yan
 * @Description
 * @Date 2020/6/11 9:27 下午
 */
@Service
public class OneServiceImpl implements RouterService{
    @Override
    public boolean matching(Integer param) {
        return param == 1;
    }

    @Override
    public void excute() {
        System.out.println(1);
    }
}
