<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>欢迎11</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/bjSalary.jsp">工资</a>
<a href="<%=request.getContextPath() %>/index.jsp">主页</a>
<a href="<%=request.getContextPath() %>/bjJob.jsp">北京工作</a>
<a href="pie.jsp">总工作</a>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->  
<div id="main" style="height:600px;width: 800px"></div>  
<!-- ECharts单文件引入 -->  
<script src="<%=request.getContextPath() %>/js/echarts.js"></script>  
<script type="text/javascript">  
	
    // 基于准备好的dom，初始化echarts图表  
    var myChart = echarts.init(document.getElementById("main"));  
    var arr = [118760,27267,134665,47684,13530]  
    var option = {  
        title : {       //提示的标题  
            text: '学历分布情况',  
            subtext: '截至至2017/04'  
           
        },  
        tooltip : {  
            trigger: 'item'       //鼠标移入提示   none代表不提示   axis坐标轴触发  item数据项图形触发  
        },  
       
        toolbox: {        //工具栏 可以导出图片 数据视图 动态类型切换 数据区域缩放 重置  
            show : true,      //是否显示本工具栏  
            orient : 'horizontal',  //工具栏的显示位置 默认    vertical为右边竖向  
            feature : {       //各工具配置项 可以自定义工具名字 不过只能以my开头  
                mark : {show: true},  
                dataView : {show: true, readOnly: false},  
                magicType : {show: true, type: ['line', 'pine']},  
                restore : {show: true},  
                saveAsImage : {show: true}  
            }  
        },  
        calculable : true,  
        xAxis : [     //直角坐标系grid中的x轴，一般情况下只能放两个 多于两个需要配置offset属性防止同位置的多个x轴的重叠  
            {  
                type : 'category',   //坐标轴的数据类型   
                boundaryGap : true,  //坐标两边留白侧略 决定x轴的开始位置  
                data : ['不限','中专','大专','本科','硕士']   //x轴的数据  
            }  
        ],  
        yAxis : [  
            {  
                type : 'value',    
                axisLabel : {     //坐标轴设置  
                    formatter: '{value} '   //支持字符串拼接  
                }  
            }  
        ],  
        series : [       //系列列表 对应legend  
            {  
                name:'工作数量',  
                type:'line',  
                data: arr,    //[11, 11, 15, 13, 12, 13, 10],  可以使用变量  
                markPoint : {     
                    data : [  
                        {type : 'max', name: '数量个数',select : true}
                        
                    ]  
                }
            },  
            
        ]  
    };  
    myChart.setOption(option);           // 为echarts对象加载数据  
  
</script>  
</body>
</html>











