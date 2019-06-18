$(document).ready(function () {
    $('li.btn_subNav').hover(function () {
        var offset = $(this).offset();
        var offsetW = offset.left;
        var offsetH = offset.top;
        //alert(offsetH);
        $(this).addClass('selected');
        $('.sub-nav').css({ "left": offsetW - 50, "top": offsetH + 50 });
        $('.sub-nav').show();
        $('.sub-nav').hover(function () { $(this).show(); $('li.btn_subNav').addClass('selected'); }, function () { $(this).hide(); $('li.btn_subNav').removeClass('selected'); })
    }, function () { $('.sub-nav').hide(); $(this).removeClass('selected'); })
});
function showImg(i) {
    $("#idSlider").stop(true, false).animate({ top: -320 * i }, 800);
    $("#idNum li")
    .eq(i).addClass("on")
    .siblings().removeClass("on");
}

function navigate(this_pager) {
    $("#nav ul li").each(function () {
        var $this_obj = $(this);
        var each_id = $this_obj.attr("id");
        if (each_id.length > 0 && each_id != "player") {
            if (each_id == this_pager)
                $this_obj.attr("class", "selected");
            else
                $this_obj.removeAttr("class");
        }
    });
}