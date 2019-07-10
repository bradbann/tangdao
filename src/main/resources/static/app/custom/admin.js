if (typeof jQuery === "undefined") {
    throw new Error("Tangdao's JavaScript requires jQuery")
} (function($, window, undefined) {
	var js = {
        log: function(msg) {
            if (typeof(console) !== "undefined") {
                console.log(msg)
            }
        },
        error: function(msg) {
            if (typeof(console) !== "undefined") {
                console.error(msg)
            }
        }
	};
	window.js = js;
    window.log = js.log;
    window.error = js.error;
})(window.jQuery, window); (function(f, d, a) {
    var b, g, c;
    c = "resizeEnd";
    g = {
        delay: 150
    };
    b = function(i, h, j) {
        if (typeof h === "function") {
            j = h;
            h = {}
        }
        j = j || null;
        this.element = i;
        this.settings = f.extend({},
        g, h);
        this._defaults = g;
        this._name = c;
        this._timeout = false;
        this._callback = j;
        return this.init()
    };
    b.prototype = {
        init: function() {
            var h, i;
            i = this;
            h = f(this.element);
            return h.on("resize",
            function() {
                return i.initResize()
            })
        },
        getUTCDate: function(i) {
            var h;
            i = i || new Date();
            h = Date.UTC(i.getUTCFullYear(), i.getUTCMonth(), i.getUTCDate(), i.getUTCHours(), i.getUTCMinutes(), i.getUTCSeconds(), i.getUTCMilliseconds());
            return h
        },
        initResize: function() {
            var h;
            h = this;
            h.controlTime = h.getUTCDate();
            if (h._timeout === false) {
                h._timeout = true;
                return setTimeout(function() {
                    return h.runCallback(h)
                },
                h.settings.delay)
            }
        },
        runCallback: function(i) {
            var h;
            h = i.getUTCDate();
            if (h - i.controlTime < i.settings.delay) {
                return setTimeout(function() {
                    return i.runCallback(i)
                },
                i.settings.delay)
            } else {
                i._timeout = false;
                return i._callback()
            }
        }
    };
    return f.fn[c] = function(h, i) {
        return this.each(function() {
            if (!f.data(this, "plugin_" + c)) {
                return f.data(this, "plugin_" + c, new b(this, h, i))
            }
        })
    }
})(jQuery, window, document); !
'use strict';
(function($) {
	
	$.fn.myDatatable = function(options) {
		var KTDatatable = typeof $this != "undefined" ? $this: options.KTDatatable ? options.KTDatatable: $(".kt-datatable"),
		searchForm = options.searchForm ? options.searchForm: $("#searchForm"),
				//console.log(searchForm.serializeArray());
        options = $.extend({
        	btnSearch: $("#btnSearch"),
            //postData: searchForm.serializeArray(),
            data: {
        		type: 'remote',
        		source: {
        			read: {
        				url: searchForm.attr("action"),
        				// sample custom headers
        				//headers: {'x-my-custokt-header': 'some value', 'x-test-header': 'the value'},
        				map: function(raw) {
        					// sample data mapping
        					var dataSet = raw;
        					if (typeof raw.data !== 'undefined') {
        						dataSet = raw.data;
        					}
        					return dataSet;
        				},
        			},
        		},
        		pageSize: 10,
        		serverPaging: true,
        		serverFiltering: true,
        		serverSorting: true,
        	},

        	// layout definition
        	layout: {
        		scroll: false,
        		footer: false,
        	},
        	translate:{
        		records:{
        			processing: '正在加载，请稍候...',
        			noRecords: '未查询到任何记录'
        		}
        	},
        	// column sorting
        	sortable: true,

        	pagination: true
        	
        }, options);
        
        if (options.btnSearch.length > 0) {
            options.btnSearch.unbind("click").click(function() {
                var btnSearch = $(this);
                if (searchForm.hasClass("kt-hidden")) {
                    searchForm.removeClass("kt-hidden");
                    btnSearch.addClass("active");
                    btnSearch.html(btnSearch.html().replace("查询", "隐藏"));
                } else {
                    searchForm.addClass("kt-hidden");
                    btnSearch.removeClass("active");
                    btnSearch.html(btnSearch.html().replace("隐藏", "查询"));
                }
                return false
            });
            if (!searchForm.hasClass("kt-hidden")) {
                var btnSearch = options.btnSearch;
                searchForm.removeClass("kt-hidden");
                btnSearch.addClass("active");
                btnSearch.html(btnSearch.html().replace("查询", "隐藏"));
            }
        }
        if (searchForm && searchForm.length > 0) {
            searchForm.submit(function() {
            	refresh();
                return false
            }).on("reset",
            function() {
            	setTimeout(function() {
                    if ($.fn.iCheck !== undefined) {
                        searchForm.find("input[type=checkbox].form-control:not(.noicheck),input[type=radio].form-control:not(.noicheck)").iCheck("update")
                    }
                    if ($.fn.select2 !== undefined||$.fn.selectpicker !== undefined) {
                        searchForm.find("select.form-control:not(.noselect2)").trigger("change")
                    }
                    searchForm.find(".isReset").each(function() {
                        $(this).val($(this).data("defaultValue"))
                    })
                },
                200)
            })
        }
        
        var refresh = function(){
        	var formArray = searchForm.serializeArray();
        	function transformToJson(formArray){
                var obj={}
                for (var i in formArray) {
                	if(formArray[i]['value']){
                		obj[formArray[i].name]=formArray[i]['value'];
                	}
                }
                return obj;
            }
        	KTDatatable.setOption("data.source.read.params", transformToJson(formArray));
        	KTDatatable.reload();
        }
        KTDatatable.KTDatatable(options);
        $(window).resizeEnd(function() {
        	KTDatatable.layoutUpdate();
        });
		return KTDatatable;
    };
    
}(jQuery));
