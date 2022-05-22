$(document).ready(function(){
    // $(".data-item-li").children("div").addClass("to-big");
	//分类栏隐藏显示
	$(".list-group-item").hover(function(){
		$(this).children("div.sort-detail").show();
	},function(){
		$(this).children("div.sort-detail").delay(1).hide(0);
		// $(this).children("div.sort-detail").hide(10);
	});

	//幻灯片左右控制器
	$("#mycarousel").hover(function(){
		$(this).children(".carousel-control").show();
	},function(){
		$(this).children(".carousel-control").hide();
	});

	
	$(".info-a").hover(function(){
		//需处理显示哪个按钮
		// $(this).find(".like-button").css("display","inline-block");
		$(this).find(".dropdown-menu").show();
	},function(){
		$(this).find(".dropdown-menu").hide();
	});


});