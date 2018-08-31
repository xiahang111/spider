<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath() %>/bjSalary.jsp">工资</a>
<a href="<%=request.getContextPath() %>/index.jsp">主页</a>
<a href="<%=request.getContextPath() %>/bjJob.jsp">北京工作</a>
<a href="pie.jsp">总工作</a>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->  
<div id="main" style="height:900px;width: 1300px"></div>  
<!-- ECharts单文件引入 -->  
<script src="<%=request.getContextPath() %>/js/echarts.js"></script>  
<script src="<%=request.getContextPath() %>/js/china.js"></script>
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	function randomData() {
	    return Math.round(Math.random()*1000);
	}

	option = {
	    title: {
	        text: '全国工作分布图',
	       
	        left: 'center'
	    },
	    tooltip: {
	        trigger: 'item'
	    },
	    legend: {
	        orient: 'vertical',
	        left: 'left',
	    },
	    visualMap: {
	        min: 0,
	        max: 15000,
	        left: 'left',
	        top: 'bottom',
	        text: ['高','低'],           // 文本，默认为数值文本
	        calculable: true
	    },
	    toolbox: {
	        show: true,
	        orient: 'vertical',
	        left: 'right',
	        top: 'center',
	        feature: {
	            dataView: {readOnly: false},
	            restore: {},
	            saveAsImage: {}
	        }
	    },
	    series: [
	        {
	            name: '工作数量',
	            type: 'map',
	            mapType: 'china',
	            roam: false,
	            label: {
	                normal: {
	                    show: true
	                },
	                emphasis: {
	                    show: true
	                }
	            },
	            data:[
	                {name: '北京',value:7212 },
	                {name: '天津',value:11335 },
	                {name: '上海',value:10321 },
	                {name: '重庆',value:11408 },
	                {name: '河北',value:11821 },
	                {name: '河南',value:9846 },
	                {name: '云南',value:11094 },
	                {name: '辽宁',value:11485 },
	                {name: '黑龙江',value:3310 },
	                {name: '湖南',value:11319 },
	                {name: '安徽',value:10961 },
	                {name: '山东',value:11570 },
	                {name: '新疆',value:200 },
	                {name: '江苏',value:10389},
	                {name: '浙江',value: 11693 },
	                {name: '江西',value: 11738 },
	                {name: '湖北',value:11358 },
	                {name: '广西',value: 2365},
	                {name: '甘肃',value: 799 },
	                {name: '山西',value: 11751 },
	                {name: '内蒙古',value: 1786 },
	                {name: '陕西',value: 11526 },
	                {name: '吉林',value: 11559 },
	                {name: '福建',value:11533 },
	                {name: '贵州',value: 11686 },
	                {name: '广东',value: 15647},
	                {name: '青海',value: 3215 },
	                {name: '四川',value: 11377 },
	                {name: '宁夏',value: 1689 },
	               
	            ]
	        }
	    ]
	};
	myChart.setOption(option);
	
</script>
</body>
</html>