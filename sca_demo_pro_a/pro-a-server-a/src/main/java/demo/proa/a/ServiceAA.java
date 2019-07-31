package demo.proa.a;

import demo.proa.a.clients.IClientAB;
import demo.proa.a.clients.IClientAC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;

/**
 * @Author: penghaoyang
 * @Date: 2019/7/31 13:52
 * @Description: ServiceAA
 */
@Service
public class ServiceAA {

    @Autowired
    private SysPropsAA props;

    @Autowired
    private IClientAB clientAB;

    @Autowired
    private IClientAC clientAC;

    public PojoAA getOne() {
        PojoAA p = new PojoAA();
        p.setFieldAA1(props.getId());
        p.setFieldAA2(Instant.now().toString());
        p.setFieldAA3(Instant.now().getNano());
        p.getFieldAAMap().put("ab", clientAB.getOne());
        p.getFieldAAMap().put("ac", clientAC.getOne());
        return p;
    }

}
