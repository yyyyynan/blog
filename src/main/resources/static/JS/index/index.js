$(function () {
    index();
});

/**
 * 初始化函数 暂时的作用是 加载这是第几页
 */
function index() {
    var page = parseInt(GetQueryString("page"));
    switch (page) {
        case 1:
        case 2:
        case 3:
            $($("#templatemo_menu a")[page]).click();
            break;
        default:
            $($("#templatemo_menu a")[0]).click();
    }
}

/**
 * 这个是移除首页最上面的一条导航栏的样式的 点击导航列表中的任意一项都会触发
 * 然后在其函数体内给其本体加上样式
 */
function removeListClass() {
    $("#templatemo_menu a").removeClass();
}

/**
 * 页面跳转
 * @param obj
 */
function toUrl(obj,pageNum) {
    if ($("#iframe1").attr("src").substr(2) != pageNum){
        removeListClass();
        $(obj).addClass("current");
        $("#iframe1").attr("src", "./"+pageNum);
        var url = window.location.href.split("?")[0];
        window.history.replaceState({}, "", url + "?page="+distinguish(pageNum));
    }
}


function distinguish(num) {
    switch (num) {
        case "main":
            return 0;
        case "notes":
            return 1
        case "comments":
            return 2;
        case "AboutMe":
            return 3;
        default:
            return 0;
    }
}

/**
 * 记录页跳转
 * @param obj
 */
// function toNotes(obj) {
//     removeListClass();
//     $(obj).addClass("current");
//     $("#iframe1").attr("src", "./notes");
//     var url = window.location.href.split("?")[0];
//     window.history.replaceState({}, "", url + "?page=1");
// }


/**
 * 获取地址栏参数函数
 * @paramname
 * @returns{*}
 * @constructor
 */
function GetQueryString(name) {
    var reg = new RegExp("(^|\&)" + name + "=([^\&]*)(\&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURI(r[2]);
    return null;
}

/**
 * 休眠函数
 * @param numberMillis
 * @returns {boolean}
 */
function sleep(numberMillis) {
    var now = new Date();
    var exitTime = now.getTime() + numberMillis;
    while (true) {
        now = new Date();
        if (now.getTime() > exitTime)
            return true;
    }
}
