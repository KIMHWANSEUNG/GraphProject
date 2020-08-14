package com.homework.Repository.mapper;

import com.homework.Repository.VO.ChartJSVO;
import com.homework.Repository.VO.GoogleChartVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface GraphMapper {
    List<ChartJSVO> GraphData1();
    List<ChartJSVO> GraphData2();

    List<GoogleChartVO> googlechart();

}
