package com.example.composthub.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "purchase_order_item")
public class PurchaseOrderItem extends BaseEntity {
}
