$(function () {
    index();
});

/**
 * 前台首页部分内容一共有五个部分分别为
 * 首页广告         HomepageAD()
 * 首页同城活动     HomepageActivity()
 * 首页查攻略       HomepageRaiders()
 * 首页相册         HomepageAlbum()
 * 首页项目推荐     HomepageRecommend()
 */
function index() {
    $("#index").attr("css", "selected");
    $("#main").empty();
    // removeNavBarCss();
    // pageFrame();

    // addtest();
    // var i = 0;
    // while (i !== 100) {
    //     i = progressBarTest();
    //     sleep(1000);
    // }

    // HomepageAD();
    // addtest();
    // HomepageActivity();
    // HomepageRaiders();
    // HomepageAlbums();
}

/**
 * 首页轮播广告
 * @constructor
 */
function HomepageAD() {
    $.ajax({
        type: "get",
        url: "/listHomepageAD",
        data: {},
        dataType: "json",
        async: false,
        success: function (data) {
            // console.log(data);
            if (data.status === "200") {
                data = data.data;
                for (var i in data) {
                    demo = "<a target='blank' href='" + data[i].link + "' rel='1' style='display: none; z-index: 2;'>" +
                        "<img width='960' height='320' src='" + data[i].photo + "' alt='第" + i + "张广告图'></a>";
                    $("#bigAd").append(demo);
                }
            }
            $("#bigAd").slideshow({
                pauseSeconds: 4,
                height: 320,
                caption: false
            });
            if (data.status === "100") {
                var demo = "<div>" + data.errorMsg +
                    "</div>";
                $("#main").append(demo);
            }
        }
    });
}

/**
 * 首页同城活动
 * @constructor
 */
function HomepageActivity() {
    $.ajax({
        type: "get",
        url: "/listHomepageActivity",
        data: {},
        dataType: "json",
        async: false,
        success: function (data) {
            // console.log(data);
            if (data.status === "200") {
                data = data.data;
                var htmll = "<div id='quna'>" +
                    "<div class='header_quna'>" +
                    "<h2>同城活动" +
                    "</h2>" +
                    "</div>" +
                    "<h4>" +
                    "<span>" + "</span>" + "<a href='http://bbs.szhome.com/500-500100-detail-120213607.html' target='_blank' style='color:#000;'>" + data[0].title + "</a>" +
                    "</h4>" +
                    "<div class='detail_quna'>" +
                    "<a href='" + data[0].link + "' target='_blank'>" + "<img width='150' height='90' src='" + data[0].img + "'>" + "</a>" + "<p>&nbsp;" +
                    "<a class='apply' target='blank' href='" + data[0].link + "'>报名" + "</a>" + "</p>" +
                    "</div>" +
                    "</div>";
                $("#container").append(htmll);
            }
            if (data.status === "100") {
                var demo = "<div>" + data.errorMsg +
                    "</div>";
                $("#container").append(demo);
            }
        }
    });
}

/**
 * 首页查攻略
 * @constructor
 */
function HomepageRaiders() {
    $.ajax({
        type: "get",
        url: "/listHomepageRaiders",
        data: {},
        dataType: "json",
        async: false,
        success: function (data) {
            // console.log(data);
            if (data.status === "200") {
                data = data.data;
                var htmll = " <div id='gonglie'><h2>" +
                    "<a target='_blank' href='http://bbs.szhome.com/340010.html'>查攻略</a></h2>" +
                    "<ul>";
                for (var i in data) {
                    htmll += "<li><span>" + data[i].addr + "</span><a target='_blank' title='" + data[i].title + "' href='" + data[i].link + "'>" +
                        data[i].title + "</a></li>";
                }
                htmll += "</ul>" +
                    "</div>";
                $("#container").append(htmll);
            }
            if (data.status === "100") {
                var demo = "<div>" + data.errorMsg +
                    "</div>";
                $("#container").append(demo);
            }
        }
    });
}

/**
 * 首页翻相册部分
 * @constructor
 */
function HomepageAlbums() {
    $.ajax({
        type: "get",
        url: "/listHomepageAlbums",
        data: {},
        dataType: "json",
        async: false,
        success: function (data) {
            console.log(data);
            if (data.status === "200") {
                data = data.data;
                var htmll = " <div id='gonglie'><h2>" +
                    "<a target='_blank' href='http://bbs.szhome.com/340010.html'>查攻略</a></h2>" +
                    "<ul>";
                for (var i in data) {
                    htmll += "<li><span>" + data[i].addr + "</span><a target='_blank' title='" + data[i].title + "' href='" + data[i].link + "'>" +
                        data[i].title + "</a></li>";
                }
                htmll += "</ul>" +
                    "</div>";
                $("#container").append(htmll);
            }
        }
    });
}

/**
 * 添加尝试
 * @constructor
 */
function addtest() {
    $.ajax({
        type: "get",
        url: "/addtest",
        data: {},
        dataType: "json",
        async: true,
        success: function (data) {
            console.log(data);
        }
    });
}

/**
 * 消除首页导航栏样式
 */
function removeNavBarCss() {
    $("#index").attr("css", "");
    $("#player").attr("css", "");
    $("#sel").attr("css", "");
    $("#photo").attr("css", "");
}

/**
 * 这部分代码是添加页面框架用的
 */
function pageFrame() {
    var demo = "<div id = 'bigAd' class = slideshowlite' style = 'width=960 px; height=320 px;'>" +
        "</div>";
    $("#main").append(demo);
    demo = "<div id='container'></div>";
    $("#main").append(demo);
}

/**
 * 进度条测试
 */
function progressBarTest() {
    var d = 0;
    $.ajax({
        type: "get",
        url: "/getProgress",
        data: {},
        dataType: "json",
        async: false,
        success: function (data) {
            console.log(data);
            d = data;
        }
    });
    return d;
}

/**
 * 获取地址栏参数函数
 * @paramname
 * @returns{*}
 * @constructor
 */
function GetQueryString(name) {
    var reg = newRegExp("(^|\&)" + name + "=([^\&]*)(\&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) returndecodeURI(r[2]);
    returnnull;
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
