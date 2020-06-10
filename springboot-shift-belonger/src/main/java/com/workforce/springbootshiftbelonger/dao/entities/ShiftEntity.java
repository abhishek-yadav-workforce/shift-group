package com.workforce.springbootshiftbelonger.dao.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "shift", indexes = { @Index(name = "shift_code_IX", columnList = "code", unique = true) })
public class ShiftEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, precision = 10)
    private int id;

    @Column(unique = true, nullable = false, length = 45)
    private String code;

    @OneToMany(mappedBy = "shift")
    private Set<ShiftGroupingEntity> shiftGrouping;

}
