package com.sap.academy.production.service.contoller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Optional;

@Component
public class ProductionOrderService {
    @Autowired
    ProductionOrderRepository productionOrderRepository;

    public com.sap.academy.production.api.models.ProductionOrderHeader createProductionOrder(com.sap.academy.production.api.models.ProductionOrderHeader productionOrderHeader) {
        com.sap.academy.production.service.entities.ProductionOrderHeader productionOrderHeader1 = new com.sap.academy.production.service.entities.ProductionOrderHeader(productionOrderHeader);
        productionOrderRepository.save(productionOrderHeader1);
        return productionOrderHeader;
    }

    public void deleteProductionOrder(String productionOrderHeaderId) {
        productionOrderRepository.deleteById(productionOrderHeaderId);
    }

    public com.sap.academy.production.api.models.ProductionOrderHeader getById(@PathVariable(required = true) String id) throws Exception {
        //com.sap.academy.production.api.models.ProductionOrderHeader productionOrderHeader = null;
        try {
            Optional<com.sap.academy.production.service.entities.ProductionOrderHeader> productionOrderHeaderOptional = productionOrderRepository.findById(id);
            com.sap.academy.production.service.entities.ProductionOrderHeader productionOrderHeaderTemp = productionOrderHeaderOptional.orElseThrow(()->new Exception("Production order not found!"));
            return productionOrderHeaderTemp.toModel();
        } catch (Exception e) {
            throw e;
        }
    }
}
