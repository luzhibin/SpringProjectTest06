package demo1;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class GoodsTest {
    @Resource(name = "goodsDao")
    private GoodsDao goodsDao;
    @Test
    public void test(){
        System.out.println("-------------");
        goodsDao.save();
        goodsDao.update();
        goodsDao.delete();
        goodsDao.find();
    }
}
