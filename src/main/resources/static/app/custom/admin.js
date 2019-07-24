if (typeof jQuery === "undefined") {
    throw new Error("Tangdao's JavaScript requires jQuery")
} (function($, window, undefined) {
	$(function() {
		$("#inputForm input[type=text]:not([readonly]):not([disabled]):not(.nofocus):eq(0)").focus();
		if (js.ie && js.ie <= 9) {W
			setTimeout(function() {
				$("input[placeholder],textarea[placeholder]").placeholder()
			}, 500)
		}
	});
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
        },
        ie: function() {
            var agent = navigator.userAgent.toLowerCase();
            return (!!window.ActiveXObject || "ActiveXObject"in window) ? ((agent.match(/msie\s(\d+)/) || [])[1] || (agent.match(/Trident/i) && agent.match(/rv:(\d+)/) || [])[1] || false) : false
        }(),
        loading: function(message, ignoreMessageIfExists) {
            var topJs;
            try {
                top.loadingFlag = true;
                topJs = top.js || parent.parent.js || parent.js
            } catch (e) {}
            if (typeof loadingFlag == "undefined" && topJs) {
                if (typeof topJs.loading == "function") {
                    topJs.loading(message);
                    return
                }
            }
            if (message == undefined || message == "") {
                message = "正在加载，请稍候..."
            }
            if (message == "none") {
                return
            }
            
            setTimeout(function() {
                if (!js.pageLoadingNum) {
                    js.pageLoadingNum = 0
                }
//                if (!js.pageLoadingStyle) {
//                    if ($("body").hasClass("loading-topline")) {
//                        js.pageLoadingStyle = 2
//                    } else {
//                        js.pageLoadingStyle = 1
//                    }
//                }
//                if (js.pageLoadingStyle == 1) {
//                    message += '<em onclick="js.closeLoading(0, true)">×</em>';
//                    if ($("#page-loading").length == 0) {
//                        $("body").append('<div id="page-loading" onmouseover="$(this).find(\'em\').show()" onmouseout="$(this).find(\'em\').hide()">' + message + "</div>")
//                    } else {
//                        if (!(ignoreMessageIfExists == true)) {
//                            $("#page-loading").html(message)
//                        }
//                    }
//                } else {
//                    if (js.pageLoadingStyle == 2) {
//                        if ($("#page-loading-top").length == 0) {
//                            $("body").append('<div id="page-loading-top" class="page-loading-top"></div>');
//                            $("#page-loading-top").animate({
//                                width: "65%"
//                            }, 2000, function() {
//                                $(this).animate({
//                                    width: "85%"
//                                }, 8000)
//                            })
//                        }
//                    }
//                }
                KTApp.blockPage({
                    overlayColor: '#000000',
                    type: 'v2',
                    state: 'primary',
                    message: message
                });
                js.pageLoadingNum++
            }, 0)
        },
        closeLoading: function(timeout, forceClose) {
            var topJs;
            try {
                top.loadingFlag = true;
                topJs = top.js || parent.parent.js || parent.js
            } catch (e) {}
            if (typeof loadingFlag == "undefined" && topJs) {
                if (typeof topJs.closeLoading == "function") {
                    topJs.closeLoading(timeout, forceClose);
                    return
                }
            }
            setTimeout(function() {
                if (!js.pageLoadingNum) {
                    js.pageLoadingNum = 0
                }
                js.pageLoadingNum--;
                if (forceClose || js.pageLoadingNum <= 0) {
//                    if (js.pageLoadingStyle == 1) {
//                        $("#page-loading").remove()
//                    } else {
//                        if (js.pageLoadingStyle == 2) {
//                            $("#page-loading-top").stop().animate({
//                                width: "100%"
//                            }, 200, function() {
//                                $(this).fadeOut(300, function() {
//                                    $(this).remove()
//                                })
//                            })
//                        }
//                    }
                	KTApp.unblockPage();
                    js.pageLoadingNum = 0
                }
            }, timeout == undefined ? 0 : timeout)
        },
        layer: function() {
            try {
                if (top.layer && top.layer.window) {
                    return top.layer
                }
                if (parent.parent.layer && parent.parent.layer.window) {
                    return parent.parent.layer
                }
                if (parent.layer && parent.layer.window) {
                    return parent.layer
                }
            } catch (e) {}
            if (window.layer) {
                return layer
            }
            return null
        }(),
        showMessage: function(message, title, type, timeout) {
            var msgType, layerIcon, msg = String(message), msgTimeout = timeout == undefined ? 4000 : timeout;
            var contains = function(str, searchs) {
                if (searchs) {
                    var ss = searchs.split(",");
                    for (var i = 0; i < ss.length; i++) {
                        if (msg.indexOf(ss[i]) >= 0) {
                            return true
                        }
                    }
                }
                return false
            };
            if (type == "error" || contains(msg, "失败,错误,未完成")) {
                msgType = "error";
                layerIcon = 2
            } else {
                if (type == "warning" || contains(msg, "不能,不允许,必须,已存在,不需要,不正确")) {
                    msgType = "warning";
                    layerIcon = 5
                } else {
                    if (type == "success" || contains(msg, "成功,完成")) {
                        msgType = "success";
                        layerIcon = 1
                    } else {
                        msgType = "info";
                        layerIcon = 6
                    }
                }
            }
            try {
                if (top.toastr) {
                    var positionClass = "toast-bottom-right";
                    if (msg && msg.length >= 8 && msg.indexOf("posfull:") >= 0) {
                        if (timeout == undefined) {
                            msgTimeout = 0
                        }
                        positionClass = "toast-top-full-width";
                        msg = msg.substring(8);
                        js.log(msg)
                    }
                    top.toastr.options = {
                        closeButton: true,
                        positionClass: positionClass,
                        timeOut: msgTimeout
                    };
                    top.toastr[msgType](msg, title);
                    return
                }
            } catch (e) {}
            if (!js.layer) {
                alert(msg);
                return
            }
            if (layerIcon) {
                js.layer.msg(msg, {
                    icon: layerIcon,
                    time: msgTimeout
                })
            } else {
                js.layer.msg(msg, {
                    time: msgTimeout
                })
            }
        },
        showErrorMessage: function(responseText) {
            if (responseText && responseText != "") {
                js.error(js.abbr(responseText, 500));
                if (responseText.length>6 && (responseText.indexOf("<html ") != -1 || responseText.indexOf("<head ") != -1 || responseText.indexOf("<body ") != -1)) {
                    js.showMessage("未知错误，F12查看异常信息！", null, "error")
                } else {
                    try {
                        var json = JSON.parse(responseText);
                        if (typeof json == "object" && typeof json.message != "undefined") {
                            js.showMessage(json.message, null, "error");
                            return
                        }
                    } catch (e) {}
                    js.showMessage(responseText, null, "error")
                }
            }
        },
        closeMessage: function() {
            try {
                if (top.toastr) {
                    top.toastr.clear()
                }
            } catch (e) {}
        },
        alert: function(message, options, closed) {
            if (typeof options != "object") {
                closed = options;
                options = {
                    icon: 1
                }
            }
            if (!js.layer) {
                alert(message);
                if (typeof closed == "function") {
                    closed()
                }
                return
            }
            js.layer.alert(message, options, function(index) {
                if (typeof closed == "function") {
                    closed(index)
                }
                js.layer.close(index)
            })
        },
        confirm: function(message, urlOrFun, data, callback, dataType, async, loadingMessage) {
            if (typeof data == "function") {
                loadingMessage = async;
                async = dataType;
                dataType = callback;
                callback = data;
                data = undefined
            }
            var sendAjax = function() {
                js.loading(loadingMessage == undefined ? '正在提交，请稍候...' : loadingMessage);
                $.ajax({
                    type: "POST",
                    url: urlOrFun,
                    data: data,
                    dataType: dataType == undefined ? "json" : dataType,
                    async: async == undefined ? true : async,
                    error: function(data) {
                        js.showErrorMessage(data.responseText);
                        js.closeLoading(0, true)
                    },
                    success: function(data) {
                        if (typeof callback == "function") {
                            callback(data)
                        }
                        js.closeLoading()
                    }
                })
            };
            if (!js.layer) {
                if (confirm(message)) {
                    if (typeof urlOrFun == "function") {
                        urlOrFun()
                    } else {
                        sendAjax()
                    }
                }
                return
            }
            var options = {
                icon: 3
            };
            js.layer.confirm(message, options, function(index) {
                if (typeof urlOrFun == "function") {
                    urlOrFun()
                } else {
                    sendAjax()
                }
                js.layer.close(index)
            });
            return false
        },
        ajaxSubmit: function(url, data, callback, dataType, async, message) {
            $(".btn").attr("disabled", true);
            if (typeof data == "function") {
                message = async;
                async = dataType;
                dataType = callback;
                callback = data;
                data = undefined
            }
            var options = {};
            if (typeof callback == "object") {
                options = callback;
                callback = options.callback;
                dataType = options.dataType;
                async = options.async;
                message = options.message
            }
            js.loading(message == undefined ? '正在提交，请稍候...' : message);
            $.ajax($.extend(true, {
                type: "POST",
                url: url,
                data: data,
                dataType: dataType == undefined ? "json": dataType,
                async: async == undefined ? true: async,
                error: function(data) {
                    $(".btn").attr("disabled", false);
                    js.showErrorMessage(data.responseText);
                    js.closeLoading(0, true)
                },
                success: function(data, status, xhr) {
                    $(".btn").attr("disabled", false);
                    js.closeLoading();
                    if (typeof callback == "function") {
                        callback(data, status, xhr)
                    } else {
                        js.log(data)
                    }
                }
            },
            options))
        },
        ajaxSubmitForm: function(formJqueryObj, callback, dataType, async, message) {
            $(".btn").attr("disabled", true);
            var options = {};
            if (typeof callback == "object") {
                options = callback;
                callback = options.callback;
                dataType = options.dataType;
                async = options.async;
                message = options.message;
            }
            js.loading(message == undefined ? '正在提交，请稍候...' : message);
            if (options.downloadFile === true) {
                options.iframe = true
            }
            formJqueryObj.ajaxSubmit($.extend(true, {
                type: "POST",
                xhrFields: {
                    withCredentials: true
                },
                url: formJqueryObj.attr("action"),
                dataType: dataType == undefined ? "json": dataType,
                async: async == undefined ? true: async,
                error: function(data) {
                    $(".btn").attr("disabled", false);
                    js.showErrorMessage(data.responseText);
                    js.closeLoading(0, true)
                },
                success: function(data, status, xhr) {
                    $(".btn").attr("disabled", false);
                    js.closeLoading();
                    if (typeof callback == "function") {
                        callback(data, status, xhr)
                    } else {
                        js.log(data)
                    }
                }
            },
            options));
            if (options.downloadFile === true) {
                $(".btn").attr("disabled", false);
                js.closeLoading()
            }
        },
        trim: function(str) {
            return jQuery.trim(str)
        },
        startWith: function(str, start) {
            var reg = new RegExp("^" + start);
            return reg.test(str)
        },
        startsWith: function(str, prefix) {
            if (!str || !prefix || str.length < prefix.length) {
                return false
            }
            return str.slice(0, prefix.length) === prefix
        },
        endWith: function(str, end) {
            var reg = new RegExp(end + "$");
            return reg.test(str)
        },
        endsWith: function(str, suffix) {
            if (!str || !suffix || str.length < suffix.length) {
                return false
            }
            return str.indexOf(suffix, str.length - suffix.length) !== -1
        },
        abbr: function(name, maxLength) {
            if (!maxLength) {
                maxLength = 20
            }
            if (name == null || name.length < 1) {
                return ""
            }
            var w = 0;
            var s = 0;
            var p = false;
            var b = false;
            var nameSub;
            for (var i = 0; i < name.length; i++) {
                if (i > 1 && b == false) {
                    p = false
                }
                if (i > 1 && b == true) {
                    p = true
                }
                var c = name.charCodeAt(i);
                if ((c >= 1 && c <= 126) || (65376 <= c && c <= 65439)) {
                    w++;
                    b = false
                } else {
                    w += 2;
                    s++;
                    b = true
                }
                if (w > maxLength && i <= name.length - 1) {
                    if (b == true && p == true) {
                        nameSub = name.substring(0, i - 2) + "..."
                    }
                    if (b == false && p == false) {
                        nameSub = name.substring(0, i - 3) + "..."
                    }
                    if (b == true && p == false) {
                        nameSub = name.substring(0, i - 2) + "..."
                    }
                    if (p == true) {
                        nameSub = name.substring(0, i - 2) + "..."
                    }
                    break
                }
            }
            if (w <= maxLength) {
                return name
            }
            return nameSub
        },
	};
	window.js = js;
    window.log = js.log;
    window.error = js.error;
})(window.jQuery, window); ! 
(function(f, d, a) {
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
		var myDatatable = typeof $this != "undefined" ? $this: options.myDatatable ? options.myDatatable: $(".kt-datatable"),
		searchForm = options.searchForm ? options.searchForm: $("#searchForm"),
		myDatatableId = myDatatable.attr("id"),
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
        		saveState: {
        			cookie: false,
        			webstorage:false
        		}
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

        	pagination: true,
        	
        	btnEventBind: function(elements, reload) {
                elements.each(function() {
                    if ($(this).attr("data-click-binded") == undefined || reload) {
                        $(this).attr("data-click-binded", true);
                        $(this).click(function() {
                            var se = $(this);
                            var url = se.attr("href");
                            var title = se.data("title");
                            if (title == undefined) {
                                title = se.attr("title")
                            }
                            var confirm = se.data("confirm");
                            if (confirm != undefined) {
                                js.confirm(confirm, url, function(data) {
                                    js.showMessage(data.message);
                                    if (data.result == 'true') {
                                    	refresh();
                                    }
                                }, "json")
                            }
                            return false
                        })
                    }
                });
                return false
            }
        	
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
                    if ($.fn.selectpicker !== undefined) {
                        searchForm.find("select.form-control").trigger("change")
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
        	myDatatable.setOption("data.source.read.params", transformToJson(formArray));
        	myDatatable.reload();
        }
        
        
        if (typeof options.btnEventBind == "function") {
        	
        	myDatatable.on('kt-datatable--on-init',function(){
        		js.log('kt-datatable--on-init');
        	}).on('kt-datatable--on-ajax-done',function(){
        		js.log('kt-datatable--on-ajax-done');
        		//options.btnEventBind(myDatatable.find(".btnList"),true);
        		setTimeout(function(){
        			options.btnEventBind(myDatatable.find(".kt-datatable__row .btnList"));
        		},100);
        	}).on('kt-datatable--on-reloaded',function(){
        		//js.log('kt-datatable--on-reloaded');
        	}).on('kt-datatable--on-layout-updated',function(){
        		//js.log('kt-datatable--on-layout-updated');
        		//setTimeout(function(){
        		//	options.btnEventBind(myDatatable.find(".btnList"));
        		//},100);
        		setTimeout(function(){
        			options.btnEventBind(myDatatable.find(".kt-datatable__row .btnList"));
        		},100);
        	}).on('kt-datatable--on-tangdao',function(){
        		//js.log('kt-datatable--on-tangdao');
        		setTimeout(function(){
        			options.btnEventBind(myDatatable.find(".kt-datatable__row-detail .btnList"), true);
        		},100);
        		//setTimeout(function(){
        		//	options.btnEventBind(myDatatable.find(".btnList"));
        		//},100);
        	})
        }
        
        myDatatable.KTDatatable(options);
        
        
        $(window).resizeEnd(function() {
        	myDatatable.layoutUpdate();
        });
		return myDatatable;
    };
    
}(jQuery));
