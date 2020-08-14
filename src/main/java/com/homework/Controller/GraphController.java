package com.homework.Controller;


import com.homework.Repository.VO.ChartJSVO;
import com.homework.Repository.VO.GoogleChartVO;
import com.homework.Repository.mapper.GraphMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@Log4j2
@Controller
public class GraphController {
    @Autowired
    GraphMapper graphMapper;

    @RequestMapping(value = "/chartjs")
    public String home(Model model) {

        return "chartjs";
    }

    @ResponseBody
    @RequestMapping("/linechart.ajax")
    public List linechart() {

        List<ChartJSVO> chartJSVO1 = graphMapper.GraphData1();
        List<ChartJSVO> chartJSVO2 = graphMapper.GraphData2();

        //19년도 리스트 담기
        List list19 = new ArrayList();
        for (ChartJSVO vo19 : chartJSVO1) {
            list19.add(vo19.getSum());
        }

        //20년도 리스트 담기
        List list20 = new ArrayList();
        for (ChartJSVO vo20 : chartJSVO2) {
            list20.add(vo20.getSum());
        }

        //리스트 두개를 Array<List>에 담기
        ArrayList<List> sumlist = new ArrayList();
        sumlist.add(list19);
        sumlist.add(list20);


        logger.info("**************");
        logger.info(sumlist);

        return sumlist;
    }

    @RequestMapping(value = "/googlechart")
    public String googlechart() {


        return "googlechart";
    }

    @ResponseBody
    @RequestMapping(value = "googlechart.ajax")
    public List<List> googlechartajax() {
        List<GoogleChartVO> googlechartvo = graphMapper.googlechart();

        List<List> listdata=new ArrayList<>();

        List l0=new ArrayList<>();
        List l1=new ArrayList<>();
        List l2=new ArrayList<>();
        List l3=new ArrayList<>();
        List l4=new ArrayList<>();
        List l5=new ArrayList<>();
        List l6=new ArrayList<>();
        List l7=new ArrayList<>();

        double avg1=0,avg2=0,avg3=0,avg4=0,avg5=0,avg6=0,avg7=0;

        l0.add("월별");
        l0.add("바나나");
        l0.add("사과");
        l0.add("수박");
        l0.add("오렌지");
        l0.add("Average");

        l1.add("1월");
        l2.add("2월");
        l3.add("3월");
        l4.add("4월");
        l5.add("5월");
        l6.add("6월");
        l7.add("7월");



        for(GoogleChartVO vo:googlechartvo){
            if(vo.getDate1().equals("1")){
                l1.add(vo.getSum1());
                avg1+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("2")){
                l2.add(vo.getSum1());
                avg2+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("3")){
                l3.add(vo.getSum1());
                avg3+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("4")){
                l4.add(vo.getSum1());
                avg4+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("5")){
                l5.add(vo.getSum1());
                avg5+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("6")){
                l6.add(vo.getSum1());
                avg6+=vo.getSum1()/4;
            } else if(vo.getDate1().equals("7")){
                l7.add(vo.getSum1());
                avg7+=vo.getSum1()/4;
            }
        }

        logger.info(avg1);
        l1.add(avg1);
        l2.add(avg2);
        l3.add(avg3);
        l4.add(avg4);
        l5.add(avg5);
        l6.add(avg6);
        l7.add(avg7);

        listdata.add(l0);
        listdata.add(l1);
        listdata.add(l2);
        listdata.add(l3);
        listdata.add(l4);
        listdata.add(l5);
        listdata.add(l6);
        listdata.add(l7);


        logger.info(listdata);
        return listdata;
    }

    @RequestMapping(value = "/")
    public String home() {

        return "home";
    }


}
