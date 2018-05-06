/**
 * jquery Form validator
 * 
 * @Author Bird
 * @Date 2015-02
 * @param $
 */
(function($) {
	$.fn.validator = function(cfg) {
		// 默认配置
		var defCfg = {
			requiredCls : "required"
		};
		cfg = $.extend(defCfg, cfg);
		var me = $(this);
		function _validate() {
			var valRes = true;
			//非空验证
			me.find("." + cfg.requiredCls).each(function(i, obj) {
				var tagName = this.tagName;
				var name = this.name;
				if(tagName == "IMG"){
					var src = this.src;
					var fileName = src.substr(src.lastIndexOf("/")+1);
					//if(fileName == "waitpho.png"){
					//	valRes = false;
					//	alert('请选择图片');
					//	return false;
					//}
				}
				else if (!$(this).val()) {
					valRes = false;
					var title = $(obj).parent().prev().text();
					if(tagName == "INPUT"){
						alert("请输入" + title);
					}
					else if(tagName == "SELECT"){
						alert("请选择" + title);
					}
					
					return false;
				}
			});
			//长度验证
			
			return valRes;
		}
		this.validate = _validate;
		return this;
	}
})(jQuery);