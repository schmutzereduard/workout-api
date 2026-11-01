package com.resolvedd.workoutapi.model;

import com.resolvedd.workoutapi.model.enums.WeightUnit;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@Table(name = "user_preferences")
public class UserPreferences extends SyncableEntity{

    @Column(name = "weight_unit", nullable = false)
    private WeightUnit weightUnit;

    @Column(name = "progressive_overload_increment", precision = 5, scale = 2, nullable = false)
    private BigDecimal progressiveOverloadIncrement;

    @Column(name = "deload_volume_percentage", nullable = false)
    private Integer deloadVolumePercentage;

    @Column(name = "deload_intensity_percentage", nullable = false)
    private Integer deloadIntensityPercentage;

    @Column(name = "background_color", nullable = false)
    private String backgroundColor;

    @Column(name = "accent_color", nullable = false)
    private String accentColor;
}
