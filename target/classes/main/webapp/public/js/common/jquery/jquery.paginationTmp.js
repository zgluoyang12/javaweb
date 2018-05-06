/**
 * This jQuery plugin displays pagination links inside the selected elements.
 *
 * @author Gabriel Birke (birke *at* d-scribe *dot* de)
 * @version 1.2
 * @param {int} _maxentries Number of entries to paginate
 * @param {Object} opts Several options (see README for documentation)
 * @return {Object} jQuery Object
 */
jQuery.fn.paginationTmp = function(opts){
	return this.each(function() {
		opts = jQuery.extend({
			items_per_page:2, //每页记录数
			current_page:0,  //第一页以0开始
			num_display_entries:3,  //开始链接显示数量
			num_edge_entries:3,//结束链接显示数量
			link_to:"#",
			prev_text:"上一页",
			next_text:"下一页",
			ellipse_text:"...",
			prev_show_always:true,
			next_show_always:true,
			callback:function(){return false;},   //页面数据渲染回调函数
		    params:{},   //查询所需参数
			url:""
		},opts||{});
		//记录数
		var _maxentries = 0;
		var _current_page = opts.current_page;
		var _items_per_page = opts.items_per_page;
		var url = opts.url;
		// Create a sane value for _maxentries and items_per_page
		_maxentries = (!_maxentries || _maxentries < 0)?1:_maxentries;
		opts.items_per_page = (!opts.items_per_page || opts.items_per_page < 0)?1:opts.items_per_page;
		// Store DOM element for easy access from all inner functions
		var panel = jQuery(this);
		var me = this;
		//当前页索引  每页最大条数
		me.current_page = _current_page;
		me.items_per_page = _items_per_page;
		/**
		 * Calculate the maximum number of pages
		 */
		function numPages() {
			return Math.ceil(_maxentries/me.items_per_page);
		}
		
		/**
		 * Calculate start and end point of pagination links depending on 
		 * current_page and num_display_entries.
		 * @return {Array}
		 */
		function getInterval()  {
			var ne_half = Math.ceil(opts.num_display_entries/2);
			var np = numPages();
			var upper_limit = np-opts.num_display_entries;
			var start = me.current_page>ne_half?Math.max(Math.min(me.current_page-ne_half, upper_limit), 0):0;
			var end = me.current_page>ne_half?Math.min(me.current_page+ne_half, np):Math.min(opts.num_display_entries, np);
			return [start,end];
		}
		/**
		 * 后台访问方法
		 */
		function startRequest(evt){
		   var params = $.extend({},opts.params);
		   params.pageIndex = me.current_page;
		   params.pageSize = me.items_per_page;
		   if(url){
			   $.ajax({
					url :url,
					data : params,
					method:"post",
					success : function(data) {
						 _maxentries = data.count;
						 me.count =_maxentries;
                         drawLinks();
						 opts.callback(data);
					},
					dataType : "json"
				});  
		   }

		}
		/**
		 * This is the event handling function for the pagination links. 
		 * @param {int} page_id The new page number
		 */
		function pageSelected(page_id, evt){

			// 清空table
			$("#order_coach .listTable tbody").empty();
			// 显示等待
			$("#stay").css('display','block');
			me.current_page = page_id;
			startRequest(evt);
		}
		
		/**
		 * This function inserts the pagination links into the container element
		 */
		function drawLinks() {
			panel.empty();
			var interval = getInterval();
			var np = numPages();
			// This helper function returns a handler function that calls pageSelected with the right page_id
			var getClickHandler = function(page_id) {
				return function(evt){ return pageSelected(page_id,evt); }
			}
			// Helper function for generating a single link (or a span tag if it's the current page)
			var appendItem = function(page_id, appendopts){
				page_id = page_id<0?0:(page_id<np?page_id:np-1); // Normalize page id to sane value
				
				appendopts = jQuery.extend({text:page_id+1, classes:""}, appendopts||{});
				page_id = page_id<0 ? 0:page_id;
				if(page_id == me.current_page){
					var lnk = jQuery("<span class='current'>"+(appendopts.text)+"</span>");
				}
				else
				{
					var lnk = jQuery("<a>"+(appendopts.text)+"</a>")
						.bind("click", getClickHandler(page_id))
						.attr('href', opts.link_to.replace(/__id__/,page_id));
						
						
				}
				if(appendopts.classes){lnk.addClass(appendopts.classes);}
				panel.append(lnk);
			}
			// Generate "Previous"-Link
			if(opts.prev_text && (me.current_page > 0 || opts.prev_show_always)){
				appendItem(me.current_page-1,{text:opts.prev_text, classes:"prev"});
			}
			// Generate starting points
			if (interval[0] > 0 && opts.num_edge_entries > 0)
			{
				var end = Math.min(opts.num_edge_entries, interval[0]);
				for(var i=0; i<end; i++) {
					appendItem(i);
				}
				if(opts.num_edge_entries < interval[0] && opts.ellipse_text)
				{
					jQuery("<span>"+opts.ellipse_text+"</span>").appendTo(panel);
				}
			}
			// Generate interval links
			for(var i=interval[0]; i<interval[1]; i++) {
				appendItem(i);
			}
			// Generate ending points
			if (interval[1] < np && opts.num_edge_entries > 0)
			{
				if(np-opts.num_edge_entries > interval[1]&& opts.ellipse_text)
				{
					jQuery("<span>"+opts.ellipse_text+"</span>").appendTo(panel);
				}
				var begin = Math.max(np-opts.num_edge_entries, interval[1]);
				for(var i=begin; i<np; i++) {
					appendItem(i);
				}
				
			}
			// Generate "Next"-Link
			if(opts.next_text && (me.current_page < np-1 || opts.next_show_always)){
				appendItem(me.current_page+1,{text:opts.next_text, classes:"next"});
			}
			//Generate count
			panel.append("&nbsp;&nbsp;<font style='color:#15B;'>共 <font style='font-weight:bold;'>"+me.count+"</font> 条</font>");
		}
		// Attach control functions to the DOM element 
		this.selectPage = function(page_id){ pageSelected(page_id);}
		this.prevPage = function(){ 
			if (me.current_page > 0) {
				pageSelected(me.current_page - 1);
				return true;
			}
			else {
				return false;
			}
		}
		this.nextPage = function(){ 
			if(me.current_page < numPages()-1) {
				pageSelected(me.current_page+1);
				return true;
			}
			else {
				return false;
			}
		}
		startRequest();
	});
}


