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
<div id="main" style="height:600px;width: 800px"></div>  
<!-- ECharts单文件引入 -->  
<script src="<%=request.getContextPath() %>/js/echarts.js"></script>  
<script type="text/javascript">
	var myChart = echarts.init(document.getElementById('main'));
	option = { 
			
			title : {       //提示的标题  
	            text: 'Java薪资情况分布',  
	            subtext: '2016~2017年'  
	           
	        },  
	        
	        toolbox: {        //工具栏 可以导出图片 数据视图 动态类型切换 数据区域缩放 重置  
	            show : true,      //是否显示本工具栏  
	            orient : 'horizontal',  //工具栏的显示位置 默认    vertical为右边竖向  
	            feature : {       //各工具配置项 可以自定义工具名字 不过只能以my开头  
	                mark : {show: true},  
	                dataView : {show: true, readOnly: false},  
	                magicType : {show: true, type: ['bar', 'pine']},  
	                restore : {show: true},  
	                saveAsImage : {show: true}  
	            }  
	        }, 
	        
	        calculable : true,  
	        tooltip : {  
	            trigger: 'axis'       //鼠标移入提示   none代表不提示   axis坐标轴触发  item数据项图形触发  
	        },  
		    tooltip: { 
		        trigger: 'item', 
		        formatter: "{a} <br/>{b}: {c} ({d}%)" 
		    }, 
		    legend: { 
		        orient: 'horizontal', 
		        left: 'center', 
		        bottom: 0, 
		        data:['4k~6k','6k~8k','8k~10k','10k以上'] 
		    }, 
		    series: [ 
		        { 
		            name:'访问来源', //内环 
		            type:'pie', 
		            selectedMode: 'single', //单一选中模式 
		            radius: [0, '80%'], //饼图的半径 [内半径，外半径] 
		 
		            label: { 
		                normal: { 
		                    position: 'inner' //内置文本标签 
		                } 
		            }, 
		            labelLine: { 
		                normal: { 
		                    show: false     //不需要设置引导线 
		                } 
		            }, 
		            data:[ 
		                {value:551, name:'4k~6k',selected:true}, 
		                {value:389, name:'6k~8k'}, 
		                {value:642, name:'8k~10k',selected:true} ,
		                {value:398,name:'10k以上'}
		               
		            ] 
		        }
		         /* { 
		            name:'访问来源', 
		            type:'pie', 
		            radius: ['40%', '55%'], 
		 
		            data:[ 
		                {value:335, name:'直接输入网址或书签'}, 
		                {value:310, name:'cnblogs.com'}, 
		                {value:234, name:'微博'}, 
		                {value:135, name:'微信'}, 
		                {value:1048, name:'百度'}, 
		                {value:251, name:'谷歌'}, 
		                {value:147, name:'360'}, 
		                {value:42, name:'必应'}, 
		                {value:60, name:'其他'} 
		            ] 
		        }   */
		    ] 
		}; 
	
	myChart.setOption(option);
	
</script>
</body>
</html>