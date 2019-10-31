package com.sap.academy.production.service.contoller;

import com.sap.academy.production.service.entities.ProductionOrderHeader;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductionOrderRepository  extends JpaRepository<ProductionOrderHeader,String> {
}
