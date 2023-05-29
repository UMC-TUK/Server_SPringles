package com.umc.market.domain.product.entity;

import com.umc.market.domain.category.entity.Categorys;
import com.umc.market.global.common.BaseEntity;
import javax.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import java.util.UUID;
import static javax.persistence.FetchType.LAZY;

@Getter
@AllArgsConstructor
@Entity
@Setter
@Builder
@NoArgsConstructor
@Table(name="products")
public class Products extends BaseEntity {


    @Id
    @Column(name = "id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private Users users;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "categorys")
    private Categorys categorys;

    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "product_uuid" ,length = 36, nullable = false, updatable = false)  // uuid 나중에 추가
    private UUID productUUID ;

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


    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }


}
