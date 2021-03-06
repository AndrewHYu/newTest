package mock;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author huangyu
 * @date 2017/8/8
 */
public class EasyMockTest {

    @Test
    public void test(){

        List list = EasyMock.createMock(List.class);
        // 录制过程

        // 期望方法list.set(0,1)执行2次，返回null，不抛出异常
        expect1: EasyMock.expect(list.set(0, 1)).andReturn(null).times(2);
        // 期望方法list.set(0,1)执行1次，返回null，不抛出异常
        expect2: EasyMock.expect(list.set(0, 1)).andReturn(1);

        // 执行测试代码
        EasyMock.replay(list);
        // 执行list.set(0,1)，匹配expect1期望，会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect1（因为expect1期望执行此方法2次），会返回null
        Assert.assertNull(list.set(0, 1));
        // 执行list.set(0,1)，匹配expect2，会返回1
        Assert.assertEquals(1, list.set(0, 1));

        // 验证期望
        EasyMock.verify(list);
    }
}
