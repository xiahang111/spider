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
	            text: '全国主要城市工作分布',  
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
		        data:['北京','上海','广州','深圳','天津','武汉','西安','成都','大连','长春','沈阳','南京','济南','青岛','杭州','苏州','无锡','宁波','重庆','郑州','长沙','福州','厦门','哈尔滨','石家庄','合肥','惠州','太原','昆明','烟台','佛山','南昌','贵阳'] 
		    }, 
		    series: [ 
		        { 
		            name:'访问来源', //内环 
		            type:'pie', 
		            selectedMode: 'single', //单一选中模式 
		            radius: [0, '65%'], //饼图的半径 [内半径，外半径] 
		 
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
		                {value:7212, name:'北京',selected:true}, 
		                {value:10321, name:'上海'}, 
		                {value:10515, name:'广州',selected:true} ,
		                {value:4845,name:'深圳'},
		                {value:11335,name:'天津',selected:true},
		                {value:11358,name:'武汉'},
		                {value:11526,name:'西安'},
		                {value:11377,name:'成都',selected:true},
		                {value:11845,name:'大连'},
		                {value:11559,name:'长春'},
		                {value:11485,name:'沈阳'},
		                {value:10389,name:'南京'},
		                {value:11570,name:'济南',selected:true},
		                {value:10489,name:'青岛'},
		                {value:2014,name:'苏州'},
		                {value:7800,name:'无锡'},
		                {value:11693,name:'宁波'},
		                {value:11408,name:'重庆',selected:true},
		                {value:9846,name:'郑州'},
		                {value:11319,name:'长沙'},
		                {value:11533,name:'福州',selected:true},
		                {value:11586,name:'厦门'},
		                {value:3310,name:'哈尔滨'},
		                {value:11821,name:'石家庄'},
		                {value:10961,name:'合肥'},
		                {value:11751,name:'太原',selected:true},
		                {value:11094,name:'昆明'},
		                {value:11806,name:'烟台'},
		                {value:11756,name:'佛山'},
		                {value:11738,name:'南昌'},
		                {value:11686,name:'贵阳'}
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