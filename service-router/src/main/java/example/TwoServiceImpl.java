package example;

import org.springframework.stereotype.Service;

/**
 * @Author Yan
 * @Description
 * @Date 2020/6/11 10:03 下午
 */
@Service
public class TwoServiceImpl implements RouterService{
    @Override
    public boolean matching(Integer param) {
        return param == 2;
    }

    @Override
    public void excute() {
        System.out.println(2);
    }
}
