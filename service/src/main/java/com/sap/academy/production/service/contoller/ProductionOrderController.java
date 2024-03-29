package com.sap.academy.production.service.contoller;


import com.google.gson.Gson;
import com.sap.academy.production.api.models.ProductionOrderHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sap.academy.dbhandler.TechnicalContext;
import com.sap.academy.dbhandler.TechnicalContextHolder;

@RestController
@RequestMapping("/productionorder")
public class ProductionOrderController {
    @Autowired
    ProductionOrderService productionOrderService;

    @PostMapping("/createorder")
    public ResponseEntity<String> newProductionOrder(@RequestHeader(value="tenantId") String tenantId, @RequestHeader(value="userId") String userId, @RequestBody ProductionOrderHeader productionOrderHeader) {
        setTechnicalContext(tenantId,userId);
        ProductionOrderHeader productionOrderHeader1 = productionOrderService.createProductionOrder(productionOrderHeader);
        Gson gson = new Gson();
        return new ResponseEntity<String>(gson.toJson(productionOrderHeader1).toString(), HttpStatus.CREATED);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<String> getById(@RequestHeader(value="tenantId") String tenantId,@RequestHeader(value="userId") String userId,@PathVariable(required = true) String id)  {
        ProductionOrderHeader productionOrderHeader = null;
        try {
            setTechnicalContext(tenantId,userId);
            productionOrderHeader = productionOrderService.getById(id);
            Gson gson = new Gson();
            return new ResponseEntity<String>(gson.toJson(productionOrderHeader).toString(),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/deleteorder/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteById(@RequestHeader(value="tenantId") String tenantId,@RequestHeader(value="userId") String userId,@PathVariable(required = true) String id)  {
        ProductionOrderHeader productionOrderHeader = null;
        try {
            setTechnicalContext(tenantId,userId);
            productionOrderService.deleteProductionOrder(id);
            return new ResponseEntity<String>(HttpStatus.ACCEPTED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<String>("Not Found",HttpStatus.NOT_FOUND);
        }
    }

    private void setTechnicalContext(String tenantId,String userId){
        TechnicalContext technicalContext = new TechnicalContext();
        technicalContext.setTenantId(tenantId);
        technicalContext.setUserId(userId);
        TechnicalContextHolder.setTechnicalContext(technicalContext);
    }
}
