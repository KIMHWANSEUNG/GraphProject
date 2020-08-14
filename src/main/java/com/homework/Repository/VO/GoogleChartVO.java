package com.homework.Repository.VO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GoogleChartVO {
    String product;
    String date1;
    int sum1;

}
