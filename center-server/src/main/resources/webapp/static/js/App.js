/**
 * App全局变量
 * 
 * @author zz
 * @date 2015-12-04
 */

window.App = (function(app) {

	app = {
		ctx : window.ctx,
		
		now:function(){
			var jsNow = new Date();
			
			return jsNow;
		},
		openWindow : function(href, winId, iWidth, iHeight) {
			var iTop = (window.screen.availHeight - 30 - iHeight) / 2; // 获得窗口的垂直位置;
			var iLeft = (window.screen.availWidth - 10 - iWidth) / 2; // 获得窗口的水平位置;
			window.open(href, winId, 'height=' + iHeight + ',innerHeight=' + iHeight + ',width=' + iWidth + ',innerWidth=' + iWidth + ',top=' + iTop + ',left=' + iLeft + ',toolbar=no,menubar=no,scrollbars=auto,resizeable=no,location=no,status=no');

		},
		ajaxError : function(xmlHttpRequest, ajaxOptions, thrownError) {
			var httpStatus = xmlHttpRequest.status;
			if (httpStatus == 455) {
				try {
					var rsp = eval('(' + xmlHttpRequest.responseText + ')');
					if (!rsp.success) {
						bootbox.alert(rsp.msg || '系统异常');
					} else {
						bootbox.alert('服务不存在[' + xmlHttpRequest.statusText
								+ ']');
					}
				} catch (err) {
					bootbox.alert('ERROR:[' + xmlHttpRequest.statusText + ']');
				}
			} else if(httpStatus==400){
				bootbox.alert('请检查请求参数格式[' + xmlHttpRequest.statusText + ']');
				
			} else if (httpStatus == 404) {
				bootbox.alert('服务或页不存在[' + xmlHttpRequest.statusText + ']');
			} else if(httpStatus==401){
				bootbox.alert('请求未被授权,请确认是否已登陆');
			} else if (httpStatus > 400 && httpStatus < 500) {
				bootbox
						.alert('服务出错,请检查提交数据[' + xmlHttpRequest.statusText
								+ ']');

			} else if (httpStatus == 200) {
				if ('' == xmlHttpRequest.responseText) {
					bootbox.alert("无相关数据");
				} else {
					bootbox.alert("解析响应异常");
				}
			} else if (httpStatus == 0 && xmlHttpRequest.statusText == 'error'
					&& thrownError == '') {
				bootbox.alert("会话已过期，请刷新页面!");
			} else {
				try {
					var rsp = eval('(' + xmlHttpRequest.responseText + ')');
					if (!rsp.success) {
						bootbox.alert(rsp.msg || '系统异常');
					}
				} catch (err) {
					bootbox.alert("系统运行错误，如果您在使用本系统，多次出现此错误，请与管理员联系。httpStatus:"
							+ httpStatus);
				}
				
				
			}
		},
		setUpAjax : function() {
			
		},
		showLoading : function(flag,msg) {
			
			if (flag) {
				var $container = $('div.mask-loading-container');
				if (!$("#mask-loading").length) {
					$container.append('<div id="mask-loading"><div id="loading"><i class="fas fa-spinner"></i>&nbsp;正在加载...</div><div  class="mask"></div></div>');
				}
				$("#mask-loading .mask").css("height",
						$container.height());
				$("#mask-loading .mask").css("width",
						$container.width());
				$("#mask-loading").show();
			} else {
				$("#mask-loading").hide();

			}

		},
		init:function(){
			this.setUpAjax()
			this.vueInstance = new Vue({el: document.body});
		},
		alert:function(msg,title){
			this.vueInstance.$alert(msg, title, {
		       confirmButtonText: '确定'
		   });
		}
	}
	app.init()
	return app;
})(window.App || {});
