package com.sap.academy.production.service;


import com.sap.academy.dbhandler.DynamicDeployApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DbDeployer {
    @Autowired
    private DynamicDeployApi dynamicDeployApiImpl;

    @Value("${spring.application.name}")
    private String applicationId;

    public void prepareExistingTenants() {
//        List<String> tenants = dynamicDeployApiImpl.getAllTenants(applicationId);
//        tenants.forEach(tenantId->{
//            try {
//                prepareTenant(tenantId);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
        try {
            prepareTenant("ACA_T5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void prepareTenant(String tenantId) throws Exception {
        dynamicDeployApiImpl.redeployDBModule(tenantId);
//        consumerStarter.bindTenantToConsumer(tenantId);
    }

    public void prepareNewTenant(String tenantId,String databaseId) throws Exception {
        dynamicDeployApiImpl.deployDBModule(databaseId,tenantId);
//        consumerStarter.bindTenantToConsumer(tenantId);
    }
}
