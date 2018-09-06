/**
 * 工具集
 */
define(['jquery'], function () {

    return {
        /**
         * 事件绑定
         * @param bindings [{el:x,event:y,handler:z}]
         *                  el为页面元素 event为绑定事件 handler为事件响应函数
         */
        bindEvents: function (bindings) {
            $.each(bindings, function (i, v) {
                if (typeof v.el == 'string') {
                    $(document).on(v.event, v.el, v.handler);
                } else {
                    $(v.el).on(v.event, v.handler);
                }
            });
        },
        
        /**
         * 获取Url参数
         * @param url url地址
         */
        getUrlParams: function (url) {
            // 需要返回的参数集合
            var rtnParams = {},
            // 参数键值对
                paramPair = [];
            if (!url || url.indexOf('?') === -1) {
                return rtnParams;
            }

            $.each(url.substr(url.indexOf('?') + 1).split('&'), function (i, v) {
                paramPair = v.split('=');
                rtnParams[paramPair[0]] = paramPair[1];
            });

            return rtnParams;
        },

        /**
         * 去除空格
         * @param array
         * @returns {Array}
         */
        trims: function (array) {
            var newArr = [],
                ele;
            $.each(array, function (i, v) {
                ele = v.replace(/ /g, '');
                ele != '' && newArr.push(ele);
            });
            return newArr;
        },

        /**
         *  时间间隔计算工具
         * @param strInterval
         * @param num
         * @returns {string}
         */
        timeInterval: function (strInterval, num) {
            var date = arguments[2] || new Date();
            switch (strInterval) {
                case 's' :
                    date = new Date(date.getTime() + (1000 * num));
                    break;
                case 'n' :
                    date = new Date(date.getTime() + (60000 * num));
                    break;
                case 'h' :
                    date = new Date(date.getTime() + (3600000 * num));
                    break;
                case 'd' :
                    date = new Date(date.getTime() + (86400000 * num));
                    break;
                case 'w' :
                    date = new Date(date.getTime() + ((86400000 * 7) * num));
                    break;
                case 'm' :
                    date = new Date(date.getFullYear(), (date.getMonth()) + num, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
                    break;
                default:
                    date = new Date((date.getFullYear() + num), date.getMonth(), date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds());
            }
            date = date.getTime() >= (new Date()).getTime() ? new Date() : date;
            return [date.getFullYear(), date.getMonth() + 1, date.getDate()].join('/');
        },

        /**
         * 格式化日期  /yy/MM/dd/hh/mm/ss
         * @param date
         * @param formatStr
         * @returns {*}
         */
        dateFormat: function (date, formatStr) {
            var str = formatStr;
            var Week = ['日', '一', '二', '三', '四', '五', '六'];
            str = str.replace(/yy/, date.getFullYear());
            str = str.replace(/y/, (date.getYear() % 100) > 9 ? (date.getYear() % 100).toString() : '0' + (date.getYear() % 100));
            str = str.replace(/MM/, date.getMonth() >= 9 ? (date.getMonth() + 1).toString() : '0' + (date.getMonth() + 1));
            str = str.replace(/M/, date.getMonth() + 1);
            str = str.replace(/w|W/, Week[date.getDay()]);
            str = str.replace(/dd/, date.getDate() > 9 ? date.getDate().toString() : '0' + date.getDate());
            str = str.replace(/d/, date.getDate());
            str = str.replace(/hh/, date.getHours() > 9 ? date.getHours().toString() : '0' + date.getHours());
            str = str.replace(/h/, date.getHours());
            str = str.replace(/mm/, date.getMinutes() > 9 ? date.getMinutes().toString() : '0' + date.getMinutes());
            str = str.replace(/m/, date.getMinutes());
            str = str.replace(/ss/, date.getSeconds() > 9 ? date.getSeconds().toString() : '0' + date.getSeconds());
            str = str.replace(/s/, date.getSeconds());
            return str;
        },
        /**
         * 判断为空
         * author:wangjin
         */
        isEmpty: function (val) {
            val = val.replace(/(^\s*)|(\s*$)/g, "");//去掉左右空额
            //val = $.trim(val); // 采用这种方式需要在头上引入 jquery
            if (val == null) return true;
            if (val == undefined || val == 'undefined')return true;
            if (val == "") return true;
            if (val.length == 0) return true;
            if (!/[^(^\s*)|(\s*$)]/.test(val))return true;//这样是去掉左右空格
            return false;
        },

        /**
         * 判断不为为空
         * author:wangjin
         */
        isNotEmpty: function (val) {
            return !isEmpty(val);
        },
        //显示提示
        showMsg:function(msg,val){
            //成功
            if(val=='success'){ return "<span style='color: green;font-size:14px;font-weight: bold'>"+msg+"</span>"; }
            //错误
            if(val=='error'){ return "<span style='color: red;font-size:14px;font-weight: bold'>"+msg+"</span>"; }
            //失败
            if(val=='fail'){ return "<span style='color: red;font-size:14px;font-weight: bold'>"+msg+"</span>"; }
            //确认
            if(val=='confirm'){return "<span style='color: red;font-size:14px;font-weight: bold'>"+msg+"</span>";}
            //感叹号
            if(val=='7'){return "<span style='color: red;font-size:14px;font-weight: bold'>"+msg+"</span>";}
        },
        //显示样式
        styleMsg:function(val,time){
            var style = null;
            //成功
            if(val=="success")style={icon:6,skin: 'layui-layer-rim',time:time};
            //错误
            if(val=='error')style={icon:5,skin: 'layui-layer-rim',time:time};
            //失败
            if(val=='fail')style={icon:5,skin: 'layui-layer-rim',time:time};
            //确认
            if(val=='confirm')style={icon: 3, title: '提示',skin: 'layui-layer-rim',time:time};
            //感叹号
            if(val=='7')style={icon: 7, title: '提示',skin: 'layui-layer-rim',time:time};
            return style;
        },
        //过滤特殊字符查询
        filterStr:function(val){
            var containSpecial = RegExp(/[(\ )(\~)(\!)(\@)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
          return ( containSpecial.test(val) );
        }

    }
});
