package com.sap.academy.production.service.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity(name="PRODUCTION_ORDER_HEADER")
//@Table(name="PRODUCTION_ORDER_HEADER")
public class ProductionOrderHeader implements Serializable{
    @Id
    @Column(name="DOCUMENT_ID", length=50, nullable=false, unique=false)
    String documentId;
    @Column(name="ORDER_NUMBER", length=50, nullable=false, unique=false)
    String orderNumber;
    @Column(name="START_DATE", nullable=false, unique=false)
    LocalDate finishDate;
    @Column(name="FINISH_DATE", nullable=false, unique=false)
    LocalDate startDate;
    @Column(name="SCHEDULED_START_DATE", nullable=false, unique=false)
    LocalDate scheduledStartDate;
    @Column(name="QUANTITY", length=50, nullable=false, unique=false)
    Double quantity;
    @Column(name="UNIT_OF_MEASURE", length=50, nullable=false, unique=false)
    String unitOfMeasure;
    @Column(name="STATUS", length=50, nullable=false, unique=false)
    String status;

    @OneToMany(mappedBy="productionOrderHeader", fetch = FetchType.EAGER,cascade = {CascadeType.ALL})
    private Set<ProductionOrderItem> items;

    public ProductionOrderHeader() {
    }

    public ProductionOrderHeader(ProductionOrderHeader productionOrderHeader) {
        this.documentId = productionOrderHeader.documentId;
        this.orderNumber = productionOrderHeader.orderNumber;
        this.finishDate = productionOrderHeader.finishDate;
        this.startDate = productionOrderHeader.startDate;
        this.scheduledStartDate = productionOrderHeader.scheduledStartDate;
        this.quantity = productionOrderHeader.quantity;
        this.unitOfMeasure = productionOrderHeader.unitOfMeasure;
        this.status = productionOrderHeader.status;
        this.items = productionOrderHeader.items;
    }

    public ProductionOrderHeader(com.sap.academy.production.api.models.ProductionOrderHeader productionOrderHeader) {
        this.documentId = productionOrderHeader.getDocumentId();
        this.orderNumber = productionOrderHeader.getOrderNumber();
        this.finishDate = productionOrderHeader.getFinishDate();
        this.startDate = productionOrderHeader.getStartDate();
        this.scheduledStartDate = productionOrderHeader.getScheduledStartDate();
        this.quantity = productionOrderHeader.getQuantity();
        this.unitOfMeasure = productionOrderHeader.getUnitOfMeasure();
        this.status = productionOrderHeader.getStatus();
        this.items = ProductionOrderItem.toEntitySet(productionOrderHeader.getItems(), this);
    }

    public com.sap.academy.production.api.models.ProductionOrderHeader toModel() {
        com.sap.academy.production.api.models.ProductionOrderHeader productionOrderHeader = new com.sap.academy.production.api.models.ProductionOrderHeader();
        productionOrderHeader.setDocumentId(this.getDocumentId());
        productionOrderHeader.setOrderNumber(this.getOrderNumber());
        productionOrderHeader.setFinishDate(this.getFinishDate());
        productionOrderHeader.setStartDate(this.getStartDate());
        productionOrderHeader.setScheduledStartDate(this.getScheduledStartDate());
        productionOrderHeader.setQuantity(this.getQuantity());
        productionOrderHeader.setUnitOfMeasure(this.getUnitOfMeasure());
        productionOrderHeader.setStatus(this.getStatus());
        productionOrderHeader.setItems(ProductionOrderItem.toModelSet(this.getItems()));
        return productionOrderHeader;
    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getScheduledStartDate() {
        return scheduledStartDate;
    }

    public void setScheduledStartDate(LocalDate scheduledStartDate) {
        this.scheduledStartDate = scheduledStartDate;
    }

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Set<ProductionOrderItem> getItems() {
        return items;
    }

    public void setItems(Set<ProductionOrderItem> items) {
        this.items = items;
    }
}
