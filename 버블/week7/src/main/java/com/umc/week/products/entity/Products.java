package com.umc.week.products.entity;

import com.umc.week.category.entity.Categorys;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

import static javax.persistence.FetchType.LAZY;

@Getter
@AllArgsConstructor
@Entity
@Builder
@NoArgsConstructor
public class Products {

    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categorys")
    private Categorys categorys;

    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "product_uuid" ,length = 36, nullable = false, updatable = false)  // uuid 나중에 추가
    private UUID productUuid ;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProductState productState ;

    @Column(name = "views", nullable = false)
    private int views;




}
