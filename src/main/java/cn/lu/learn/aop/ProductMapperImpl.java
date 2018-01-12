package cn.lu.learn.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lutiehua
 * @date 2018/1/12
 */
@Component
public class ProductMapperImpl implements ProductMapper {

    private final Logger logger = LoggerFactory.getLogger(ProductMapperImpl.class);

    private Map<Long, Product> productMap = new HashMap<>();

    public ProductMapperImpl() {
        Product product = new Product();
        product.setProductId(1L);
        product.setProductName("产品1");
        productMap.put(product.getProductId(), product);

        product = new Product();
        product.setProductId(2L);
        product.setProductName("产品2");
        productMap.put(product.getProductId(), product);
    }


    @Override
    public Product select(long productId) {
        logger.info("select {}", productId);
        return productMap.get(productId);
    }
}
