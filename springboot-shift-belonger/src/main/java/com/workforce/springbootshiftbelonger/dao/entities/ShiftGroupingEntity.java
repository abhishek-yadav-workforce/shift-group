package com.workforce.springbootshiftbelonger.dao.entities;

import java.io.Serializable;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "shift_grouping")
@Cacheable
public class ShiftGroupingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    /** Primary key. */
    protected static final String PK = "id";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false, precision = 10)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_group_code", nullable = false)
    private GroupEntity shiftGroup;

    @ManyToOne(optional = false)
    @JoinColumn(name = "shift_code", nullable = false)
    private ShiftEntity shift;

}
